package boardgamecafe.menu;

public class Bebida extends Producto
{
	private boolean alcoholica;
	
	private boolean caliente;
	
	public Bebida(String nombre, double precio, boolean alcoholica, boolean caliente)
	{	
		super(nombre, precio);
		this.alcoholica = alcoholica;
		this.caliente = caliente;
	}
	
	public boolean esAlcoholica()
	{
		return alcoholica;
	}
	
	public boolean esCaliente()
	{
		return caliente;
	}
}
