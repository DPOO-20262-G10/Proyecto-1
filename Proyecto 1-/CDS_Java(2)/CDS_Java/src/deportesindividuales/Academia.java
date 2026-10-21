package deportesindividuales;

import club.Club;
import entrenamiento.SesionEntrenoAcademia;
import java.util.ArrayList;
import java.util.List;
import partido.PartidoAcademia;

public class Academia {

    private String nombre;
    private int num_mesas;
    private Club club;
    private List<InscripcionAcademia> inscripcionesAcademia = new ArrayList<>();
    private List<Instalacion> instalaciones = new ArrayList<>();
    private List<PartidoAcademia> partidosAcademia = new ArrayList<>();
    private List<SesionEntrenoAcademia> sesionesEntrenoAcademia = new ArrayList<>();

    public Academia() {
    }

    public Academia(String nombre, int num_mesas) {
        this.nombre = nombre;
        this.num_mesas = num_mesas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNum_mesas() {
        return num_mesas;
    }

    public void setNum_mesas(int num_mesas) {
        this.num_mesas = num_mesas;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public List<InscripcionAcademia> getInscripcionesAcademia() {
        return inscripcionesAcademia;
    }

    public void setInscripcionesAcademia(List<InscripcionAcademia> inscripcionesAcademia) {
        this.inscripcionesAcademia = inscripcionesAcademia;
    }

    public List<Instalacion> getInstalaciones() {
        return instalaciones;
    }

    public void setInstalaciones(List<Instalacion> instalaciones) {
        this.instalaciones = instalaciones;
    }

    public List<PartidoAcademia> getPartidosAcademia() {
        return partidosAcademia;
    }

    public void setPartidosAcademia(List<PartidoAcademia> partidosAcademia) {
        this.partidosAcademia = partidosAcademia;
    }

    public List<SesionEntrenoAcademia> getSesionesEntrenoAcademia() {
        return sesionesEntrenoAcademia;
    }

    public void setSesionesEntrenoAcademia(List<SesionEntrenoAcademia> sesionesEntrenoAcademia) {
        this.sesionesEntrenoAcademia = sesionesEntrenoAcademia;
    }

}
