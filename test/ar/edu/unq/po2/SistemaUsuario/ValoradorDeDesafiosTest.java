package ar.edu.unq.po2.SistemaUsuario;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.Desafios.DesafioDeUsuario;
import ar.edu.unq.po2.Desafios.Voto;

class ValoradorDeDesafiosTest {
	
	private ValoradorDeDesafios valoradorDeDesafios;
	private DesafioDeUsuario desafioDeUsuario1;
	private Voto voto;
	
	@BeforeEach
	public void setUp() {
		valoradorDeDesafios = new ValoradorDeDesafios();
		desafioDeUsuario1 = mock(DesafioDeUsuario.class);
		voto = mock(Voto.class);
	}

	@Test
	void testVotarDesafioDeUsuario() throws Exception {
		int valorDeVoto = 5;
		//when(desafioDeUsuario1.getVoto()).thenReturn(voto);
		valoradorDeDesafios.votar(desafioDeUsuario1, valorDeVoto);
		
		
		assertEquals(valorDeVoto, desafioDeUsuario1.getVoto().getValorVoto());
	}

}
