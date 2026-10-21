package partido;

import deportesgrupales.Equipo;
import java.util.Date;

public class PartidoGrupal extends Partido {

    private Equipo equipoLocal;
    private Equipo equipoVisitante;

    public PartidoGrupal() {
    }

    public PartidoGrupal(Date fecha, String deporte, String marcador) {
        super(fecha, deporte, marcador);
    }

    public Equipo getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(Equipo equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public Equipo getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(Equipo equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

}
