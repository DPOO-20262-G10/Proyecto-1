package boardgamecafe;


import java.io.File;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import boardgamecafe.Turnos.SolicitudCambioTurno;
import boardgamecafe.Turnos.Turno;
import boardgamecafe.menu.Pasteleria;
import boardgamecafe.menu.Producto;
import boardgamecafe.VentaJuegos.Compra;
import boardgamecafe.pedidos.Mesa;
import boardgamecafe.pedidos.Pedido;
import boardgamecafe.pedidos.Prestamo;
import boardgamecafe.usuarios.Administrador;
import boardgamecafe.usuarios.Cliente;
import boardgamecafe.usuarios.Cocinero;
import boardgamecafe.usuarios.Empleado;
import boardgamecafe.usuarios.Mesero;
import boardgamecafe.usuarios.Usuario;
import boardgamecafe.Juegos.JuegosDeMesa;
import boardgamecafe.Juegos.CopiaJuego;
import boardgamecafe.Juegos.JuegoVenta;
import boardgamecafe.menu.Bebida;



public class BoardCafe {

    private Map<String, Usuario> usuarios;
    private Map<Integer, JuegosDeMesa> juegosDeMesa;
    private Map<Integer, CopiaJuego> copias;
    private Map<Integer, Mesa> mesas;
    private Map<Integer, Producto> productos;
    private List<Compra> compras;
    private List<Pedido> pedidos;
    private List<Prestamo> prestamos;
    private List<Turno> turnos;
    private List<SolicitudCambioTurno> solicitudes;
    private Usuario usuarioActivo;

    private int ultimoIdUsuario = 1;
    private int ultimoIdJuego = 1;
    private int ultimoIdCopia = 1;
    private int ultimoIdMesa = 1;
    private int ultimoIdProducto = 1;
    private int ultimoIdCompra = 1;
    private int ultimoIdPedido = 1;
    private int ultimoIdPrestamo = 1;
    private int ultimoIdTurno = 1;
    private int ultimoIdSolicitud = 1;

    public BoardCafe() {
        usuarios      = new HashMap<String, Usuario>();
        juegosDeMesa  = new HashMap<Integer, JuegosDeMesa>();
        copias        = new HashMap<Integer, CopiaJuego>();
        mesas         = new HashMap<Integer, Mesa>();
        productos     = new HashMap<Integer, Producto>();
        compras       = new ArrayList<Compra>();
        pedidos       = new ArrayList<Pedido>();
        prestamos     = new ArrayList<Prestamo>();
        turnos        = new ArrayList<Turno>();
        solicitudes   = new ArrayList<SolicitudCambioTurno>();
        usuarioActivo = null;
    }

    //la persistencia la cual sirve para que el guardarTodo funcione



    //la parte de inicio del usuario

    public void registrarUsuario(String nombre, String login, String password, String tipo) {
        if (usuarios.containsKey(login))
            throw new IllegalArgumentException("El login ya existe.");

        Usuario u;
        if (tipo.equalsIgnoreCase("cliente")) 
        {
            u = new Cliente(ultimoIdUsuario++, login, password, nombre);
        } 
        else if (tipo.equalsIgnoreCase("mesero")) 
        {
            u = new Mesero(ultimoIdUsuario++, login, password, nombre);
        } 
        else if (tipo.equalsIgnoreCase("cocinero")) 
        {
            u = new Cocinero(ultimoIdUsuario++, login, password, nombre);
        } 
        else if (tipo.equalsIgnoreCase("administrador")) 
        {
            u = new Administrador(ultimoIdUsuario++, login, password, nombre);
        }
        else 
        {
            u = new Empleado(ultimoIdUsuario++, login, password, nombre);
        }

        usuarios.put(login, u);
        guardarTodo();
    }

    public boolean login(String login, String password) {
        Usuario u = usuarios.get(login);

        if (u != null && u.iniciarSesion(login, password)) {
            usuarioActivo = u;
            return true;
        }

        return false;
    }

    public void logout() {
        if (usuarioActivo != null) {
            usuarioActivo.cerrarSesion();
            usuarioActivo = null;
        }
    }

    public List<JuegosDeMesa> consultarCatalogo() {
        return new ArrayList<>(juegosDeMesa.values());
    }

    public JuegosDeMesa buscarJuego(String nombre) {
        for (JuegosDeMesa j : juegosDeMesa.values()) {
            if (j.getNombre().equalsIgnoreCase(nombre))
                return j;
        }
        return null;
    }

