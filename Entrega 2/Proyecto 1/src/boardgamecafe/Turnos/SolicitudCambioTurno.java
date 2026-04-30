package boardgamecafe.Turnos;

import boardgamecafe.usuarios.Empleado;


public class SolicitudCambioTurno {

    private int idSolicitud;
    private String estado;
    private String cambioDia;
    private Turno turnoActual;
    private Empleado empleadoSolicitante;
    private Empleado empleadoIntercambio;

    public SolicitudCambioTurno(int idSolicitud, String cambioDia, Turno turnoActual, Empleado empleadoSolicitante, Empleado empleadoIntercambio) {
        this.idSolicitud = idSolicitud;
        this.cambioDia = cambioDia;
        this.turnoActual = turnoActual;
        this.empleadoSolicitante = empleadoSolicitante;
        this.empleadoIntercambio = empleadoIntercambio;
        this.estado = "Pendiente";
    }

    public void aprobar() {
        this.estado = "Aprobada";
        System.out.println("Solicitud " + idSolicitud + " aprobada.");
    }

    public void rechazar() {
        this.estado = "Rechazada";
        System.out.println("Solicitud " + idSolicitud + " rechazada.");
    }

    public int getIdSolicitud() 
    { 
        return idSolicitud; 
    }

    public void setIdSolicitud(int idSolicitud) 
    { 
        this.idSolicitud = idSolicitud; 
    }

    public String getEstado() 
    { 
        return estado; 
    }

    public void setEstado(String estado) 
    { 
        this.estado = estado; 
    }

    public String getCambioDia() 
    { 
        return cambioDia; 
    }

    public void setCambioDia(String cambioDia) 
    { 
        this.cambioDia = cambioDia; 
    }

    public Turno getTurnoActual() 
    { 
        return turnoActual; 
    }

    public void setTurnoActual(Turno turnoActual) 
    { 
        this.turnoActual = turnoActual; 
    }

    public Empleado getEmpleadoSolicitante() 
    { 
        return empleadoSolicitante; 
    }

    public void setEmpleadoSolicitante(Empleado empleadoSolicitante) 
    { 
        this.empleadoSolicitante = empleadoSolicitante; 
    }

    public Empleado getEmpleadoIntercambio() 
    { 
        return empleadoIntercambio; 
    }

    public void setEmpleadoIntercambio(Empleado empleadoIntercambio) 
    { 
        this.empleadoIntercambio = empleadoIntercambio; 
    }
}
