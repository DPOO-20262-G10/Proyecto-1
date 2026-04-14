package boardgamecafe.usuarios;

import java.util.List;
import java.util.ArrayList;

public class Cliente extends Usuario {
    
    private int idCliente;
    private List<JuegosDeMesa> juegos;
    
    public Cliente(int idCliente, String login, String password) {
        super(login, password);
        this.idCliente = idCliente;
        this.juegos = new ArrayList<>();
    }
    
    @Override
    public void IniciarSesion(String login, String password) {
    	System.out.println("Inició sesión como Cliente");
    }
    
    @Override
    public void CerrarSesion() {
    	System.out.println("Cliente cierra sesión");
    }
    
    @Override
    public void AgregarFavorito(JuegoDeMesa juego) {
    	juegos.add(juego);
    	System.out.println("Juego agregado a favoritos");
    }
    
    @Override
    public void EliminarFavorito(JuegoDeMesa juego) {
    	juegos.remove(juego);
    	System.out.println("Juego eliminado de favoritos");
    }
    
    @Override
    public void ConsultarFavoritos() {
    	System.out.println("Favoritos: " + juegos);
    }
    
    public void TomarMesa(int numeroPersonas, boolean hayNinos, boolean hayJovenes) {
    	System.out.println("Mesa tomada");
    }
    
    public void SolicitarPrestamo(int idJuego1, int idJuego2, int idMesa) {
    	System.out.println("Solicitando préstamo");
    }
    
    public void DevolverJuego(int idPrestamo) {
    	System.out.println("Devolviendo juego");
    }
    
    public void ComprarJuego(int idJuego, int cantidad) {
    	System.out.println("Comprando juego");
    }
    
    public void UsarPuntos(int puntos) {
    	System.out.println("Usando puntos");
    }
    
    public void ComprarProducto(int idProducto, int cantidad, double propina) {
    	System.out.println("Comprando producto");
    }
    
    public void VerAlergenos(int idProducto) {
    	System.out.println("Consultando alérgenos");
    }
    
    public void ConsultarHistorialCompras() {
    	System.out.println("Consultando historial");
    }
}
