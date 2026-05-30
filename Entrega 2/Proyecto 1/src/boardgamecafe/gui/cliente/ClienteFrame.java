package boardgamecafe.gui.cliente;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import boardgamecafe.BoardCafe;
import boardgamecafe.gui.principal.NavPanel;

public class ClienteFrame extends JPanel {
    private static final Color COLOR_CLIENTE = new Color(110, 80, 180);
    private static final Color COLOR_BG = new Color(245, 246, 248);
    private static final Color COLOR_BORDER = new Color(220, 224, 230);

    private BoardCafe cafe;
    private CardLayout internalLayout;
    private JPanel contentPanel;

    public ClienteFrame(CardLayout cardLayout, JPanel mainContainer, BoardCafe cafe) {
        this.cafe = cafe;
        setLayout(new BorderLayout());
        setBackground(COLOR_BG);

        NavPanel nav = new NavPanel();
        JPanel sidebar = new JPanel();
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setBackground(Color.WHITE);
        sidebar.setBorder(new EmptyBorder(15, 10, 15, 10));
        sidebar.setPreferredSize(new Dimension(200, 0));

        JLabel lblTitulo = new JLabel("  Cliente");
        lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 18));
        lblTitulo.setForeground(COLOR_CLIENTE);
        sidebar.add(lblTitulo);
        sidebar.add(Box.createRigidArea(new Dimension(0, 15)));

        String[] nombres = { "Inicio", "Catálogo", "Favoritos", "Pedidos", "Compras", "Préstamos", "Torneos" };
        String[] keys = { "INICIO", "CATALOGO", "FAVORITOS", "PEDIDOS", "COMPRAS", "PRESTAMOS", "TORNEOS" };

        internalLayout = new CardLayout();
        contentPanel = new JPanel(internalLayout);

        for (int i = 0; i < nombres.length; i++) {
            JButton btn = nav.crearBoton(nombres[i], COLOR_CLIENTE);
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

        JButton btnLogout = nav.crearBoton("Cerrar Sesión", COLOR_CLIENTE);
        btnLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cafe.logout();
                cardLayout.show(mainContainer, "LOGIN");
            }
        });
        sidebar.add(btnLogout);

        contentPanel.add(new ClienteInicioPanel(cafe), "INICIO");
        contentPanel.add(new CatalogoPanel(cafe), "CATALOGO");
        contentPanel.add(new FavoritosPanel(cafe), "FAVORITOS");
        contentPanel.add(new PedidosClientePanel(cafe), "PEDIDOS");
        contentPanel.add(new MisComprasPanel(cafe), "COMPRAS");
        contentPanel.add(new MisPrestamosPanel(cafe), "PRESTAMOS");
        contentPanel.add(new TorneosClientePanel(cafe), "TORNEOS");

        add(sidebar, BorderLayout.WEST);
        add(contentPanel, BorderLayout.CENTER);
    }
}