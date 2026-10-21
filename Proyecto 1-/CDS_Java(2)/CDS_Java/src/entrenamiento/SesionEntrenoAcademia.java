package entrenamiento;

import deportesindividuales.Academia;
import java.sql.Time;
import java.util.Date;

public class SesionEntrenoAcademia extends SesionEntreno {

    private Academia academia;

    public SesionEntrenoAcademia() {
    }

    public SesionEntrenoAcademia(Date fecha, Time hora, int duracion) {
        super(fecha, hora, duracion);
    }

    public Academia getAcademia() {
        return academia;
    }

    public void setAcademia(Academia academia) {
        this.academia = academia;
    }

}
