package boardgamecafe.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import boardgamecafe.logica.BoardCafe;
import boardgamecafe.pedidos.Pedido;
import boardgamecafe.turnos.Turno;
import boardgamecafe.ventaJuegos.Compra;

public class BoardCafeTest {
	
	private BoardCafe cafe;
	
	@BeforeEach
	void setUp() throws Exception {
		cafe = new BoardCafe();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

//la parte de inicio del usuario -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	@Test
	void testRegistrarUsuario() {
		cafe.registrarUsuario("Joan", "Joan", "1234", "cliente");	
		assertTrue(cafe.login("Joan", "1234"), "El usuario deberia haberse registrado correctamente");
	}
	
	@Test
	void testLoginCorrecto() {
		cafe.registrarUsuario("Admin", "admin", "1234", "administrador");
		assertTrue(cafe.login("admin", "1234"), "El login deberia ser exitoso");
	}
	
	@Test
	void testLoginIncorrecto() {
		cafe.registrarUsuario("Admin", "admin", "1234", "administrador");
		assertFalse(cafe.login("admin", "123"), "El login no deberia ser exitoso");
	}
	
	@Test
	void testCerrarSesion() {
		cafe.registrarUsuario("Admin", "admin", "1234", "administrador");
		cafe.login("admin", "1234");
		cafe.logout();
		assertNull(cafe.getUsuarioActivo(), "El usuario deberia haber cerrado sesión");
	}
	
	@Test
	void testConsultarCatalogo() {
		cafe.registrarUsuario("Admin", "admin", "1234", "administrador");
		cafe.login("admin", "1234");
		
		cafe.agregarJuego("uno", Date.valueOf("2023-06-12"), 2, 8, 6, "Cartas", false);
		cafe.agregarJuego("monopoly", Date.valueOf("2023-06-12"), 2, 6, 6, "Estrategia", false);
		
		assertEquals(2, cafe.consultarCatalogo().size(), "El catalogo deberia tener 2 juegos");
	}
	
	@Test
	void testBuscarJuego() {
		cafe.registrarUsuario("Admin", "admin", "1234", "administrador");
		cafe.login("admin", "1234");
		
		cafe.agregarJuego("uno", Date.valueOf("2023-06-12"), 2, 8, 6, "Cartas", false);
		assertNotNull(cafe.buscarJuego("uno"), "El juego deberia estar en el catalogo");
	}
	
	@Test
	void testVerAlergenos() {
		cafe.registrarUsuario("Joan", "Joan", "1234", "empleado");	
		cafe.login("Joan", "1234");
		
		List<String> alergenos = new ArrayList<>();
		alergenos.add("Leche");
		
		cafe.sugerirProducto("Torta", 8000, "Pasteleria", false, false, alergenos);
		
		assertEquals(1, cafe.verAlergenoS(1).size(), "Los alergenos no son correctos");
	}
	
	@Test
	void testConsultarHistorialCompras() {
		cafe.registrarUsuario("Admin", "admin", "1234", "administrador");
		cafe.login("admin", "1234");
		
		cafe.agregarJuego("uno", Date.valueOf("2023-06-12"), 2, 8, 6, "Cartas", false);
		cafe.agregarJuegosInventario(1, 1, "venta", "nuevo");
		
		cafe.logout();
		cafe.registrarUsuario("Joan", "Joan", "1234", "cliente");	
		cafe.login("Joan", "1234");
		
		cafe.comprarJuego(1, 1);
		
		assertEquals(1, cafe.consultarHistorialCompras().size(), "El usuario deberia tener una compra registrada");
	}
	
	@Test
	void testConsultarHistorialComprasVacio() {
		cafe.registrarUsuario("Joan", "Joan", "1234", "cliente");	
		cafe.login("Joan", "1234");
		assertTrue(cafe.consultarHistorialCompras().isEmpty(), "El usuario no deberia tener historial de compras");
	}
	
	@Test
	void testConsultarHistorialPedidosVacio() {
		cafe.registrarUsuario("Joan", "Joan", "1234", "cliente");	
		cafe.login("Joan", "1234");
		assertTrue(cafe.consultarHistorialPedidos().isEmpty(), "El usuario no deberia tener historial de pedidos");
	}
	
	@Test
	void testAgregarFavorito() {
		cafe.registrarUsuario("Admin", "admin", "1234", "administrador");
		cafe.login("admin", "1234");
		
		cafe.agregarJuego("uno", Date.valueOf("2023-06-12"), 2, 8, 6, "Cartas", false);
		
		cafe.agregarFavorito(1);
		
		assertEquals(1, cafe.getUsuarioActivo().getFavoritos().size(), "El usuario deberia tener un juego en favoritos");
	}
	
	@Test
	void testEliminarFavorito() {
		cafe.registrarUsuario("Admin", "admin", "1234", "administrador");
		cafe.login("admin", "1234");
		
		cafe.agregarJuego("uno", Date.valueOf("2023-06-12"), 2, 8, 6, "Cartas", false);
		
		cafe.agregarFavorito(1);
	    cafe.eliminarFavorito(1);
	    
	    assertTrue(cafe.getUsuarioActivo().getFavoritos().isEmpty(), "El usuario no deberia tener ningun juego en favoritos");
	}
	
	@Test
	void testConsultarFavoritos() {
		cafe.registrarUsuario("Admin", "admin", "1234", "administrador");
		cafe.login("admin", "1234");
		
		cafe.agregarJuego("uno", Date.valueOf("2023-06-12"), 2, 8, 6, "Cartas", false);
		
		cafe.agregarFavorito(1);
		
		assertEquals(1, cafe.consultarFavoritos().size(), "El usuario deberia tener un juego en favoritos");
	}

	// Empleado con sus metodos -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	@Test
	void testSugerirProducto() {
		cafe.registrarUsuario("Joan", "Joan", "1234", "empleado");	
		cafe.login("Joan", "1234"); 
		
		List<String> alergenos = new ArrayList<>();
		alergenos.add("Leche");
		
		cafe.sugerirProducto("Torta", 8000, "Pasteleria", false, false, alergenos);
		
		assertEquals(1, cafe.verAlergenoS(1).size(), "La solicitud deberia haberse enviado correctamente");
	}
	
	@Test
	void testSugerirProductoNoEmpleado() {
		cafe.registrarUsuario("Joan", "Joan", "1234", "cliente");	
		cafe.login("Joan", "1234");
		
		List<String> alergenos = new ArrayList<>();
		
		assertThrows(IllegalArgumentException.class, ()-> cafe.sugerirProducto("Torta", 8000, "Pasteleria", false, false, alergenos));
	}
	
	// mesero con su unico metodo -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	@Test
	void testRegistrarJuegosDificiles() {
		cafe.registrarUsuario("Joan", "Joan", "1234", "mesero");	
		cafe.login("Joan", "1234"); 
		
		List<Integer> juegos = new ArrayList<>();
		juegos.add(1);
		juegos.add(2);
		
		cafe.registrarJuegosDificiles(juegos);
		
		assertEquals(2, cafe.getUsuarioActivo().getFavoritos());
	}
	
	// adminitrador con sus metodos -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	@Test
	void testAgregarJuego() {
		cafe.registrarUsuario("Admin", "admin", "1234", "administrador");
		cafe.login("admin", "1234");
		
		cafe.agregarJuego("uno", Date.valueOf("2023-06-12"), 2, 8, 6, "Cartas", false);
		
		assertEquals(1, cafe.consultarCatalogo().size(), "El juego deberia agregarse");
		}
	
	@Test
	void testAgregarJuegoNoAdmin() {
		cafe.registrarUsuario("Joan", "Joan", "1234", "cliente");	
		cafe.login("Joan", "1234");
		
		assertThrows(IllegalArgumentException.class, () -> cafe.agregarJuego("uno", Date.valueOf("2023-06-12"), 2, 8, 6, "Cartas", false));
	}
	
	@Test
	void testCrearTurno() {
		cafe.registrarUsuario("Admin", "admin", "1234", "administrador");
		cafe.registrarUsuario("Emp", "emp", "1234", "empleado");
		
		cafe.login("admin", "1234");
		
		cafe.crearTurno(1, "lunes", Time.valueOf("10:00:00"), Time.valueOf("16:00:00"));
		Turno turno = cafe.consultarTurno(1);
		
		assertNotNull(turno, "El turno deberia existir");
	}
	
	@Test
	void testModificarTurno() {
		cafe.registrarUsuario("Admin", "admin", "1234", "administrador");
		cafe.registrarUsuario("Emp", "emp", "1234", "empleado");
		
		cafe.login("admin", "1234");
		cafe.crearTurno(1, "lunes", Time.valueOf("10:00:00"), Time.valueOf("16:00:00"));
		cafe.modificarTurno(1, "martes", Time.valueOf("10:00:00"), Time.valueOf("16:00:00"));
		
		Turno turno = cafe.consultarTurno(1);
		assertEquals("martes", turno.getDiaSemana());
	}
	
	@Test
	void testAprobarSugerencia() {
		cafe.registrarUsuario("Joan", "Joan", "1234", "empleado");	
		cafe.login("Joan", "1234"); 
		
		List<String> alergenos = new ArrayList<>();
		alergenos.add("Leche");		
		cafe.sugerirProducto("Torta", 8000, "Pasteleria", false, false, alergenos);
		
		cafe.registrarUsuario("Admin", "admin", "1234", "administrador");
		cafe.login("admin", "1234");
		
		cafe.aprobarSugerencia(1);
		assertTrue(true);
	}
	
	@Test
	void testMarcarCopiaDesaparecida() {
		cafe.registrarUsuario("Admin", "admin", "1234", "administrador");
		cafe.login("admin", "1234");
		
		cafe.agregarJuego("uno", Date.valueOf("2023-06-12"), 2, 8, 6, "Cartas", false);
		cafe.agregarJuegosInventario(1, 1, "prestamo", "nuevo");
		
		cafe.marcarCopiaDesaparecida(1);
		
		assertTrue(true);
	}
	
	@Test
	
	void testVerInventario() {
		cafe.registrarUsuario("Admin", "admin", "1234", "administrador");
		cafe.login("admin", "1234");
		
		cafe.agregarJuego("uno", Date.valueOf("2023-06-12"), 2, 8, 6, "Cartas", false);
		assertEquals(1, cafe.verInventarioCompleto().size());
	}
	
	@Test
	
	void testGenerarReporteVentas() {
		cafe.registrarUsuario("Admin", "admin", "1234", "administrador");
		cafe.login("admin", "1234");
		
		String reporte = cafe.generarReporteVentas(new Date(), new Date(), "dia", "todos");
		assertEquals("Reporte de Ventas Generado.", reporte);
	}
}
