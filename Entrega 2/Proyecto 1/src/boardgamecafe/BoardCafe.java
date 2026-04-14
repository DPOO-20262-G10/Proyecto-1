package boardgamecafe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;

import boardgamecafe.menu.Producto;
import boardgamecafe.pedidos.Pedido;
import boardgamecafe.pedidos.Prestamo;
import boardgamecafe.usuarios.Administrador;
import boardgamecafe.usuarios.Cliente;
import boardgamecafe.usuarios.Cocinero;
import boardgamecafe.usuarios.Mesero;
import boardgamecafe.usuarios.Usuario;

public class BoardCafe {


    private Map<String, Usuario> usuarios = new HashMap<>();
    private Map<Integer, JuegosDeMesa> juegos = new HashMap<>();
    private Map<Integer, CopiaJuego> copias = new HashMap<>();
    private Map<Integer, Producto> productos = new HashMap<>();
    private Map<Integer, Mesa> mesas = new HashMap<>();
    private List<Pedido> pedidos = new ArrayList<>();
    private List<Compra> compras = new ArrayList<>();
    private List<Prestamo> prestamos = new ArrayList<>();
    private List<Turno> turnos = new ArrayList<>();
    private List<SolicitudCambioTurno> solicitudes = new ArrayList<>();


    private int nextJuegoId = 1;
    private int nextCopiaId = 1;
    private int nextProductoId = 1;
    private int nextMesaId = 1;
    private int nextPedidoId = 1;
    private int nextCompraId = 1;
    private int nextPrestamoId = 1;
    private int nextSolicitudId = 1;
    


    public BoardCafe() {
        this.usuarios = new HashMap<>();
        this.juegos = new HashMap<>();
        this.copias = new HashMap<>();
        this.productos = new HashMap<>();
        this.mesas = new HashMap<>();
        this.pedidos = new ArrayList<>();
        this.compras = new ArrayList<>();
        this.prestamos = new ArrayList<>();
        this.turnos = new ArrayList<>();
        this.solicitudes = new ArrayList<>();
    }



    public void registrarUsuario(String nombre, String login, String password, String tipo) {
    // Verificar si el usuario ya existe
    if (usuarios.containsKey(login)) {
        throw new IllegalArgumentException("Error: El usuario con login '" + login + "' ya existe.");
    }
    
        Usuario user = new Usuario();
        user.nombre = nombre;
        user.login = login;
        user.password = password;
        user.tipo = tipo;
        usuarios.put(login, user);
        System.out.println("Usuario registrado: " + nombre);
    }


    public boolean login(String login, String password) {
        Usuario user = usuarios.get(login);
        if (user != null && user.password.equals(password)) {
            System.out.println("Login exitoso: " + login);
            return true;
        }
        System.out.println("Login fallido: " + login);
        return false;
    }

    public void logout(String login) {
        System.out.println("Logout: " + login);
    }


    public void agregarJuego(String nombre, Date anioPublicacion, String empresaMatriz, int minJugadores, int maxJugadores, int edadMinima, String categoria, boolean esDificil) {
        JuegoDeMesa juego = new JuegoDeMesa();
        juego.id = nextJuegoId++;
        juego.nombre = nombre;
        juego.anioPublicacion = anioPublicacion;
        juego.empresaMatriz = empresaMatriz;
        juego.minJugadores = minJugadores;
        juego.maxJugadores = maxJugadores;
        juego.edadMinima = edadMinima;
        juego.categoria = categoria;
        juego.esDificil = esDificil;
        juegos.put(juego.id, juego);
        System.out.println("Juego agregado: " + nombre + " (ID: " + juego.id + ")");
    }

    public JuegoDeMesa buscarJuego(String nombre) {
        for (JuegoDeMesa juego : juegos.values()) {
            if (juego.nombre.equalsIgnoreCase(nombre)) {
                return juego;
            }
        }
        return null;
    }






}
