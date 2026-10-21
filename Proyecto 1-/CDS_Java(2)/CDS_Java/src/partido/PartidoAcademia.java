package partido;

import deportesindividuales.Academia;
import deportesindividuales.InscripcionAcademia;
import java.util.Date;

public class PartidoAcademia extends Partido {

    private InscripcionAcademia jugador1;
    private InscripcionAcademia jugador2;
    private Academia academia;

    public PartidoAcademia() {
    }

    public PartidoAcademia(Date fecha, String deporte, String marcador) {
        super(fecha, deporte, marcador);
    }

    public InscripcionAcademia getJugador1() {
        return jugador1;
    }

    public void setJugador1(InscripcionAcademia jugador1) {
        this.jugador1 = jugador1;
    }

    public InscripcionAcademia getJugador2() {
        return jugador2;
    }

    public void setJugador2(InscripcionAcademia jugador2) {
        this.jugador2 = jugador2;
    }

    public Academia getAcademia() {
        return academia;
    }

    public void setAcademia(Academia academia) {
        this.academia = academia;
    }

}
