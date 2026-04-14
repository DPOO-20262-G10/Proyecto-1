package boardgamecafe.usuarios;

public class Administrador extends Usuario {

	private int idAdmin;
    private List<JuegosDeMesa> juegos;

    public Administrador(int idAdmin, String login, String password) {
        super(login, password);
        this.idAdmin = idAdmin;
    }

    @Override
    public void IniciarSesion(String login, String password) {
    	System.out.println("Inició sesión como Administrador");
    }

    @Override
    public void CerrarSesion() {
    	System.out.println("Administrador cerró la sesión");
    }

    @Override
    public void AgregarFavorito(JuegoDeMesa juego) {
    	juegos.add(juego);
    	System.out.println("Juego agregado a favoritos");
    }
    
    @Override
    public void EliminarFavorito(JuegoDeMesa juego) {
    	juegos.remove(juego);
    	System.out.println("Juego eliminado de favoritos");
    }
    
    @Override
    public void ConsultarFavoritos() {
    	System.out.println("Favoritos: " + juegos);
    }
    
}