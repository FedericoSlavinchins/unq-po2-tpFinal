package ar.edu.unq.po2.SistemaUsuario;

import java.util.ArrayList;

import ar.edu.unq.po2.Desafios.DesafioDeUsuario;

public class MenuDeDesafios {
	
	private ArrayList<DesafioDeUsuario>	desafiosDisponibles = new ArrayList<DesafioDeUsuario>();	// FS: No aceptados.
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
	
	public void agregarDesafioADisponibles(DesafioDeUsuario desafioDeUsuario) {
		this.desafiosDisponibles.add(desafioDeUsuario);
	}

	public ArrayList<DesafioDeUsuario> getDesafiosAceptados() {
		return desafiosAceptados;
	}



	public ArrayList<DesafioDeUsuario> getDesafiosCompletados() {
		return desafiosCompletados;
	}

}
