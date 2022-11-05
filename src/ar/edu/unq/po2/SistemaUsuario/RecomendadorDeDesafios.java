package ar.edu.unq.po2.SistemaUsuario;

import java.util.List;
import ar.edu.unq.po2.Desafios.Desafio;
import ar.edu.unq.po2.Desafios.DesafioDeUsuario;

public interface RecomendadorDeDesafios {
	
	double calcularCoincidencia(Desafio desafio);
	List<DesafioDeUsuario> DesafiosRecomendados();
}
