package boardgamecafe.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import boardgamecafe.juegos.JuegosDeMesa;
import boardgamecafe.juegos.CopiaJuego;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class JuegoDeMesaTest {

	private JuegosDeMesa juego;
	
	@BeforeEach
	void setUp() throws Exception {
		juego = new JuegosDeMesa(1, "uno", Date.valueOf("2023-06-12"), 2, 8, 6, "Cartas", false);
	}
	
	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	void testObtenerCopaiJuego() {
		List<CopiaJuego> copias = new ArrayList<>();
		CopiaJuego copia1 = new CopiaJuego(1, true, "nuevo");
		copias.add(copia1);
		
		juego.setCopias(copias);
		
		assertEquals(copia1, juego.obtenerCopiaDisponible(), "La copia disponible no es la correcta");
	}
	
	@Test
	void testContarCopiasDisponibles() {
		List<CopiaJuego> copias = new ArrayList<>();
		CopiaJuego copia1 = new CopiaJuego(1, true, "nuevo");
		CopiaJuego copia2 = new CopiaJuego(2, true, "nuevo");
		CopiaJuego copia3 = new CopiaJuego(3, true, "nuevo");
		copias.add(copia1);
		copias.add(copia2);
		copias.add(copia3);
		
		juego.setCopias(copias);
		assertEquals(3, juego.contarCopiasDisponibles(), "La cantidad de copias disponibles no es la correcta");
	}
	
	@Test
	void testListaCopiasVacia() {
		assertTrue(juego.getCopias().isEmpty(), "La lista de copias deberia iniciar en 0");
	}
	
	@Test
	void testGetIdJuego() {
		assertEquals(1, juego.getIdJuego());
	}
	
	@Test
	void testGetEdadMinima() {
		assertEquals(6, juego.getEdadMinima());
	}
	
	@Test
	void testSetEsDificil() {
		juego.setEsDificil(true);
		
		assertTrue(juego.isEsDificil());
	}
}
