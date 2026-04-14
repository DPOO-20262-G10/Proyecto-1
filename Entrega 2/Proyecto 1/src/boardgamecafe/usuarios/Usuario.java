package boardgamecafe.usuarios;

public abstract class Usuario {
    private String login;
	private String password;
	private int puntos_fidelidad;
	
	public Usuario(String login, String password)
	{
		this.login = login;
		this.password = password;
		this.puntos_fidelidad = 0;
		
	}


    public abstract void Iniciar_sesion(String login, String password);
	
    public abstract void Cerrar_sesion();
    
    public abstract void Agregar_favorito(int id_juego);
    
    public abstract void Eliminar_favorito(int id_juego);
    
    public abstract void Consultar_favoritos();

}
