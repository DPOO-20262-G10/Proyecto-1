package boardgamecafe.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import boardgamecafe.turnos.SolicitudCambioTurno;
import boardgamecafe.turnos.Turno;
import boardgamecafe.usuarios.Empleado;

import java.sql.Time;


public class SolicitudCambioTurnoTest {
	
	private SolicitudCambioTurno solicitud;
	
	private Turno turno;
	
	private Empleado emp1;
	
	private Empleado emp2;
	
	@BeforeEach
	void setUp() {
		turno = new	Turno(1, "lunes", Time.valueOf("10:00:00"), Time.valueOf("16:00:00"));
		emp1 = new Empleado(1, "emp1", "1234", "Joan");
		emp2 = new Empleado(2, "emp2", "1234", "Nicolas");
		solicitud = new SolicitudCambioTurno(1, "martes", turno, emp1, emp2);
	}
	
	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	void testEstadoInicial() {
		assertEquals("Pendiente", solicitud.getEstado(), "El estado inicial de la solicitud no es correcto");
	}
	
	@Test
	void testAprobarSolicitud() {
		solicitud.aprobar();
		assertEquals("Aprobada", solicitud.getEstado(), "El estado de la solicitud no es correcto");
	}
	
	@Test
	void testRechazarSolicitud() {
		solicitud.rechazar();
		assertEquals("Rechazada", solicitud.getEstado(), "El estado de la solicitud no es correcto");
	}
	
	@Test
	void testGetCambioDia() {
		assertEquals("martes", solicitud.getCambioDia(), "El cambio de dia no es correcto");
	}
	
	@Test
	void testGetTurnoActual() {
		assertEquals(turno, solicitud.getTurnoActual(), "El turno no es correcto");
	}
	
	@Test
	void testGetEmpleadoSolicitante() {
		assertEquals(emp1, solicitud.getEmpleadoSolicitante(), "El empleado solicitante no es correcto");
	}
	
	@Test
	void testGetEmpleadoIntercambio() {
		assertEquals(emp2, solicitud.getEmpleadoIntercambio(), "El empleado de intercambio no es correcto");
	}
	
	@Test
	void testNoReprocesarSolicitud() {
	    solicitud.aprobar();
	    assertThrows(IllegalStateException.class, () -> solicitud.rechazar());
	}
	
}
