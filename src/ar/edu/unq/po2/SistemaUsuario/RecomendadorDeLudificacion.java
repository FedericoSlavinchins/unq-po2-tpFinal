package ar.edu.unq.po2.SistemaUsuario;

import java.util.List;
import ar.edu.unq.po2.Desafios.DesafioDeUsuario;

public class RecomendadorDeLudificacion {
	
	private List<DesafioDeUsuario> desafiosCompletadosDelUsuario;
	private RecomendadorDeDesafios recomendador;
	
	public RecomendadorDeLudificacion(List<DesafioDeUsuario> desafiosCompletados) {
		this.desafiosCompletadosDelUsuario = desafiosCompletados;
		//El recomendador basico es por preferencias
		this.setRecomendador(new RecomendacionPorPreferencias());
	}

	public RecomendadorDeDesafios getRecomendador() {
		return recomendador;
	}

	public void setRecomendador(RecomendadorDeDesafios recomendador) {
		this.recomendador = recomendador;
	}
	
	public List<DesafioDeUsuario> RecomendarDesafios(){
		
		return this.recomendador.DesafiosRecomendados();
	}
}