    public List<String> verAlergenoS(int idProducto) {
        Producto p = productos.get(idProducto);

        if (p instanceof Pasteleria)
            return ((Pasteleria) p).getAlergenos();

        return new ArrayList<>();
    }

    public List<Compra> consultarHistorialCompras() {
        List<Compra> res = new ArrayList<>();
        for (Compra c : compras) {
            if (c.getLoginUsuario().equals(usuarioActivo.getLogin()))
                res.add(c);
        }
        return res;
    }

    public List<Pedido> consultarHistorialPedidos() {
        List<Pedido> res = new ArrayList<>();
        for (Pedido p : pedidos) {
            if (p.getLoginUsuario().equals(usuarioActivo.getLogin()))
                res.add(p);
        }
        return res;
    }

    public void agregarFavorito(int idJuego) {
        if (usuarioActivo != null) {
            usuarioActivo.agregarFavorito(idJuego);
            guardarTodo();
        }
    }

    public void eliminarFavorito(int idJuego) {
        if (usuarioActivo != null) {
            usuarioActivo.eliminarFavorito(idJuego);
            guardarTodo();
        }
    }

    public List<JuegosDeMesa> consultarFavoritos() {
        List<JuegosDeMesa> favs = new ArrayList<>();

        if (usuarioActivo != null) {
            for (int id : usuarioActivo.getFavoritos()) {
                JuegosDeMesa j = juegosDeMesa.get(id);
                if (j != null)
                    favs.add(j);
            }
        }

        return favs;
    }

    public Usuario getUsuarioActivo() {
        return usuarioActivo;
    }




// Empleado con sus metodos

    public void sugerirProducto(String nombre, double precio, String tipo, boolean alcoholica, boolean caliente, List<String> alergenos) {
        if (!(usuarioActivo instanceof Empleado))
            throw new IllegalArgumentException("Solo empleado.");

        Empleado e = (Empleado) usuarioActivo;
        Producto p = e.sugerirProducto(nombre, precio, tipo, alcoholica, caliente, alergenos);

        p.setAprobado(false);
        p.setIdProducto(ultimoIdProducto++);
        productos.put(p.getIdProducto(), p);
        guardarTodo();
    }

    public void solicitarCambioTurno(String cambioDia, String tipo, int idEmpleadoIntercambio) {
        if (!(usuarioActivo instanceof Empleado))
            throw new IllegalArgumentException("Solo empleados pueden solicitar cambio de turno.");

        Empleado emp = (Empleado) usuarioActivo;

        Empleado inter = null;
        boolean encontrado = false;
        for (Usuario u : usuarios.values()) {
            if (!encontrado && u instanceof Empleado && ((Empleado) u).getIdEmpleado() == idEmpleadoIntercambio) {
                inter = (Empleado) u;
                encontrado = true;
            }
        }

        if (inter == null)
            throw new IllegalArgumentException("Empleado intercambio no existe.");

        SolicitudCambioTurno s = new SolicitudCambioTurno(ultimoIdSolicitud++, cambioDia, emp.getTurnos().get(0), emp, inter);
        solicitudes.add(s);
        emp.getSolicitudes().add(s);
        guardarTodo();
    }


// mesero con su unico metodo

    public void registrarJuegosDificiles(List<Integer> idsJuegos) {
        if (!(usuarioActivo instanceof Mesero))
            throw new IllegalArgumentException("Solo mesero.");

        ((Mesero) usuarioActivo).registrarJuegosDificiles(idsJuegos);
        guardarTodo();
    }

// adminitrador con sus metodos

    public void agregarJuego(String nombre, Date anioPublicacion, int minJugadores, int maxJugadores, int edadMinima, String categoria, boolean esDificil) {
        if (!(usuarioActivo instanceof Administrador))
            throw new IllegalArgumentException("Solo Administrador puede agregar juegos.");

        JuegosDeMesa j = new JuegosDeMesa(ultimoIdJuego++, nombre, anioPublicacion, minJugadores, maxJugadores, edadMinima, categoria, esDificil);
        juegosDeMesa.put(j.getIdJuego(), j);
        guardarTodo();
    }

    public void crearTurno(int idEmpleado, String diaSemana, Time horaInicio, Time horaFinal) {
        if (!(usuarioActivo instanceof Administrador))
            throw new IllegalArgumentException("Solo admin.");

        Turno t = new Turno(ultimoIdTurno++, diaSemana, horaInicio, horaFinal);
        turnos.add(t);

        for (Usuario u : usuarios.values()) {
            if (u instanceof Empleado && ((Empleado) u).getIdEmpleado() == idEmpleado) 
                
            {
                ((Empleado) u).getTurnos().add(t);
            }
        }

        guardarTodo();
    }

