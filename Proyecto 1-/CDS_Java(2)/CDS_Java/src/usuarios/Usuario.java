package usuarios;

import java.util.ArrayList;
import java.util.List;
import tiendacafeteria.Transaccion;

public abstract class Usuario {

    private String nombre;
    private String login;
    private String contraseña;
    private List<Transaccion> transacciones = new ArrayList<>();

    public Usuario() {
    }

    public Usuario(String nombre, String login, String contraseña) {
        this.nombre = nombre;
        this.login = login;
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public List<Transaccion> getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(List<Transaccion> transacciones) {
        this.transacciones = transacciones;
    }

}
