package boardgamecafe.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import boardgamecafe.juegos.CopiaJuego;

public class CopiaJuegoTest {
	
	private CopiaJuego copia;

	@BeforeEach
	void setUp() throws Exception {
		copia = new CopiaJuego(1, true, "nuevo");
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	void testGetCopia() {
		assertEquals(copia, copia.getCopia());
	}
	
	@Test
	void testGetIdCopia() {
		assertEquals(1, copia.getIdCopia());
	}
	
	@Test
	void testSetIsDisponible() {
		copia.setDisponible(false);
		assertFalse(copia.isDisponible());
	}
}
