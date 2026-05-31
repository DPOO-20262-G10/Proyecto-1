package boardgamecafe.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import boardgamecafe.usuarios.Cliente;
import boardgamecafe.juegos.JuegosDeMesa;
import java.util.ArrayList;
import java.util.List;

public class ClienteTest {
	
	private Cliente cliente;
	
	
	@BeforeEach
	void setUp() throws Exception {
		cliente = new Cliente(1, "cliente", "1234", "Nicolas");
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetIdCliente() {
		assertEquals(1, cliente.getIdCliente(), "El id del cliente no es correcto.");
	}
	
	@Test
	void testSetIdCliente() {
		cliente.setIdCliente(10);
		assertEquals(10, cliente.getIdCliente(), "El id del cliente no se actualizó correctamente.");
	}
	
	@Test
	void testListaInicialVacia() {
		assertTrue(cliente.getJuegos().isEmpty(), "La lista de juegos debería iniciar vacía.");
	}
	
	@Test
	void testSetJuegos() {
		List<JuegosDeMesa> nuevaLista = new ArrayList<>();
		cliente.setJuegos(nuevaLista);
		
		assertEquals(nuevaLista, cliente.getJuegos(), "La lista de juegos no se asignó correctamente.");
	}

}
