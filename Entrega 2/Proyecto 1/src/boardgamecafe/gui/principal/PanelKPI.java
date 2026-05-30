package boardgamecafe.gui.principal;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class PanelKPI extends JPanel {
    private static final Color COLOR_BORDER = new Color(220, 224, 230);

    public static JPanel crearKPICard(String kpiName, String value, String subtext, Color accentColor) {
        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(COLOR_BORDER, 1),
                new EmptyBorder(15, 15, 15, 15)));

        JLabel lblName = new JLabel(kpiName);
        lblName.setFont(new Font("SansSerif", Font.BOLD, 11));
        lblName.setForeground(Color.GRAY);

        JLabel lblVal = new JLabel(value);
        lblVal.setFont(new Font("SansSerif", Font.BOLD, 22));
        lblVal.setForeground(accentColor);

        JLabel lblSub = new JLabel(subtext);
        lblSub.setFont(new Font("SansSerif", Font.PLAIN, 11));
        lblSub.setForeground(new Color(46, 204, 113));

        card.add(lblName);
        card.add(Box.createRigidArea(new Dimension(0, 5)));
        card.add(lblVal);
        card.add(Box.createRigidArea(new Dimension(0, 5)));
        card.add(lblSub);

        return card;
    }
}
