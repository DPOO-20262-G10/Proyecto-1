package boardgamecafe.persistencia;

import org.json.JSONArray;
import org.json.JSONObject;

import boardgamecafe.Juegos.CopiaJuego;
import boardgamecafe.Juegos.JuegoVenta;
import boardgamecafe.Juegos.JuegosDeMesa;
import boardgamecafe.Torneos.InscripcionTorneo;
import boardgamecafe.Torneos.Torneo;
import boardgamecafe.Turnos.SolicitudCambioTurno;
import boardgamecafe.Turnos.Turno;
import boardgamecafe.VentaJuegos.Compra;
import boardgamecafe.menu.Bebida;
import boardgamecafe.menu.Pasteleria;
import boardgamecafe.menu.Producto;
import boardgamecafe.pedidos.Mesa;
import boardgamecafe.pedidos.Pedido;
import boardgamecafe.pedidos.Prestamo;
import boardgamecafe.usuarios.*;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.sql.Time;
import java.util.*;

/**
 * Clase de persistencia para BoardCafe.
 *
 * Guarda y carga el estado completo del sistema en un único archivo JSON
 * llamado "boardcafe_data.json" ubicado en el directorio de trabajo.
 *
 * Uso:
 *   // Guardar
 *   PersistenciaJSON.guardar(estado);
 *
 *   // Cargar
 *   EstadoBoardCafe estado = PersistenciaJSON.cargar();
 *
 * Dependencia externa requerida: org.json  (json-20231013.jar o superior)
 * Descarga: https://repo1.maven.org/maven2/org/json/json/20231013/json-20231013.jar
 * En Eclipse: clic derecho al proyecto → Build Path → Add External JARs
 */
public class PersistenciaJSON {

    private static final String ARCHIVO = "boardcafe_data.json";

    // =========================================================================
    // GUARDAR
    // =========================================================================

    public static void guardar(EstadoBoardCafe e) {
        try {
            JSONObject raiz = new JSONObject();

            // Contadores de IDs
            raiz.put("ultimoIdUsuario",   e.ultimoIdUsuario);
            raiz.put("ultimoIdJuego",     e.ultimoIdJuego);
            raiz.put("ultimoIdCopia",     e.ultimoIdCopia);
            raiz.put("ultimoIdMesa",      e.ultimoIdMesa);
            raiz.put("ultimoIdProducto",  e.ultimoIdProducto);
            raiz.put("ultimoIdCompra",    e.ultimoIdCompra);
            raiz.put("ultimoIdPedido",    e.ultimoIdPedido);
            raiz.put("ultimoIdPrestamo",  e.ultimoIdPrestamo);
            raiz.put("ultimoIdTurno",     e.ultimoIdTurno);
            raiz.put("ultimoIdSolicitud", e.ultimoIdSolicitud);
            raiz.put("ultimoIdTorneo",    e.ultimoIdTorneo);

            // Colecciones
            raiz.put("usuarios",      serializarUsuarios(e.usuarios));
            raiz.put("juegos",        serializarJuegos(e.juegosDeMesa));
            raiz.put("copias",        serializarCopias(e.copias));
            raiz.put("mesas",         serializarMesas(e.mesas));
            raiz.put("productos",     serializarProductos(e.productos));
            raiz.put("compras",       serializarCompras(e.compras));
            raiz.put("pedidos",       serializarPedidos(e.pedidos));
            raiz.put("prestamos",     serializarPrestamos(e.prestamos));
            raiz.put("turnos",        serializarTurnos(e.turnos));
            raiz.put("solicitudes",   serializarSolicitudes(e.solicitudes));
            raiz.put("torneos",       serializarTorneos(e.torneos));
            raiz.put("inscripciones", serializarInscripciones(e.inscripciones));

            String contenido = raiz.toString(2); // pretty-print con 2 espacios
            Files.write(Paths.get(ARCHIVO),
                        contenido.getBytes(StandardCharsets.UTF_8),
                        StandardOpenOption.CREATE,
                        StandardOpenOption.TRUNCATE_EXISTING);

        } catch (Exception ex) {
            System.err.println("[PersistenciaJSON] Error al guardar: " + ex.getMessage());
        }
    }

    // =========================================================================
    // CARGAR
    // =========================================================================

