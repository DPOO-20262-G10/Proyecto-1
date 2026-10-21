package usuarios;

import deportesgrupales.InscripcionEquipo;
import deportesindividuales.InscripcionAcademia;
import java.util.ArrayList;
import java.util.List;

public class Socio extends Usuario {

    private List<InscripcionEquipo> inscripcionesEquipo = new ArrayList<>();
    private List<InscripcionAcademia> inscripcionesAcademia = new ArrayList<>();

    public Socio() {
    }

    public Socio(String nombre, String login, String contraseña) {
        super(nombre, login, contraseña);
    }

    public List<InscripcionEquipo> getInscripcionesEquipo() {
        return inscripcionesEquipo;
    }

    public void setInscripcionesEquipo(List<InscripcionEquipo> inscripcionesEquipo) {
        this.inscripcionesEquipo = inscripcionesEquipo;
    }

    public List<InscripcionAcademia> getInscripcionesAcademia() {
        return inscripcionesAcademia;
    }

    public void setInscripcionesAcademia(List<InscripcionAcademia> inscripcionesAcademia) {
        this.inscripcionesAcademia = inscripcionesAcademia;
    }

}
