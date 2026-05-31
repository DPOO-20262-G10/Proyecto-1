package boardgamecafe.gui.empleado;

import java.awt.*;
import java.util.List;
import javax.swing.*;

import boardgamecafe.BoardCafe;
import boardgamecafe.Turnos.Turno;
import boardgamecafe.Turnos.SolicitudCambioTurno;
import boardgamecafe.usuarios.Empleado;
import boardgamecafe.usuarios.Usuario;

public class MiTurnoPanel extends JPanel {

    private BoardCafe mundo;
    private JPanel contenido;

    public MiTurnoPanel(BoardCafe mundo) {
        this.mundo = mundo;
        setLayout(new BorderLayout());

        JLabel titulo = new JLabel("Mi Turno");
        add(titulo, BorderLayout.NORTH);

        contenido = new JPanel();
        contenido.setLayout(new BoxLayout(contenido, BoxLayout.Y_AXIS));

        add(contenido, BorderLayout.CENTER);
    }

    public void refrescar() {

        contenido.removeAll();

        Usuario u = mundo.getUsuarioActivo();

        if (!(u instanceof Empleado)) {
            contenido.add(new JLabel("No disponible"));
            return;
        }

        Empleado emp = (Empleado) u;

        Turno turno = mundo.consultarTurno(emp.getIdEmpleado());

        contenido.add(new JLabel("=== Turno actual ==="));

        if (turno != null) {

            contenido.add(new JLabel("Día: " + turno.getDiaSemana()));
            contenido.add(new JLabel("Inicio: " + turno.getHoraInicio()));
            contenido.add(new JLabel("Fin: " + turno.getHoraFinal()));
            contenido.add(new JLabel("ID: " + turno.getIdTurno()));
            contenido.add(new JLabel("Estado: " +
                    (emp.isEnTurno() ? "En turno" : "Fuera de turno")));

        } else {
            contenido.add(new JLabel("No tiene turno asignado"));
        }

        contenido.add(new JLabel(""));
        contenido.add(new JLabel("=== Todos mis turnos ==="));

        List<Turno> turnos = emp.getTurnos();

        if (turnos.isEmpty()) {
            contenido.add(new JLabel("Sin turnos registrados"));
        } else {

            for (int i = 0; i < turnos.size(); i++) {

                Turno t = turnos.get(i);

                contenido.add(new JLabel(
                        t.getIdTurno() + " - " +
                        t.getDiaSemana() + " (" +
                        t.getHoraInicio() + "-" +
                        t.getHoraFinal() + ")"
                ));
            }
        }

        contenido.add(new JLabel(""));
        contenido.add(new JLabel("=== Solicitudes ==="));

        List<SolicitudCambioTurno> solicitudes = emp.getSolicitudes();

        if (solicitudes.isEmpty()) {
            contenido.add(new JLabel("No hay solicitudes"));
        } else {

            for (int i = 0; i < solicitudes.size(); i++) {

                SolicitudCambioTurno s = solicitudes.get(i);

                String nombre = "—";

                if (s.getEmpleadoIntercambio() != null) {
                    nombre = s.getEmpleadoIntercambio().getNombre();
                }

                contenido.add(new JLabel(
                        s.getIdSolicitud() + " - " +
                        s.getCambioDia() + " - " +
                        s.getEstado() + " - " +
                        nombre
                ));
            }
        }

        contenido.revalidate();
        contenido.repaint();
    }
}
