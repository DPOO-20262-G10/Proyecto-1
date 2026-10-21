package tiendacafeteria;

import java.util.Date;

public class TransaccionTienda extends Transaccion {

    private double IVA = 0.19;
    private double descuentoSocio = 0.08;
    private double descuentoEmpleado = 0.15;

    public TransaccionTienda() {
    }

    public TransaccionTienda(Date fecha) {
        super(fecha);
    }

    public double getIVA() {
        return IVA;
    }

    public void setIVA(double IVA) {
        this.IVA = IVA;
    }

    public double getDescuentoSocio() {
        return descuentoSocio;
    }

    public void setDescuentoSocio(double descuentoSocio) {
        this.descuentoSocio = descuentoSocio;
    }

    public double getDescuentoEmpleado() {
        return descuentoEmpleado;
    }

    public void setDescuentoEmpleado(double descuentoEmpleado) {
        this.descuentoEmpleado = descuentoEmpleado;
    }

}
