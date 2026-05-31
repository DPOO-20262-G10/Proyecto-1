package boardgamecafe.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import boardgamecafe.pedidos.Mesa;

public class MesaTest {
	
	private Mesa mesa;

	@BeforeEach
	void setUp() throws Exception {
		mesa = new Mesa(1, 4, false, false);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetIdMesa() {
		assertEquals(1, mesa.getIdMesa());
	}
	
	@Test
	void testGetNumeroPersonas() {
		assertEquals(4, mesa.getNumeroPersonas());
	}
	
	@Test
	void testIsHayNinos() {
		assertFalse(mesa.isHayNinos());
	}
	
	@Test
	void testIsHayJovenes() {
		assertFalse(mesa.isHayJovenes());
	}
	
	@Test
	void testSetIdMesa() {
		mesa.setIdMesa(2);
		assertEquals(2, mesa.getIdMesa());
	}
}
