package boardgamecafe.Juegos;

public class CopiaJuego {

    private int idCopia;
    private boolean disponible;
    private JuegosDeMesa juego;

    public CopiaJuego(int idCopia, boolean disponible, JuegosDeMesa juego) {
        this.idCopia = idCopia;
        this.disponible = disponible;
        this.juego = juego;
    }

    public int getIdCopia() {
        return idCopia;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public JuegosDeMesa getJuego() {
        return juego;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}