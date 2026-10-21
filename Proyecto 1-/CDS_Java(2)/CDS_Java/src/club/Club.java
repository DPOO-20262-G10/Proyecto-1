package club;

import deportesgrupales.Equipo;
import deportesindividuales.Academia;
import java.util.ArrayList;
import java.util.List;
import tiendacafeteria.Tienda;

public class Club {

    private String nombre;
    private List<Equipo> equipos = new ArrayList<>();
    private List<Academia> academias = new ArrayList<>();
    private List<Tienda> tiendas = new ArrayList<>();

    public Club() {
    }

    public Club(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(List<Equipo> equipos) {
        this.equipos = equipos;
    }

    public List<Academia> getAcademias() {
        return academias;
    }

    public void setAcademias(List<Academia> academias) {
        this.academias = academias;
    }

    public List<Tienda> getTiendas() {
        return tiendas;
    }

    public void setTiendas(List<Tienda> tiendas) {
        this.tiendas = tiendas;
    }

}
