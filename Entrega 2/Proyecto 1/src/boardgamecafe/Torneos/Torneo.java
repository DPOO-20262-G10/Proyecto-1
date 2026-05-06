package boardgamecafe.Torneos;

import boardgamecafe.Juegos.*;
import boardgamecafe.usuarios.*;


public class Torneo {
	
	private Usuario ganador;
	private boolean activo;
	private JuegosDeMesa juego;
	private int idTorneo;
	private String nombre;
	private String tipo;
	private int cuposTotales;
	private int cuposFanaticos;
	private int cuposRegularesOcupados;
	private int cuposFanaticosOcupados;
	private double tarifaEntrada;
	private double premioMetalico;
	private double bonoDescuento;
	
	public Torneo (int idTorneo, String nombre, String tipo, 
			int cuposTotales, int cuposFanaticos, int cuposRegularesOcupados,
			int cuposFanaticosOcupados, double tarifaEntrada, double premioMetalico,
			double bonoDescuento, JuegosDeMesa Juego) {
		
		this.idTorneo = idTorneo;
		this.nombre = nombre;
		this.tipo = tipo;
		this.cuposTotales = cuposTotales;
		this.cuposFanaticos = cuposFanaticos;
		this.cuposRegularesOcupados = cuposRegularesOcupados;
		this.cuposFanaticosOcupados = cuposFanaticosOcupados;
		this.tarifaEntrada = tarifaEntrada;
		this.premioMetalico = premioMetalico;
		this.bonoDescuento = bonoDescuento;
		this.juego = Juego;
		this.activo = true;
		this.ganador = null;
		
	}
	
	public boolean getactivo() {
	    return activo;
	}
	
	public Usuario getGanador() {
	    return ganador;
	}

	public void setGanador(Usuario ganador) {
	    this.ganador = ganador;
	    this.activo = false;
	}
	
	
	public JuegosDeMesa getJuego() {
	    return juego;
	}

	public void setJuego(JuegosDeMesa Juego) {
	    this.juego = Juego;
	}
	    
	public int getIdTorneo() {
	    return idTorneo;
	}

	public void setIdTorneo(int idTorneo) {
	    this.idTorneo = idTorneo;
	}

	public String getNombre() {
	    return nombre;
	}

	public void setNombre(String nombre) {
	    this.nombre = nombre;
	}

	public String getTipo() {
	    return tipo;
	}

	public void setTipo(String tipo) {
	    this.tipo = tipo;
	}

	public int getCuposTotales() {
	    return cuposTotales;
	}

	public void setCuposTotales(int cuposTotales) {
	    this.cuposTotales = cuposTotales;
	}

	public int getCuposFanaticos() {
	    return cuposFanaticos;
	}

	public void setCuposFanaticos(int cuposFanaticos) {
	    this.cuposFanaticos = cuposFanaticos;
	}

	public int getCuposRegularesOcupados() {
	    return cuposRegularesOcupados;
	}

	public void setCuposRegularesOcupados(int cuposRegularesOcupados) {
	    this.cuposRegularesOcupados = cuposRegularesOcupados;
	}

	public int getCuposFanaticosOcupados() {
	    return cuposFanaticosOcupados;
	}

	public void setCuposFanaticosOcupados(int cuposFanaticosOcupados) {
	    this.cuposFanaticosOcupados = cuposFanaticosOcupados;
	}

	public double getTarifaEntrada() {
	    return tarifaEntrada;
	}

	public void setTarifaEntrada(double tarifaEntrada) {
	    this.tarifaEntrada = tarifaEntrada;
	}

	public double getPremioMetalico() {
	    return premioMetalico;
	}

	public void setPremioMetalico(double premioMetalico) {
	    this.premioMetalico = premioMetalico;
	}

	public double getBonoDescuento() {
	    return bonoDescuento;
	}

	public void setBonoDescuento(double bonoDescuento) {
	    this.bonoDescuento = bonoDescuento;
	}



	public int getCuposDisponibles()
	{
		int cuposDisponibles = this.cuposTotales - this.cuposRegularesOcupados;
		return cuposDisponibles;
	}
	
	public int getCuposFanaticosDisponibles()
	{
		int cuposDisponibles = this.cuposFanaticos - this.cuposFanaticosOcupados;
		return cuposDisponibles;
	}
	
	public double calcularPremioMetalico()
	{
		return this.premioMetalico;
	}
	
	
}