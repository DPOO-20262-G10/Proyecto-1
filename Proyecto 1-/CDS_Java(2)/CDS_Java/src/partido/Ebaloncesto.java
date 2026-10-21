package partido;

public class Ebaloncesto extends EstadisticaJugador {

    private int puntos;
    private int rebotes;

    public Ebaloncesto() {
    }

    public Ebaloncesto(int puntos, int rebotes) {
        this.puntos = puntos;
        this.rebotes = rebotes;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getRebotes() {
        return rebotes;
    }

    public void setRebotes(int rebotes) {
        this.rebotes = rebotes;
    }

}
