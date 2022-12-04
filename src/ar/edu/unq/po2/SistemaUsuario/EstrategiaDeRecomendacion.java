package ar.edu.unq.po2.SistemaUsuario;

import java.util.List;

import ar.edu.unq.po2.Desafios.Desafio;
import ar.edu.unq.po2.Desafios.DesafioDeUsuario;

public interface EstrategiaDeRecomendacion {
	
	List<DesafioDeUsuario> recomendar(List<Desafio> desafiosDelUsuario, PreferenciaUsuario preferencias, List<Desafio> desafiosDeProyectos);
	double calcularCoincidencia(Desafio desafio);
}