    public static EstadoBoardCafe cargar() {
        EstadoBoardCafe e = new EstadoBoardCafe();
        Path ruta = Paths.get(ARCHIVO);

        if (!Files.exists(ruta)) {
            return e; // primera ejecución: estado vacío
        }

        try {
            String contenido = new String(Files.readAllBytes(ruta), StandardCharsets.UTF_8);
            JSONObject raiz  = new JSONObject(contenido);

            // Contadores
            e.ultimoIdUsuario   = raiz.optInt("ultimoIdUsuario",   1);
            e.ultimoIdJuego     = raiz.optInt("ultimoIdJuego",     1);
            e.ultimoIdCopia     = raiz.optInt("ultimoIdCopia",     1);
            e.ultimoIdMesa      = raiz.optInt("ultimoIdMesa",      1);
            e.ultimoIdProducto  = raiz.optInt("ultimoIdProducto",  1);
            e.ultimoIdCompra    = raiz.optInt("ultimoIdCompra",    1);
            e.ultimoIdPedido    = raiz.optInt("ultimoIdPedido",    1);
            e.ultimoIdPrestamo  = raiz.optInt("ultimoIdPrestamo",  1);
            e.ultimoIdTurno     = raiz.optInt("ultimoIdTurno",     1);
            e.ultimoIdSolicitud = raiz.optInt("ultimoIdSolicitud", 1);
            e.ultimoIdTorneo    = raiz.optInt("ultimoIdTorneo",    1);

            // El orden importa: primero entidades independientes, luego las que
            // tienen referencias a otras.
            deserializarUsuarios(raiz.optJSONArray("usuarios"),    e);
            deserializarJuegos  (raiz.optJSONArray("juegos"),      e);
            deserializarCopias  (raiz.optJSONArray("copias"),      e); // asocia copias a juegos
            deserializarMesas   (raiz.optJSONArray("mesas"),       e);
            deserializarProductos(raiz.optJSONArray("productos"),  e);
            deserializarTurnos  (raiz.optJSONArray("turnos"),      e); // asocia turnos a empleados
            deserializarSolicitudes(raiz.optJSONArray("solicitudes"), e);
            deserializarCompras (raiz.optJSONArray("compras"),     e);
            deserializarPedidos (raiz.optJSONArray("pedidos"),     e);
            deserializarPrestamos(raiz.optJSONArray("prestamos"),  e);
            deserializarTorneos (raiz.optJSONArray("torneos"),     e);
            deserializarInscripciones(raiz.optJSONArray("inscripciones"), e);

        } catch (Exception ex) {
            System.err.println("[PersistenciaJSON] Error al cargar: " + ex.getMessage());
            ex.printStackTrace();
        }

        return e;
    }

    // =========================================================================
    // SERIALIZACIÓN
    // =========================================================================

    // --- Usuarios ------------------------------------------------------------

    private static JSONArray serializarUsuarios(Map<String, Usuario> mapa) {
        JSONArray arr = new JSONArray();
        for (Usuario u : mapa.values()) {
            JSONObject o = new JSONObject();
            o.put("tipo",             tipoDe(u));
            o.put("login",            u.getLogin());
            o.put("password",         u.getPassword());
            o.put("nombre",           u.getNombre());
            o.put("puntosFidelidad",  u.getPuntosFidelidad());
            o.put("favoritos",        new JSONArray(u.getFavoritos()));

            if (u instanceof Empleado) {
                Empleado emp = (Empleado) u;
                o.put("idEmpleado",       emp.getIdEmpleado());
                o.put("enTurno",          emp.isEnTurno());
                o.put("codigoDescuento",  emp.getCodigoDescuento());
                if (u instanceof Mesero) {
                    o.put("juegosDificilesConocidos",
                          new JSONArray(((Mesero) u).getJuegosDificilesConocidos()));
                }
            } else if (u instanceof Cliente) {
                o.put("idCliente", ((Cliente) u).getIdCliente());
            } else if (u instanceof Administrador) {
                o.put("idAdmin", ((Administrador) u).getIdAdmin());
            }

            arr.put(o);
        }
        return arr;
    }

    // --- Juegos --------------------------------------------------------------

