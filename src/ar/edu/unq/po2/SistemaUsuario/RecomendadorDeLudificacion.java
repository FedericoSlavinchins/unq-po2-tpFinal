package ar.edu.unq.po2.SistemaUsuario;

import java.util.List;
import ar.edu.unq.po2.Desafios.DesafioDeUsuario;

public class RecomendadorDeLudificacion {
	
	private List<DesafioDeUsuario> desafiosCompletadosDelUsuario;
	private EstrategiaDeRecomendacion estrategia;
	
	public RecomendadorDeLudificacion(List<DesafioDeUsuario> desafiosCompletados) {
		this.desafiosCompletadosDelUsuario = desafiosCompletados;
		//El recomendador basico es por preferencias
		this.setRecomendador(new RecomendacionPorPreferencias());
	}

	public EstrategiaDeRecomendacion getRecomendador() {
		return estrategia;
	}

	public void setRecomendador(EstrategiaDeRecomendacion recomendador) {
		this.estrategia = recomendador;
	}
	
	public List<DesafioDeUsuario> RecomendarDesafios(){
		
		return this.estrategia.DesafiosRecomendados();
	}
}
