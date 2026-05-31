package boardgamecafe.gui.admin;

import boardgamecafe.BoardCafe;
import boardgamecafe.turnos.Turno;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TurnosAdminPanel extends JPanel implements ActionListener {
	
	private BoardCafe cafe;
	
	private JTextField idEmpleado;
	
    private JTextField dia;
    
    private JTextField horaInicio;
    
    private JTextField horaFin;
    
    private JTextField idSolicitud;
    
    private JTextArea resultado;

    private JButton btnCrear;
    
    private JButton btnModificar;
    
    private JButton btnConsultar;
    
    private JButton btnAprobar;
    
    private JButton btnRechazar;
    
    public TurnosAdminPanel(BoardCafe cafe) {

        this.cafe = cafe;
        
        setLayout(new BorderLayout());

        JLabel titulo = new JLabel("Gestion de Turnos");
        add(titulo, BorderLayout.NORTH);

        JPanel panelDatos = new JPanel();
        panelDatos.setLayout(new GridLayout(5, 2));

        panelDatos.add(new JLabel("ID Empleado"));
        idEmpleado = new JTextField();
        panelDatos.add(idEmpleado);

        panelDatos.add(new JLabel("Dia"));
        dia = new JTextField();
        panelDatos.add(dia);

        panelDatos.add(new JLabel("Hora Inicio (hh:mm:ss)"));
        horaInicio = new JTextField();
        panelDatos.add(horaInicio);

        panelDatos.add(new JLabel("Hora Fin (hh:mm:ss)"));
        horaFin = new JTextField();
        panelDatos.add(horaFin);

        panelDatos.add(new JLabel("ID Solicitud"));
        idSolicitud = new JTextField();
        panelDatos.add(idSolicitud);

        add(panelDatos, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel();

        btnCrear = new JButton("Crear");
        btnCrear.addActionListener(this);
        panelBotones.add(btnCrear);
        
        btnModificar = new JButton("Modificar");
        btnModificar.addActionListener(this);
        panelBotones.add(btnModificar);
        
        btnConsultar = new JButton("Consultar");
        btnConsultar.addActionListener(this);
        panelBotones.add(btnConsultar);
        
        btnAprobar = new JButton("Aprobar");
        btnAprobar.addActionListener(this);
        panelBotones.add(btnAprobar);
        
        btnRechazar = new JButton("Rechazar");
        btnRechazar.addActionListener(this);
        panelBotones.add(btnRechazar);
        
        add(panelBotones, BorderLayout.SOUTH);

        resultado = new JTextArea();
        resultado.setEditable(false);

        add(resultado, BorderLayout.EAST);
               
    }
    	
}
