package boardgamecafe.menu;

import java.util.ArrayList;
import java.util.List;


public class Pasteleria extends Producto {

    private List<String> alergenos;

    public Pasteleria(int idProducto, String nombre, double precio, List<String> alergenos) {
		super(idProducto, nombre, precio, "Pasteleria");
		if (alergenos != null) {
			this.alergenos = alergenos;
		} else {
			this.alergenos = new ArrayList<String>();
		}
	}

	public Pasteleria(String nombre, double precio, List<String> alergenos) {
		super(0, nombre, precio, "Pasteleria");
		if (alergenos != null) {
			this.alergenos = alergenos;
		} else {
			this.alergenos = new ArrayList<String>();
		}
	}

    public void agregarAlergeno(String alergeno) {
        if (!alergenos.contains(alergeno)) 
        {
            alergenos.add(alergeno);
        }
    }

    public void mostrarAlergenos() {
        System.out.println("Alergenos de " + getNombre() + ":");

        if (alergenos.isEmpty()) {
            System.out.println("  sin alergenos conocidos");
        } else {
            for (String a : alergenos) {
                System.out.println("  - " + a);
            }
        }
    }

    public List<String> getAlergenos() 
    { 
        return alergenos; 
    }

    public void setAlergenos(List<String> alergenos) 
    { 
        this.alergenos = alergenos; 
    }
    
}
