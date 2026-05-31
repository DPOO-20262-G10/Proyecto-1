package boardgamecafe.gui.auth;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import boardgamecafe.BoardCafe;
import javax.swing.*;


public class DialogRegistro extends JDialog {
	private JLabel lbltitulo;
	private JLabel lblNombre;
	private JLabel lblLogin;
	private JLabel lblPassword;
	private JLabel lblTipo;

	private JTextField txtNombre;
	private JTextField txtLogin;
	private JTextField txtPassword;

	private JComboBox<String> cmbTipo;

	private JButton btnRegistrar;
	private JButton btnCancelar;
	private BoardCafe mundo;
	
    public DialogRegistro(BoardCafe mundo) {
    	
    	this.mundo = mundo;
    	setTitle("Registro");
        setSize(300, 200);
    	setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
    	
    	//Panel Titulo
    	JPanel paneltitulo = new JPanel();
		paneltitulo.setLayout(new FlowLayout(FlowLayout.CENTER));
		lbltitulo = new JLabel("Registro de usuarios");
		lbltitulo.setFont(new Font("Arial", Font.BOLD, 24));
		paneltitulo.add(lbltitulo);
		add(paneltitulo);
        
        //Panel Formulario
        JPanel panelformularios = new JPanel();
		panelformularios.setLayout(new GridLayout(4,2));
		lblNombre = new JLabel("Nombre");
		panelformularios.add(lblNombre);
		txtNombre = new JTextField();
		panelformularios.add(txtNombre);
		lblLogin = new JLabel("Login");
		panelformularios.add(lblLogin);
		txtLogin = new JTextField();
		panelformularios.add(txtLogin);
		lblPassword = new JLabel("Contraseña");
		panelformularios.add(lblPassword);
		txtPassword = new JTextField();
		panelformularios.add(txtPassword);
		lblTipo = new JLabel("Tipo");
		panelformularios.add(lblTipo);
		cmbTipo = new JComboBox<>();
		cmbTipo.addItem("cliente");
		cmbTipo.addItem("empleado");
		panelformularios.add(cmbTipo);
		add(panelformularios);
		
		//Panel Botones
		JPanel panelbotones = new JPanel();
		panelbotones.setLayout(new FlowLayout());
		btnRegistrar = new JButton("Registrar");
		panelbotones.add(btnRegistrar);
		btnCancelar = new JButton("Cancelar");
		panelbotones.add(btnCancelar);
		add(panelbotones);
        
		btnRegistrar.addActionListener(e -> Registrar());
		btnCancelar.addActionListener(e -> dispose());
		
		setLocationRelativeTo(null);
        setModal(true);
    }
    
    private void Registrar() {
    	
    	try {
    	String Nombre = txtNombre.getText();
    	String login = txtLogin.getText();
    	String contraseña = txtPassword.getText();
    	String tipo = (String) cmbTipo.getSelectedItem();
    	
    	mundo.registrarUsuario(Nombre, login, contraseña, tipo);
    	JOptionPane.showMessageDialog(
                this,
                "Usuario registrado correctamente"
            );

            dispose();
    	}
	    catch (IllegalArgumentException e) {
	    	JOptionPane.showMessageDialog(
	                this,
	                e.getMessage(),
	                "Error",
	                JOptionPane.ERROR_MESSAGE
	            );

	        }
	    }
	    
    
}
