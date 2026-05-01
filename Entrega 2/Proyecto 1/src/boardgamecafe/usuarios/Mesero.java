package boardgamecafe.usuarios;

import java.util.ArrayList;
import java.util.List;


public class Mesero extends Empleado {

    private List<Integer> juegosDificilesConocidos;

    public Mesero(int idEmpleado, String login, String password, String nombre) {
        super(idEmpleado, login, password, nombre);
        this.juegosDificilesConocidos = new ArrayList<Integer>();
    }

    public void registrarJuegosDificiles(List<Integer> idsJuegos) {
        for (int id : idsJuegos) {
            if (!juegosDificilesConocidos.contains(id)) {
                juegosDificilesConocidos.add(id);
            }
        }
        
        System.out.println(getNombre() + " ahora conoce " + juegosDificilesConocidos.size() + " juego(s) dificil(es).");
    }

    public boolean conoceJuego(int idJuego) 
    {
        return juegosDificilesConocidos.contains(idJuego);
    }

    public List<Integer> getJuegosDificilesConocidos() 
    { 
        return juegosDificilesConocidos; 
    }
    
    public void setJuegosDificilesConocidos(List<Integer> juegosDificilesConocidos) {
        this.juegosDificilesConocidos = juegosDificilesConocidos;
    }
}
