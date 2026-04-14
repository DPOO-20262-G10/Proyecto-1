package boardgamecafe.VentaJuegos;

import java.util.Date;
import java.util.List;

public class Compra {

    private Date fecha;
    private double valor;
    private double impuesto;
    private double descuento;
    private boolean descuentoAplicado;

    private List<JuegoVenta> juegos;

    public Compra(Date fecha, double valor, double impuesto,
                  double descuento, boolean descuentoAplicado,
                  List<JuegoVenta> juegos) {

        this.fecha = fecha;
        this.valor = valor;
        this.impuesto = impuesto;
        this.descuento = descuento;
        this.descuentoAplicado = descuentoAplicado;
        this.juegos = juegos;
    }

    public Date getFecha() {
        return fecha;
    }

    public double getValor() {
        return valor;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public double getDescuento() {
        return descuento;
    }

    public boolean isDescuentoAplicado() {
        return descuentoAplicado;
    }

    public List<JuegoVenta> getJuegos() {
        return juegos;
    }
}