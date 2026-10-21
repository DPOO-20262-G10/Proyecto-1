package partido;

import java.util.ArrayList;
import java.util.List;

public class EstadisticaCompetencia {

    private List<EstadisticaJugador> estadisticasJugador = new ArrayList<>();

    public EstadisticaCompetencia() {
    }

    public List<EstadisticaJugador> getEstadisticasJugador() {
        return estadisticasJugador;
    }

    public void setEstadisticasJugador(List<EstadisticaJugador> estadisticasJugador) {
        this.estadisticasJugador = estadisticasJugador;
    }

}