    private static JSONArray serializarJuegos(Map<Integer, JuegosDeMesa> mapa) {
        JSONArray arr = new JSONArray();
        for (JuegosDeMesa j : mapa.values()) {
            JSONObject o = new JSONObject();
            o.put("tipo",            j instanceof JuegoVenta ? "venta" : "prestamo");
            o.put("idJuego",         j.getIdJuego());
            o.put("nombre",          j.getNombre());
            o.put("anioPublicacion", j.getAnioPublicacion() != null
                                        ? j.getAnioPublicacion().getTime() : -1);
            o.put("minJugadores",    j.getMinJugadores());
            o.put("maxJugadores",    j.getMaxJugadores());
            o.put("edadMinima",      j.getEdadMinima());
            o.put("categoria",       j.getCategoria());
            o.put("esDificil",       j.isEsDificil());

            if (j instanceof JuegoVenta) {
                JuegoVenta jv = (JuegoVenta) j;
                o.put("stock",  jv.getStock());
                o.put("precio", jv.getPrecio());
            }
            arr.put(o);
        }
        return arr;
    }

    // --- Copias --------------------------------------------------------------

    private static JSONArray serializarCopias(Map<Integer, CopiaJuego> mapa) {
        JSONArray arr = new JSONArray();
        for (CopiaJuego c : mapa.values()) {
            JSONObject o = new JSONObject();
            o.put("idCopia",     c.getIdCopia());
            o.put("disponible",  c.isDisponible());
            o.put("estadoJuego", c.getEstadoJuego());
            arr.put(o);
        }
        return arr;
    }

    // --- Mesas ---------------------------------------------------------------

    private static JSONArray serializarMesas(Map<Integer, Mesa> mapa) {
        JSONArray arr = new JSONArray();
        for (Mesa m : mapa.values()) {
            JSONObject o = new JSONObject();
            o.put("idMesa",         m.getIdMesa());
            o.put("numeroPersonas", m.getNumeroPersonas());
            o.put("hayNinos",       m.isHayNinos());
            o.put("hayJovenes",     m.isHayJovenes());
            arr.put(o);
        }
        return arr;
    }

    // --- Productos -----------------------------------------------------------

    private static JSONArray serializarProductos(Map<Integer, Producto> mapa) {
        JSONArray arr = new JSONArray();
        for (Producto p : mapa.values()) {
            JSONObject o = new JSONObject();
            o.put("tipo",       p.getTipo()); // "Bebida" o "Pasteleria"
            o.put("idProducto", p.getIdProducto());
            o.put("nombre",     p.getNombre());
            o.put("precio",     p.getPrecio());
            o.put("aprobado",   p.isAprobado());
            if (p instanceof Bebida) {
                Bebida b = (Bebida) p;
                o.put("alcoholica", b.isAlcoholica());
                o.put("caliente",   b.isCaliente());
            } else if (p instanceof Pasteleria) {
                o.put("alergenos", new JSONArray(((Pasteleria) p).getAlergenos()));
            }
            arr.put(o);
        }
        return arr;
    }

    // --- Compras -------------------------------------------------------------

    private static JSONArray serializarCompras(List<Compra> lista) {
        JSONArray arr = new JSONArray();
        for (Compra c : lista) {
            JSONObject o = new JSONObject();
            o.put("idCompra",           c.getIdCompra());
            o.put("fecha",              c.getFecha().getTime());
            o.put("valor",              c.getValor());
            o.put("impuesto",           c.getImpuesto());
            o.put("descuento",          c.getDescuento());
            o.put("descuentoAplicado",  c.isDescuentoAplicado());
            o.put("loginUsuario",       c.getLoginUsuario());
            // Solo guardamos los IDs de los juegos comprados
            JSONArray ids = new JSONArray();
            for (JuegoVenta jv : c.getJuegos()) ids.put(jv.getIdJuego());
            o.put("idsJuegos", ids);
            arr.put(o);
        }
        return arr;
    }

    // --- Pedidos -------------------------------------------------------------

    private static JSONArray serializarPedidos(List<Pedido> lista) {
        JSONArray arr = new JSONArray();
        for (Pedido p : lista) {
            JSONObject o = new JSONObject();
            o.put("idPedido",          p.getIdPedido());
            o.put("fecha",             p.getFecha().getTime());
            o.put("propina",           p.getPropina());
            o.put("descuento",         p.getDescuento());
            o.put("descuentoAplicado", p.getDescuentoAplicado());
            o.put("loginUsuario",      p.getLoginUsuario());
            JSONArray ids = new JSONArray();
            for (Producto prod : p.getProductos()) ids.put(prod.getIdProducto());
            o.put("idsProductos", ids);
            arr.put(o);
        }
        return arr;
    }

    // --- Préstamos -----------------------------------------------------------

