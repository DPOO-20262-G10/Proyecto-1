package boardgamecafe.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import boardgamecafe.usuarios.Mesero;
import java.util.ArrayList;
import java.util.List;

public class MeseroTest {

	private Mesero mesero;
	
	@BeforeEach
	void setUp() throws Exception {
		mesero = new Mesero(1, "mesero", "1234", "Joan");
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testListaInicialVacia() {
		assertTrue(mesero.getJuegosDificilesConocidos().isEmpty(), "La lista de juegos dificiles debería iniciar vacia");
	}
	
	@Test
	void testRegistrarJuegosDificiles() {
		List<Integer> juegos = new ArrayList<>();
		juegos.add(1);
		juegos.add(2);
		juegos.add(3);
		
		mesero.registrarJuegosDificiles(juegos);
		
		assertEquals(3, mesero.getJuegosDificilesConocidos().size(), "No se registraron correctamente los juegos dificiles");
	}
	
	@Test
	void testEvitarDuplicados() {
		List<Integer> juegos = new ArrayList<>();
		juegos.add(1);
		juegos.add(2);
		
		mesero.registrarJuegosDificiles(juegos);
		mesero.registrarJuegosDificiles(juegos);
		
		assertEquals(2, mesero.getJuegosDificilesConocidos().size(), "No deberia haber duplicados");
	}
	
	@Test
	void testConoceJuego() {
		List<Integer> juegos = new ArrayList<>();
		juegos.add(5);
		
		mesero.registrarJuegosDificiles(juegos);
		assertTrue(mesero.conoceJuego(5), "El mesero deberia conocer este juego");
	}
	
	@Test 
	void testNoConoceJuego() {
		assertFalse(mesero.conoceJuego(5), "El mesero no deberia conocer este juego");
	}
	
	@Test
	void testSetJuegosDificilesConocidos() {
		List<Integer> juegos = new ArrayList<>();
		juegos.add(15);
		
		mesero.setJuegosDificilesConocidos(juegos);
		assertEquals(1, mesero.getJuegosDificilesConocidos().size(), "No se cambio correctamente la lista de juegos conocidos");
	}
}
