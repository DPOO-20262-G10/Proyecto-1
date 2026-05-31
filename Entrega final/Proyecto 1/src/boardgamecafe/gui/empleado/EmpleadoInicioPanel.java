package boardgamecafe.gui.empleado;

import java.awt.*;
import java.util.List;
import javax.swing.*;

import boardgamecafe.BoardCafe;
import boardgamecafe.Turnos.Turno;
import boardgamecafe.pedidos.Mesa;
import boardgamecafe.pedidos.Prestamo;
import boardgamecafe.usuarios.Empleado;
import boardgamecafe.usuarios.Usuario;

public class EmpleadoInicioPanel extends JPanel {

    private BoardCafe mundo;

    private JLabel lblBienvenida;
    private JLabel lblRol;

    private JPanel kpiPanel;
    private JPanel panelTurno;

    public EmpleadoInicioPanel(BoardCafe mundo) {
        this.mundo = mundo;
        setLayout(new BorderLayout());
        
        lblBienvenida = new JLabel("Bienvenido");
        lblRol = new JLabel("Empleado");

        JPanel header = new JPanel(new GridLayout(2, 1));
        header.add(lblBienvenida);
        header.add(lblRol);

        add(header, BorderLayout.NORTH);

        kpiPanel = new JPanel(new GridLayout(1, 4));
        panelTurno = new JPanel(new BorderLayout());

        JPanel centro = new JPanel(new BorderLayout());
        centro.add(kpiPanel, BorderLayout.NORTH);
        centro.add(panelTurno, BorderLayout.CENTER);

        add(centro, BorderLayout.CENTER);
    }


    public void refrescar() {

        Usuario u = mundo.getUsuarioActivo();
        if (u == null) return;

        lblBienvenida.setText("Bienvenido, " + u.getNombre());
        lblRol.setText(u.getClass().getSimpleName() + " - " + u.getLogin());

        kpiPanel.removeAll();

        String turnoValor = "Sin turno";
        String turnoSub = "";

        if (u instanceof Empleado) {
            Empleado emp = (Empleado) u;

            Turno t = mundo.consultarTurno(emp.getIdEmpleado());
            if (t != null) {
                turnoValor = t.getDiaSemana();
                turnoSub = t.getHoraInicio() + " - " + t.getHoraFinal();
            }
        }

        kpiPanel.add(new JLabel("Turno: " + turnoValor + " " + turnoSub));

        List<Mesa> mesas = mundo.getMesas();

        int ocupadas = 0;
        for (int i = 0; i < mesas.size(); i++) {
            if (mesas.get(i).getNumeroPersonas() > 0) {
                ocupadas++;
            }
        }

        kpiPanel.add(new JLabel("Mesas ocupadas: " + ocupadas));

        int prestamosActivos = 0;
        List<Prestamo> prestamos = mundo.getPrestamos();

        for (int i = 0; i < prestamos.size(); i++) {
            if (prestamos.get(i).isActivo()) {
                prestamosActivos++;
            }
        }

        kpiPanel.add(new JLabel("Prestamos activos: " + prestamosActivos));

        kpiPanel.add(new JLabel("Puntos: " + u.getPuntosFidelidad()));

        panelTurno.removeAll();

        panelTurno.add(new JLabel("Detalle del turno"), BorderLayout.NORTH);

        JPanel detalle = new JPanel(new GridLayout(0, 2));

        if (u instanceof Empleado) {

            Empleado emp = (Empleado) u;
            Turno t = mundo.consultarTurno(emp.getIdEmpleado());

            if (t != null) {

                detalle.add(new JLabel("Día:"));
                detalle.add(new JLabel(t.getDiaSemana()));

                detalle.add(new JLabel("Hora inicio:"));
                detalle.add(new JLabel(String.valueOf(t.getHoraInicio())));

                detalle.add(new JLabel("Hora fin:"));
                detalle.add(new JLabel(String.valueOf(t.getHoraFinal())));

                detalle.add(new JLabel("Estado:"));
                detalle.add(new JLabel(emp.isEnTurno() ? "En turno" : "Fuera de turno"));

                detalle.add(new JLabel("Código:"));
                detalle.add(new JLabel(emp.getCodigoDescuento()));

            } else {
                detalle.add(new JLabel("No tiene turno asignado"));
            }
        }

        panelTurno.add(detalle, BorderLayout.CENTER);

        revalidate();
        repaint();
    }
}
