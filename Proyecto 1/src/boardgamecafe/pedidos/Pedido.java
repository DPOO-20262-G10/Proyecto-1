package boardgamecafe.pedidos;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import boardgamecafe.menu.Producto;



public class Pedido 
{
	private Date fecha;
	
	private List<Producto> productos;
	
	private double propina;
	
	private double descuento;
	
	private boolean descuentoAplicado;
	
	public Pedido(Date fecha, double propina, double descuento, boolean descuentoAplicado)
	{
		this.fecha = fecha;
		this.productos = new ArrayList<>();
		this.propina = propina;
		this.descuento = descuento;
		this.descuentoAplicado = descuentoAplicado;
	}
	
	public Date getFecha()
	{
		return fecha;
	}
	
	public void agregarProducto(Producto producto)
	{
		productos.add(producto);
	}
	
	public List<Producto> getProductos()
	{
		return productos;
	}
	
	public double calcularSubtotal()
	{
		double subtotal = 0;
		
		for (Producto p : productos)
		{
			subtotal += p.getPrecio();
		}
		return subtotal;
	}
	
	public double calcularImpuestoConsumo()
	{
		return calcularSubtotal() * 0.08;
	}
	
	public double calcularTotal()
	{
		double total = calcularSubtotal() + calcularImpuestoConsumo() + propina;
		
		if (descuentoAplicado)
		{
			total = total - descuento;
		}
		
		return total;
	}
}
