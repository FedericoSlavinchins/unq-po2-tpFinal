package ar.edu.unq.po2.SistemaUsuario;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.Desafios.Desafio;
import ar.edu.unq.po2.Desafios.DesafioDeUsuario;

public class RecomendacionPorFavoritos implements EstrategiaDeRecomendacion {
	private PreferenciaUsuario preferenciaDelUsuario;
	private List<DesafioDeUsuario> desafiosCompletadosDeUsuario;

	
	@Override
	public ArrayList<DesafioDeUsuario> recomendar(List<DesafioDeUsuario> desafiosCompletados, PreferenciaUsuario preferencias) {
		
		return null;
	}
	
	public double calcularCoincidencia(Desafio desafio) {
		// TODO Auto-generated method stub
		return 0;
	}
/*
	@Override
	public List<DesafioDeUsuario> DesafiosRecomendados() {
		// TODO Auto-generated method stub
		return null;
	}
*/

}
