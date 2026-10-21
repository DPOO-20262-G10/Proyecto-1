package entrenamiento;

import deportesgrupales.Equipo;
import java.sql.Time;
import java.util.Date;

public class SesionEntrenoEquipo extends SesionEntreno {

    private Equipo equipo;

    public SesionEntrenoEquipo() {
    }

    public SesionEntrenoEquipo(Date fecha, Time hora, int duracion) {
        super(fecha, hora, duracion);
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

}
