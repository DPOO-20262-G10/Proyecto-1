package boardgamecafe;


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

}
