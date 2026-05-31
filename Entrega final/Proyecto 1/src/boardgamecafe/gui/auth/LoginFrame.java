package boardgamecafe.gui.auth;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import boardgamecafe.BoardCafe;
import boardgamecafe.usuarios.Administrador;
import boardgamecafe.usuarios.Cliente;
import boardgamecafe.usuarios.Empleado;

public class LoginFrame extends JPanel {
    private static final Color COLOR_BG = new Color(245, 246, 248);
    private static final Color COLOR_BORDER = new Color(220, 224, 230);
    private static final Font FONT_BOLD = new Font("SansSerif", Font.BOLD, 13);
    private static final Font FONT_PLAIN = new Font("SansSerif", Font.PLAIN, 13);

    private BoardCafe cafe;
    private CardLayout cardLayout;
    private JPanel mainContainer;
    private JTextField txtUsuario;
    private JPasswordField txtPassword;

    public LoginFrame(CardLayout cardLayout, JPanel mainContainer, BoardCafe cafe) {
        this.cardLayout = cardLayout;
        this.mainContainer = mainContainer;
        this.cafe = cafe;

        setLayout(new GridBagLayout());
        setBackground(COLOR_BG);

        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(COLOR_BORDER, 1),
                new EmptyBorder(30, 45, 30, 45)));
        card.setPreferredSize(new Dimension(380, 420));
        card.setMaximumSize(new Dimension(380, 420));

        JLabel lblLogo = new JLabel("BoardCafe");
        lblLogo.setFont(new Font("SansSerif", Font.BOLD, 32));
        lblLogo.setForeground(new Color(50, 50, 60));
        lblLogo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lblSub = new JLabel("Cafe & Juegos de Mesa");
        lblSub.setFont(FONT_PLAIN);
        lblSub.setForeground(Color.GRAY);
        lblSub.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lblUser = new JLabel("Usuario");
        lblUser.setFont(FONT_BOLD);
        lblUser.setAlignmentX(Component.LEFT_ALIGNMENT);

        txtUsuario = new JTextField();
        txtUsuario.setMaximumSize(new Dimension(300, 35));
        txtUsuario.setFont(FONT_PLAIN);
        txtUsuario.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(COLOR_BORDER, 1),
                new EmptyBorder(5, 10, 5, 10)));

        JLabel lblPass = new JLabel("Contrasena");
        lblPass.setFont(FONT_BOLD);
        lblPass.setAlignmentX(Component.LEFT_ALIGNMENT);

        txtPassword = new JPasswordField();
        txtPassword.setMaximumSize(new Dimension(300, 35));
        txtPassword.setFont(FONT_PLAIN);
        txtPassword.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(COLOR_BORDER, 1),
                new EmptyBorder(5, 10, 5, 10)));

        JButton btnLogin = new JButton("Iniciar Sesion");
        btnLogin.setMaximumSize(new Dimension(300, 40));
        btnLogin.setBackground(new Color(60, 60, 70));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFont(FONT_BOLD);
        btnLogin.setFocusPainted(false);
        btnLogin.setBorderPainted(false);
        btnLogin.setOpaque(true);
        btnLogin.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                manejarLogin();
            }
        });

        JButton btnRegistrar = new JButton("Registrarse");
        btnRegistrar.setMaximumSize(new Dimension(300, 35));
        btnRegistrar.setBackground(Color.WHITE);
        btnRegistrar.setForeground(new Color(60, 60, 70));
        btnRegistrar.setFont(FONT_PLAIN);
        btnRegistrar.setFocusPainted(false);
        btnRegistrar.setBorderPainted(false);
        btnRegistrar.setOpaque(true);
        btnRegistrar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame parent = (JFrame) SwingUtilities.getWindowAncestor(LoginFrame.this);
                DialogRegistro dialogo = new DialogRegistro(parent, cafe);
                dialogo.setVisible(true);
            }
        });

        card.add(lblLogo);
        card.add(Box.createRigidArea(new Dimension(0, 5)));
        card.add(lblSub);
        card.add(Box.createRigidArea(new Dimension(0, 25)));
        card.add(lblUser);
        card.add(Box.createRigidArea(new Dimension(0, 5)));
        card.add(txtUsuario);
        card.add(Box.createRigidArea(new Dimension(0, 15)));
        card.add(lblPass);
        card.add(Box.createRigidArea(new Dimension(0, 5)));
        card.add(txtPassword);
        card.add(Box.createRigidArea(new Dimension(0, 25)));
        card.add(btnLogin);
        card.add(Box.createRigidArea(new Dimension(0, 10)));
        card.add(btnRegistrar);

        add(card);
    }

    private void manejarLogin() {
        try {
            String usuario = txtUsuario.getText().trim();
            String password = new String(txtPassword.getPassword()).trim();
            cafe.login(usuario, password);

            if (cafe.getUsuarioActivo() instanceof Administrador) {
                cardLayout.show(mainContainer, "ADMIN");
            } else if (cafe.getUsuarioActivo() instanceof Empleado) {
                cardLayout.show(mainContainer, "EMPLEADO");
            } else if (cafe.getUsuarioActivo() instanceof Cliente) {
                cardLayout.show(mainContainer, "CLIENTE");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}