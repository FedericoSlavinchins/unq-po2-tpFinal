package ar.edu.unq.po2.SistemaUsuario;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

import ar.edu.unq.po2.Desafios.Desafio;
import ar.edu.unq.po2.Desafios.DesafioDeUsuario;

public class RecomendacionPorPreferencias implements EstrategiaDeRecomendacion {
	private PreferenciaUsuario preferenciasDelUsuario;
	private List<Desafio> desafiosRecomendados;
	private List<DesafioDeUsuario> desafiosCompletados;

	
	@Override
	public ArrayList<DesafioDeUsuario> recomendar(List<DesafioDeUsuario> desafiosCompletados, PreferenciaUsuario preferencias, List<Desafio> desafiosDeProyectos) {
		this.setPreferencias(preferencias);
		this.setDesafiosCompletados(desafiosCompletados);
		this.setDesafiosRecomendados(desafiosDeProyectos);
		return null; //this.filtrarDesafios();
	}

	//Metodos que setean los atributos de la clase
	
	public void setPreferencias(PreferenciaUsuario preferencias) {
		this.preferenciasDelUsuario = preferencias;
	}

	public void setDesafiosCompletados(List<DesafioDeUsuario> desafiosCompletados) {
		this.desafiosCompletados = desafiosCompletados;
	}
	
	public void setDesafiosRecomendados(List<Desafio> desafios) {
		this.desafiosRecomendados = desafios;
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
		return resMuestras + resDificultad + resRecompensas;
	}

	private int valorAbsoluto(int numero) { 
		return numero > 0 ? numero : -numero; 
	}
	
	private double valorAbsolutoDouble (double numero) { 
		return numero > 0 ? numero : -numero; 
	}
	

	private ArrayList<DesafioDeUsuario> filtrarDesafios() {
		ArrayList<Desafio> desafiosValidos = new ArrayList<Desafio>();
		for (DesafioDeUsuario desafioDeUsuario : this.desafiosCompletados) {
			if(this.desafiosRecomendados.contains(desafioDeUsuario.getDesafio())) {} 
			else {
				
			}
		}
		return null;
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
