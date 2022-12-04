package ar.edu.unq.po2.SistemaUsuario;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.Desafios.Desafio;
import ar.edu.unq.po2.Desafios.DesafioDeUsuario;

public class MenuDeDesafios {
	
	private ArrayList<Desafio>			desafiosDisponibles = new ArrayList<Desafio>();	// FS: No aceptados.
	private ArrayList<DesafioDeUsuario>	desafiosAceptados 	= new ArrayList<DesafioDeUsuario>();	// FS: Aceptados.
	private ArrayList<DesafioDeUsuario>	desafiosCompletados = new ArrayList<DesafioDeUsuario>();	// FS: Completados.
	
	
	public void setDesafiosDisponibles(List<Desafio> desafiosRecomendadosPorEstrategia) {
		this.desafiosDisponibles = (ArrayList<Desafio>) desafiosRecomendadosPorEstrategia;
	}
	
	public void moverDesafioAAceptados(DesafioDeUsuario desafioDeUsuario) {
		if (esDesafioDisponible(desafioDeUsuario)) {
			this.desafiosDisponibles.remove(desafioDeUsuario);
			this.desafiosAceptados.add(desafioDeUsuario);
		}
	}
	
	
	
	public void moverDesafioACompletados(DesafioDeUsuario desafioDeUsuario) {
		if (esDesafioAceptado(desafioDeUsuario)) {
			this.desafiosAceptados.remove(desafioDeUsuario);
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
	
	public List<Desafio> getDesafiosDisponibles() {
		return desafiosDisponibles;
	}

	

	public ArrayList<DesafioDeUsuario> getDesafiosCompletados() {
		return desafiosCompletados;
	}



	
	
	public void agregarAAceptados(DesafioDeUsuario desafioDeUsuario) {
		this.desafiosAceptados.add(desafioDeUsuario);
	}
	
	public void removerDeDisponibles(Desafio desafio) {
		this.desafiosDisponibles.remove(desafio);
	}



	public void agregarADisponible(Desafio desafio) {
		this.desafiosDisponibles.add(desafio);
	}


}
