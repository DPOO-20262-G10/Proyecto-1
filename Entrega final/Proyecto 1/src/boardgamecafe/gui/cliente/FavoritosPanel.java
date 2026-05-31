package boardgamecafe.gui.cliente;

import boardgamecafe.BoardCafe;
import boardgamecafe.Juegos.JuegosDeMesa;

import java.awt.BorderLayout;
import java.awt.event.*;

import javax.swing.*;

public class FavoritosPanel extends JPanel implements ActionListener {
	
    private BoardCafe cafe;
    
    private JTextArea favoritos;
    
    private JButton btnVer;
    
    public FavoritosPanel(BoardCafe cafe) {
    	
    	this.cafe = cafe;
    	
    	setLayout(new BorderLayout());
    	
    	JLabel titulo = new JLabel("Mis Favoritos");
    	add(titulo, BorderLayout.NORTH);
    	
    	favoritos = new JTextArea();
    	favoritos.setEditable(false);
    	add(favoritos, BorderLayout.CENTER);
    	
    	btnVer = new JButton("Ver Favoritos");
    	btnVer.addActionListener(this);
    	add(btnVer, BorderLayout.SOUTH);
    	
    }
    
    public void actionPerformed(ActionEvent e) {
    	if(e.getSource() == btnVer) {
			String texto = "";
			
			for(JuegosDeMesa juego : cafe.consultarCatalogo()) {
				texto = texto 
						+ "Juego: " + juego.getIdJuego()
						+ " - " + juego.getNombre() + " - " + juego.getAnioPublicacion() + " - " + juego.getMinJugadores() 
						+ " - " + juego.getMaxJugadores() + " - " + juego.getEdadMinima() + " - " + juego.isEsDificil() + " - " + juego.getCategoria()
						+ "\n";
			}
			favoritos.setText(texto);
		}
    	
    }

}
