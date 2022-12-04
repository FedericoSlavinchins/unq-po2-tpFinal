package ar.edu.unq.po2.SistemaUsuario;

import java.util.LinkedHashMap;
import java.util.List;

import ar.edu.unq.po2.Desafios.Desafio;
import ar.edu.unq.po2.Desafios.DesafioDeUsuario;

public abstract class EstrategiaDeRecomendacion {
	
	private PreferenciaUsuario preferenciasDelUsuario;
	private List<Desafio> desafiosPosibles;
	private List<DesafioDeUsuario> desafiosYaAceptados;
	
	
	
	public abstract List<DesafioDeUsuario> recomendar(List<DesafioDeUsuario> desafiosDelUsuario, PreferenciaUsuario preferencias, List<Desafio> desafiosDeProyectos);
	
	
	public LinkedHashMap<Desafio, Integer> desafiosConSusCoincidencias() {
		LinkedHashMap<Desafio, Integer> desafiosConSusCoincidencias = new LinkedHashMap<Desafio, Integer>();
		for (Desafio desafio : this.desafiosPosibles) {
			desafiosConSusCoincidencias.put(desafio, (int) this.calcularCoincidencia(desafio));
		}
		return desafiosConSusCoincidencias;
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
	
	
}
