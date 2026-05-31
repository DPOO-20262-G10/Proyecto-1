package boardgamecafe.gui.empleado;

import java.awt.*;
import java.util.List;
import javax.swing.*;

import boardgamecafe.BoardCafe;
import boardgamecafe.menu.Producto;
import boardgamecafe.pedidos.Pedido;

public class PedidosMesaPanel extends JPanel {

    private BoardCafe mundo;

    private JPanel lista;
    private JLabel contador;

    public PedidosMesaPanel(BoardCafe mundo) {
        this.mundo = mundo;

        setLayout(new BorderLayout());

        construir();
    }

    private void construir() {

        JPanel header = new JPanel(new FlowLayout(FlowLayout.LEFT));

        contador = new JLabel("0 pedidos");

        JButton btn = new JButton("Refrescar");

        btn.addActionListener(e -> refrescar());

        header.add(contador);
        header.add(btn);

        lista = new JPanel();
        lista.setLayout(new BoxLayout(lista, BoxLayout.Y_AXIS));

        JScrollPane scroll = new JScrollPane(lista);

        add(header, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
    }

    public void refrescar() {

        lista.removeAll();

        List<Pedido> pedidos = mundo.getPedidosTodos();

        contador.setText(pedidos.size() + " pedidos");

        if (pedidos.isEmpty()) {
            lista.add(new JLabel("No hay pedidos"));
        } else {

            for (int i = 0; i < pedidos.size(); i++) {

                Pedido p = pedidos.get(i);

                JPanel panel = new JPanel(new GridLayout(0, 1));

                panel.add(new JLabel("Pedido " + p.getIdPedido()));
                panel.add(new JLabel("Usuario " + p.getLoginUsuario()));

                if (p.getFecha() != null) {
                    panel.add(new JLabel("Fecha " + p.getFecha().toString()));
                } else {
                    panel.add(new JLabel("Fecha -"));
                }

                List<Producto> productos = p.getProductos();

                panel.add(new JLabel("Productos: " + productos.size()));

                double total = p.calcularTotal();
                panel.add(new JLabel("Total: " + total));

                lista.add(panel);
                lista.add(new JLabel(" "));
            }
        }

        lista.revalidate();
        lista.repaint();
    }
}
