package ar.edu.unq.po2.SistemaUsuario;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.Desafios.Desafio;
import ar.edu.unq.po2.Desafios.DesafioDeUsuario;
import ar.edu.unq.po2.Desafios.RestriccionDeEntreFechasSimple;
import ar.edu.unq.po2.Desafios.RestriccionTemporal;
import ar.edu.unq.po2.Desafios.Voto;
import ar.edu.unq.po2.Proyecto.AreaGeografica;

class ValoradorDeDesafiosTest {
	
	private ValoradorDeDesafios valoradorDeDesafios;
	private DesafioDeUsuario desafioDeUsuario;
	private Desafio desafio;
	private Usuario usuario;
	private AreaGeografica area;
	private RestriccionDeEntreFechasSimple restriccion;
	private Voto voto;
	
	@BeforeEach
	public void setUp() {
		
		//desafio = mock(Desafio.class);
		area = mock(AreaGeografica.class);
		restriccion = mock(RestriccionDeEntreFechasSimple.class);
		voto = mock(Voto.class);
		usuario = mock(Usuario.class);
		desafio = new Desafio(area, 3, 3, restriccion, 500.2);
		desafioDeUsuario = mock(DesafioDeUsuario.class);
		valoradorDeDesafios = new ValoradorDeDesafios();
		
	}

	@Test
	void testVotarDesafioDeUsuario() throws Exception {
		int valorDeVoto = 5;
		
		valoradorDeDesafios.votar(desafioDeUsuario, valorDeVoto);
		
		when(desafioDeUsuario.getVoto()).thenReturn(voto);
		when(voto.getValorVoto()).thenReturn(5);
		assertEquals(valorDeVoto, desafioDeUsuario.getVoto().getValorVoto());
		
	}

}
