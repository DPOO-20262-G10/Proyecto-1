package boardgamecafe.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import boardgamecafe.usuarios.Cocinero;

public class CocineroTest {
	
	private Cocinero cocinero;
	
	@BeforeEach
    void setUp() {
        cocinero = new Cocinero(1, "cocinero", "1234", "Luis");
    }
	
	 @AfterEach
	 void tearDown( ) throws Exception
	 {
	 }
	 
	 @Test
	 void testHeredado() {
		 assertEquals(1, cocinero.getIdEmpleado());
		 assertEquals("cocinero", cocinero.getLogin());
		 assertEquals("1234", cocinero.getPassword());
		 assertEquals("Luis", cocinero.getNombre());
	 }

}
