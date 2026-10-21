package deportesindividuales;

import usuarios.Socio;

public class InscripcionAcademia {

    private String nivel;
    private Socio socio;
    private Academia academia;

    public InscripcionAcademia() {
    }

    public InscripcionAcademia(String nivel) {
        this.nivel = nivel;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public Academia getAcademia() {
        return academia;
    }

    public void setAcademia(Academia academia) {
        this.academia = academia;
    }

}
