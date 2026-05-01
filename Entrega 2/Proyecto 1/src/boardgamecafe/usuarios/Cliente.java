package boardgamecafe.usuarios;

import java.util.ArrayList;
import java.util.List;
import boardgamecafe.Juegos.JuegosDeMesa;

public class Cliente extends Usuario {

    private int idCliente;
    private List<JuegosDeMesa> juegos;

    public Cliente(int idCliente, String login, String password, String nombre) {
        super(login, password, nombre);
        this.idCliente = idCliente;
        this.juegos = new ArrayList<JuegosDeMesa>();
    }

    public void consultarHistorialCompras() {
        System.out.println("Consultando historial de compras de " + getNombre());
    }

    public int getIdCliente() 
    { 
        return idCliente; 
    }

    public void setIdCliente(int idCliente) 
    { 
        this.idCliente = idCliente; 
    }

    public List<JuegosDeMesa> getJuegos() 
    { 
        return juegos; 
    }

    public void setJuegos(List<JuegosDeMesa> juegos) 
    { 
        this.juegos = juegos; 
    }
}
