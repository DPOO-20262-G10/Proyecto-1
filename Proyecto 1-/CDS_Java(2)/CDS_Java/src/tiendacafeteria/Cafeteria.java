package tiendacafeteria;

import java.util.ArrayList;
import java.util.List;

public class Cafeteria extends Tienda {

    private List<Snacks> snacks = new ArrayList<>();
    private List<Bebida> bebidas = new ArrayList<>();

    public Cafeteria() {
    }

    public Cafeteria(String nombre, String ubicacion) {
        super(nombre, ubicacion);
    }

    public List<Snacks> getSnacks() {
        return snacks;
    }

    public void setSnacks(List<Snacks> snacks) {
        this.snacks = snacks;
    }

    public List<Bebida> getBebidas() {
        return bebidas;
    }

    public void setBebidas(List<Bebida> bebidas) {
        this.bebidas = bebidas;
    }

}
