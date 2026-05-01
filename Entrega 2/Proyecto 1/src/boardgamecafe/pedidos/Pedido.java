package boardgamecafe.pedidos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import boardgamecafe.menu.Producto;

public class Pedido {

    private int idPedido;
    private Date fecha;
    private double propina;
    private double descuento;
    private double descuentoAplicado;
    private List<Producto> productos;
    private String loginUsuario;

    private static final double IMPUESTO_CONSUMO = 0.08;

    public Pedido(int idPedido, Date fecha, double propina, double descuento, String loginUsuario) {
        this.idPedido = idPedido;
        this.fecha = fecha;
        this.propina = propina;
        this.descuento = descuento;
        this.descuentoAplicado = 0.0;
        this.productos = new ArrayList<Producto>();
        this.loginUsuario = loginUsuario;
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public double calcularSubtotal() {
        double subtotal = 0.0;

        for (Producto p : productos) {
            subtotal += p.getPrecio();
        }
        
        return subtotal;
    }

    public double calcularImpuestoConsumo() {
        return calcularSubtotal() * IMPUESTO_CONSUMO;
    }

    public double calcularTotal(){
        double subtotal = calcularSubtotal();
        double impuesto = calcularImpuestoConsumo();
        double totalBase = subtotal + impuesto + propina;
        return totalBase - descuento - descuentoAplicado;
    }

    public List<Producto> getProductos() 
	{
        return productos;
    }

    public int getIdPedido() 
	{
        return idPedido;
    }

    public void setIdPedido(int idPedido) 
	{
        this.idPedido = idPedido;
    }

    public Date getFecha() 
	{
        return fecha;
    }

    public void setFecha(Date fecha) 
	{
        this.fecha = fecha;
    }

    public double getPropina() 
	{
        return propina;
    }

    public void setPropina(double propina) 
	{
        this.propina = propina;
    }

    public double getDescuento() 
	{
        return descuento;
    }

    public void setDescuento(double descuento) 
	{
        this.descuento = descuento;
    }

    public double getDescuentoAplicado() 
	{
        return descuentoAplicado;
    }

    public void setDescuentoAplicado(double descuentoAplicado) 
	{
        this.descuentoAplicado = descuentoAplicado;
    }

    
	public void setProductos(List<Producto> productos) 
	{
        this.productos = productos;
    }

    public String getLoginUsuario() 
	{
        return loginUsuario;
    }

    public void setLoginUsuario(String loginUsuario) 
	{
        this.loginUsuario = loginUsuario;
    }
}
