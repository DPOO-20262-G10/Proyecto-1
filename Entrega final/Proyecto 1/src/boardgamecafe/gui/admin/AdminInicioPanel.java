package boardgamecafe.gui.admin;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import boardgamecafe.BoardCafe;
import boardgamecafe.Torneos.Torneo;
import boardgamecafe.gui.principal.PanelKPI;

public class AdminInicioPanel extends JPanel {
    private static final Color COLOR_ADMIN = new Color(230, 80, 120);
    private static final Color COLOR_BG = new Color(245, 246, 248);

    private BoardCafe cafe;
    private JLabel lblBienvenida;
    private JPanel kpiContainer;

    public AdminInicioPanel(BoardCafe cafe) {
        this.cafe = cafe;
        setLayout(new BorderLayout(10, 10));
        setBackground(COLOR_BG);
        setBorder(new EmptyBorder(20, 20, 20, 20));

        lblBienvenida = new JLabel("Panel de Administracion");
        lblBienvenida.setFont(new Font("SansSerif", Font.BOLD, 24));
        lblBienvenida.setForeground(COLOR_ADMIN);

        kpiContainer = new JPanel(new GridLayout(1, 3, 15, 0));
        kpiContainer.setOpaque(false);

        JButton btnRefresh = new JButton("Actualizar");
        btnRefresh.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actualizarDatos();
            }
        });

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setOpaque(false);
        topPanel.add(lblBienvenida, BorderLayout.WEST);
        topPanel.add(btnRefresh, BorderLayout.EAST);

        add(topPanel, BorderLayout.NORTH);
        add(kpiContainer, BorderLayout.CENTER);

        addComponentListener(new ComponentAdapter() {
            public void componentShown(ComponentEvent e) {
                actualizarDatos();
            }
        });
    }

    private void actualizarDatos() {
        kpiContainer.removeAll();

        try {
            int totalTorneos = cafe.consultarTorneos().size();
            kpiContainer.add(PanelKPI.crearKPICard("Torneos Activos",
                    String.valueOf(totalTorneos), "torneos registrados", COLOR_ADMIN));
        } catch (Exception e) {
            kpiContainer.add(PanelKPI.crearKPICard("Torneos Activos", "—", "sin datos", COLOR_ADMIN));
        }

        try {
            int totalJuegos = cafe.consultarCatalogo().size();
            kpiContainer.add(PanelKPI.crearKPICard("Juegos en Catálogo",
                    String.valueOf(totalJuegos), "juegos disponibles", COLOR_ADMIN));
        } catch (Exception e) {
            kpiContainer.add(PanelKPI.crearKPICard("Juegos en Catálogo", "—", "sin datos", COLOR_ADMIN));
        }

        kpiContainer.add(PanelKPI.crearKPICard("Usuarios", "6", "usuarios registrados", COLOR_ADMIN));

        kpiContainer.revalidate();
        kpiContainer.repaint();
        /*
         * Estas dos funciones de repaint y revalidate se usan debido a que toca
         * actualizar los datos ya que hace que el swing lo recalcule y coloque los
         * nuevos
         */
    }
}
