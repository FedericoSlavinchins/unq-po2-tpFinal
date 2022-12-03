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
import ar.edu.unq.po2.Desafios.RestriccionDeEntreFechas;
import ar.edu.unq.po2.Desafios.RestriccionTemporal;
import ar.edu.unq.po2.Desafios.Voto;
import ar.edu.unq.po2.Proyecto.AreaGeografica;

class ValoradorDeDesafiosTest {
	
	private ValoradorDeDesafios valoradorDeDesafios;
	private DesafioDeUsuario desafioDeUsuario1;
	private Desafio desafio;
	private Usuario usuario;
	private AreaGeografica area;
	private RestriccionDeEntreFechas restriccion;
	
	@BeforeEach
	public void setUp() {
		
		//desafio = mock(Desafio.class);
		area = mock(AreaGeografica.class);
		restriccion = mock(RestriccionDeEntreFechas.class);
		
		usuario = mock(Usuario.class);
		desafio = new Desafio(area, 3, 3, restriccion, 500.2);
		desafioDeUsuario1 = new DesafioDeUsuario(desafio, usuario);
		valoradorDeDesafios = new ValoradorDeDesafios();
		
	}

	@Test
	void testVotarDesafioDeUsuario() throws Exception {
		int valorDeVoto = 5;
		when(desafio.getRecompensa()).thenReturn(500.2);
		valoradorDeDesafios.votar(desafioDeUsuario1, valorDeVoto);
		//when(desafioDeUsuario1.getVoto()).thenReturn(voto);
		//when(desafioDeUsuario1.getVoto().getValorVoto()).thenReturn(valorDeVoto);
		verify(desafioDeUsuario1, times(1)).setVoto(new Voto(valorDeVoto));
		
	}

}
