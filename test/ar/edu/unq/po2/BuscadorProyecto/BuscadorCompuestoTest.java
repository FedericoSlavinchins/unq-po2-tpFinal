package ar.edu.unq.po2.BuscadorProyecto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.Proyecto.Proyecto;

class BuscadorCompuestoTest {
	
	private BuscadorCompuesto buscadorCompuesto;
	private BuscadorTitulo buscadorTitulo;
	private IncluidorDeCategorias buscadorIncluidorDeCategorias;
	private List<String> categorias;
	
	@BeforeEach
	public void setUp() {
		categorias = new ArrayList<String>();
		categorias.add("Biología");
		buscadorTitulo = new BuscadorTitulo("Árboles");
		buscadorIncluidorDeCategorias = new IncluidorDeCategorias(categorias);
		buscadorCompuesto = new BuscadorAnd(buscadorTitulo, buscadorIncluidorDeCategorias);
	}

	@Test
	void cuandoSeConstruyeUnBuscadorCompuestoElPrimerBuscadorEsElDeBuscadorTitulo() {
		BuscadorTitulo resultadoEsperado = buscadorTitulo;
		BuscadorTitulo resultado = (BuscadorTitulo) buscadorCompuesto.getPrimerBuscador();
		assertEquals(resultadoEsperado, resultado);
	}
	
	@Test
	void cuandoSeConstruyeUnBuscadorCompuestoElSegundoBuscadorEsElDeBuscadorIncluidorDeCategorias() {
		IncluidorDeCategorias resultadoEsperado = buscadorIncluidorDeCategorias;
		IncluidorDeCategorias resultado = (IncluidorDeCategorias) buscadorCompuesto.getSegundoBuscador();
		assertEquals(resultadoEsperado, resultado);
	}
	
	@Test
	void cuandoSeSeteaUnBuscadorSobreBuscadorCompuestoElSegundoBuscadorEsElBuscadorTitulo() {
		BuscadorTitulo resultadoEsperado = buscadorTitulo;
		buscadorCompuesto.setSegundoBuscador(buscadorTitulo);
		BuscadorTitulo resultado = (BuscadorTitulo) buscadorCompuesto.getSegundoBuscador();
		assertEquals(resultadoEsperado, resultado);
	}

}
