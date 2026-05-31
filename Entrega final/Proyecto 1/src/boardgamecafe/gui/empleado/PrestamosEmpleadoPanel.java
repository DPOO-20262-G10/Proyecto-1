package boardgamecafe.gui.empleado;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.*;
import boardgamecafe.BoardCafe;
import boardgamecafe.Juegos.CopiaJuego;
import boardgamecafe.pedidos.Prestamo;

public class PrestamosEmpleadoPanel extends JPanel {

    private BoardCafe mundo;
    private JPanel listaPrestamos;
    private JLabel lblContador;
    private JCheckBox chkSoloActivos;

    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    public PrestamosEmpleadoPanel(BoardCafe mundo) {
        this.mundo = mundo;

        setLayout(new BorderLayout());

        JPanel header = new JPanel(new FlowLayout());

        JLabel titulo = new JLabel("Gestión de Préstamos");
        chkSoloActivos = new JCheckBox("Solo activos");
        lblContador = new JLabel();

        JButton btnRefrescar = new JButton("Refrescar");

        header.add(titulo);
        header.add(chkSoloActivos);
        header.add(lblContador);
        header.add(btnRefrescar);

        add(header, BorderLayout.NORTH);

        listaPrestamos = new JPanel();
        listaPrestamos.setLayout(new BoxLayout(listaPrestamos, BoxLayout.Y_AXIS));

        JScrollPane scroll = new JScrollPane(listaPrestamos);
        add(scroll, BorderLayout.CENTER);

        btnRefrescar.addActionListener(e -> refrescar());
        chkSoloActivos.addActionListener(e -> refrescar());
    }

    public void refrescar() {

        listaPrestamos.removeAll();

        List<Prestamo> todos = mundo.getPrestamos();
        boolean soloActivos = chkSoloActivos.isSelected();

        int activos = 0;
        boolean hay = false;

        for (int i = 0; i < todos.size(); i++) {

            Prestamo pr = todos.get(i);

            if (pr.isActivo()) {
                activos++;
            }

            if (soloActivos && !pr.isActivo()) {
                continue;
            }

            listaPrestamos.add(crearTarjeta(pr));
            hay = true;
        }

        lblContador.setText(activos + "/" + todos.size());

        if (!hay) {
            listaPrestamos.add(new JLabel("Sin préstamos"));
        }

        listaPrestamos.revalidate();
        listaPrestamos.repaint();
    }

    private JPanel crearTarjeta(Prestamo pr) {

        JPanel panel = new JPanel(new GridLayout(0, 1));

        panel.add(new JLabel("Prestamo: " + pr.getIdPrestamo()));
        panel.add(new JLabel("Activo: " + pr.isActivo()));

        String solicitante = "—";

        if (pr.getSolicitante() != null) {
            solicitante = pr.getSolicitante().getLogin();
        }

        panel.add(new JLabel("Usuario: " + solicitante));

        if (pr.getFechaInicio() != null) {
            panel.add(new JLabel("Inicio: " + sdf.format(pr.getFechaInicio())));
        }

        if (pr.getFechaFin() != null) {
            panel.add(new JLabel("Fin: " + sdf.format(pr.getFechaFin())));
        }

        List<CopiaJuego> copias = pr.getCopias();

        String texto = "";

        for (int i = 0; i < copias.size(); i++) {
            if (i > 0) {
                texto = texto + ", ";
            }
            texto = texto + copias.get(i).getIdCopia();
        }

        panel.add(new JLabel("Copias: " + texto));

        if (pr.isActivo()) {

            JButton btn = new JButton("Devolver");

            btn.addActionListener(e -> {
                mundo.devolverJuego(pr.getIdPrestamo());
                refrescar();
            });

            panel.add(btn);
        }

        return panel;
    }
}
