package boardgamecafe.gui.cliente;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import boardgamecafe.BoardCafe;
import boardgamecafe.usuarios.Usuario;
import boardgamecafe.gui.principal.PanelKPI;

public class ClienteInicioPanel extends JPanel {
    private static final Color COLOR_CLIENTE = new Color(110, 80, 180);

    private BoardCafe cafe;
    private JLabel lblBienvenida;
    private JPanel kpiContainer;

    public ClienteInicioPanel(BoardCafe cafe) {
        this.cafe = cafe;
        setLayout(new BorderLayout(10, 10));
        setBackground(new Color(245, 246, 248));
        setBorder(new EmptyBorder(20, 20, 20, 20));

        lblBienvenida = new JLabel("Bienvenido");
        lblBienvenida.setFont(new Font("SansSerif", Font.BOLD, 24));
        lblBienvenida.setForeground(COLOR_CLIENTE);

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
        Usuario u = cafe.getUsuarioActivo();
        if (u != null) {
            lblBienvenida.setText("Bienvenido, " + u.getNombre());
            kpiContainer.removeAll();
            kpiContainer.add(PanelKPI.crearKPICard("Puntos Fidelidad",
                String.valueOf(u.getPuntosFidelidad()), "puntos acumulados", COLOR_CLIENTE));
            kpiContainer.add(PanelKPI.crearKPICard("Favoritos",
                String.valueOf(cafe.consultarFavoritos().size()), "juegos favoritos", COLOR_CLIENTE));
            kpiContainer.add(PanelKPI.crearKPICard("Pedidos",
                String.valueOf(cafe.consultarHistorialPedidos().size()), "pedidos realizados", COLOR_CLIENTE));
            kpiContainer.revalidate();
            kpiContainer.repaint();
        }
    }
}
