package boardgamecafe.gui.empleado;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import boardgamecafe.BoardCafe;
import boardgamecafe.usuarios.Empleado;
import boardgamecafe.usuarios.Usuario;


public class CambioTurnoPanel extends JPanel {

    private BoardCafe mundo;

    private JTextField  txtDia;
    private JComboBox<String> cbTipo;
    private JTextField  txtIdIntercambio;
    private JLabel      lblEstado;

    public CambioTurnoPanel(BoardCafe mundo) {
        this.mundo = mundo;
        setLayout(new GridLayout(5, 2));

        add(new JLabel("Dia:"));
        txtDia = new JTextField();
        add(txtDia);

        add(new JLabel("Tipo:"));
        cbTipo = new JComboBox<>(new String[]{"cambio", "intercambio"});
        add(cbTipo);

        add(new JLabel("ID empleado intercambio:"));
        txtIdIntercambio = new JTextField();
        add(txtIdIntercambio);

        JButton btnEnviar = new JButton("Enviar");
        add(btnEnviar);

        lblEstado = new JLabel("");
        add(lblEstado);

        btnEnviar.addActionListener(e -> enviarSolicitud());
    }

    private void enviarSolicitud() {
        String dia  = txtDia.getText().trim();
        String tipo = (String) cbTipo.getSelectedItem();
        String idStr = txtIdIntercambio.getText().trim();

        if (dia.isEmpty()) {
            mostrarError("El día no puede estar vacío.");
            return;
        }

        int idIntercambio;
        try {
            idIntercambio = Integer.parseInt(idStr);
        } catch (NumberFormatException ex) {
            mostrarError("El ID del empleado debe ser un número entero.");
            return;
        }

        try {
            mundo.solicitarCambioTurno(dia, tipo, idIntercambio);
            mostrarExito("Solicitud enviada correctamente. Pendiente de aprobación.");
            limpiarFormulario();
        } catch (IllegalArgumentException ex) {
            mostrarError(ex.getMessage());
        }
    }

    private void limpiarFormulario() {
        txtDia.setText("");
        txtIdIntercambio.setText("");
        cbTipo.setSelectedIndex(0);
    }

    private void mostrarError(String msg) {
        lblEstado.setText(msg);
    }

    private void mostrarExito(String msg) {
        lblEstado.setText(msg);
    }

    public void refrescar() {
        lblEstado.setText("");
    }
    

}
