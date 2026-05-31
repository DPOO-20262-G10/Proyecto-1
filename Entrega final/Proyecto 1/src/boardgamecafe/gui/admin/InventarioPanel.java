package boardgamecafe.gui.admin;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.Map;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import boardgamecafe.BoardCafe;
import boardgamecafe.Juegos.CopiaJuego;
import boardgamecafe.Juegos.JuegosDeMesa;

public class InventarioPanel extends JPanel {
    private static final Color COLOR_ADMIN = new Color(230, 80, 120);

    private BoardCafe cafe;
    private DefaultTableModel tableModel;

    // se pidio ayuda a IA para definir la estructura general del panel de
    // inventario ya que es uno complejo y no se ha visto mucho en DPOO

    public InventarioPanel(BoardCafe cafe) {
        this.cafe = cafe;
        setLayout(new BorderLayout(10, 10));
        setBackground(new Color(245, 246, 248));
        setBorder(new EmptyBorder(20, 20, 20, 20));

        JLabel lblTitulo = new JLabel("Inventario de Juegos");
        lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 22));
        lblTitulo.setForeground(COLOR_ADMIN);

        JButton btnRefresh = new JButton("Actualizar");
        btnRefresh.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cargarTabla();
            }
        });

        JPanel top = new JPanel(new BorderLayout());
        top.setOpaque(false);
        top.add(lblTitulo, BorderLayout.WEST);
        top.add(btnRefresh, BorderLayout.EAST);

        tableModel = new DefaultTableModel(new String[] { "ID Juego", "Nombre", "ID Copia", "Estado", "Disponible" },
                0) {
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        JTable tabla = new JTable(tableModel);

        JPanel fila1 = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 3));
        fila1.setOpaque(false);
        fila1.add(new JLabel("ID Juego:"));

        JTextField txtIdJuego = new JTextField(5);
        fila1.add(txtIdJuego);
        fila1.add(new JLabel("Cantidad:"));

        JSpinner spnCantidad = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
        fila1.add(spnCantidad);
        fila1.add(new JLabel("Tipo:"));

        JComboBox<String> comboTipo = new JComboBox<String>(new String[] { "prestamo", "venta" });
        fila1.add(comboTipo);

        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.setBackground(COLOR_ADMIN);
        btnAgregar.setForeground(Color.WHITE);
        btnAgregar.setFocusPainted(false);
        btnAgregar.setOpaque(true);
        btnAgregar.setBorderPainted(false);
        btnAgregar.addActionListener(new ActionListener()

        {
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(txtIdJuego.getText().trim());
                    int cant = (Integer) spnCantidad.getValue();
                    String tipo = (String) comboTipo.getSelectedItem();
                    cafe.agregarJuegosInventario(id, cant, tipo, "Disponible");
                    JOptionPane.showMessageDialog(InventarioPanel.this, "Inventario actualizado.");
                    cargarTabla();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(InventarioPanel.this, ex.getMessage(), "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        fila1.add(btnAgregar);

        JPanel fila2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 3));
        fila2.setOpaque(false);
        fila2.add(new JLabel("Mover — ID Juego:"));

        JTextField txtIdMover = new JTextField(5);
        fila2.add(txtIdMover);
        fila2.add(new JLabel("Cantidad:"));

        JSpinner spnCantMover = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
        fila2.add(spnCantMover);
        fila2.add(new JLabel("Origen:"));

        JComboBox<String> comboOrigen = new JComboBox<String>(new String[] { "venta", "prestamo" });
        fila2.add(comboOrigen);

        JButton btnMover = new JButton("Mover");
        btnMover.setBackground(COLOR_ADMIN);
        btnMover.setForeground(Color.WHITE);
        btnMover.setFocusPainted(false);
        btnMover.setOpaque(true);
        btnMover.setBorderPainted(false);
        btnMover.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(txtIdMover.getText().trim());
                    int cant = (Integer) spnCantMover.getValue();
                    String origen = (String) comboOrigen.getSelectedItem();
                    cafe.moverJuegoEntreInventarios(id, cant, origen);
                    JOptionPane.showMessageDialog(InventarioPanel.this, "Juegos movidos.");
                    cargarTabla();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(InventarioPanel.this, ex.getMessage(), "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        fila2.add(btnMover);

        JPanel fila3 = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 3));
        fila3.setOpaque(false);
        fila3.add(new JLabel("ID Copia:"));

        JTextField txtIdCopia = new JTextField(5);
        fila3.add(txtIdCopia);

        JButton btnMarcar = new JButton("Marcar Desaparecida");
        btnMarcar.setBackground(new Color(200, 60, 60));
        btnMarcar.setForeground(Color.WHITE);
        btnMarcar.setFocusPainted(false);
        btnMarcar.setOpaque(true);
        btnMarcar.setBorderPainted(false);
        btnMarcar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(txtIdCopia.getText().trim());
                    cafe.marcarCopiaDesaparecida(id);
                    JOptionPane.showMessageDialog(InventarioPanel.this, "Copia marcada como desaparecida.");
                    cargarTabla();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(InventarioPanel.this, ex.getMessage(), "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        fila3.add(btnMarcar);

        JPanel acciones = new JPanel();
        acciones.setLayout(new BoxLayout(acciones, BoxLayout.Y_AXIS));
        acciones.setOpaque(false);
        acciones.add(fila1);
        acciones.add(fila2);
        acciones.add(fila3);

        add(top, BorderLayout.NORTH);
        add(new JScrollPane(tabla), BorderLayout.CENTER);
        add(acciones, BorderLayout.SOUTH);

        addComponentListener(new ComponentAdapter() {
            public void componentShown(ComponentEvent e) {
                cargarTabla();
            }
        });
    }

    private void cargarTabla() {
        tableModel.setRowCount(0);
        try {
            Map<JuegosDeMesa, List<CopiaJuego>> inventario = cafe.verInventarioCompleto();
            for (Map.Entry<JuegosDeMesa, List<CopiaJuego>> entry : inventario.entrySet()) {
                JuegosDeMesa juego = entry.getKey();
                List<CopiaJuego> copias = entry.getValue();
                if (copias.isEmpty()) {
                    tableModel.addRow(new Object[] { juego.getIdJuego(), juego.getNombre(), "—", "Sin copias", "—" });
                } else {
                    for (CopiaJuego c : copias) {
                        String disponible;
                        if (c.isDisponible()) {
                            disponible = "Sí";
                        } else {
                            disponible = "No";
                        }
                        tableModel.addRow(new Object[] {
                                juego.getIdJuego(), juego.getNombre(), c.getIdCopia(),
                                c.getEstadoJuego(), disponible
                        });
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
