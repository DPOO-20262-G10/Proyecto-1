package boardgamecafe;

import boardgamecafe.usuarios.Empleado;

public class SolicitudCambioTurno {
	
	private String estado;
	
	private String cambioDia;
	
	private Turno turnoActual;
	
	private Empleado empleadoIntercambio;
	
	public SolicitudCambioTurno(String cambioDia, Turno turnoActual, Empleado empleadoIntercambio)
	{
		this.estado = "pendiente";
		this.cambioDia = cambioDia;
		this.turnoActual = turnoActual;
		this.empleadoIntercambio = empleadoIntercambio;
	}
	
	public String getEstado()
	{
		return estado;
	}
	
	public void aprobar()
	{
		this.estado = "aprobado";
	}
	
	public void rechazar()
	{
		this.estado = "rechazado";
	}
	
	public String getCambioDia()
	{
		return cambioDia;
	}
	
	public Turno getTurnoActual()
	{
		return turnoActual;
	}
	
	public Empleado getEmpleadoIntercambio()
	{
		return empleadoIntercambio;
	}
}
