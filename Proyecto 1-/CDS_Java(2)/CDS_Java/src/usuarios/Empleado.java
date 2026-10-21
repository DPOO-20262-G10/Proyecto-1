package usuarios;

import entrenamiento.SesionEntreno;
import java.util.ArrayList;
import java.util.List;

public class Empleado extends Usuario {

    private List<SesionEntreno> sesionesEntreno = new ArrayList<>();

    public Empleado() {
    }

    public Empleado(String nombre, String login, String contraseña) {
        super(nombre, login, contraseña);
    }

    public List<SesionEntreno> getSesionesEntreno() {
        return sesionesEntreno;
    }

    public void setSesionesEntreno(List<SesionEntreno> sesionesEntreno) {
        this.sesionesEntreno = sesionesEntreno;
    }

}
