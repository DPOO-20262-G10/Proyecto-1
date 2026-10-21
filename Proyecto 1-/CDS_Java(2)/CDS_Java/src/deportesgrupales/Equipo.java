package deportesgrupales;

import club.Club;
import entrenamiento.SesionEntrenoEquipo;
import java.util.ArrayList;
import java.util.List;

public class Equipo {

    private String nombre;
    private String deporte;
    private String categoria;
    private int num_integrantes;
    private int cupo_maximo;
    private List<InscripcionEquipo> inscripcionesEquipo = new ArrayList<>();
    private Club club;
    private List<InscripcionCompetencia> inscripcionesCompetencia = new ArrayList<>();
    private List<SesionEntrenoEquipo> sesionesEntrenoEquipo = new ArrayList<>();

    public Equipo() {
    }

    public Equipo(String nombre, String deporte, String categoria, int num_integrantes, int cupo_maximo) {
        this.nombre = nombre;
        this.deporte = deporte;
        this.categoria = categoria;
        this.num_integrantes = num_integrantes;
        this.cupo_maximo = cupo_maximo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getNum_integrantes() {
        return num_integrantes;
    }

    public void setNum_integrantes(int num_integrantes) {
        this.num_integrantes = num_integrantes;
    }

    public int getCupo_maximo() {
        return cupo_maximo;
    }

    public void setCupo_maximo(int cupo_maximo) {
        this.cupo_maximo = cupo_maximo;
    }

    public List<InscripcionEquipo> getInscripcionesEquipo() {
        return inscripcionesEquipo;
    }

    public void setInscripcionesEquipo(List<InscripcionEquipo> inscripcionesEquipo) {
        this.inscripcionesEquipo = inscripcionesEquipo;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public List<InscripcionCompetencia> getInscripcionesCompetencia() {
        return inscripcionesCompetencia;
    }

    public void setInscripcionesCompetencia(List<InscripcionCompetencia> inscripcionesCompetencia) {
        this.inscripcionesCompetencia = inscripcionesCompetencia;
    }

    public List<SesionEntrenoEquipo> getSesionesEntrenoEquipo() {
        return sesionesEntrenoEquipo;
    }

    public void setSesionesEntrenoEquipo(List<SesionEntrenoEquipo> sesionesEntrenoEquipo) {
        this.sesionesEntrenoEquipo = sesionesEntrenoEquipo;
    }

}
