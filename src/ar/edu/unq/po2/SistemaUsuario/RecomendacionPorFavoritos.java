package ar.edu.unq.po2.SistemaUsuario;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import ar.edu.unq.po2.Desafios.Desafio;
import ar.edu.unq.po2.Desafios.DesafioDeUsuario;

public class RecomendacionPorFavoritos extends EstrategiaDeRecomendacion {

	private Desafio desafioFavorito;

	@Override
	public List<Desafio> recomendar(List<DesafioDeUsuario> desafiosAceptados, PreferenciaUsuario preferencias,
			List<Desafio> desafiosDeProyectos) {
		
		this.setPreferencias(preferencias);
		this.setDesafiosYaAceptados(desafiosAceptados);
		this.setDesafiosPosibles(desafiosDeProyectos);
		
		List<Desafio> desafiosARecomendar = this.primeros20DesafiosDeLaLista(this.desafiosOrdenadosPorCoincidencia());
		List<Desafio> primeros5DesafiosFavoritos = this.primeros5DesafiosDeLaLista(desafiosARecomendar);
		
		
		return primeros5DesafiosFavoritos;
	}
	
	
	private List<Desafio> primeros20DesafiosDeLaLista(List<Desafio> desafiosOrdenadosPorCoincidencia) {
		
		
		List<Desafio> desafiosOrdenadosPorFavorito = 
								this.desafiosOrdenadosPorCoincidenciaConFavorito(desafiosOrdenadosPorCoincidencia);
		List<Desafio> primeros20DesafiosOrdenadosPorFavorito = 
								desafiosOrdenadosPorCoincidencia.stream().limit(20).toList();
		
		
		return primeros20DesafiosOrdenadosPorFavorito;
	}
	
	
	
	private double calcularMedidaDeSimilitud(Desafio desafioA, Desafio desafioB) {
		double resMuestras = 
				diferenciaEntreCantObjetivoDeMuestras(desafioA, desafioB);
		double resDificultad = 
				diferenciaEntreDificultad(desafioA, desafioB);
		double resRecompensa = 
				diferenciaEntreRecompensa(desafioA, desafioB);
		
		double suma = Math.abs(resMuestras) + Math.abs(resDificultad) + Math.abs(resRecompensa);
		
		return (suma/3);
	}
	
	private List<Desafio> desafiosOrdenadosPorCoincidenciaConFavorito(List<Desafio> desafios) {
		List<Desafio> desafiosOrdenados = this.desafiosFiltradosDisponiblesParaRealizar();
		
		
		desafiosOrdenados.sort((d1, d2) -> Double.compare(this.calcularMedidaDeSimilitud(d1, this.desafioFavorito), this.calcularMedidaDeSimilitud(d2, this.desafioFavorito)));
		
		
		return desafiosOrdenados;
	}
	/*
	private List<Desafio> reverse(List<Desafio> desafios) {
	    if(desafios.size() > 1) {                   
	    	Desafio value = desafios.remove(0);
	        reverse(desafios);
	        desafios.add(value);
	    }
	    return desafios;
	}
	*/
	/*
	public List<Desafio> reversa(List<Desafio> desafios) {
	    for(int i = 0, j = desafios.size() - 1; i < j; i++) {
	    	desafios.add(i, desafios.remove(j));
	    }
	    return desafios;
	}*/

	private double diferenciaEntreRecompensa(Desafio desafioA, Desafio desafioB) {
		return desafioA.getRecompensa() - desafioB.getRecompensa();
	}


	private int diferenciaEntreDificultad(Desafio desafioA, Desafio desafioB) {
		return desafioA.getDificultad() - desafioB.getDificultad();
	}


	private int diferenciaEntreCantObjetivoDeMuestras(Desafio desafioA, Desafio desafioB) {
		return desafioA.getCantidadObjetivoDeMuestras() - desafioB.getCantidadObjetivoDeMuestras();
	}
	
	


	@Override
	protected void setDesafioQueMasLeGusto(Desafio desafioQueMasLeGustoAlUsuario) {
		this.setDesafioFavorito(desafioQueMasLeGustoAlUsuario);
	}
	
	public void setDesafioFavorito(Desafio desafio) {
		this.desafioFavorito = desafio;
	}

}