    public void modificarTurno(int idEmpleado, String diaSemana, Time horaInicio, Time horaFinal) {
        if (!(usuarioActivo instanceof Administrador))
            throw new IllegalArgumentException("Solo admin.");

        for (Usuario u : usuarios.values()) {
            if (u instanceof Empleado && ((Empleado) u).getIdEmpleado() == idEmpleado) {
                for (Turno t : ((Empleado) u).getTurnos()) {
                    if (t.getDiaSemana().equalsIgnoreCase(diaSemana)) 
                    {
                        t.setHoraInicio(horaInicio);
                        t.setHoraFinal(horaFinal);
                    }
                }
            }
        }

        guardarTodo();
    }

    public Turno consultarTurno(int idEmpleado) {
        for (Usuario u : usuarios.values()) {
            if (u instanceof Empleado && ((Empleado) u).getIdEmpleado() == idEmpleado) {
                if (!((Empleado) u).getTurnos().isEmpty())
                    return ((Empleado) u).getTurnos().get(0);
            }
        }
        return null;
    }

    public void aprobarCambioTurno(int idSolicitud) {
        if (!(usuarioActivo instanceof Administrador))
            throw new IllegalArgumentException("Solo admin.");

        for (SolicitudCambioTurno s : solicitudes) {
            if (s.getIdSolicitud() == idSolicitud) {
                s.aprobar();
                guardarTodo();
                return;
            }
        }
    }

    public void rechazarCambioTurno(int idSolicitud) {
        if (!(usuarioActivo instanceof Administrador))
            throw new IllegalArgumentException("Solo admin.");

        for (SolicitudCambioTurno s : solicitudes) {
            if (s.getIdSolicitud() == idSolicitud) {
                s.rechazar();
                guardarTodo();
                return;
            }
        }
    }

    public void aprobarSugerencia(int idProducto) {
        if (!(usuarioActivo instanceof Administrador))
            throw new IllegalArgumentException("Solo admin.");

        Producto p = productos.get(idProducto);
        if (p != null) {
            p.setAprobado(true);
            guardarTodo();
        }
    }

    public void rechazarSugerencia(int idProducto) {
        if (!(usuarioActivo instanceof Administrador))
            throw new IllegalArgumentException("Solo admin.");

        productos.remove(idProducto);
        guardarTodo();
    }

    public void agregarJuegosInventario(int idJuego, int cantidad, String tipo, String estadoInicial) {
        if (!(usuarioActivo instanceof Administrador))
            throw new IllegalArgumentException("Solo admin.");

        JuegosDeMesa j = juegosDeMesa.get(idJuego);
        if (j == null)
            throw new IllegalArgumentException("Juego no existe.");

        if (tipo.equalsIgnoreCase("venta") && j instanceof JuegoVenta) 
        {
            ((JuegoVenta) j).setStock(((JuegoVenta) j).getStock() + cantidad);
        } 
        else if (tipo.equalsIgnoreCase("prestamo")) 
        {
            for (int i = 0; i < cantidad; i++) {
                CopiaJuego c = new CopiaJuego(ultimoIdCopia++, true, estadoInicial);
                j.getCopias().add(c);
                copias.put(c.getIdCopia(), c);
            }
        }

        guardarTodo();
    }

    public void moverJuegoEntreInventarios(int idJuego, int cantidad, String tipoOrigen) {
        if (!(usuarioActivo instanceof Administrador))
            throw new IllegalArgumentException("Solo admin.");

        guardarTodo();
    }

    public void marcarCopiaDesaparecida(int idCopia) {
        if (!(usuarioActivo instanceof Administrador))
            throw new IllegalArgumentException("Solo admin.");

        CopiaJuego c = copias.get(idCopia);
        if (c != null) {
            c.setEstadoJuego("Desaparecido");
            guardarTodo();
        }
    }

    public Map<JuegosDeMesa, List<CopiaJuego>> verInventarioCompleto() {
        if (!(usuarioActivo instanceof Administrador))
            throw new IllegalArgumentException("Solo admin.");

        Map<JuegosDeMesa, List<CopiaJuego>> inv = new HashMap<>();
        for (JuegosDeMesa j : juegosDeMesa.values())
            inv.put(j, j.getCopias());

        return inv;
    }

