package tiendacafeteria;

public class ArticuloDeportivo extends Producto {

    private String categoria;
    private TiendaDeportiva tiendaDeportiva;

    public ArticuloDeportivo() {
    }

    public ArticuloDeportivo(String nombre, double precio, int cantidad, String categoria) {
        super(nombre, precio, cantidad);
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public TiendaDeportiva getTiendaDeportiva() {
        return tiendaDeportiva;
    }

    public void setTiendaDeportiva(TiendaDeportiva tiendaDeportiva) {
        this.tiendaDeportiva = tiendaDeportiva;
    }

}
