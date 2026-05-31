package boardgamecafe.gui.admin;

import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import boardgamecafe.BoardCafe;

public class InformesPanel extends JPanel {
    private static final Color COLOR_ADMIN = new Color(230, 80, 120);

    private BoardCafe cafe;

    public InformesPanel(BoardCafe cafe) {
        this.cafe = cafe;
        setLayout(new BorderLayout(10, 10));
        setBackground(new Color(245, 246, 248));
        setBorder(new EmptyBorder(20, 20, 20, 20));

        JLabel lblTitulo = new JLabel("Generacion de Informes");
        lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 22));
        lblTitulo.setForeground(COLOR_ADMIN);
        add(lblTitulo, BorderLayout.NORTH);

        JPanel controles = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        controles.setOpaque(false);

        controles.add(new JLabel("Tipo:"));
        JComboBox<String> comboTipo = new JComboBox<String>(new String[] { "juegos", "cafe", "ambos" });
        controles.add(comboTipo);

        controles.add(new JLabel("Agrupación:"));
        JComboBox<String> comboAgrupacion = new JComboBox<String>(new String[] { "producto", "tipo" });
        controles.add(comboAgrupacion);

        JTextArea txtResultado = new JTextArea(15, 40);
        txtResultado.setEditable(false);
        txtResultado.setFont(new Font("Monospaced", Font.PLAIN, 13));

        JButton btnGenerar = new JButton("Generar Reporte");
        btnGenerar.setBackground(COLOR_ADMIN);
        btnGenerar.setForeground(Color.WHITE);
        btnGenerar.setFocusPainted(false);
        btnGenerar.setOpaque(true);
        btnGenerar.setBorderPainted(false);
        btnGenerar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String tipo = (String) comboTipo.getSelectedItem();
                    String agrupacion = (String) comboAgrupacion.getSelectedItem();
                    Date fechaInicio = new Date(0);
                    Date fechaFin = new Date();
                    String reporte = cafe.generarReporteVentas(fechaInicio, fechaFin, agrupacion, tipo);
                    txtResultado.setText(reporte);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(InformesPanel.this, ex.getMessage(), "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        controles.add(btnGenerar);

        add(controles, BorderLayout.SOUTH);
        add(new JScrollPane(txtResultado), BorderLayout.CENTER);
    }
}
