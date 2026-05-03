package boardgamecafe.Torneos;

public class Torneo {
	
	private int idTorneo;
	private String nombre;
	private String diaSemana;
	private String tipo;
	private int cuposTotales;
	private int cuposFanaticos;
	private int cuposRegularesOcupados;
	private int cuposFanaticosOcupados;
	private double tarifaEntrada;
	private double premioMetalico;
	private double bonoDescuento;
	private boolean activo;
	
	public Torneo (int idTorneo, String nombre, String diaSemana, String tipo, 
			int cuposTotales, int cuposFanaticos, int cuposRegularesOcupados,
			int cuposFanaticosOcupados, double tarifaEntrada, double premioMetalico,
			double bonoDescuento, boolean activo) {
		
		this.idTorneo = idTorneo;
		this.nombre = nombre;
		this.diaSemana = diaSemana;
		this.tipo = tipo;
		this.cuposTotales = cuposTotales;
		this.cuposFanaticos = cuposFanaticos;
		this.cuposRegularesOcupados = cuposRegularesOcupados;
		this.cuposFanaticosOcupados = cuposFanaticosOcupados;
		this.tarifaEntrada = tarifaEntrada;
		this.premioMetalico = premioMetalico;
		this.bonoDescuento = bonoDescuento;
		this.activo = activo;
		
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