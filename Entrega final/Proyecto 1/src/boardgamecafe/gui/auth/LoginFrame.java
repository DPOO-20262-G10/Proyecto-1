package boardgamecafe.gui.auth;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import boardgamecafe.BoardCafe;


public class LoginFrame extends JPanel {
	
	private JLabel lblCafe;
	private JLabel lblUsuario;
	private JLabel lblContraseña;
	private JTextField txtUsuario;
	private JTextField txtContraseña;
	private JButton bttingresar;
	private JButton bttregistrar;
	private BoardCafe mundo;
	private CardLayout cardLayout;
	private JPanel mainContainer;
	
	public LoginFrame(BoardCafe mundo ,CardLayout cardLayout,JPanel mainContainer) {
		
		this.mundo = mundo;
	    this.cardLayout = cardLayout;
	    this.mainContainer = mainContainer;
	    
	    
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		//Panel Titulo
		JPanel paneltitulo = new JPanel();
		paneltitulo.setLayout(new FlowLayout(FlowLayout.CENTER));
		lblCafe = new JLabel("Board Game Cafe");
		lblCafe.setFont(new Font("Arial", Font.BOLD, 24));
		paneltitulo.add(lblCafe);
		add(paneltitulo);
		
		//Panel Formularios
		JPanel panelformularios = new JPanel();
		panelformularios.setLayout(new GridLayout(2,2));
		lblUsuario = new JLabel("Usuario");
		panelformularios.add(lblUsuario);
		txtUsuario = new JTextField();
		panelformularios.add(txtUsuario);
		lblContraseña = new JLabel("Contraseña");
		panelformularios.add(lblContraseña);
		txtContraseña = new JTextField();
		panelformularios.add(txtContraseña);
		add(panelformularios);
		
		//Panel Botones
		JPanel panelbotones = new JPanel();
		panelbotones.setLayout(new FlowLayout());
		bttingresar = new JButton("Ingresar");
		panelbotones.add(bttingresar);
		bttregistrar = new JButton("Registrar");
		panelbotones.add(bttregistrar);
		add(panelbotones);
		
		bttingresar.addActionListener(e -> login());
		bttregistrar.addActionListener(e -> registrar());
		
	}
	
	private void login() {
		
	    String usuario = txtUsuario.getText();

	    String contraseña = txtContraseña.getText();

	    boolean ok = mundo.login(usuario, contraseña);

	    if (ok) {
	        JOptionPane.showMessageDialog(
	            this,
	            "Bienvenido " + usuario
	        );
	        String Tipo = mundo.darTipoUsuarioActivo();
	        cardLayout.show(mainContainer, Tipo);
	    }
	    else {
	        JOptionPane.showMessageDialog(
	            this,
	            "Usuario o contraseña incorrectos"
	        );
	    }	    
	}
	
	private void registrar() {
		
		DialogRegistro dialogo = new DialogRegistro(mundo);

	    dialogo.setLocationRelativeTo(this);

	    dialogo.setVisible(true);
	    
	}
	
}
