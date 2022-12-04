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



	
	
	
	/*
	
<<<<<<< HEAD
	//Metodo que filtra los desafios y retorna aquellos que el usuario no haya tomado
	private List<Desafio> filtrarDesafios() {
=======
	//Metodo que filtra desafios 
	private List<Desafio> desafiosFiltradosDisponiblesParaRealizar() {
>>>>>>> branch 'main-2' of https://github.com/FedericoSlavinchins/unq-po2-tpFinal.git
		List<Desafio> desafiosNoValidos = this.desafiosYaAceptados.stream().map(d -> d.getDesafio()).toList();
		List<Desafio> desafiosValidos = new ArrayList<Desafio>();
		for (Desafio desafio : desafiosPosibles) {
			if(!(desafiosNoValidos.contains(desafio))) {
				desafiosValidos.add(desafio);
			}
		}
		return desafiosValidos;
	}
<<<<<<< HEAD
	
=======
	*/
//>>>>>>> branch 'main-2' of https://github.com/FedericoSlavinchins/unq-po2-tpFinal.git


/*
	@Override
	public List<DesafioDeUsuario> DesafiosRecomendados() {
		List<DesafioDeUsuario> recomendados = new ArrayList<DesafioDeUsuario>();
		DesafioDeUsuario desafioRecomendado;
		for (Desafio desafio : this.desafiosRecomendados) {
			desafioRecomendado = new DesafioDeUsuario(desafio);
			recomendados.add(desafioRecomendado);
		}
		return recomendados;
	}*/
	
	/*private List<Desafio> filtrarCoincidencias(Desafio desafio, double valorCoincidencia) {
		List<Desafio> resultado = this.desafiosRecomendados;
		if (this.calcularCoincidencia(resultado.get(4)) > valorCoincidencia) {
			resultado.remove(4);
			resultado.add(desafio);
			resultado.stream().sorted().toList();
		}
		return resultado;
	}*/
	/*
	private Desafio filtrarMasCoincidente(Desafio desafio1, Desafio desafio2) {
		Desafio resultado = 
				this.calcularCoincidencia(desafio1) > this.calcularCoincidencia(desafio2) ? desafio2 : desafio1;
		return resultado;
	}*/
}
