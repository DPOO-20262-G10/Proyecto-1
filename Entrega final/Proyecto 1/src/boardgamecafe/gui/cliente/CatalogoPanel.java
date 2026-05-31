package boardgamecafe.gui.cliente;

import boardgamecafe.BoardCafe;
import boardgamecafe.juegos.JuegosDeMesa;



import java.awt.BorderLayout;
import java.awt.event.*;

import javax.swing.*;

public class CatalogoPanel extends JPanel implements ActionListener{
    
	private BoardCafe cafe;
	
	private JTextArea txtCatalogo;
	
	private JButton btnVer;
	
	public CatalogoPanel(BoardCafe cafe) {
		
		this.cafe = cafe;
		
		setLayout(new BorderLayout());
		
		JLabel titulo = new JLabel("Catalogo de Juegos");
		add(titulo, BorderLayout.NORTH);
		
		txtCatalogo = new JTextArea();
		txtCatalogo.setEditable(false);
		add(txtCatalogo, BorderLayout.CENTER);
		
		btnVer = new JButton("Ver Catalogo");
		btnVer.addActionListener(this);
		add(btnVer, BorderLayout.SOUTH);
		
    }
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnVer) {
			String texto = "";
			
			for(JuegosDeMesa juego : cafe.consultarCatalogo()) {
				texto = texto 
						+ "Juego: " + juego.getIdJuego()
						+ " - " + juego.getNombre() + " - " + juego.getAnioPublicacion() + " - " + juego.getMinJugadores() 
						+ " - " + juego.getMaxJugadores() + " - " + juego.getEdadMinima() + " - " + juego.isEsDificil() + " - " + juego.getCategoria()
						+ "\n";
			}
			txtCatalogo.setText(texto);
		}
	}
}