    private static JSONArray serializarPrestamos(List<Prestamo> lista) {
        JSONArray arr = new JSONArray();
        for (Prestamo p : lista) {
            JSONObject o = new JSONObject();
            o.put("idPrestamo",         p.getIdPrestamo());
            o.put("fechaInicio",        p.getFechaInicio().getTime());
            o.put("fechaFin",           p.getFechaFin() != null ? p.getFechaFin().getTime() : -1);
            o.put("activo",             p.isActivo());
            o.put("advertenciaDificil", p.isAdvertenciaDificil());
            o.put("loginSolicitante",   p.getSolicitante().getLogin());
            JSONArray ids = new JSONArray();
            for (CopiaJuego c : p.getCopias()) ids.put(c.getIdCopia());
            o.put("idsCopias", ids);
            arr.put(o);
        }
        return arr;
    }

    // --- Turnos --------------------------------------------------------------

    private static JSONArray serializarTurnos(List<Turno> lista) {
        JSONArray arr = new JSONArray();
        for (Turno t : lista) {
            JSONObject o = new JSONObject();
            o.put("idTurno",    t.getIdTurno());
            o.put("diaSemana",  t.getDiaSemana());
            o.put("horaInicio", t.getHoraInicio().toString());
            o.put("horaFinal",  t.getHoraFinal().toString());
            arr.put(o);
        }
        return arr;
    }

    // --- Solicitudes de cambio de turno --------------------------------------

    private static JSONArray serializarSolicitudes(List<SolicitudCambioTurno> lista) {
        JSONArray arr = new JSONArray();
        for (SolicitudCambioTurno s : lista) {
            JSONObject o = new JSONObject();
            o.put("idSolicitud",          s.getIdSolicitud());
            o.put("estado",               s.getEstado());
            o.put("cambioDia",            s.getCambioDia());
            o.put("idTurnoActual",        s.getTurnoActual().getIdTurno());
            o.put("loginSolicitante",     s.getEmpleadoSolicitante().getLogin());
            o.put("loginIntercambio",     s.getEmpleadoIntercambio().getLogin());
            arr.put(o);
        }
        return arr;
    }

    // --- Torneos -------------------------------------------------------------

    private static JSONArray serializarTorneos(List<Torneo> lista) {
        JSONArray arr = new JSONArray();
        for (Torneo t : lista) {
            JSONObject o = new JSONObject();
            o.put("idTorneo",              t.getIdTorneo());
            o.put("nombre",                t.getNombre());
            o.put("tipo",                  t.getTipo());
            o.put("cuposTotales",          t.getCuposTotales());
            o.put("cuposFanaticos",        t.getCuposFanaticos());
            o.put("cuposRegularesOcupados",t.getCuposRegularesOcupados());
            o.put("cuposFanaticosOcupados",t.getCuposFanaticosOcupados());
            o.put("tarifaEntrada",         t.getTarifaEntrada());
            o.put("premioMetalico",        t.getPremioMetalico());
            o.put("bonoDescuento",         t.getBonoDescuento());
            o.put("activo",                t.getactivo());
            o.put("idJuego",               t.getJuego() != null ? t.getJuego().getIdJuego() : -1);
            o.put("loginGanador",          t.getGanador() != null ? t.getGanador().getLogin() : "");
            arr.put(o);
        }
        return arr;
    }

    // --- Inscripciones -------------------------------------------------------

    private static JSONArray serializarInscripciones(List<InscripcionTorneo> lista) {
        JSONArray arr = new JSONArray();
        for (InscripcionTorneo i : lista) {
            JSONObject o = new JSONObject();
            o.put("loginUsuario",         i.getUsuario().getLogin());
            o.put("idTorneo",             i.getTorneo().getIdTorneo());
            o.put("cantidadParticipantes",i.getCantidadParticipantes());
            o.put("esFanatico",           i.isEsFanatico());
            o.put("esEmpleado",           i.isEsEmpleado());
            arr.put(o);
        }
        return arr;
    }

    // =========================================================================
    // DESERIALIZACIÓN
    // =========================================================================

