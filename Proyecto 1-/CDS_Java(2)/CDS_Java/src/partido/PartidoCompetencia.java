package partido;

import deportesgrupales.Competencia;
import java.util.Date;

public class PartidoCompetencia extends PartidoGrupal {

    private String escenario;
    private Competencia competencia;

    public PartidoCompetencia() {
    }

    public PartidoCompetencia(Date fecha, String deporte, String marcador, String escenario) {
        super(fecha, deporte, marcador);
        this.escenario = escenario;
    }

    public String getEscenario() {
        return escenario;
    }

    public void setEscenario(String escenario) {
        this.escenario = escenario;
    }

    public Competencia getCompetencia() {
        return competencia;
    }

    public void setCompetencia(Competencia competencia) {
        this.competencia = competencia;
    }

}
