package boardgamecafe.menu;

import java.util.List;
import java.util.ArrayList;

public class Pasteleria extends Producto
{
	private List<String> alergenos;
	
	public Pasteleria(String nombre, double precio)
	{
		super(nombre, precio);
		alergenos = new ArrayList<>();
	}
	
	public List<String> getAlergenos()
	{
		return alergenos;
	}
	
	public void agregarAlergenos(String alergeno)
	{
		alergenos.add(alergeno);
	}
}
