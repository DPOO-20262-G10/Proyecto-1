package boardgamecafe.gui.empleado;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

import boardgamecafe.BoardCafe;
import boardgamecafe.Juegos.JuegosDeMesa;
import boardgamecafe.usuarios.Mesero;
import boardgamecafe.usuarios.Usuario;

public class JuegosDificilesPanel extends JPanel {

    private BoardCafe mundo;

    private JTextField txtIds;
    private JLabel lblEstado;

    private JPanel panelLista;
    private JPanel panelCatalogo;

    public JuegosDificilesPanel(BoardCafe mundo) {
        this.mundo = mundo;
        setLayout(new BorderLayout());
        construirUI();
    }

    private void construirUI() {

        JLabel titulo = new JLabel("Juegos difíciles");
        add(titulo, BorderLayout.NORTH);

        JPanel centro = new JPanel(new GridLayout(1, 2));

        centro.add(construirFormulario());
        centro.add(construirCatalogo());

        add(centro, BorderLayout.CENTER);
    }

    private JPanel construirFormulario() {

        JPanel panel = new JPanel(new GridLayout(6, 1));

        panel.add(new JLabel("IDs (ej: 1,2,3)"));

        txtIds = new JTextField();
        panel.add(txtIds);

        JButton btn = new JButton("Registrar");
        panel.add(btn);

        lblEstado = new JLabel("");
        panel.add(lblEstado);

        panelLista = new JPanel(new GridLayout(0, 1));
        panel.add(panelLista);

        btn.addActionListener(e -> registrar());

        return panel;
    }

    private JPanel construirCatalogo() {

        panelCatalogo = new JPanel(new GridLayout(0, 1));

        List<JuegosDeMesa> catalogo = mundo.consultarCatalogo();

        for (JuegosDeMesa j : catalogo) {
            if (j.isEsDificil()) {

                panelCatalogo.add(new JLabel(
                        j.getIdJuego() + " - " + j.getNombre()
                ));
            }
        }

        return panelCatalogo;
    }

    private void registrar() {

        String raw = txtIds.getText().trim();

        if (raw.isEmpty()) {
            lblEstado.setText("Ingrese IDs");
            return;
        }

        List<Integer> ids = new ArrayList<>();

        String[] partes = raw.split(",");

        for (int i = 0; i < partes.length; i++) {
            try {
                ids.add(Integer.parseInt(partes[i].trim()));
            } catch (Exception e) {
                lblEstado.setText("ID inválido: " + partes[i]);
                return;
            }
        }

        mundo.registrarJuegosDificiles(ids);

        lblEstado.setText("Registrado OK");
        txtIds.setText("");

        actualizarLista();
    }

    private void actualizarLista() {

        panelLista.removeAll();

        Usuario u = mundo.getUsuarioActivo();

        if (u instanceof Mesero) {

            Mesero m = (Mesero) u;

            List<Integer> lista = m.getJuegosDificilesConocidos();

            for (int i = 0; i < lista.size(); i++) {

                panelLista.add(new JLabel(
                        "Juego ID: " + lista.get(i)
                ));
            }
        }

        panelLista.revalidate();
        panelLista.repaint();
    }

    public void refrescar() {
        actualizarLista();
    }
}
