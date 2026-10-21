package partido;

public abstract class EstadisticaJugador {

    private Partido partido;
    private EstadisticaCompetencia estadisticaCompetencia;

    public EstadisticaJugador() {
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public EstadisticaCompetencia getEstadisticaCompetencia() {
        return estadisticaCompetencia;
    }

    public void setEstadisticaCompetencia(EstadisticaCompetencia estadisticaCompetencia) {
        this.estadisticaCompetencia = estadisticaCompetencia;
    }

}
