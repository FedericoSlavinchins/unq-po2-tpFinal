package ar.edu.unq.po2.SistemaUsuario;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.Desafios.Desafio;
import ar.edu.unq.po2.Desafios.DesafioDeUsuario;

public class RecomendadorDeLudificacion {
	
	private List<DesafioDeUsuario> desafiosDelUsuario;
	private PreferenciaUsuario preferenciasDelUsuario;
	
	private EstrategiaDeRecomendacion estrategia;
	
	public RecomendadorDeLudificacion(List<DesafioDeUsuario> desafios, PreferenciaUsuario preferencias) {
		this.desafiosDelUsuario = desafios;
		this.preferenciasDelUsuario = preferencias;
		//El recomendador basico es por preferencias
		this.cambiarEstrategiaDeRecomendacion(new RecomendacionPorPreferencias());
	}

	public List<DesafioDeUsuario> getDesafiosDelUsuario(){
		return this.desafiosDelUsuario;
	}
	
	public PreferenciaUsuario getPreferencias() {
		return this.preferenciasDelUsuario;
	}
	
	public void cambiarEstrategiaDeRecomendacion(EstrategiaDeRecomendacion estrategia) {
		this.estrategia = estrategia;
	}

	public EstrategiaDeRecomendacion getEstrategia() {
		return estrategia;
	}
	
	public List<DesafioDeUsuario> recomendarDesafios(List<Desafio> desafiosDeProyectos) {
		ArrayList<Desafio> desafiosYaAceptados = desafiosBaseYaAceptadosPorElUsuario();
		// Se le pasa los desafíos "base" (o "receta"), y no DesafioDeUsuario's.
		return this.estrategia.recomendar(desafiosYaAceptados, preferenciasDelUsuario, desafiosDeProyectos);
	}

	private ArrayList<Desafio> desafiosBaseYaAceptadosPorElUsuario() {
		ArrayList<Desafio> desafiosYaAceptados = new ArrayList<Desafio>();
		for (DesafioDeUsuario desafioDeUsuario : this.desafiosDelUsuario) {
			desafiosYaAceptados.add(desafioDeUsuario.getDesafio());
		}
		return desafiosYaAceptados;
	}
}
