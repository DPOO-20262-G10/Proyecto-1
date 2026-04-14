package boardgamecafe.pedidos;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import boardgamecafe.usuarios.Usuario;
import boardgamecafe.juegos.CopiaJuego;


public class Prestamo {
	
	private Date fechaInicio;
	
	private Date fechaFin;
	
	private boolean activo;
	
	private boolean advertenciaDificil;
	
	private Usuario solicitante;
	
	private List<CopiaJuego> copias;
	
	public Prestamo(boolean advertenciaDificil, Usuario solicitante)
	{
		this.fechaInicio = new Date();
		this.activo = true;
		this.advertenciaDificil = advertenciaDificil;
		this.solicitante = solicitante;
		this.copias = new ArrayList<>();
	}
	
	public void agregarCopia(CopiaJuego copia)
	{	
		if (copia != null)
		{
			copias.add(copia);	
	
		}
	}
	
	public List<CopiaJuego> getCopias()
	{
		return copias;
	}
	
	public void finalizarPrestamo()
	{
		this.activo = false;
		this.fechaFin = new Date();
	}
	
	public boolean esActivo()
	{
		return activo;
	}
}
