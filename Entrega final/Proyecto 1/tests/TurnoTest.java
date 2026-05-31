package boardgamecafe.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.sql.Time;

import boardgamecafe.turnos.Turno;

public class TurnoTest {
	
	private Turno turno;

	@BeforeEach
	void setUp() throws Exception {
		Time Inicio = Time.valueOf("12:00:00");
		Time Final = Time.valueOf("18:00:00");
		
		turno = new Turno(1, "martes", Inicio, Final);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetIdTurno() {
		assertEquals(1, turno.getIdTurno(), "El id del turno no es correcto");
	}
	
	@Test
	void testGetDiaSemana() {
		assertEquals("martes", turno.getDiaSemana(), "El dia del turno no es correcto");
	}
	
	@Test
	void testGetHoraInicio() {
		Time fechaInicio = Time.valueOf("12:00:00");
		assertEquals(fechaInicio, turno.getHoraInicio(), "La hora de inicio del turno no es correcta");
	}
	
	@Test
	void testGetHoraFinal() {
		Time fechaFinal = Time.valueOf("18:00:00");
		assertEquals(fechaFinal, turno.getHoraFinal(), "La hora de finalizacion del turno no es correcta");
	}
	
	@Test
	void testSetIdTurno() {
		turno.setIdTurno(2);
		assertEquals(2, turno.getIdTurno(), "El id del turno no es correcto");
	}
	
	@Test
	void testSetDiaSemana() {
		turno.setDiaSemana("domingo");
		assertEquals("domingo", turno.getDiaSemana(), "El dia del turno no es correcto");
	}
	
	@Test
	void testSetHoraInicio() {
		Time nueva = Time.valueOf("10:00:00");
		turno.setHoraInicio(nueva);
		assertEquals(nueva, turno.getHoraInicio(), "La hora de inicio del turno no es correcta");
	}
	
	@Test
	void testSetHoraFinal() {
		Time nueva = Time.valueOf("16:00:00");
		turno.setHoraFinal(nueva);
		assertEquals(nueva, turno.getHoraFinal(), "La hora de finalizacion del turno no es correcta");
	}
	
}
