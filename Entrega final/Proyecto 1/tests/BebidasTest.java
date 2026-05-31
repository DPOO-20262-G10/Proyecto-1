package boardgamecafe.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import boardgamecafe.menu.Bebida;

public class BebidaTest {
	
	private Bebida bebida;

	@BeforeEach
	void setUp() throws Exception {
		bebida = new Bebida(1, "Coca cola", 5000, false, false);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testIsAlcoholica() {
		assertFalse(bebida.isAlcoholica());
	}
	
	@Test
	void testIsCaliente() {
		assertFalse(bebida.isCaliente());
	}
}
