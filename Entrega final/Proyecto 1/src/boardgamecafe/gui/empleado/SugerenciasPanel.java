package boardgamecafe.gui.empleado;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

import boardgamecafe.BoardCafe;
import boardgamecafe.menu.Producto;

public class SugerenciasPanel extends JPanel {

    private BoardCafe mundo;

    private JTextField txtNombre;
    private JTextField txtPrecio;
    private JTextField txtAlergenos;

    private JComboBox<String> cbTipo;
    private JCheckBox chkAlcoholica;
    private JCheckBox chkCaliente;

    private JLabel lblEstado;

    private JPanel panelProductos;

    public SugerenciasPanel(BoardCafe mundo) {
        this.mundo = mundo;

        setLayout(new BorderLayout());

        JPanel form = new JPanel(new GridLayout(0, 2));

        txtNombre = new JTextField();
        txtPrecio = new JTextField();
        txtAlergenos = new JTextField();

        cbTipo = new JComboBox<>(new String[]{"Bebida", "Pasteleria"});
        chkAlcoholica = new JCheckBox();
        chkCaliente = new JCheckBox();

        JButton btn = new JButton("Enviar");

        lblEstado = new JLabel("");

        form.add(new JLabel("Nombre"));
        form.add(txtNombre);

        form.add(new JLabel("Precio"));
        form.add(txtPrecio);

        form.add(new JLabel("Tipo"));
        form.add(cbTipo);

        form.add(new JLabel("Alcoholica"));
        form.add(chkAlcoholica);

        form.add(new JLabel("Caliente"));
        form.add(chkCaliente);

        form.add(new JLabel("Alergenos"));
        form.add(txtAlergenos);

        form.add(btn);
        form.add(lblEstado);

        panelProductos = new JPanel();
        panelProductos.setLayout(new BoxLayout(panelProductos, BoxLayout.Y_AXIS));

        JSplitPane split = new JSplitPane(
                JSplitPane.HORIZONTAL_SPLIT,
                form,
                panelProductos
        );

        add(split, BorderLayout.CENTER);

        btn.addActionListener(e -> enviar());
    }


    private void enviar() {

        String nombre = txtNombre.getText().trim();
        String precioStr = txtPrecio.getText().trim();

        if (nombre.isEmpty()) {
            lblEstado.setText("Nombre vacío");
            return;
        }

        double precio;

        try {
            precio = Double.parseDouble(precioStr);
        } catch (Exception e) {
            lblEstado.setText("Precio inválido");
            return;
        }

        List<String> alergenos = new ArrayList<>();

        String raw = txtAlergenos.getText().trim();

        if (!raw.isEmpty()) {
            String[] parts = raw.split(",");
            for (int i = 0; i < parts.length; i++) {
                alergenos.add(parts[i].trim());
            }
        }

        try {
            mundo.sugerirProducto(
                    nombre,
                    precio,
                    (String) cbTipo.getSelectedItem(),
                    chkAlcoholica.isSelected(),
                    chkCaliente.isSelected(),
                    alergenos
            );

            lblEstado.setText("Enviado OK");

            limpiar();

            actualizar();

        } catch (Exception e) {
            lblEstado.setText(e.getMessage());
        }
    }

    private void actualizar() {

        panelProductos.removeAll();

        List<Producto> productos = mundo.getProductos();

        if (productos.isEmpty()) {
            panelProductos.add(new JLabel("No hay productos"));
        } else {

            for (int i = 0; i < productos.size(); i++) {

                Producto p = productos.get(i);

                panelProductos.add(new JLabel(
                        p.getIdProducto() + " - " +
                        p.getNombre() + " - " +
                        p.getPrecio()
                ));
            }
        }

        panelProductos.revalidate();
        panelProductos.repaint();
    }

    public void refrescar() {
        actualizar();
    }

    private void limpiar() {

        txtNombre.setText("");
        txtPrecio.setText("");
        txtAlergenos.setText("");

        chkAlcoholica.setSelected(false);
        chkCaliente.setSelected(false);

        cbTipo.setSelectedIndex(0);
    }
}
