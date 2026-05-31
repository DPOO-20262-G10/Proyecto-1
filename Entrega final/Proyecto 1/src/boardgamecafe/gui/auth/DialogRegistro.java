package boardgamecafe.gui.auth;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import boardgamecafe.BoardCafe;

public class DialogRegistro extends JDialog {
    private BoardCafe cafe;
    private JTextField txtNombre = new JTextField(15);
    private JTextField txtLogin = new JTextField(15);
    private JPasswordField txtPassword = new JPasswordField(15);
    private JComboBox<String> comboTipo = new JComboBox<>(
            new String[] { "cliente", "mesero", "cocinero", "administrador" });

    public DialogRegistro(JFrame parent, BoardCafe cafe) {
        super(parent, "Registro", true);
        this.cafe = cafe;

        setSize(300, 250);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(5, 2, 8, 8));
        panel.setBorder(new EmptyBorder(15, 15, 15, 15));

        panel.add(new JLabel("Nombre:"));
        panel.add(txtNombre);
        panel.add(new JLabel("Usuario (Login):"));
        panel.add(txtLogin);
        panel.add(new JLabel("Contraseña:"));
        panel.add(txtPassword);
        panel.add(new JLabel("Rol:"));
        panel.add(comboTipo);

        JButton btnConfirmar = new JButton("Registrarse");
        btnConfirmar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    cafe.registrarUsuario(
                            txtNombre.getText().trim(),
                            txtLogin.getText().trim(),
                            new String(txtPassword.getPassword()).trim(),
                            (String) comboTipo.getSelectedItem());
                    JOptionPane.showMessageDialog(DialogRegistro.this, "Usuario registrado correctamente.");
                    dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(DialogRegistro.this, ex.getMessage(), "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        add(panel, BorderLayout.CENTER);
        add(btnConfirmar, BorderLayout.SOUTH);
    }
}
