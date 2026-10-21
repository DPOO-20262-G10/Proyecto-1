package tiendacafeteria;

public class Bebida extends Producto {

    private boolean fria;
    private Cafeteria cafeteria;

    public Bebida() {
    }

    public Bebida(String nombre, double precio, int cantidad, boolean fria) {
        super(nombre, precio, cantidad);
        this.fria = fria;
    }

    public boolean isFria() {
        return fria;
    }

    public void setFria(boolean fria) {
        this.fria = fria;
    }

    public Cafeteria getCafeteria() {
        return cafeteria;
    }

    public void setCafeteria(Cafeteria cafeteria) {
        this.cafeteria = cafeteria;
    }

}
