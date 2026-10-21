package partido;

public class Etenismesa extends EstadisticaJugador {

    private int sets_ganados;
    private int puntosTotales;

    public Etenismesa() {
    }

    public Etenismesa(int sets_ganados, int puntosTotales) {
        this.sets_ganados = sets_ganados;
        this.puntosTotales = puntosTotales;
    }

    public int getSets_ganados() {
        return sets_ganados;
    }

    public void setSets_ganados(int sets_ganados) {
        this.sets_ganados = sets_ganados;
    }

    public int getPuntosTotales() {
        return puntosTotales;
    }

    public void setPuntosTotales(int puntosTotales) {
        this.puntosTotales = puntosTotales;
    }

}
