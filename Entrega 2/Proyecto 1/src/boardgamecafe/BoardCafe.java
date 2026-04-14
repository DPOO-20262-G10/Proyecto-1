package boardgamecafe;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import boardgamecafe.menu.Producto;
import boardgamecafe.pedidos.Compra;
import boardgamecafe.pedidos.Pedido;
import boardgamecafe.pedidos.Prestamo;
import boardgamecafe.usuarios.Administrador;
import boardgamecafe.usuarios.Cliente;
import boardgamecafe.usuarios.Cocinero;
import boardgamecafe.usuarios.Mesero;
import boardgamecafe.usuarios.Usuario;

public class BoardCafe {

    private Map<String, Usuario> usuarios;
    private Map<Integer, JuegosDeMesa> juegos;
    private Map<Integer, CopiaJuego> copias;
    private Map<Integer, Producto> productos;
    private Map<Integer, Mesa> mesas;
    private List<Pedido> pedidos;
    private List<Compra> compras;
    private List<Prestamo> prestamos;
    private List<Turno> turnos;
    private List<SolicitudCambioTurno> solicitudes;
    private int nextJuegoId = 1;
    private int nextPedidoId = 1;
    private int nextPrestamoId = 1;
    private int nextCompraId = 1;

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
        if (usuarios.containsKey(login)) {
            System.out.println("El login ya existe");
            return;
        }
        int nuevoId = usuarios.size() + 1;
        if (tipo.equals("cliente")) {
            usuarios.put(login, new Cliente(nuevoId, login, password, this));
        } else if (tipo.equals("mesero")) {
            usuarios.put(login, new Mesero(nuevoId, login, password, this));
        } else if (tipo.equals("cocinero")) {
            usuarios.put(login, new Cocinero(nuevoId, login, password, this));
        } else if (tipo.equals("administrador")) {
            usuarios.put(login, new Administrador(nuevoId, login, password, this));
        } else {
            System.out.println("Tipo de usuario invalido");
        }
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
