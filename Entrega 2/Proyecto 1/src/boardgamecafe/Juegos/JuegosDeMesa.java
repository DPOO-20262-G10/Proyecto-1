package boardgamecafe.Juegos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JuegosDeMesa {

    private int idJuego;
    private String nombre;
    private Date anioPublicacion;
    private int minJugadores;
    private int maxJugadores;
    private int edadMinima;
    private boolean esDificil;
    private String categoria;
    private List<CopiaJuego> copias;

    public JuegosDeMesa() {
        this.copias = new ArrayList<CopiaJuego>();
    }

    public JuegosDeMesa(int idJuego, String nombre, Date anioPublicacion, int minJugadores,
            int maxJugadores, int edadMinima, String categoria, boolean esDificil) {
        this.idJuego = idJuego;
        this.nombre = nombre;
        this.anioPublicacion = anioPublicacion;
        this.minJugadores = minJugadores;
        this.maxJugadores = maxJugadores;
        this.edadMinima = edadMinima;
        this.categoria = categoria;
        this.esDificil = esDificil;
        this.copias = new ArrayList<CopiaJuego>();
    }

    public CopiaJuego obtenerCopiaDisponible() {
        for (CopiaJuego c : copias) {
            if (c.isDisponible()) {
                return c;
            }
        }
        return null;
    }

    public int contarCopiasDisponibles() {
        int count = 0;

        for (CopiaJuego c : copias) {
            if (c.isDisponible())
                count++;
        }

        return count;
    }

    // Getters y Setters
    public int getIdJuego() {
        return idJuego;
    }

    public void setIdJuego(int idJuego) {
        this.idJuego = idJuego;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(Date anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public int getMinJugadores() {
        return minJugadores;
    }

    public void setMinJugadores(int minJugadores) {
        this.minJugadores = minJugadores;
    }

    public int getMaxJugadores() {
        return maxJugadores;
    }

    public void setMaxJugadores(int maxJugadores) {
        this.maxJugadores = maxJugadores;
    }

    public int getEdadMinima() {
        return edadMinima;
    }

    public void setEdadMinima(int edadMinima) {
        this.edadMinima = edadMinima;
    }

    public boolean isEsDificil() {
        return esDificil;
    }

    public void setEsDificil(boolean esDificil) {
        this.esDificil = esDificil;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public List<CopiaJuego> getCopias() {
        return copias;
    }

    public void setCopias(List<CopiaJuego> copias) {
        this.copias = copias;
    }
}
