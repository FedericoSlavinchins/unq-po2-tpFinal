package ar.edu.unq.po2.SistemaUsuario;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

import ar.edu.unq.po2.Desafios.Desafio;
import ar.edu.unq.po2.Desafios.DesafioDeUsuario;

public class RecomendacionPorPreferencias implements EstrategiaDeRecomendacion {
	private PreferenciaUsuario preferenciasDelUsuario;
	private List<Desafio> desafiosPosibles;
	private List<Desafio> desafiosYaAceptados;

	
	@Override
	public List<DesafioDeUsuario> recomendar(List<Desafio> desafiosAceptados, PreferenciaUsuario preferencias, List<Desafio> desafiosPosibles) {
		this.setPreferencias(preferencias);
		this.setDesafiosYaAceptados(desafiosAceptados);
		this.setDesafiosPosibles(desafiosPosibles);
		return null; //this.filtrarDesafios();
	}
	
	

	//Metodos que setean los atributos de la clase
	
	public void setPreferencias(PreferenciaUsuario preferencias) {
		this.preferenciasDelUsuario = preferencias;
	}

	public void setDesafiosYaAceptados(List<Desafio> desafiosYaAceptados) {
		this.desafiosYaAceptados = desafiosYaAceptados;
	}
	
	public void setDesafiosPosibles(List<Desafio> desafios) {
		this.desafiosPosibles = desafios;
	}


	
	
	//Calcula el nivel de coincidencia con las preferencias del usuario haciendo una suma del valor absoluto de las diferencias
	public double calcularCoincidencia(Desafio desafio) {
		int resMuestras = 
				this.valorAbsoluto(this.preferenciasDelUsuario.getCantidadDeMuestrasARecolectar()
						- desafio.getCantidadObjetivoDeMuestras()); //Calcula el valor absoluto de la diferencia de muestras
		int resDificultad = 
				this.valorAbsoluto(this.preferenciasDelUsuario.getDificultadPreferida() 
						- desafio.getDificultad()); //Calcula el valor absoluto de la diferencia de dificultades.
		double resRecompensas =
				this.valorAbsolutoDouble(this.preferenciasDelUsuario.getRecompensaPreferida() 
						- desafio.getRecompensa()); //Calcula el valor absoluto de la diferencia de recompensas.
		return (resMuestras + resDificultad + resRecompensas);
	}

	private int valorAbsoluto(int numero) { 
		return numero > 0 ? numero : -numero; 
	}
	
	private double valorAbsolutoDouble (double numero) { 
		return numero > 0 ? numero : -numero; 
	}
	
	
	
	//Metodo que filtra desafios 
	private List<Desafio> filtrarDesafios() {
		List<Desafio> desafiosNoValidos = this.desafiosYaAceptados.stream().map(d -> d.getDesafio()).toList();
		List<Desafio> desafiosValidos = new ArrayList<Desafio>();
		for (Desafio desafio : desafiosPosibles) {
			if(!(desafiosNoValidos.contains(desafio))) {
				desafiosValidos.add(desafio);
			}
		}
		return desafiosValidos;
	}

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
		return this.desafiosRecomendados = resultado;
	}*/
	/*
	private Desafio filtrarMasCoincidente(Desafio desafio1, Desafio desafio2) {
		Desafio resultado = 
				this.calcularCoincidencia(desafio1) > this.calcularCoincidencia(desafio2) ? desafio2 : desafio1;
		return resultado;
	}*/
}
