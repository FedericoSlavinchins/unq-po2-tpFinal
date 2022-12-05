package ar.edu.unq.po2.Desafios;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class VotoTest {
	Voto voto;
	
	@BeforeEach
	public void setUp() throws Exception {
		voto = new Voto(3);
	}
	
	@Test
	public void votarTest() throws Exception {
		voto.colocarVoto(4);
		
		assertEquals(4, voto.getValorVoto());
		
		String mensajeDeExceptionEsperado = "El voto debe ser entre 0 y 5";
		
		Exception exception = assertThrows(Exception.class,
	            () -> {this.voto.colocarVoto(9);} );
		
		assertEquals(mensajeDeExceptionEsperado, exception.getMessage());
	}
}
