package boardgamecafe.Torneos;

import boardgamecafe.usuarios.*;

public class InscripcionTorneo {
    
    private int cantidadParticipantes;
    private boolean esFanatico;
    private boolean esEmpleado;
    private Usuario usuario;
    private Torneo torneo;


    public InscripcionTorneo(Usuario usuario, int cantidadParticipantes, boolean esFanatico, boolean esEmpleado, Torneo torneo) {
        this.cantidadParticipantes = cantidadParticipantes;
        this.esFanatico = esFanatico;
        this.esEmpleado = esEmpleado;
        this.usuario = usuario;
        this.torneo = torneo;
    }

    public Torneo getTorneo() {
        return torneo;
    }
    
    public int getCantidadParticipantes() {
        return cantidadParticipantes;
    }

    public boolean isEsFanatico() {
        return esFanatico;
    }

    public boolean isEsEmpleado() {
        return esEmpleado;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }


    public void setCantidadParticipantes(int cantidadParticipantes) {
        this.cantidadParticipantes = cantidadParticipantes;
    }

    public void setEsFanatico(boolean esFanatico) {
        this.esFanatico = esFanatico;
    }

    public void setEsEmpleado(boolean esEmpleado) {
        this.esEmpleado = esEmpleado;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
