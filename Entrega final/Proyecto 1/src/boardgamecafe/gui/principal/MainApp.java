package boardgamecafe.gui.principal;

import java.awt.*;
import javax.swing.*;
import boardgamecafe.gui.auth.LoginFrame;
import boardgamecafe.gui.cliente.ClienteFrame;
import boardgamecafe.gui.empleado.EmpleadoFrame;
import boardgamecafe.gui.admin.AdminFrame;
import boardgamecafe.BoardCafe;

public class MainApp {
	
	private BoardCafe cafe;
    private JFrame ventana;
    private CardLayout cardLayout;
    private JPanel mainContainer;

    public MainApp() {
    	
    	cafe = new BoardCafe();
        ventana = new JFrame("BoardCafe - Sistema de Gestión");
        ventana.setSize(1024, 680);
        ventana.setMinimumSize(new Dimension(800, 600));
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        mainContainer = new JPanel(cardLayout);

        mainContainer.add(new LoginFrame(cardLayout, mainContainer, cafe), "LOGIN");
        mainContainer.add(new ClienteFrame(cardLayout, mainContainer, cafe), "CLIENTE");
        mainContainer.add(new EmpleadoFrame(cardLayout, mainContainer, cafe), "EMPLEADO");
        mainContainer.add(new AdminFrame(cardLayout, mainContainer, cafe), "ADMIN");

        cardLayout.show(mainContainer, "LOGIN");
        ventana.add(mainContainer);
        ventana.setVisible(true);
    }

    /*
    * Nota: estructura de esta clase fue reorganizada con apoyo de IA
    * para separar la ventana principal del punto de entrada main()
    */
            
           

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception ignored) {
                }
                new MainApp();
            }
        });
    }
}
