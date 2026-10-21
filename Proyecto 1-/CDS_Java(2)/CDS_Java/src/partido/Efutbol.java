package partido;

public class Efutbol extends EstadisticaJugador {

    private int goles;
    private int asistencias;
    private int tarjetas_amarillas;
    private int tarjeta_roja;

    public Efutbol() {
    }

    public Efutbol(int goles, int asistencias, int tarjetas_amarillas, int tarjeta_roja) {
        this.goles = goles;
        this.asistencias = asistencias;
        this.tarjetas_amarillas = tarjetas_amarillas;
        this.tarjeta_roja = tarjeta_roja;
    }

    public int getGoles() {
        return goles;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }

    public int getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(int asistencias) {
        this.asistencias = asistencias;
    }

    public int getTarjetas_amarillas() {
        return tarjetas_amarillas;
    }

    public void setTarjetas_amarillas(int tarjetas_amarillas) {
        this.tarjetas_amarillas = tarjetas_amarillas;
    }

    public int getTarjeta_roja() {
        return tarjeta_roja;
    }

    public void setTarjeta_roja(int tarjeta_roja) {
        this.tarjeta_roja = tarjeta_roja;
    }

}
