package boardgamecafe.gui.cliente;

import boardgamecafe.BoardCafe;
import boardgamecafe.pedidos.Pedido;

import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;

public class PedidosClientePanel extends JPanel implements ActionListener {
	
	private BoardCafe cafe;
	
	private JTextArea pedidos;
	
	private JButton btnVer;
	
	public PedidosClientePanel(BoardCafe cafe) {
		
		this.cafe = cafe;
		
		setLayout(new BorderLayout());
		
		JLabel titulo = new JLabel("Mis Pedidos");
		add(titulo, BorderLayout.NORTH);
		
		pedidos = new JTextArea();
		pedidos.setEditable(false);
		add(pedidos, BorderLayout.CENTER);
		
		btnVer = new JButton("Ver Pedidos");
		btnVer.addActionListener(this);
		add(btnVer, BorderLayout.SOUTH);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnVer) { 
			
			String texto = "";
			
			for (Pedido pedido: cafe.consultarHistorialPedidos()) {
				
				texto = texto
						+ "Pedido ID: " + pedido.getIdPedido() + " - Valor: " + pedido.calcularTotal() + " - Fecha: " + pedido.getFecha() + "\n";
			}
			pedidos.setText(texto);
		}
	}
}
