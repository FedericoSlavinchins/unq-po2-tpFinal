package ar.edu.unq.po2.SistemaUsuario;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import ar.edu.unq.po2.Desafios.Desafio;
import ar.edu.unq.po2.Desafios.DesafioDeUsuario;

public abstract class EstrategiaDeRecomendacion {
	
	private PreferenciaUsuario preferenciasDelUsuario;
	private List<Desafio> desafiosPosibles;
	private List<DesafioDeUsuario> desafiosYaAceptados;
	
	
	
	public abstract List<Desafio> recomendar(List<DesafioDeUsuario> desafiosDelUsuario, PreferenciaUsuario preferencias, List<Desafio> desafiosDeProyectos);
	
	
	
	public List<Desafio> desafiosOrdenadosPorCoincidencia() {
		List<Desafio> desafiosOrdenados = this.desafiosPosibles;
		
		desafiosOrdenados.sort((d1,d2) -> Double.compare(this.calcularCoincidencia(d1), this.calcularCoincidencia(d2)));
		return desafiosOrdenados;
	}
	
	
	

	//Calcula el nivel de coincidencia con las preferencias del usuario haciendo una suma del valor absoluto de las diferencias
	public double calcularCoincidencia(Desafio desafio) {
		double resMuestras = 
				this.valorAbsoluto(this.preferenciasDelUsuario.getCantidadDeMuestrasARecolectar()
						- desafio.getCantidadObjetivoDeMuestras()); //Calcula el valor absoluto de la diferencia de muestras
		double resDificultad = 
				this.valorAbsoluto(this.preferenciasDelUsuario.getDificultadPreferida() 
						- desafio.getDificultad()); //Calcula el valor absoluto de la diferencia de dificultades.
		double resRecompensas =
				this.valorAbsoluto(this.preferenciasDelUsuario.getRecompensaPreferida() 
						- desafio.getRecompensa()); //Calcula el valor absoluto de la diferencia de recompensas.
		return (resMuestras + resDificultad + resRecompensas);
	}
	
	private double valorAbsoluto(double numero) { 
		return (Math.abs(numero));
	}
	
	/*
	private double valorAbsoluto(int numero) { 
		return numero > 0 ? numero : -numero; 
	}
	
	
	private double valorAbsolutoDouble (double numero) { 
		return numero > 0 ? numero : -numero; 
	}*/



	public void setPreferenciasDelUsuario(PreferenciaUsuario preferenciasDelUsuario) {
		this.preferenciasDelUsuario = preferenciasDelUsuario;
	}



	public void setDesafiosYaAceptados(ArrayList<DesafioDeUsuario> desafiosYaAceptados) {
		this.desafiosYaAceptados = desafiosYaAceptados;
	}



	public void setDesafiosPosibles(List<Desafio> desafiosPosibles) {
		this.desafiosPosibles = desafiosPosibles;
	}
	
	public List<Desafio> getDesafiosPosibles() {
		return desafiosPosibles;
	}
	
	public void setPreferencias(PreferenciaUsuario preferencias) {
		this.preferenciasDelUsuario = preferencias;
	}
	
}
