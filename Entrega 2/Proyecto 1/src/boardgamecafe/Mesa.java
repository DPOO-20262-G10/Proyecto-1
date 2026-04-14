package boardgamecafe;

public class Mesa 
{	
	private int idMesa;
	
	private int numeroPersonas;
	
	private boolean hayNinos;
		
	private boolean hayJovenes;
	
	public Mesa(int idMesa, int numeroPersonas, boolean hayNinos, boolean hayJovenes)
	{
		this.idMesa = idMesa;
		this.numeroPersonas = numeroPersonas;
		this.hayNinos = hayNinos;
		this.hayJovenes = hayJovenes;
	}
	
	public int getIdMesa()
	{
		return idMesa;
	}
	
	public int getNumeroPersonas()
	{
		return numeroPersonas;
	}
	
	public boolean getHayNiños()
	{
		return hayNinos;
	}
	
	public boolean getHayJovenes()
	{
		return hayJovenes;
	}
}
