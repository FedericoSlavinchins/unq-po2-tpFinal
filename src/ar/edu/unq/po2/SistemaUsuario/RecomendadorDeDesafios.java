package ar.edu.unq.po2.SistemaUsuario;

import java.util.List;
import ar.edu.unq.po2.Desafios.Desafio;

public interface RecomendadorDeDesafios {
	
	int calcularCoincidencia(Desafio desafio);
	List<Desafio> DesafiosRecomendados(List<Desafio> recomendados);
}