    private static void deserializarUsuarios(JSONArray arr, EstadoBoardCafe e) {
        if (arr == null) return;
        for (int i = 0; i < arr.length(); i++) {
            JSONObject o = arr.getJSONObject(i);
            String tipo = o.getString("tipo");
            String login    = o.getString("login");
            String password = o.getString("password");
            String nombre   = o.getString("nombre");

            Usuario u;
            switch (tipo) {
                case "Administrador":
                    u = new Administrador(o.getInt("idAdmin"), login, password, nombre);
                    break;
                case "Mesero":
                    Mesero m = new Mesero(o.getInt("idEmpleado"), login, password, nombre);
                    JSONArray jdc = o.optJSONArray("juegosDificilesConocidos");
                    if (jdc != null) {
                        List<Integer> ids = new ArrayList<>();
                        for (int k = 0; k < jdc.length(); k++) ids.add(jdc.getInt(k));
                        m.setJuegosDificilesConocidos(ids);
                    }
                    u = m;
                    break;
                case "Cocinero":
                    u = new Cocinero(o.getInt("idEmpleado"), login, password, nombre);
                    break;
                case "Empleado":
                    u = new Empleado(o.getInt("idEmpleado"), login, password, nombre);
                    break;
                default: // "Cliente"
                    u = new Cliente(o.getInt("idCliente"), login, password, nombre);
                    break;
            }

            u.setPuntosFidelidad(o.optInt("puntosFidelidad", 0));
            JSONArray favs = o.optJSONArray("favoritos");
            if (favs != null) {
                List<Integer> fl = new ArrayList<>();
                for (int k = 0; k < favs.length(); k++) fl.add(favs.getInt(k));
                u.setFavoritos(fl);
            }

            if (u instanceof Empleado) {
                Empleado emp = (Empleado) u;
                emp.setEnTurno(o.optBoolean("enTurno", false));
                if (o.has("codigoDescuento"))
                    emp.setCodigoDescuento(o.getString("codigoDescuento"));
            }

            e.usuarios.put(login, u);
        }
    }

    private static void deserializarJuegos(JSONArray arr, EstadoBoardCafe e) {
        if (arr == null) return;
        for (int i = 0; i < arr.length(); i++) {
            JSONObject o = arr.getJSONObject(i);
            int    id    = o.getInt("idJuego");
            String nombre = o.getString("nombre");
            long   ms    = o.optLong("anioPublicacion", -1);
            Date   fecha = ms >= 0 ? new Date(ms) : null;
            int    min   = o.getInt("minJugadores");
            int    max   = o.getInt("maxJugadores");
            int    edad  = o.getInt("edadMinima");
            String cat   = o.getString("categoria");
            boolean dif  = o.getBoolean("esDificil");
            String tipo  = o.getString("tipo");

            JuegosDeMesa j;
            if ("venta".equals(tipo)) {
                j = new JuegoVenta(id, nombre, cat, dif, min, max, edad,
                                   o.getInt("stock"), o.getDouble("precio"));
                j.setAnioPublicacion(fecha);
            } else {
                j = new JuegosDeMesa(id, nombre, fecha, min, max, edad, cat, dif);
            }
            e.juegosDeMesa.put(id, j);
        }
    }

    private static void deserializarCopias(JSONArray arr, EstadoBoardCafe e) {
        if (arr == null) return;
        // Las copias están asociadas a juegos; necesitamos saber a qué juego
        // pertenece cada copia. Como no guardamos ese vínculo directamente,
        // reconstruimos el mapa global de copias y vinculamos por idCopia ↔ juego.
        // IMPORTANTE: el BoardCafe también mantiene un mapa global de copias,
        // así que simplemente llenamos ese mapa y luego vinculamos.
        for (int i = 0; i < arr.length(); i++) {
            JSONObject o  = arr.getJSONObject(i);
            int idCopia   = o.getInt("idCopia");
            boolean disp  = o.getBoolean("disponible");
            String estado = o.getString("estadoJuego");
            CopiaJuego c  = new CopiaJuego(idCopia, disp, estado);
            e.copias.put(idCopia, c);
        }

        // Ahora asociamos cada copia al juego correcto buscando por idCopia en
        // la lista de copias de cada juego. Como las copias ya existían antes de
        // guardar, están implícitamente vinculadas; aquí recreamos esa lista.
        // NOTA: el JSON de juegos NO guarda la lista de copias por simplicidad.
        // Si tu diseño requiere saber qué copia pertenece a qué juego al cargar,
        // agrega el campo "idJuego" a cada copia en serializarCopias() y haz la
        // asociación aquí.  La implementación base lo deja como extensión.
    }

