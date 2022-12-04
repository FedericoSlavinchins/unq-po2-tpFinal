package ar.edu.unq.po2.SistemaUsuario;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

import ar.edu.unq.po2.Desafios.Desafio;
import ar.edu.unq.po2.Desafios.DesafioDeUsuario;

public class RecomendacionPorPreferencias extends EstrategiaDeRecomendacion {
	

	
	@Override
	public List<Desafio> recomendar(List<DesafioDeUsuario> desafiosAceptados, PreferenciaUsuario preferencias, List<Desafio> desafiosPosibles) {
		this.setPreferencias(preferencias);
		this.setDesafiosYaAceptados(desafiosAceptados);
		this.setDesafiosPosibles(desafiosPosibles);
		
		List<Desafio> desafiosRecomendados = primeros5DesafiosDeLaLista(this.desafiosOrdenadosPorCoincidencia());
		
		return desafiosRecomendados;
	}
	
	

	private List<Desafio> primeros5DesafiosDeLaLista(List<Desafio> desafiosOrdenadosPorCoincidencia) {
		return desafiosOrdenadosPorCoincidencia.stream().limit(5).toList();
	}



	
	
	
	
}
