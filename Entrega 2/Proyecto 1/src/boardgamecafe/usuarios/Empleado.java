package boardgamecafe.usuarios;

import java.util.List;
import java.util.ArrayList;

import boardgamecafe.Turnos.SolicitudCambioTurno;
import boardgamecafe.Turnos.Turno;

public class Empleado extends Usuario{

	private int idEmpleado;
	private boolean enTurno;
    private String codigoDescuento;
    private List<JuegosDeMesa> juegos;
    private List<Turno> turnos;
    private List<SolicitudCambioTurno> solicitudes;
    
    public Empleado(int idEmpleado, String login, String password, String codigoDescuento) {
        super(login, password);
        this.idEmpleado = idEmpleado;
        this.enTurno = false;
        this.codigoDescuento = codigoDescuento;
        this.juegos = new ArrayList<>();
        this.turnos = new ArrayList<>();
        this.solicitudes = new ArrayList<>();
    }
	
    @Override
    public void IniciarSesion(String login, String password) {
    	System.out.println("Inició sesion como Empleado");
    }
    
    @Override
    public void CerrarSesion() {
    	System.out.println("Empleado cierra sesión");
    }
    
    @Override
    public void AgregarFavorito(JuegoDeMesa juego) {
    	juegos.add(juego);
    	System.out.println("Juego agregado a favoritos");
    }
    
    @Override
    public void EliminarFavorito(JuegoDeMesa juego) {
    	juegos.remove(juego);
    	System.out.println("Juego eliminado de favoritos");
    }
    
    
    @Override
    public void ConsultarFavoritos() {
    	System.out.println("Favoritos: " + juegos);
    }
    public void ConsultarTurnoSemanal() {
    	System.out.println("Turnos del empleado:");
    	for (Turno t: turnos)
    	{
    		System.out.println(
    			t.getDiaSemana() + " " +
    			t.getHoraInicio() + " " +
    			t.getHoraFinal()
    			);
    	}
    }
    
    public void Solicitar_cambio_turno(String cambioDia, Turno turno, Empleado empleadoIntercambio) {
    	SolicitudCambioTurno solicitud = new SolicitudCambioTurno(cambioDia, turno, empleadoIntercambio);
    	solicitudes.add(solicitud);
    	System.out.println("Solicitud de cambio de turno enviada");
    	
    }
    
    public void SugerirProducto(String nombre, double precio, String tipo, boolean alcoholica, boolean caliente, List<String> alergenos) {
    	System.out.println("Producto sugerido: " + nombre);
    }
}