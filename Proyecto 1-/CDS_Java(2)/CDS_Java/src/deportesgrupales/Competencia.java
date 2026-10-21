package deportesgrupales;

import java.util.ArrayList;
import java.util.List;
import partido.PartidoCompetencia;

public class Competencia {

    private String nombre;
    private String entidad;
    private String temporada;
    private String deporte;
    private String categoria;
    private String formato;
    private List<InscripcionCompetencia> inscripcionesCompetencia = new ArrayList<>();
    private List<PartidoCompetencia> partidosCompetencia = new ArrayList<>();

    public Competencia() {
    }

    public Competencia(String nombre, String entidad, String temporada, String deporte, String categoria, String formato) {
        this.nombre = nombre;
        this.entidad = entidad;
        this.temporada = temporada;
        this.deporte = deporte;
        this.categoria = categoria;
        this.formato = formato;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    public String getTemporada() {
        return temporada;
    }

    public void setTemporada(String temporada) {
        this.temporada = temporada;
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

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public List<InscripcionCompetencia> getInscripcionesCompetencia() {
        return inscripcionesCompetencia;
    }

    public void setInscripcionesCompetencia(List<InscripcionCompetencia> inscripcionesCompetencia) {
        this.inscripcionesCompetencia = inscripcionesCompetencia;
    }

    public List<PartidoCompetencia> getPartidosCompetencia() {
        return partidosCompetencia;
    }

    public void setPartidosCompetencia(List<PartidoCompetencia> partidosCompetencia) {
        this.partidosCompetencia = partidosCompetencia;
    }

}