    public String generarReporteVentas(Date fechaInicio, Date fechaFin, String agrupacion, String tipoVenta) {
        if (!(usuarioActivo instanceof Administrador))
            throw new IllegalArgumentException("Solo admin.");

        return "Reporte de Ventas Generado.";
    }


    // Cliente los metodos que itene - toca mirar porque aveces salen errores

    public void tomarMesa(int numeroPersonas, boolean hayNinos, boolean hayJovenes) {
        if (!(usuarioActivo instanceof Cliente))
            throw new IllegalArgumentException("Solo Clientes pueden tomar mesas.");


        Mesa mesaLibre = null;
        boolean encontrada = false;
        for (Mesa m : mesas.values()) {
            if (!encontrada && m.getNumeroPersonas() == 0) 
            {
                mesaLibre = m;
                encontrada = true;
            }
        }

        if (mesaLibre == null) {
            mesaLibre = new Mesa(ultimoIdMesa++, 0, false, false);
            mesas.put(mesaLibre.getIdMesa(), mesaLibre);
        }

        mesaLibre.setNumeroPersonas(numeroPersonas);
        mesaLibre.setHayNinos(hayNinos);
        mesaLibre.setHayJovenes(hayJovenes);
        guardarTodo();
    }

    public void liberarMesa(int idMesa) {
        Mesa m = mesas.get(idMesa);
        if (m != null) {
            m.setNumeroPersonas(0);
            guardarTodo();
        }
    }

    public void solicitarPrestamo(int idJuego1, int idJuego2, int idMesa) {
        if (!(usuarioActivo instanceof Cliente))
            throw new IllegalArgumentException("Solo Clientes pueden solicitar prestamos.");

        int prestamosActivos = 0;
        for (Prestamo p : prestamos) {
            if (p.isActivo() && p.getSolicitante() == usuarioActivo)
                prestamosActivos += p.getCopias().size();
        }

        int cantidadSolicitada = 0;

        if (idJuego1 > 0) 
        {
            cantidadSolicitada++;
        }
        if (idJuego2 > 0) 
        {
            cantidadSolicitada++;
        }

        if (prestamosActivos + cantidadSolicitada > 2) {
            throw new IllegalArgumentException("Maximo 2 juegos prestados.");
        }

        Mesa m = mesas.get(idMesa);
        if (m == null || m.getNumeroPersonas() == 0)
            throw new IllegalArgumentException("Mesa invalida.");

        List<Integer> ids = new ArrayList<>();
        if (idJuego1 > 0)
            ids.add(idJuego1);
        if (idJuego2 > 0)
            ids.add(idJuego2);

        boolean advertenciaDificil = false;
        List<CopiaJuego> copiasAprestar = new ArrayList<>();

        for (int idJuego : ids) {
            JuegosDeMesa j = juegosDeMesa.get(idJuego);
            if (j == null)
                throw new IllegalArgumentException("Juego no existe.");

            CopiaJuego c = j.obtenerCopiaDisponible();
            if (c == null)
                throw new IllegalArgumentException("No hay copias disponibles para " + j.getNombre());

            if (m.getNumeroPersonas() < j.getMinJugadores() || m.getNumeroPersonas() > j.getMaxJugadores()) {
                throw new IllegalArgumentException("Numero de personas en mesa invalido para " + j.getNombre());
            }

            if (m.isHayNinos() && j.getEdadMinima() > 8)
                throw new IllegalArgumentException("Juego no apto para niños.");

            if (m.isHayJovenes() && j.getEdadMinima() > 14)
                throw new IllegalArgumentException("Juego no apto para jovenes.");

            if (j.isEsDificil()) {
                boolean conocido = false;
                for (Usuario u : usuarios.values()) {
                    if (u instanceof Mesero && ((Mesero) u).isEnTurno() && ((Mesero) u).conoceJuego(idJuego)) {
                        conocido = true;
                    }
                }
                if (!conocido)
                    advertenciaDificil = true;
            }

            if (j.getCategoria().equalsIgnoreCase("Accion")) {
                for (Pedido p : pedidos) {
                    if (p.getLoginUsuario().equals(usuarioActivo.getLogin())) {
                        for (Producto prod : p.getProductos()) 
                        {
                            if (prod instanceof Bebida && ((Bebida) prod).isCaliente()) {
                                throw new IllegalArgumentException(
                                        "No se puede prestar juego de accion si hay bebidas calientes.");
                            }
                        }
                    }
                }
            }

            copiasAprestar.add(c);
        }

        Prestamo p = new Prestamo(ultimoIdPrestamo++, advertenciaDificil, usuarioActivo);
        for (CopiaJuego c : copiasAprestar) {
            c.setDisponible(false);
            p.agregarCopia(c);
        }

        prestamos.add(p);
        guardarTodo();
    }

