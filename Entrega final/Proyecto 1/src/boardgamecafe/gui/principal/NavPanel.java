package boardgamecafe.gui.principal;

import java.awt.*;
import javax.swing.*;

public class NavPanel {

    private static final Font FUENTE_NEGRITA = new Font("SansSerif", Font.BOLD, 13);

    public JButton crearBoton(String texto, Color colorAccento) {
        JButton btn = new JButton("  " + texto);
        btn.setFont(FUENTE_NEGRITA);
        btn.setForeground(new Color(80, 80, 90));
        btn.setBackground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setOpaque(true);
        btn.setHorizontalAlignment(SwingConstants.LEFT);
        btn.setMaximumSize(new Dimension(200, 40));
        btn.setPreferredSize(new Dimension(200, 40));
        return btn;
    }
}