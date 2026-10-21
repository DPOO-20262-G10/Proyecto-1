package deportesindividuales;

public class Instalacion {

    private String nombre;
    private Academia academia;

    public Instalacion() {
    }

    public Instalacion(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Academia getAcademia() {
        return academia;
    }

    public void setAcademia(Academia academia) {
        this.academia = academia;
    }

}
