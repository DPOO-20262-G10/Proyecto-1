package boardgamecafe.usuarios;

import java.util.List;
import java.util.ArrayList;


public class Mesero extends Empleado {
	
	private List<JuegosDeMesa> juegosDificiles;
    
    public Mesero(int id_empleado, String login, String password, String codigoDescuento) {
        super(id_empleado, login, password, codigoDescuento);
        this.juegosDificiles = new ArrayList<>();
    }
    
    public void Registrar_juegos_dificiles(JuegosDeMesa juego) {
    	juegosDificiles.add(juego);
    	System.out.println("Se añadió correctamente el juego");
    }
}