package boardgamecafe.gui.cliente;

import boardgamecafe.BoardCafe;
import boardgamecafe.VentaJuegos.Compra;

import java.awt.BorderLayout;
import java.awt.event.*;

import javax.swing.*;

public class MisComprasPanel extends JPanel implements ActionListener {
	
	private boardgamecafe.logica.BoardCafe cafe;
	
	private JTextArea compras;
	
	private JButton btnVer;
	
	public MisComprasPanel(BoardCafe cafe) {
		
		this.cafe = cafe;
		
		setLayout(new BorderLayout());
		
		JLabel titulo = new JLabel("Mis Compras");
		add(titulo, BorderLayout.NORTH);
		
		compras = new JTextArea();
		compras.setEditable(false);
		add(compras, BorderLayout.CENTER);
		
		btnVer = new JButton("Ver Compras");
		btnVer.addActionListener(this);
		add(btnVer, BorderLayout.SOUTH);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnVer) {
			String texto = "";
					
			for (Compra compras : cafe.consultarHistorialCompras()) {
				
				texto = texto 
						+ "Compra ID: " + compras.getIdCompra() + " - Valor: " + compras.getValor()	 + " - Fecha: " + compras.getFecha() + "\n";
			}
			
			compras.setText(texto);
		}
	}
}
