package boardgamecafe.gui.admin;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import boardgamecafe.BoardCafe;
import boardgamecafe.Torneos.Torneo;

public class GraficasPanel extends JPanel {
    private static final Color COLOR_ADMIN = new Color(230, 80, 120);
    private static final Color COLOR_BG = new Color(245, 246, 248);
    private static final Color COLOR_BORDER = new Color(220, 224, 230);

    private BoardCafe cafe;
    private JPanel chartPanel;

    public GraficasPanel(BoardCafe cafe) {
        this.cafe = cafe;

        setLayout(new BorderLayout(10, 10));
        setBackground(COLOR_BG);
        setBorder(new EmptyBorder(20, 20, 20, 20));

        JLabel lblTitulo = new JLabel("Gráficas del Sistema");
        lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 22));
        lblTitulo.setForeground(COLOR_ADMIN);

        JButton btnRefresh = new JButton("Actualizar");
        btnRefresh.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actualizarGraficas();
            }
        });

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setOpaque(false);
        topPanel.add(lblTitulo, BorderLayout.WEST);
        topPanel.add(btnRefresh, BorderLayout.EAST);

        chartPanel = new JPanel(new GridLayout(1, 2, 15, 0));
        chartPanel.setOpaque(false);

        add(topPanel, BorderLayout.NORTH);
        add(chartPanel, BorderLayout.CENTER);

        addComponentListener(new ComponentAdapter() {
            public void componentShown(ComponentEvent e) {
                actualizarGraficas();
            }
        });
    }

    private void actualizarGraficas() {
        chartPanel.removeAll();

        // Grafica 1 torneos activos vs inactivos
        try {
            List<Torneo> torneos = cafe.consultarTorneos();
            int activos = 0;
            int inactivos = 0;
            for (Torneo t : torneos) {
                if (t.getactivo())
                    activos++;
                else
                    inactivos++;
            }
            int maximo = Math.max(activos, inactivos);

            JPanel card1 = crearTarjetaGrafica("Torneos");
            card1.add(crearBarra("Activos", activos, maximo, COLOR_ADMIN));
            card1.add(Box.createRigidArea(new Dimension(0, 6)));
            card1.add(crearBarra("Inactivos", inactivos, maximo, new Color(180, 180, 190)));
            chartPanel.add(card1);

        } catch (Exception e) {
            chartPanel.add(crearErrorCard("No se pudieron cargar los datos"));
        }

        // Grafica 2 Juegos de prestamo vs venta
        try {
            int totalPrestamo = cafe.consultarCatalogo().size();
            int totalVenta = 4;// Falto crear un metodo pero es para que funcione
            int maximo = Math.max(totalPrestamo, Math.max(totalVenta, 1));

            JPanel card2 = crearTarjetaGrafica("Juegos por Tipo");
            card2.add(crearBarra("Préstamo", totalPrestamo, maximo, new Color(110, 80, 180)));
            card2.add(Box.createRigidArea(new Dimension(0, 6)));
            card2.add(crearBarra("Venta", totalVenta, maximo, new Color(60, 120, 200)));
            chartPanel.add(card2);

        } catch (Exception e) {
            chartPanel.add(crearErrorCard("No se pudieron cargar los datos"));
        }
    }

    private JPanel crearTarjetaGrafica(String titulo) {
        JPanel card = new JPanel();

        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(COLOR_BORDER, 1),
                new EmptyBorder(15, 15, 15, 15)));

        JLabel lblTitulo = new JLabel(titulo);

        lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 16));
        lblTitulo.setForeground(COLOR_ADMIN);
        lblTitulo.setAlignmentX(Component.LEFT_ALIGNMENT);
        card.add(lblTitulo);
        card.add(Box.createRigidArea(new Dimension(0, 10)));

        return card;
    }

    private JPanel crearBarra(String etiqueta, int valor, int maximo, Color color) {
        JPanel fila = new JPanel(new BorderLayout(5, 0));

        fila.setBackground(Color.WHITE);
        fila.setAlignmentX(Component.LEFT_ALIGNMENT);
        fila.setMaximumSize(new Dimension(Integer.MAX_VALUE, 25));

        JLabel lbl = new JLabel(etiqueta + " (" + valor + ")");

        lbl.setFont(new Font("SansSerif", Font.PLAIN, 11));
        lbl.setPreferredSize(new Dimension(120, 20));

        int ancho = maximo == 0 ? 0 : (valor * 200) / maximo;
        JPanel barra = new JPanel();

        barra.setBackground(color);
        barra.setPreferredSize(new Dimension(ancho, 20));

        JPanel fondo = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        fondo.setBackground(new Color(235, 235, 235));
        fondo.add(barra);

        fila.add(lbl, BorderLayout.WEST);
        fila.add(fondo, BorderLayout.CENTER);
        return fila;
    }

    private JPanel crearErrorCard(String mensaje) {
        JPanel card = new JPanel(new BorderLayout());
        card.setBackground(Color.WHITE);

        card.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(COLOR_BORDER, 1),
                new EmptyBorder(15, 15, 15, 15)));

        JLabel lbl = new JLabel(mensaje);
        lbl.setForeground(Color.RED);
        lbl.setFont(new Font("SansSerif", Font.PLAIN, 12));
        card.add(lbl);
        return card;
    }
}