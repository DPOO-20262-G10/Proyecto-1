package boardgamecafe.usuarios;

import java.util.ArrayList;
import java.util.List;
import boardgamecafe.Juegos.JuegosDeMesa;
import boardgamecafe.Turnos.Turno;
import boardgamecafe.Turnos.SolicitudCambioTurno;
import boardgamecafe.menu.Producto;
import boardgamecafe.menu.Bebida;
import boardgamecafe.menu.Pasteleria;


public class Empleado extends Usuario {

    private int idEmpleado;
    private boolean enTurno;
    private String codigoDescuento;
    private List<JuegosDeMesa> juegos;
    private List<Turno> turnos;
    private List<SolicitudCambioTurno> solicitudes;

    public Empleado(int idEmpleado, String login, String password, String nombre) {
        super(login, password, nombre);
        this.idEmpleado = idEmpleado;
        this.enTurno = false;
        this.codigoDescuento = "EMP" + idEmpleado;
        this.juegos = new ArrayList<JuegosDeMesa>();
        this.turnos = new ArrayList<Turno>();
        this.solicitudes = new ArrayList<SolicitudCambioTurno>();
    }

    public void consultarTurnoSemanal() {
        System.out.println("Turnos de " + getNombre() + ":");
        if (turnos.isEmpty()) {
            System.out.println("  (sin turnos asignados)");

        } else {

            for (Turno t : turnos) {
                System.out.println("  " + t.getDiaSemana() + " " + t.getHoraInicio() + " - " + t.getHoraFinal());
            }
        }
    }

    
    public Producto sugerirProducto(String nombre, double precio, String tipo, boolean alcoholica, boolean caliente, List<String> alergenos) {
    if (tipo.equalsIgnoreCase("Bebida")) {
        Bebida b = new Bebida(nombre, precio, alcoholica, caliente);
        
        System.out.println("Sugerencia de bebida enviada: " + nombre);
        return b;

    } else {
        Pasteleria p = new Pasteleria(nombre, precio, alergenos);
        System.out.println("Sugerencia de pasteleria enviada: " + nombre);

        return p;
    }
}


    public int getIdEmpleado() 
    { 
        return idEmpleado; 
    }

    public void setIdEmpleado(int idEmpleado) 
    { 
        this.idEmpleado = idEmpleado; 
    }

    public boolean isEnTurno() 
    { 
        return enTurno; 
    }

    public void setEnTurno(boolean enTurno) 
    { 
        this.enTurno = enTurno; 
    }

    public String getCodigoDescuento() 
    { 
        return codigoDescuento; 
    }

    public void setCodigoDescuento(String codigoDescuento) 
    { 
        this.codigoDescuento = codigoDescuento; 
    }

    public List<JuegosDeMesa> getJuegos() { 
        return juegos; 
    }
    
    public void setJuegos(List<JuegosDeMesa> juegos) 
    { 
        this.juegos = juegos; 
    }

    public List<Turno> getTurnos() 
    { 
        return turnos; 
    }

    public void setTurnos(List<Turno> turnos) 
    { 
        this.turnos = turnos; 
    }

    public List<SolicitudCambioTurno> getSolicitudes() 
    { 
        return solicitudes; 
    }

    public void setSolicitudes(List<SolicitudCambioTurno> solicitudes) 
    { 
        this.solicitudes = solicitudes; 
    }
}
