package ar.edu.unq.po2.SistemaUsuario;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.Desafios.Desafio;
import ar.edu.unq.po2.Desafios.DesafioDeUsuario;

public class RecomendadorDeLudificacion {
	
	private List<DesafioDeUsuario> desafiosDelUsuario;
	private PreferenciaUsuario preferenciasDelUsuario;
	private EstrategiaDeRecomendacion estrategia;
	private MenuDeDesafios menuDeDesafiosDelUsuario;
	
	
	public RecomendadorDeLudificacion(List<DesafioDeUsuario> desafios, PreferenciaUsuario preferencias, MenuDeDesafios menuDeDesafios) {
		this.desafiosDelUsuario = desafios;
		this.preferenciasDelUsuario = preferencias;
		//El recomendador basico es por preferencias
		this.cambiarEstrategiaDeRecomendacion(new RecomendacionPorPreferencias());
		this.menuDeDesafiosDelUsuario = menuDeDesafios;
	}
	
	public void cambiarEstrategiaDeRecomendacion(EstrategiaDeRecomendacion estrategia) {
		this.estrategia = estrategia;
		estrategia.setDesafioQueMasLeGusto(this.filtroDesafioQueMasLeGusto());
	}

	public EstrategiaDeRecomendacion getEstrategia() {
		return estrategia;
	}
	
	public void recomendarDesafios(List<Desafio> desafiosDeProyectos) {
		List<Desafio> desafiosRecomendadosPorEstrategia = 
						this.estrategia.recomendar(desafiosDelUsuario, preferenciasDelUsuario, desafiosDeProyectos);
		this.menuDeDesafiosDelUsuario.setDesafiosDisponibles(desafiosRecomendadosPorEstrategia);
	}
	
	public Desafio filtroDesafioQueMasLeGusto() {
		List<DesafioDeUsuario> desafiosCompletados = menuDeDesafiosDelUsuario.getDesafiosCompletados();
		
		return desafioQueMasLeGusto(desafiosCompletados);
	}

	private Desafio desafioQueMasLeGusto(List<DesafioDeUsuario> desafiosCompletados) {
		DesafioDeUsuario desafioDeUsuarioQueMasLeGusto = desafiosCompletados.get(0);
		
		for (DesafioDeUsuario desafioDeUsuario : desafiosCompletados) {
			if (desafioDeUsuario.getVoto().getValorVoto() > desafioDeUsuarioQueMasLeGusto.getVoto().getValorVoto()) {
				desafioDeUsuarioQueMasLeGusto = desafioDeUsuario;
			}
		}
		return desafioDeUsuarioQueMasLeGusto.getDesafio();
	}
	
}
