package boardgamecafe.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import boardgamecafe.pedidos.Prestamo;
import boardgamecafe.usuarios.Cliente;
import boardgamecafe.juegos.CopiaJuego;
import java.util.ArrayList;
import java.util.List;


public class PrestamoTest {
	
	private Prestamo prestamo;
	private Cliente cliente;
	private CopiaJuego copia;

	@BeforeEach
	void setUp() throws Exception {
		cliente = new Cliente(1, "Joan", "1234", "Joan");
		prestamo = new Prestamo(1, false, cliente);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAgregarCopia() {
		copia = new CopiaJuego(1, true, "nuevo");
		prestamo.agregarCopia(copia);
		
		assertEquals(1, prestamo.getCopias().size(), "El prestamo deberi tener 1 copia");
	}
	
	@Test
	void testListaCopiasVacia() {
		assertTrue(prestamo.getCopias().isEmpty(), "La lista inicial de copias deberia estar vacia");
	}
	
	@Test
	void testFinalizarPrestamo() {
		prestamo.finalizarPrestamo();
		assertFalse(prestamo.isActivo());
	}
	
	@Test 
	void testGetIdCopia() {
		assertEquals(1, prestamo.getIdPrestamo(), "El id del prestamo no es correcto");
	}
	
	@Test
	void testIsAdvertenciaDificil() {
		assertFalse(prestamo.isAdvertenciaDificil());
	}
}
