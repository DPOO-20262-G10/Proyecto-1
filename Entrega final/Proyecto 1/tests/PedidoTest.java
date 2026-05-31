package boardgamecafe.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import boardgamecafe.pedidos.Pedido;
import boardgamecafe.menu.Producto;
import boardgamecafe.menu.Bebida;
import java.util.Date;

public class PedidoTest {
	
	private Pedido pedido;
	
	@BeforeEach
	void setUp() throws Exception {
		pedido = new Pedido(1, new Date(), 0, 0, "user");
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testPedidoInicialVacio() {
		assertTrue(pedido.getProductos().isEmpty(), "El pedido deberia iniciar sin productos");
	}
	
	@Test
	void testAgregarProducto() {
		Producto p = new Bebida(1, "Cafe", 5000, false, true);
		pedido.agregarProducto(p);
		
		assertEquals(1, pedido.getProductos().size(), "La lista deberia tener un producto");
	}
	
	@Test
	void testCalcularSubtotal() {
		Producto p = new Bebida(1, "Cafe", 5000, false, true);
		Producto p2 = new Bebida(2, "Coca cola", 5000, false, false);
		pedido.agregarProducto(p);
		pedido.agregarProducto(p2);
		
		assertEquals(10000, pedido.calcularSubtotal(), "El subtotal del pedido no es correcto");
		
	}
	
	@Test
	void testCalcularImpuesto() {
		Producto p = new Bebida(1, "Cafe", 5000, false, true);
		Producto p2 = new Bebida(2, "Coca cola", 5000, false, false);
		pedido.agregarProducto(p);
		pedido.agregarProducto(p2);
		
		assertEquals(800, pedido.calcularImpuestoConsumo(), "El impuesto no es correcto");
	}
	
	@Test
	void testCalcularTotalSinDescuento() {
		pedido.setPropina(2000);
		
		Producto p = new Bebida(1, "Cafe", 5000, false, true);
		Producto p2 = new Bebida(2, "Coca cola", 5000, false, false);
		pedido.agregarProducto(p);
		pedido.agregarProducto(p2);
		
		assertEquals(12800, pedido.calcularTotal(), "El total del pedido no es correcto");
	}
}	
