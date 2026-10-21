package entrenamiento;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import usuarios.Empleado;

public abstract class SesionEntreno {

    private Date fecha;
    private Time hora;
    private int duracion;
    private List<ComentariosEntreno> comentariosEntreno = new ArrayList<>();
    private Empleado empleado;

    public SesionEntreno() {
    }

    public SesionEntreno(Date fecha, Time hora, int duracion) {
        this.fecha = fecha;
        this.hora = hora;
        this.duracion = duracion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public List<ComentariosEntreno> getComentariosEntreno() {
        return comentariosEntreno;
    }

    public void setComentariosEntreno(List<ComentariosEntreno> comentariosEntreno) {
        this.comentariosEntreno = comentariosEntreno;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

}
