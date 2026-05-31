package boardgamecafe.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import boardgamecafe.usuarios.Empleado;

import boardgamecafe.menu.Producto;
import boardgamecafe.menu.Bebida;
import boardgamecafe.menu.Pasteleria;
import java.util.ArrayList;


public class EmpleadoTest {
	
	private Empleado empleado;

	@BeforeEach
	void setUp() throws Exception {
		empleado = new Empleado(1, "empleado", "1234", "Martha");
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetIdEmpleado() {
		assertEquals(1, empleado.getIdEmpleado(), "El Id del empleado no es correcto");
	}
	
	@Test
	void testIsEnTurno() {
		assertFalse(empleado.isEnTurno(), "El empleado no deberia estar en un turno");
	}
	
	@Test
	void testGetCodigoDescuento() {
		assertEquals("EMP1", empleado.getCodigoDescuento(), "El codigo de descuento no es correcto");
	}
	
	@Test
	void testSetIdEmpleado() {
		empleado.setIdEmpleado(15);
		assertEquals(15, empleado.getIdEmpleado(), "El Id del empleado no es correcto");
	}
	
	@Test
	void testSetEnTurno() {
		empleado.setEnTurno(true);
		assertTrue(empleado.isEnTurno(), "El empleado deberia estar en un turno");
	}
	
	@Test
	void testSetCodigoDescuento() {
		empleado.setCodigoDescuento("Martha1234");
		assertEquals("Martha1234", empleado.getCodigoDescuento(), "El codigo de descuento no es correcto");
	}
		
	@Test
	void testSugerirBebida() {
		Producto bebida = empleado.sugerirProducto("Coca cola", 6000, "Bebida", false, false, new ArrayList<>());
		
		assertTrue(bebida instanceof Bebida);
	}
	
	@Test
	void testSugerirPasteleria() {
		Producto pasteleria = empleado.sugerirProducto("Torta", 8000, "Pasteleria", false, false, new ArrayList<>());
		
		assertTrue(pasteleria instanceof Pasteleria);
	}
	
	@Test
	void testListasInicialesVacias() {
		assertTrue(empleado.getJuegos().isEmpty(), "La lista de juegos debería iniciar vacía.");
		assertTrue(empleado.getSolicitudes().isEmpty(), "La lista de solicitudes debería iniciar vacía.");
		assertTrue(empleado.getTurnos().isEmpty(), "La lista de turnos debería iniciar vacía.");
	}
}
