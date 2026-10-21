package tiendacafeteria;

public class Snacks extends Producto {

    private String alergeno;
    private Cafeteria cafeteria;

    public Snacks() {
    }

    public Snacks(String nombre, double precio, int cantidad, String alergeno) {
        super(nombre, precio, cantidad);
        this.alergeno = alergeno;
    }

    public String getAlergeno() {
        return alergeno;
    }

    public void setAlergeno(String alergeno) {
        this.alergeno = alergeno;
    }

    public Cafeteria getCafeteria() {
        return cafeteria;
    }

    public void setCafeteria(Cafeteria cafeteria) {
        this.cafeteria = cafeteria;
    }

}
