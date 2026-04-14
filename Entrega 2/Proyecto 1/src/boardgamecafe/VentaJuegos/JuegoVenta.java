package boardgamecafe.VentaJuegos;

public class JuegoVenta {

    private int stock;
    private double precio;

    public JuegoVenta(int stock, double precio) {
        this.stock = stock;
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}