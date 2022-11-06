package ar.edu.unq.po2.Proyecto;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UbicacionTest {
	// SUT
		Ubicacion ubicacion;
		Ubicacion ubicacion2;
		
		@BeforeEach
		public void setUp(){
			ubicacion = new Ubicacion(1, 1);
			ubicacion2 = new Ubicacion (100, 100);
		}

		@Test
		public void latitudTest() {
			//Exercise
			float latObtenida = ubicacion.getLatitud();
			
			//Verify
			assertEquals(1, latObtenida, 0);
		}
		
		@Test
		public void longitudTest() {
			//Exercise
			float longObtenida = ubicacion.getLongitud();
			
			//Verify
			assertEquals(1, longObtenida, 0);
		}
		
		@Test
		public void distanciaTest() {
			//Exercise
			float distanciaObtenida = ubicacion.distancia(ubicacion2);
			
			//Verify
			
			assertEquals(9724, distanciaObtenida, 3);
		}
		
}
