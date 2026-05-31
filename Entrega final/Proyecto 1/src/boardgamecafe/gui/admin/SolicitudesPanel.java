package boardgamecafe.gui.admin;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import boardgamecafe.BoardCafe;

public class SolicitudesPanel extends JPanel {
    private BoardCafe cafe;

    public SolicitudesPanel(BoardCafe cafe) {
        this.cafe = cafe;
        setLayout(new BorderLayout(10, 10));
        setBorder(new EmptyBorder(15, 15, 15, 15));

        JLabel lblTitulo = new JLabel("Gestión de Solicitudes");
        lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 20));
        lblTitulo.setForeground(new Color(230, 80, 120));
        add(lblTitulo, BorderLayout.NORTH);

        JPanel mainPanel = new JPanel(new GridLayout(1, 2, 15, 0));

        JPanel pnlSug = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        pnlSug.setBorder(BorderFactory.createTitledBorder("Sugerencias de Producto"));
        JTextField txtIdProducto = new JTextField(10);
        JButton btnAprobarSug = new JButton("Aprobar");
        JButton btnRechazarSug = new JButton("Rechazar");

        btnAprobarSug.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(txtIdProducto.getText().trim());
                    cafe.aprobarSugerencia(id);
                    JOptionPane.showMessageDialog(SolicitudesPanel.this, "Sugerencia aprobada.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(SolicitudesPanel.this, ex.getMessage(), "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnRechazarSug.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(txtIdProducto.getText().trim());
                    cafe.rechazarSugerencia(id);
                    JOptionPane.showMessageDialog(SolicitudesPanel.this, "Sugerencia rechazada.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(SolicitudesPanel.this, ex.getMessage(), "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        pnlSug.add(new JLabel("ID Producto:"));
        pnlSug.add(txtIdProducto);
        pnlSug.add(btnAprobarSug);
        pnlSug.add(btnRechazarSug);

        JPanel pnlCambios = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        pnlCambios.setBorder(BorderFactory.createTitledBorder("Cambios de Turno"));
        JTextField txtIdSolicitud = new JTextField(10);
        JButton btnAprobarCambio = new JButton("Aprobar");
        JButton btnRechazarCambio = new JButton("Rechazar");

        btnAprobarCambio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(txtIdSolicitud.getText().trim());
                    cafe.aprobarCambioTurno(id);
                    JOptionPane.showMessageDialog(SolicitudesPanel.this, "Cambio aprobado.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(SolicitudesPanel.this, ex.getMessage(), "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnRechazarCambio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(txtIdSolicitud.getText().trim());
                    cafe.rechazarCambioTurno(id);
                    JOptionPane.showMessageDialog(SolicitudesPanel.this, "Cambio rechazado.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(SolicitudesPanel.this, ex.getMessage(), "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        pnlCambios.add(new JLabel("ID Solicitud:"));
        pnlCambios.add(txtIdSolicitud);
        pnlCambios.add(btnAprobarCambio);
        pnlCambios.add(btnRechazarCambio);

        mainPanel.add(pnlSug);
        mainPanel.add(pnlCambios);

        add(mainPanel, BorderLayout.CENTER);
    }
}
