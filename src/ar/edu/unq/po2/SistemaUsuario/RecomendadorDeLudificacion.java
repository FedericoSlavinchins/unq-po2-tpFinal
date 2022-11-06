package ar.edu.unq.po2.SistemaUsuario;

import java.util.List;
import ar.edu.unq.po2.Desafios.DesafioDeUsuario;

public class RecomendadorDeLudificacion {
	
	private List<DesafioDeUsuario> desafiosCompletadosDelUsuario;
	private EstrategiaDeRecomendacion estrategia;
	
	public RecomendadorDeLudificacion(List<DesafioDeUsuario> desafiosCompletados) {
		this.desafiosCompletadosDelUsuario = desafiosCompletados;
		//El recomendador basico es por preferencias
		this.cambiarEstrategiaDeRecomendacion(new RecomendacionPorPreferencias());
	}

	public void cambiarEstrategiaDeRecomendacion(EstrategiaDeRecomendacion estrategia) {
		this.estrategia = estrategia;
	}

	public EstrategiaDeRecomendacion getEstrategia() {
		return estrategia;
	}
}
