package boardgamecafe.gui.principal;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class TarjetaJuego extends JPanel {
    private static final Color COLOR_BORDER = new Color(220, 224, 230);
    private static final Color COLOR_TEXT_DARK = new Color(40, 40, 40);
    private static final Font FONT_SUBTITLE = new Font("SansSerif", Font.BOLD, 16);
    private static final Font FONT_BODY = new Font("SansSerif", Font.PLAIN, 13);

    public static JPanel crearCardInfo(String title, String content, Color accentColor) {
        JPanel card = new JPanel(new BorderLayout());
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(COLOR_BORDER, 1),
            new EmptyBorder(15, 15, 15, 15)
        ));

        JLabel lblTitle = new JLabel(title);
        lblTitle.setFont(FONT_SUBTITLE);
        lblTitle.setForeground(accentColor);
        lblTitle.setBorder(new EmptyBorder(0, 0, 10, 0));

        JTextArea txtArea = new JTextArea(content);
        txtArea.setFont(FONT_BODY);
        txtArea.setForeground(COLOR_TEXT_DARK);
        txtArea.setEditable(false);
        txtArea.setBackground(Color.WHITE);
        txtArea.setLineWrap(true);
        txtArea.setWrapStyleWord(true);

        card.add(lblTitle, BorderLayout.NORTH);
        card.add(txtArea, BorderLayout.CENTER);
        return card;
    }
}
