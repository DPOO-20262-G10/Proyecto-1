package boardgamecafe.gui.admin;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import boardgamecafe.BoardCafe;
import boardgamecafe.gui.principal.NavPanel;

public class AdminFrame extends JPanel {
    private static final Color COLOR_ADMIN = new Color(230, 80, 120);
    private static final Color COLOR_BG = new Color(245, 246, 248);

    private BoardCafe cafe;
    private CardLayout internalLayout;
    private JPanel contentPanel;

    public AdminFrame(CardLayout cardLayout, JPanel mainContainer, BoardCafe cafe) {
        this.cafe = cafe;
        setLayout(new BorderLayout());
        setBackground(COLOR_BG);

        NavPanel nav = new NavPanel();
        JPanel sidebar = new JPanel();
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setBackground(Color.WHITE);
        sidebar.setBorder(new EmptyBorder(15, 10, 15, 10));
        sidebar.setPreferredSize(new Dimension(200, 0));

        JLabel lblTitulo = new JLabel("  Administrador");
        lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 18));
        lblTitulo.setForeground(COLOR_ADMIN);
        sidebar.add(lblTitulo);
        sidebar.add(Box.createRigidArea(new Dimension(0, 15)));

        String[] nombres = { "Inicio", "Usuarios", "Inventario", "Turnos", "Torneos", "Graficas", "Informes",
                "Solicitudes" };
        String[] keys = { "INICIO", "USUARIOS", "INVENTARIO", "TURNOS", "TORNEOS", "GRAFICAS", "INFORMES",
                "SOLICITUDES" };

        internalLayout = new CardLayout();
        contentPanel = new JPanel(internalLayout);

        for (int i = 0; i < nombres.length; i++) {
            JButton btn = nav.crearBoton(nombres[i], COLOR_ADMIN);
            final String key = keys[i];
            btn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    internalLayout.show(contentPanel, key);
                }
            });
            sidebar.add(btn);
            sidebar.add(Box.createRigidArea(new Dimension(0, 3)));
        }

        sidebar.add(Box.createVerticalGlue());

        JButton btnLogout = nav.crearBoton("Cerrar Sesión", COLOR_ADMIN);
        btnLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cafe.logout();
                cardLayout.show(mainContainer, "LOGIN");
            }
        });
        sidebar.add(btnLogout);

        contentPanel.add(new AdminInicioPanel(cafe), "INICIO");
        contentPanel.add(new UsuariosPanel(cafe), "USUARIOS");
        contentPanel.add(new InventarioPanel(cafe), "INVENTARIO");
        contentPanel.add(new TurnosAdminPanel(cafe), "TURNOS");
        contentPanel.add(new TorneosAdminPanel(cafe), "TORNEOS");
        contentPanel.add(new GraficasPanel(cafe), "GRAFICAS");
        contentPanel.add(new InformesPanel(cafe), "INFORMES");
        contentPanel.add(new SolicitudesPanel(cafe), "SOLICITUDES");

        add(sidebar, BorderLayout.WEST);
        add(contentPanel, BorderLayout.CENTER);
    }
}
