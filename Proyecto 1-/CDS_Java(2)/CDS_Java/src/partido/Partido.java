package partido;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Partido {

    private Date fecha;
    private String deporte;
    private String marcador;
    private List<EstadisticaJugador> estadisticasJugador = new ArrayList<>();

    public Partido() {
    }

    public Partido(Date fecha, String deporte, String marcador) {
        this.fecha = fecha;
        this.deporte = deporte;
        this.marcador = marcador;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public String getMarcador() {
        return marcador;
    }

    public void setMarcador(String marcador) {
        this.marcador = marcador;
    }

    public List<EstadisticaJugador> getEstadisticasJugador() {
        return estadisticasJugador;
    }

    public void setEstadisticasJugador(List<EstadisticaJugador> estadisticasJugador) {
        this.estadisticasJugador = estadisticasJugador;
    }

}
