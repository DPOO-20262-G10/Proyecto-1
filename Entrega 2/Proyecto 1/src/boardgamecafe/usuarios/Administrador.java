package boardgamecafe.usuarios;

public class Administrador extends Usuario {

    public int id_admin;

    public Administrador(int id_admin, String login, String password) {
        super(login, password);
        this.id_admin = id_admin;
    }

    @Override
    public void Iniciar_sesion(String login, String password) {
    }

    @Override
    public void Cerrar_sesion() {
    }

    @Override
    public void Agregar_favorito(int id_juego) {
    }

    @Override
    public void Eliminar_favorito(int id_juego) {
    }

    @Override
    public void Consultar_favoritos() {
    }

}
