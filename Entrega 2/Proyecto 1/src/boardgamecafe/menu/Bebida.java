package boardgamecafe.menu;

public class Bebida extends Producto {

    private boolean alcoholica;
    private boolean caliente;

    public Bebida(int idProducto, String nombre, double precio, boolean alcoholica, boolean caliente) {
        super(idProducto, nombre, precio, "Bebida");
        this.alcoholica = alcoholica;
        this.caliente = caliente;
    }

    public Bebida(String nombre, double precio, boolean alcoholica, boolean caliente) {
        super(0, nombre, precio, "Bebida");
        this.alcoholica = alcoholica;
        this.caliente = caliente;
    }

    public boolean isAlcoholica() 
    { 
        return alcoholica; 
    }

    public void setAlcoholica(boolean alcoholica) 
    { 
        this.alcoholica = alcoholica; 
    }

    public boolean isCaliente() 
    { 
        return caliente; 
    }

    public void setCaliente(boolean caliente) 
    { 
        this.caliente = caliente; 
    }
}

