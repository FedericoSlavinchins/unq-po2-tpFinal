package ar.edu.unq.po2.Proyecto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CategoriaTest {

	Categoria categoria;	
	
	@BeforeEach
	public void setUp() {
		categoria = new Categoria("Categoria");
	}
	
	@Test
	public void nombreCategoriaTest() {
		assertEquals(categoria.getNombre(), "Categoria");
	}
}
