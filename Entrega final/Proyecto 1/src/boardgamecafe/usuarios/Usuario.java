package boardgamecafe.usuarios;

import java.util.ArrayList;
import java.util.List;


public abstract class Usuario {

    private String login;
    private String password;
    private String nombre;
    private int puntosFidelidad;
    private List<Integer> favoritos;

    public Usuario(String login, String password, String nombre) {
        this.login = login;
        this.password = password;
        this.nombre = nombre;
        this.puntosFidelidad = 0;
        this.favoritos = new ArrayList<Integer>();
    }

    public boolean iniciarSesion(String login, String password) 
    {
        return this.login.equals(login) && this.password.equals(password);
    }

    public void cerrarSesion() 
    {
        System.out.println("Usuario " + nombre + " ha cerrado sesion.");
    }

    public void agregarFavorito(int idJuego) {
        if (!favoritos.contains(idJuego)) {
            favoritos.add(idJuego);

            System.out.println("Juego " + idJuego + " agregado a favoritos.");

        } else {
            System.out.println("El juego ya esta en favoritos.");
        }
    }

    public void eliminarFavorito(int idJuego) {
        if (favoritos.remove(Integer.valueOf(idJuego))) {
            System.out.println("Juego " + idJuego + " eliminado de favoritos.");

        } else {
            System.out.println("El juego no estaba en favoritos.");
        }
    }

    public void consultarFavoritos() {
        System.out.println("Favoritos de " + nombre + ":");
        
        if (favoritos.isEmpty()) {
            System.out.println("  (sin favoritos)");

        } else {

            for (int id : favoritos) {
                System.out.println("  - ID juego: " + id);
            }
        }
    }

    public String getLogin() 
    { 
        return login; 
    }

    public void setLogin(String login) 
    { 
        this.login = login; 
    }

    public String getPassword() 
    { 
        return password; 
    }

    public void setPassword(String password) 
    { 
        this.password = password; 
    }

    public String getNombre() 
    { 
        return nombre; 
    }

    public void setNombre(String nombre) 
    { 
        this.nombre = nombre; 
    }

    public int getPuntosFidelidad() 
    { 
        return puntosFidelidad; 
    }

    public void setPuntosFidelidad(int puntosFidelidad) 
    { 
        this.puntosFidelidad = puntosFidelidad; 
    }

    public List<Integer> getFavoritos() 
    { 
        return favoritos; 
    }

    public void setFavoritos(List<Integer> favoritos) 
    { 
        this.favoritos = favoritos; 
    }
}
