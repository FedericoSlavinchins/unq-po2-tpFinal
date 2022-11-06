package ar.edu.unq.po2.SistemaUsuario;

import java.util.ArrayList;
import java.util.List;
import ar.edu.unq.po2.Desafios.DesafioDeUsuario;

public class RecomendadorDeLudificacion {
	
	private List<DesafioDeUsuario> desafiosCompletadosDelUsuario;
	private PreferenciaUsuario preferenciasDelUsuario;
	
	private EstrategiaDeRecomendacion estrategia;
	
	public RecomendadorDeLudificacion(List<DesafioDeUsuario> desafiosCompletados, PreferenciaUsuario preferencias) {
		this.desafiosCompletadosDelUsuario = desafiosCompletados;
		this.preferenciasDelUsuario = preferencias;
		//El recomendador basico es por preferencias
		this.cambiarEstrategiaDeRecomendacion(new RecomendacionPorPreferencias());
	}

	public void cambiarEstrategiaDeRecomendacion(EstrategiaDeRecomendacion estrategia) {
		this.estrategia = estrategia;
	}

	public EstrategiaDeRecomendacion getEstrategia() {
		return estrategia;
	}
	
	public ArrayList<DesafioDeUsuario> recomendarDesafios() {
		return this.estrategia.recomendar(desafiosCompletadosDelUsuario, preferenciasDelUsuario);
	}
}
