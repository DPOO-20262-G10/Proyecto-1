package boardgamecafe.usuarios;


public class Administrador extends Usuario {

    private int idAdmin;

    public Administrador(int idAdmin, String login, String password, String nombre) {
        super(login, password, nombre);
        this.idAdmin = idAdmin;
    }

    public int getIdAdmin() 
    { 
        return idAdmin; 
    }

    public void setIdAdmin(int idAdmin) 
    { 
        this.idAdmin = idAdmin; 
    }
}
