package boardgamecafe;

import java.sql.Time;

public class Turno {
	
	private String diaSemana;
	
	private Time horaInicio;
	
	private Time horaFinal;
	
	public Turno(String diaSemana, Time horaInicio, Time horaFinal)
	{
		this.diaSemana = diaSemana;
		this.horaInicio = horaInicio;
		this.horaFinal = horaFinal;
	}
	
	public String getDiaSemana()
	{
		return diaSemana;
	}
	
	public Time getHoraInicio()
	{
		return horaInicio;
	}
	
	public Time getHoraFinal()
	{
		return horaFinal;
	}
	
}
