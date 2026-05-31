package boardgamecafe.Juegos;

import java.util.ArrayList;
import java.util.List;

public class CategoriaJuego {

    private String tipo;
    private List<JuegosDeMesa> juegos;

    public CategoriaJuego(String tipo) {
        this.tipo = tipo;
        this.juegos = new ArrayList<JuegosDeMesa>();
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<JuegosDeMesa> getJuegos() {
        return juegos;
    }

    public void setJuegos(List<JuegosDeMesa> juegos) {
        this.juegos = juegos;
    }
}
