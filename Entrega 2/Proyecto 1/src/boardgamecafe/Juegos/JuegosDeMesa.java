package boardgamecafe.Juegos;

import java.util.Date;
import java.util.List;

public class JuegosDeMesa {

    private String nombre;
    private Date anioPublicacion;
    private String empresaMatriz;
    private int minJugadores;
    private int maxJugadores;
    private int edadMinima;
    private String estadoJuego;
    private boolean esDificil;

    private CategoriaJuego categoria;
    private List<CopiaJuego> copias;

    public JuegosDeMesa(String nombre,
                        Date anioPublicacion,
                        String empresaMatriz,
                        int minJugadores,
                        int maxJugadores,
                        int edadMinima,
                        String estadoJuego,
                        boolean esDificil,
                        CategoriaJuego categoria) {

        this.nombre = nombre;
        this.anioPublicacion = anioPublicacion;
        this.empresaMatriz = empresaMatriz;
        this.minJugadores = minJugadores;
        this.maxJugadores = maxJugadores;
        this.edadMinima = edadMinima;
        this.estadoJuego = estadoJuego;
        this.esDificil = esDificil;
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public Date getAnioPublicacion() {
        return anioPublicacion;
    }

    public String getEmpresaMatriz() {
        return empresaMatriz;
    }

    public int getMinJugadores() {
        return minJugadores;
    }

    public int getMaxJugadores() {
        return maxJugadores;
    }

    public int getEdadMinima() {
        return edadMinima;
    }

    public String getEstadoJuego() {
        return estadoJuego;
    }

    public boolean isEsDificil() {
        return esDificil;
    }

    public CategoriaJuego getCategoria() {
        return categoria;
    }

    public List<CopiaJuego> getCopias() {
        return copias;
    }

    public void setCopias(List<CopiaJuego> copias) {
        this.copias = copias;
    }
}