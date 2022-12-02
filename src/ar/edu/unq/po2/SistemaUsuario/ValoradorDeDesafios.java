package ar.edu.unq.po2.SistemaUsuario;

import ar.edu.unq.po2.Desafios.DesafioDeUsuario;
import ar.edu.unq.po2.Desafios.Voto;

public class ValoradorDeDesafios {
	
	public void votar(DesafioDeUsuario desafioDeUsuario,int valorDeVoto) throws Exception {
		desafioDeUsuario.setVoto(new Voto(valorDeVoto));
	}
	
}