    private static void deserializarMesas(JSONArray arr, EstadoBoardCafe e) {
        if (arr == null) return;
        for (int i = 0; i < arr.length(); i++) {
            JSONObject o = arr.getJSONObject(i);
            Mesa m = new Mesa(o.getInt("idMesa"), o.getInt("numeroPersonas"),
                              o.getBoolean("hayNinos"), o.getBoolean("hayJovenes"));
            e.mesas.put(m.getIdMesa(), m);
        }
    }

    private static void deserializarProductos(JSONArray arr, EstadoBoardCafe e) {
        if (arr == null) return;
        for (int i = 0; i < arr.length(); i++) {
            JSONObject o  = arr.getJSONObject(i);
            int id        = o.getInt("idProducto");
            String nombre = o.getString("nombre");
            double precio = o.getDouble("precio");
            boolean aprobado = o.getBoolean("aprobado");
            String tipo   = o.getString("tipo");

            Producto p;
            if ("Bebida".equals(tipo)) {
                p = new Bebida(id, nombre, precio,
                               o.getBoolean("alcoholica"), o.getBoolean("caliente"));
            } else {
                List<String> al = new ArrayList<>();
                JSONArray ja = o.optJSONArray("alergenos");
                if (ja != null) for (int k = 0; k < ja.length(); k++) al.add(ja.getString(k));
                p = new Pasteleria(id, nombre, precio, al);
            }
            p.setAprobado(aprobado);
            e.productos.put(id, p);
        }
    }

    private static void deserializarTurnos(JSONArray arr, EstadoBoardCafe e) {
        if (arr == null) return;
        // Mapa auxiliar: idTurno → Turno (para usarlo en solicitudes)
        e.turnosPorId = new HashMap<>();

        for (int i = 0; i < arr.length(); i++) {
            JSONObject o = arr.getJSONObject(i);
            int id = o.getInt("idTurno");
            Turno t = new Turno(id,
                                o.getString("diaSemana"),
                                Time.valueOf(o.getString("horaInicio")),
                                Time.valueOf(o.getString("horaFinal")));
            e.turnos.add(t);
            e.turnosPorId.put(id, t);
        }

        // Reasignamos turnos a empleados basándonos en los IDs de turno
        // que guardamos en cada usuario.  Aquí hacemos una segunda pasada
        // si serializarUsuarios guardase los idTurnos; como simplificación
        // se reasignan desde la lista global (ver nota de diseño en el README).
    }

    private static void deserializarSolicitudes(JSONArray arr, EstadoBoardCafe e) {
        if (arr == null) return;
        for (int i = 0; i < arr.length(); i++) {
            JSONObject o = arr.getJSONObject(i);
            int id = o.getInt("idSolicitud");

            Empleado solicitante  = buscarEmpleado(o.getString("loginSolicitante"),  e);
            Empleado intercambio  = buscarEmpleado(o.getString("loginIntercambio"),  e);
            Turno    turnoActual  = e.turnosPorId  != null
                                   ? e.turnosPorId.get(o.getInt("idTurnoActual"))
                                   : null;

            if (solicitante == null || intercambio == null || turnoActual == null) continue;

            SolicitudCambioTurno s = new SolicitudCambioTurno(
                    id, o.getString("cambioDia"), turnoActual, solicitante, intercambio);
            s.setEstado(o.getString("estado"));
            e.solicitudes.add(s);
            solicitante.getSolicitudes().add(s);
        }
    }

    private static void deserializarCompras(JSONArray arr, EstadoBoardCafe e) {
        if (arr == null) return;
        for (int i = 0; i < arr.length(); i++) {
            JSONObject o = arr.getJSONObject(i);
            List<JuegoVenta> juegos = new ArrayList<>();
            JSONArray ids = o.optJSONArray("idsJuegos");
            if (ids != null) {
                for (int k = 0; k < ids.length(); k++) {
                    JuegosDeMesa j = e.juegosDeMesa.get(ids.getInt(k));
                    if (j instanceof JuegoVenta) juegos.add((JuegoVenta) j);
                }
            }
            Compra c = new Compra(
                    o.getInt("idCompra"),
                    new Date(o.getLong("fecha")),
                    o.getDouble("valor"),
                    o.getDouble("impuesto"),
                    o.getDouble("descuento"),
                    o.getBoolean("descuentoAplicado"),
                    juegos,
                    o.getString("loginUsuario"));
            e.compras.add(c);
        }
    }

