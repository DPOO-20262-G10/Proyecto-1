package boardgamecafe.gui.cliente;

import boardgamecafe.BoardCafe;
import boardgamecafe.Torneos.Torneo;

import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;


public class TorneosClientePanel extends JPanel implements ActionListener {
    
	private BoardCafe cafe;
	
	private JTextArea torneos;
	
	private JButton btnVer;
	
	public TorneosClientePanel(BoardCafe cafe) {
		
		this.cafe = cafe;
		
		setLayout(new BorderLayout());
		
		JLabel titulo = new JLabel("Mis Torneos");
		add(titulo, BorderLayout.NORTH);
		
		torneos = new JTextArea();
		torneos.setEditable(false);
		add(torneos, BorderLayout.CENTER);
		
		btnVer = new JButton("Ver Torneos");
		btnVer.addActionListener(this);
		add(btnVer, BorderLayout.SOUTH);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnVer) {
			
			String texto = "";
			
			for(Torneo torneo: cafe.consultarTorneos()) {
				texto = texto
						+ "Torneo Id: " + torneo.getIdTorneo() + " - Nombre: " + torneo.getNombre() + " - Tipo: " + torneo.getTipo() 
						+ " - Ganador: " + torneo.getGanador() + "\n";
			}
			
			torneos.setText(texto);
		}
	}
}
