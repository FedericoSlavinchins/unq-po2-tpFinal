package ar.edu.unq.po2.SistemaUsuario;

import java.util.List;

import ar.edu.unq.po2.Desafios.Desafio;
import ar.edu.unq.po2.Desafios.DesafioDeUsuario;

public class RecomendacionPorFavoritos implements RecomendacionStrategy {
	private Preferencias preferenciasDelUsuario;
	private List<DesafioDeUsuario> desafiosCompletadosDeUsuario;


	@Override
	public int calcularCoincidencia(Desafio desafio) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Desafio> DesafiosRecomendados(List<Desafio> recomendados) {
		// TODO Auto-generated method stub
		return null;
	}

}
