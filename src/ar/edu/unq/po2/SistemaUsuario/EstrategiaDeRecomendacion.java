package ar.edu.unq.po2.SistemaUsuario;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.Desafios.Desafio;
import ar.edu.unq.po2.Desafios.DesafioDeUsuario;

public interface EstrategiaDeRecomendacion {
	
	ArrayList<DesafioDeUsuario> recomendar(List<DesafioDeUsuario> desafiosCompletados, PreferenciaUsuario preferencias);
	double calcularCoincidencia(Desafio desafio);
}
