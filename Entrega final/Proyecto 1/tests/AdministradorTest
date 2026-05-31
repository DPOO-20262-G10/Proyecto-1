package boardgamecafe.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import boardgamecafe.usuarios.Administrador;

public class AdministradorTest {
	
	private Administrador admin;

	@BeforeEach
	void setUp() throws Exception {
		admin = new Administrador(1, "admin", "1234", "Joan");
	}
	

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetIdAdmin() {
		assertEquals(1, admin.getIdAdmin(),"El id del administrador no es el esperado.");
	}
	
	@Test
	void testSetIdAdmin() {
		admin.setIdAdmin(10);
		assertEquals(10, admin.getIdAdmin(),"El id del administrador no se actualizó correctamente.");
	}

}
