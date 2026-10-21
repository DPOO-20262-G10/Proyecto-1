package entrenamiento;

public class ComentariosEntreno {

    private boolean asistencia;
    private String desempeño;
    private String comentario;
    private SesionEntreno sesionEntreno;

    public ComentariosEntreno() {
    }

    public ComentariosEntreno(boolean asistencia, String desempeño, String comentario) {
        this.asistencia = asistencia;
        this.desempeño = desempeño;
        this.comentario = comentario;
    }

    public boolean isAsistencia() {
        return asistencia;
    }

    public void setAsistencia(boolean asistencia) {
        this.asistencia = asistencia;
    }

    public String getDesempeño() {
        return desempeño;
    }

    public void setDesempeño(String desempeño) {
        this.desempeño = desempeño;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public SesionEntreno getSesionEntreno() {
        return sesionEntreno;
    }

    public void setSesionEntreno(SesionEntreno sesionEntreno) {
        this.sesionEntreno = sesionEntreno;
    }

}
