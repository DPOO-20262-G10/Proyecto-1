package boardgamecafe.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import boardgamecafe.usuarios.Usuario;
import boardgamecafe.usuarios.Cliente;

public class UsuarioTest {

	private Usuario usuario;
	@BeforeEach
	void setUp() throws Exception {
		usuario = new Cliente(1, "usuario", "1234", "Nicolas");
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test 
	void testGetLogin() {
		assertEquals("usuario", usuario.getLogin(), "El id del usuario no es correcto");
	}
	
	@Test
	void testGetPassword() {
		assertEquals("1234", usuario.getPassword(), "La contraseña del usuario no es correcta");
	}
	
	@Test
	void testGetNombre() {
		assertEquals("Nicolas", usuario.getNombre(), "El nombre del usuario no es correcto");
	}
	
	@Test
	void testGetPuntosFidelidad() {
		assertEquals(0, usuario.getPuntosFidelidad(), "Los puntos de fidelidad del usuario deberian iniciar en 0");
	}
	
	@Test 
	void testSetLogin() {
		usuario.setLogin("usuario1");
		assertEquals("usuario1", usuario.getLogin(), "El id del usuario no es correcto");
	}
	
	@Test
	void testSetPassword() {
		usuario.setPassword("123");
		assertEquals("123", usuario.getPassword(), "La contraseña del usuario no es correcta");
	}
	
	@Test
	void testSetNombre() {
		usuario.setNombre("Nico");
		assertEquals("Nico", usuario.getNombre(), "El nombre del usuario no es correcto");
	}
	
	@Test
	void testSetPuntosFidelidad() {
		usuario.setPuntosFidelidad(10);
		assertEquals(10, usuario.getPuntosFidelidad(), "Los puntos de fidelidad del usuario deberian iniciar en 0");
	}
	
	@Test
	void testIniciarSesionCorrecto() {
		assertTrue(usuario.iniciarSesion("usuario", "1234"), "El login deberia ser valido");
	}
	
	@Test
	void  testIniciarSesionIncorrecto() {
		assertFalse(usuario.iniciarSesion("usuario", "123"), "El login no deberia ser valido");
	}
	
	@Test
	void testFavoritosVacia() {
		assertTrue(usuario.getFavoritos().isEmpty(), "La lista de favorits deberia estar vacia");
	}
	
	@Test
	void testAgregarFavoritos() {
		usuario.agregarFavorito(1);
		
		assertEquals(1, usuario.getFavoritos().size(), "No se agrego correctamente el juego");
	}
	
	@Test
	void testEvitarDuplicados() {
		usuario.agregarFavorito(1);
		usuario.agregarFavorito(1);
		
		assertEquals(1, usuario.getFavoritos().size(), "No deberia haber duplicados");
	}
	
	@Test
	void testEliminarFavorito() {
		usuario.agregarFavorito(1);
		usuario.eliminarFavorito(1);
		
		assertTrue(usuario.getFavoritos().isEmpty(), "La lista de favorits deberia estar vacia");
	}
}

