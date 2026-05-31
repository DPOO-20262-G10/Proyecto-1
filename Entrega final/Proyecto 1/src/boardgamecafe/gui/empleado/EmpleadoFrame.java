package boardgamecafe.gui.empleado;

import java.awt.*;
import javax.swing.*;

import boardgamecafe.BoardCafe;
import boardgamecafe.usuarios.Mesero;
import boardgamecafe.usuarios.Usuario;

public class EmpleadoFrame extends JPanel {


    private BoardCafe mundo;

    private CardLayout layout;
    private JPanel contenido;

    private JButton btnInicio;
    private JButton btnTurno;
    private JButton btnPedidos;
    private JButton btnPrestamos;
    private JButton btnSugerencias;
    private JButton btnJuegos;
    private JButton btnSalir;

    private EmpleadoInicioPanel panelInicio;
    private MiTurnoPanel panelTurno;
    private PedidosMesaPanel panelPedidos;
    private PrestamosEmpleadoPanel panelPrestamos;
    private SugerenciasPanel panelSugerencias;
    private JuegosDificilesPanel panelJuegos;

    public EmpleadoFrame(BoardCafe mundo) {
        this.mundo = mundo;

        setLayout(new BorderLayout());

        add(crearMenu(), BorderLayout.WEST);
        add(crearContenido(), BorderLayout.CENTER);
    }


    private JPanel crearMenu() {

        JPanel menu = new JPanel();
        menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));
        menu.setPreferredSize(new Dimension(180, 0));

        menu.add(crearBoton("Inicio", "INICIO"));
        menu.add(crearBoton("Mi turno", "TURNO"));
        menu.add(crearBoton("Pedidos", "PEDIDOS"));
        menu.add(crearBoton("Préstamos", "PRESTAMOS"));
        menu.add(crearBoton("Sugerencias", "SUGERENCIAS"));
        menu.add(crearBoton("Juegos difíciles", "JUEGOS"));

        menu.add(Box.createVerticalGlue());

        btnSalir = new JButton("Salir");
        btnSalir.addActionListener(e -> logout());
        menu.add(btnSalir);

        return menu;
    }

    private JButton crearBoton(String texto, String vista) {

        JButton b = new JButton(texto);

        b.setMaximumSize(new Dimension(180, 40));

        b.addActionListener(e -> navegar(vista));

        return b;
    }


    private JPanel crearContenido() {

        layout = new CardLayout();
        contenido = new JPanel(layout);

        panelInicio = new EmpleadoInicioPanel(mundo);
        panelTurno = new MiTurnoPanel(mundo);
        panelPedidos = new PedidosMesaPanel(mundo);
        panelPrestamos = new PrestamosEmpleadoPanel(mundo);
        panelSugerencias = new SugerenciasPanel(mundo);
        panelJuegos = new JuegosDificilesPanel(mundo);

        contenido.add(panelInicio, "INICIO");
        contenido.add(panelTurno, "TURNO");
        contenido.add(panelPedidos, "PEDIDOS");
        contenido.add(panelPrestamos, "PRESTAMOS");
        contenido.add(panelSugerencias, "SUGERENCIAS");
        contenido.add(panelJuegos, "JUEGOS");

        layout.show(contenido, "INICIO");

        return contenido;
    }


    private void navegar(String vista) {

        if (vista.equals("INICIO")) panelInicio.refrescar();
        if (vista.equals("TURNO")) panelTurno.refrescar();
        if (vista.equals("PEDIDOS")) panelPedidos.refrescar();
        if (vista.equals("PRESTAMOS")) panelPrestamos.refrescar();
        if (vista.equals("SUGERENCIAS")) panelSugerencias.refrescar();
        if (vista.equals("JUEGOS")) panelJuegos.refrescar();

        layout.show(contenido, vista);
    }

    private void logout() {
        mundo.logout();
        JOptionPane.showMessageDialog(this, "Sesión cerrada");
    }


    public void inicializar() {

        Usuario u = mundo.getUsuarioActivo();

        boolean esMesero = (u instanceof Mesero);

        btnJuegos.setVisible(esMesero);

        navegar("INICIO");
    }
}
