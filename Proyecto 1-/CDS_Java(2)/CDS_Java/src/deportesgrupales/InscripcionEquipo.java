package deportesgrupales;

import usuarios.Socio;

public class InscripcionEquipo {

    private String posicion;
    private int numero_camiseta;
    private Socio socio;
    private Equipo equipo;

    public InscripcionEquipo() {
    }

    public InscripcionEquipo(String posicion, int numero_camiseta) {
        this.posicion = posicion;
        this.numero_camiseta = numero_camiseta;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int getNumero_camiseta() {
        return numero_camiseta;
    }

    public void setNumero_camiseta(int numero_camiseta) {
        this.numero_camiseta = numero_camiseta;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

}
