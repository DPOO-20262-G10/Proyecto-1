package tiendacafeteria;

import java.util.ArrayList;
import java.util.List;

public abstract class Producto {

    private String nombre;
    private double precio;
    private int cantidad;
    private List<DetalleTransaccion> detallesTransaccion = new ArrayList<>();

    public Producto() {
    }

    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public List<DetalleTransaccion> getDetallesTransaccion() {
        return detallesTransaccion;
    }

    public void setDetallesTransaccion(List<DetalleTransaccion> detallesTransaccion) {
        this.detallesTransaccion = detallesTransaccion;
    }

}
