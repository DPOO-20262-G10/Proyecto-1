package boardgamecafe.Juegos;

public class JuegoVenta extends JuegosDeMesa {

    private int stock;
    private double precio;

    public JuegoVenta(int idJuego, String nombre, String categoria, boolean esDificil, int minJugadores, int maxJugadores, int edadMinima, int stock, double precio) {
        super(idJuego, nombre, null, minJugadores, maxJugadores, edadMinima, categoria, esDificil);
        this.stock = stock;
        this.precio = precio;
    }

    public int getStock() 
    {
        return stock;
    }

    public void setStock(int stock) 
	{
        this.stock = stock;
    }

    public double getPrecio() 
	{
        return precio;
    }

    public void setPrecio(double precio) 
    {
        this.precio = precio;
    }
}
