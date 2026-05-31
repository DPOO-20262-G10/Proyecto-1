package boardgamecafe.VentaJuegos;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import boardgamecafe.Juegos.JuegoVenta;

public class Compra {

    private int idCompra;
    private Date fecha;
    private double valor;
    private double impuesto;
    private double descuento;
    private boolean descuentoAplicado;
    private List<JuegoVenta> juegos;
    private String loginUsuario;

    public Compra(int idCompra, Date fecha, double valor, double impuesto, double descuento, boolean descuentoAplicado, List<JuegoVenta> juegos, String loginUsuario) {
        this.idCompra = idCompra;
        this.fecha = fecha;
        this.valor = valor;
        this.impuesto = impuesto;
        this.descuento = descuento;
        this.descuentoAplicado = descuentoAplicado;
        if (juegos != null) {
            this.juegos = juegos;
        } else {
            this.juegos = new ArrayList<JuegoVenta>();
        }
            this.loginUsuario = loginUsuario;
        }      

    public int getIdCompra() 
    {
        return idCompra;
    }

    public Date getFecha() 
    {
        return fecha;
    }

    public double getValor() 
    {
        return valor;
    }

    public double getImpuesto() 
    {
        return impuesto;
    }

    public double getDescuento() 
    {
        return descuento;
    }

    public boolean isDescuentoAplicado() 
    {
        return descuentoAplicado;
    }

    public List<JuegoVenta> getJuegos() 
    {
        return juegos;
    }

    public String getLoginUsuario() 
    {
        return loginUsuario;
    }

    public void setIdCompra(int idCompra) 
    {
        this.idCompra = idCompra;
    }

    public void setFecha(Date fecha) 
    {
        this.fecha = fecha;
    }

    public void setValor(double valor) 
    {
        this.valor = valor;
    }

    public void setImpuesto(double impuesto) 
    {
        this.impuesto = impuesto;
    }

    public void setDescuento(double descuento) 
    {
        this.descuento = descuento;
    }

    public void setDescuentoAplicado(boolean descuentoAplicado) 
    {
        this.descuentoAplicado = descuentoAplicado;
    }

    public void setJuegos(List<JuegoVenta> juegos) 
    {
        this.juegos = juegos;
    }

    public void setLoginUsuario(String loginUsuario) 
    {
        this.loginUsuario = loginUsuario;
    }
}