    public void devolverJuego(int idPrestamo) {
        for (Prestamo p : prestamos) {
            if (p.getIdPrestamo() == idPrestamo) 
            {
                p.finalizarPrestamo();
                for (CopiaJuego c : p.getCopias()) {
                    c.setDisponible(true);
                }
                guardarTodo();
                return;
            }
        }
        throw new IllegalArgumentException("Prestamo no encontrado.");
    }

    public void comprarJuego(int idJuego, int cantidad) {
        JuegosDeMesa j = juegosDeMesa.get(idJuego);
        if (!(j instanceof JuegoVenta))
            throw new IllegalArgumentException("El juego no es de venta.");

        JuegoVenta jv = (JuegoVenta) j;
        if (jv.getStock() < cantidad)
            throw new IllegalArgumentException("Stock insuficiente.");

        double subtotal = jv.getPrecio() * cantidad;
        double impuesto = subtotal * 0.19;
        double descuento = 0;

        if (usuarioActivo instanceof Empleado) 
        {
            descuento = subtotal * 0.20;
        } 
        else if (usuarioActivo instanceof Cliente) 
        {
            descuento = subtotal * 0.10;
        }

        double total = subtotal + impuesto - descuento;
        int puntos = (int) (total * 0.01);
        usuarioActivo.setPuntosFidelidad(usuarioActivo.getPuntosFidelidad() + puntos);

        jv.setStock(jv.getStock() - cantidad);

        List<JuegoVenta> juegosCompra = new ArrayList<>();
        for (int i = 0; i < cantidad; i++)
            juegosCompra.add(jv);

        Compra c = new Compra(ultimoIdCompra++, new Date(), subtotal, impuesto, descuento, true, juegosCompra, usuarioActivo.getLogin());

        compras.add(c);
        guardarTodo();
    }

    public void usarPuntosFidelidad(int puntos, int idCompraOPedido) {
        if (usuarioActivo.getPuntosFidelidad() < puntos)
            throw new IllegalArgumentException("Puntos insuficientes.");

        usuarioActivo.setPuntosFidelidad(usuarioActivo.getPuntosFidelidad() - puntos);

        for (Pedido p : pedidos) {
            if (p.getIdPedido() == idCompraOPedido) {
                p.setDescuentoAplicado(p.getDescuentoAplicado() + puntos);
                guardarTodo();
                return;
            }
        }

        for (Compra c : compras) {
            if (c.getIdCompra() == idCompraOPedido) {
                c.setValor(c.getValor() - puntos);
                guardarTodo();
                return;
            }
        }
    }

    public void crearPedido(int idProducto, int cantidad, double propina) {
        Producto p = productos.get(idProducto);
        if (p == null)
            throw new IllegalArgumentException("Producto no existe.");

        Mesa mesaCliente = null;
        boolean encontrada = false;

        for (Mesa m : mesas.values()) {
            if (!encontrada && m.getNumeroPersonas() > 0) {
                mesaCliente = m;
                encontrada = true;
            }
        }

        if (p instanceof Bebida) {
            Bebida b = (Bebida) p;

            if (b.isAlcoholica() && mesaCliente != null && mesaCliente.isHayNinos()) {
                throw new IllegalArgumentException("No se puede vender alcohol habiendo ninos en la mesa.");
            }

            if (b.isCaliente()) {
                for (Prestamo pr : prestamos) {

                    if (pr.isActivo() && pr.getSolicitante() == usuarioActivo) {

                        for (CopiaJuego c : pr.getCopias()) {

                            for (JuegosDeMesa juego : juegosDeMesa.values()) 
                            {
                                if (juego.getCopias().contains(c) && juego.getCategoria().equalsIgnoreCase("Accion")) {
                                    throw new IllegalArgumentException("No bebida caliente con juego de accion.");
                                }
                            }
                        }
                    }
                }
            }
        }

        Pedido ped = new Pedido(ultimoIdPedido++, new Date(), propina, 0, usuarioActivo.getLogin());
        for (int i = 0; i < cantidad; i++)
            ped.agregarProducto(p);

        double total = ped.calcularTotal();
        usuarioActivo.setPuntosFidelidad(usuarioActivo.getPuntosFidelidad() + (int) (total * 0.01));

        pedidos.add(ped);
        guardarTodo();
    }

}


