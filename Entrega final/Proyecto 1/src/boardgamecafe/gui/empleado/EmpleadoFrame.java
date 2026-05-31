package boardgamecafe.gui.empleado;

import javax.swing.*;
import java.awt.*;

import boardgamecafe.BoardCafe;
import boardgamecafe.usuarios.Mesero;
import boardgamecafe.usuarios.Usuario;

public class EmpleadoFrame extends JPanel {

    private BoardCafe mundo;

    private CardLayout layout;
    private JPanel contenido;

    private EmpleadoInicioPanel panelInicio;
    private MiTurnoPanel panelTurno;
    private PedidosMesaPanel panelPedidos;
    private PrestamosEmpleadoPanel panelPrestamos;
    private SugerenciasPanel panelSugerencias;
    private JuegosDificilesPanel panelJuegos;

    public EmpleadoFrame(BoardCafe mundo) {
        this.mundo = mundo;

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

        setLayout(new BorderLayout());
        add(contenido, BorderLayout.CENTER);

        navegar("INICIO");
    }

    public void navegar(String vista) {

        if (vista.equals("INICIO")) panelInicio.refrescar();
        else if (vista.equals("TURNO")) panelTurno.refrescar();
        else if (vista.equals("PEDIDOS")) panelPedidos.refrescar();
        else if (vista.equals("PRESTAMOS")) panelPrestamos.refrescar();
        else if (vista.equals("SUGERENCIAS")) panelSugerencias.refrescar();
        else if (vista.equals("JUEGOS")) panelJuegos.refrescar();

        layout.show(contenido, vista);
    }

    public void inicializar() {

        Usuario u = mundo.getUsuarioActivo();

        boolean esMesero = (u instanceof Mesero);

        if (!esMesero) {
            layout.show(contenido, "INICIO");
            panelJuegos = null;
        }

        navegar("INICIO");
    }

    public void cerrarSesion() {
        mundo.logout();
    }
}
