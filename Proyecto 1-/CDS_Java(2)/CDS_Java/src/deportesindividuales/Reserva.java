package deportesindividuales;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Reserva {

    private Date fecha;
    private int num_jugadores;
    private List<Instalacion> instalaciones = new ArrayList<>();

    public Reserva() {
    }

    public Reserva(Date fecha, int num_jugadores) {
        this.fecha = fecha;
        this.num_jugadores = num_jugadores;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getNum_jugadores() {
        return num_jugadores;
    }

    public void setNum_jugadores(int num_jugadores) {
        this.num_jugadores = num_jugadores;
    }

    public List<Instalacion> getInstalaciones() {
        return instalaciones;
    }

    public void setInstalaciones(List<Instalacion> instalaciones) {
        this.instalaciones = instalaciones;
    }

}
