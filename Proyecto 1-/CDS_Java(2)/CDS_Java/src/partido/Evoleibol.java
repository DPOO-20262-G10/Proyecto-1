package partido;

public class Evoleibol extends EstadisticaJugador {

    private int aces;
    private int bloqueos;

    public Evoleibol() {
    }

    public Evoleibol(int aces, int bloqueos) {
        this.aces = aces;
        this.bloqueos = bloqueos;
    }

    public int getAces() {
        return aces;
    }

    public void setAces(int aces) {
        this.aces = aces;
    }

    public int getBloqueos() {
        return bloqueos;
    }

    public void setBloqueos(int bloqueos) {
        this.bloqueos = bloqueos;
    }

}
