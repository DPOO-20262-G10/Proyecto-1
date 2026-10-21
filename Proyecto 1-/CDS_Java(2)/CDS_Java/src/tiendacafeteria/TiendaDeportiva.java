package tiendacafeteria;

import java.util.ArrayList;
import java.util.List;

public class TiendaDeportiva extends Tienda {

    private List<ArticuloDeportivo> articulosDeportivos = new ArrayList<>();

    public TiendaDeportiva() {
    }

    public TiendaDeportiva(String nombre, String ubicacion) {
        super(nombre, ubicacion);
    }

    public List<ArticuloDeportivo> getArticulosDeportivos() {
        return articulosDeportivos;
    }

    public void setArticulosDeportivos(List<ArticuloDeportivo> articulosDeportivos) {
        this.articulosDeportivos = articulosDeportivos;
    }

}