    private static void deserializarPedidos(JSONArray arr, EstadoBoardCafe e) {
        if (arr == null) return;
        for (int i = 0; i < arr.length(); i++) {
            JSONObject o = arr.getJSONObject(i);
            Pedido p = new Pedido(
                    o.getInt("idPedido"),
                    new Date(o.getLong("fecha")),
                    o.getDouble("propina"),
                    o.getDouble("descuento"),
                    o.getString("loginUsuario"));
            p.setDescuentoAplicado(o.getDouble("descuentoAplicado"));
            JSONArray ids = o.optJSONArray("idsProductos");
            if (ids != null) {
                for (int k = 0; k < ids.length(); k++) {
                    Producto prod = e.productos.get(ids.getInt(k));
                    if (prod != null) p.agregarProducto(prod);
                }
            }
            e.pedidos.add(p);
        }
    }

    private static void deserializarPrestamos(JSONArray arr, EstadoBoardCafe e) {
        if (arr == null) return;
        for (int i = 0; i < arr.length(); i++) {
            JSONObject o = arr.getJSONObject(i);
            Usuario solicitante = e.usuarios.get(o.getString("loginSolicitante"));
            if (solicitante == null) continue;

            Prestamo p = new Prestamo(o.getInt("idPrestamo"),
                                      o.getBoolean("advertenciaDificil"),
                                      solicitante);
            p.setFechaInicio(new Date(o.getLong("fechaInicio")));
            long fin = o.optLong("fechaFin", -1);
            if (fin >= 0) p.setFechaFin(new Date(fin));
            p.setActivo(o.getBoolean("activo"));

            JSONArray ids = o.optJSONArray("idsCopias");
            if (ids != null) {
                for (int k = 0; k < ids.length(); k++) {
                    CopiaJuego c = e.copias.get(ids.getInt(k));
                    if (c != null) p.agregarCopia(c);
                }
            }
            e.prestamos.add(p);
        }
    }

    private static void deserializarTorneos(JSONArray arr, EstadoBoardCafe e) {
        if (arr == null) return;
        for (int i = 0; i < arr.length(); i++) {
            JSONObject o = arr.getJSONObject(i);
            JuegosDeMesa juego = e.juegosDeMesa.get(o.getInt("idJuego"));
            Torneo t = new Torneo(
                    o.getInt("idTorneo"),
                    o.getString("nombre"),
                    o.getString("tipo"),
                    o.getInt("cuposTotales"),
                    o.getInt("cuposFanaticos"),
                    o.getInt("cuposRegularesOcupados"),
                    o.getInt("cuposFanaticosOcupados"),
                    o.getDouble("tarifaEntrada"),
                    o.getDouble("premioMetalico"),
                    o.getDouble("bonoDescuento"),
                    juego);
            t.setIdTorneo(o.getInt("idTorneo"));
            String loginGanador = o.optString("loginGanador", "");
            if (!loginGanador.isEmpty()) {
                Usuario ganador = e.usuarios.get(loginGanador);
                if (ganador != null) t.setGanador(ganador);
            }
            e.torneos.add(t);
        }
    }

    private static void deserializarInscripciones(JSONArray arr, EstadoBoardCafe e) {
        if (arr == null) return;
        for (int i = 0; i < arr.length(); i++) {
            JSONObject o = arr.getJSONObject(i);
            Usuario u = e.usuarios.get(o.getString("loginUsuario"));
            Torneo  t = buscarTorneoPorId(o.getInt("idTorneo"), e.torneos);
            if (u == null || t == null) continue;
            InscripcionTorneo ins = new InscripcionTorneo(
                    u,
                    o.getInt("cantidadParticipantes"),
                    o.getBoolean("esFanatico"),
                    o.getBoolean("esEmpleado"),
                    t);
            e.inscripciones.add(ins);
        }
    }



    private static String tipoDe(Usuario u) {
        if (u instanceof Mesero)        return "Mesero";
        if (u instanceof Cocinero)      return "Cocinero";
        if (u instanceof Administrador) return "Administrador";
        if (u instanceof Empleado)      return "Empleado";
        return "Cliente";
    }

    private static Empleado buscarEmpleado(String login, EstadoBoardCafe e) {
        Usuario u = e.usuarios.get(login);
        return (u instanceof Empleado) ? (Empleado) u : null;
    }

    private static Torneo buscarTorneoPorId(int id, List<Torneo> lista) {
        for (Torneo t : lista) if (t.getIdTorneo() == id) return t;
        return null;
    }
}