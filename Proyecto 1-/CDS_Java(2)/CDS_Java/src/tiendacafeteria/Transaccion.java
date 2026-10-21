package tiendacafeteria;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import usuarios.Usuario;

public abstract class Transaccion {

    private Date fecha;
    private Usuario usuario;
    private List<DetalleTransaccion> detallesTransaccion = new ArrayList<>();

    public Transaccion() {
    }

    public Transaccion(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<DetalleTransaccion> getDetallesTransaccion() {
        return detallesTransaccion;
    }

    public void setDetallesTransaccion(List<DetalleTransaccion> detallesTransaccion) {
        this.detallesTransaccion = detallesTransaccion;
    }

}
