package boardgamecafe.usuarios;

public abstract class Usuario {
	
    private String login;
    
	private String password;
	
	private int puntosFidelidad;
	
	public Usuario(String login, String password)
	{
		this.login = login;
		this.password = password;
		this.puntosFidelidad = 0;
		
	}


    public abstract void IniciarSesion(String login, String password);
	
    public abstract void CerrarSesion();
    
    public abstract void AgregarFavorito(int idJuego);
    
    public abstract void EliminarFavorito(int idJuego);
    
    public abstract void ConsultarFavoritos();

}