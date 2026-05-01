package boardgamecafe.menu;


public abstract class Producto {

    private int idProducto;
    private String nombre;
    private double precio;
    private String tipo;
    private boolean aprobado;

    public Producto(int idProducto, String nombre, double precio, String tipo) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
        this.aprobado = true;
    }

    
    public int getIdProducto() 
	{ 
		return idProducto; 
	}

    public void setIdProducto(int idProducto) 
	{ 
		this.idProducto = idProducto; 
	}

    public String getNombre() 
	{ 
		return nombre; 
	}

    public void setNombre(String nombre) 
	{ 
		this.nombre = nombre; 
	}

    public double getPrecio() 
	{ 
		return precio; 
	}

    public void setPrecio(double precio) 
	{ 
		this.precio = precio; 
	}

    public String getTipo() 
	{ 
		return tipo; 
	}
    
	public void setTipo(String tipo) 
	{ 
		this.tipo = tipo; 
	}

    public boolean isAprobado() 
	{ 
		return aprobado; 
	}

    public void setAprobado(boolean aprobado) 
	{ 
		this.aprobado = aprobado; 
	}
}
