package boardgamecafe.Juegos;

public class CopiaJuego {

    private int idCopia;
    private boolean disponible;
    private String estadoJuego;

    public CopiaJuego(int idCopia) {
        this.idCopia = idCopia;
        this.disponible = true;
        this.estadoJuego = "Disponible";
    }

    public CopiaJuego(int idCopia, boolean disponible, String estadoJuego) {
        this.idCopia = idCopia;
        this.disponible = disponible;
        this.estadoJuego = estadoJuego;
    }

    public CopiaJuego getCopia() 
    {
        return this;
    }

    public int getIdCopia() 
    {
        return idCopia;
    }

    public void setIdCopia(int idCopia) 
    {
        this.idCopia = idCopia;
    }

    public boolean isDisponible() 
    {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;

        if (disponible) {
            this.estadoJuego = "Disponible";

        } else {

            this.estadoJuego = "Prestado";
        }
    }

    public String getEstadoJuego() {
        return estadoJuego;
    }

    public void setEstadoJuego(String estadoJuego) {
        this.estadoJuego = estadoJuego;
        this.disponible = estadoJuego.equals("Disponible");
    }
    
}
