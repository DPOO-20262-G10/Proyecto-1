package boardgamecafe.gui.admin;

import boardgamecafe.BoardCafe;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

public class UsuariosPanel extends JPanel implements ActionListener {
    
	private BoardCafe cafe;
	
	private JTextField nombre;
	
	private JTextField login;
	
	private JTextField password;
	
	private JTextField tipo;
	
	private JButton btnCrear;
	
	public UsuariosPanel(BoardCafe cafe) {
		
		this.cafe = cafe;
		
		setLayout(new BorderLayout());
		
		JLabel titulo = new JLabel("Crear Usuario");
		add(titulo, BorderLayout.NORTH);
		
		JPanel centro = new JPanel();
		centro.setLayout(new GridLayout(4, 2));
		
		centro.add(new JLabel("Nombre"));
		nombre = new JTextField();
		centro.add(nombre);
		
		centro.add(new JLabel("Login"));
		login = new JTextField();
		centro.add(login);
		
		centro.add(new JLabel("Password"));
		password = new JTextField();
		centro.add(password);
		
		centro.add(new JLabel("Tipo (cliente, empleado, mesero, cocinero, administrador)"));
		tipo = new JTextField();
		centro.add(tipo);
		
		add(centro, BorderLayout.CENTER);
		
		btnCrear = new JButton("Crear Usuario");
		btnCrear.addActionListener(this);
		add(btnCrear, BorderLayout.SOUTH);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCrear) {
			
			String n = nombre.getText();
			String l = login.getText();
			String p = password.getText();
			String t = tipo.getText();
				
			cafe.registrarUsuario(n, l, p, t);
				
		}	
	}	
}
	
