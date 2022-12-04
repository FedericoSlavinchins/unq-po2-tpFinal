package ar.edu.unq.po2.SistemaUsuario;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.Desafios.Desafio;
import ar.edu.unq.po2.Desafios.DesafioDeUsuario;

public class MenuDeDesafios {
	
	private List<Desafio>				desafiosDisponibles;	// FS: No aceptados.
	private ArrayList<DesafioDeUsuario>	desafiosAceptados 	= new ArrayList<DesafioDeUsuario>();	// FS: Aceptados.
	private ArrayList<DesafioDeUsuario>	desafiosCompletados = new ArrayList<DesafioDeUsuario>();	// FS: Completados.
	
	public void moverDesafioAAceptados(DesafioDeUsuario desafioDeUsuario) {
		if (esDesafioDisponible(desafioDeUsuario)) {
			this.desafiosDisponibles.remove(this.desafiosDisponibles.indexOf(desafioDeUsuario));
			this.desafiosAceptados.add(desafioDeUsuario);
		}
	}

	
	
	public void moverDesafioACompletados(DesafioDeUsuario desafioDeUsuario) {
		if (esDesafioAceptado(desafioDeUsuario)) {
			this.desafiosAceptados.remove(this.desafiosAceptados.indexOf(desafioDeUsuario));
			this.desafiosCompletados.add(desafioDeUsuario);
		}
	}

	private boolean esDesafioAceptado(DesafioDeUsuario desafioDeUsuario) {
		return this.desafiosAceptados.contains(desafioDeUsuario);
	}
	
	private boolean esDesafioDisponible(DesafioDeUsuario desafioDeUsuario) {
		return this.desafiosDisponibles.contains(desafioDeUsuario);
	}
	
	

	public ArrayList<DesafioDeUsuario> getDesafiosAceptados() {
		return desafiosAceptados;
	}



	public ArrayList<DesafioDeUsuario> getDesafiosCompletados() {
		return desafiosCompletados;
	}



	public void setDesafiosDisponibles(List<Desafio> desafiosRecomendadosPorEstrategia) {
		this.desafiosDisponibles = desafiosRecomendadosPorEstrategia;
	}

}
