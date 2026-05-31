package boardgamecafe.persistencia;

import boardgamecafe.Juegos.CopiaJuego;
import boardgamecafe.Juegos.JuegosDeMesa;
import boardgamecafe.Torneos.InscripcionTorneo;
import boardgamecafe.Torneos.Torneo;
import boardgamecafe.Turnos.SolicitudCambioTurno;
import boardgamecafe.Turnos.Turno;
import boardgamecafe.VentaJuegos.Compra;
import boardgamecafe.menu.Producto;
import boardgamecafe.pedidos.Mesa;
import boardgamecafe.pedidos.Pedido;
import boardgamecafe.pedidos.Prestamo;
import boardgamecafe.usuarios.Usuario;


import java.util.*;

/**
 * Objeto de transferencia de datos (DTO) que agrupa todos los campos
 * persistibles de BoardCafe.
 *
 * BoardCafe crea una instancia, la rellena con sus colecciones y la pasa
 * a PersistenciaJSON.guardar(). En el constructor llama a cargar() y
 * restaura sus campos desde el DTO.
 */
public class EstadoBoardCafe {

    // Colecciones principales
    public Map<String,  Usuario>            usuarios      = new HashMap<>();
    public Map<Integer, JuegosDeMesa>       juegosDeMesa  = new HashMap<>();
    public Map<Integer, CopiaJuego>         copias        = new HashMap<>();
    public Map<Integer, Mesa>               mesas         = new HashMap<>();
    public Map<Integer, Producto>           productos     = new HashMap<>();
    public List<Compra>                     compras       = new ArrayList<>();
    public List<Pedido>                     pedidos       = new ArrayList<>();
    public List<Prestamo>                   prestamos     = new ArrayList<>();
    public List<Turno>                      turnos        = new ArrayList<>();
    public List<SolicitudCambioTurno>       solicitudes   = new ArrayList<>();
    public List<Torneo>                     torneos       = new ArrayList<>();
    public List<InscripcionTorneo>          inscripciones = new ArrayList<>();

    // Auxiliar interno: usado durante la deserialización
    // (no se persiste, se construye al cargar)
    public transient Map<Integer, Turno>    turnosPorId;

    // Contadores de IDs autoincremental
    public int ultimoIdUsuario   = 1;
    public int ultimoIdJuego     = 1;
    public int ultimoIdCopia     = 1;
    public int ultimoIdMesa      = 1;
    public int ultimoIdProducto  = 1;
    public int ultimoIdCompra    = 1;
    public int ultimoIdPedido    = 1;
    public int ultimoIdPrestamo  = 1;
    public int ultimoIdTurno     = 1;
    public int ultimoIdSolicitud = 1;
    public int ultimoIdTorneo    = 1;
}