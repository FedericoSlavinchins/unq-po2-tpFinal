package ar.edu.unq.po2.SistemaUsuario;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.Desafios.DesafioDeUsuario;

public class Usuario {
	
	private Preferencias preferencias; //Agregar params
	private ArrayList<DesafioDeUsuario>	desafiosAceptados 			= new ArrayList<DesafioDeUsuario>();
	private ArrayList<DesafioDeUsuario>	desafiosCompletados			= new ArrayList<DesafioDeUsuario>();
	
	
	//public void aceptarDesafio(Desafio desafio) {
	//	this.desafiosAceptados.add(desafio);
	//}
	
	//public void completarDesafio(DesafioDeUsuario desafio) {
	//	this.desafiosAceptados.remove(desafio);
	//	this.desafiosCompletados.add(desafio);
		//Otorgar recompensa
	//}
	
	public List<DesafioDeUsuario> getDesafiosCompletados(){
		return this.desafiosCompletados;
	}
	
	public boolean esDesafioCompletado(DesafioDeUsuario desafio) {
		return desafio.estaCompleto();
	}
	
	public int porcentajeDeCompletitud(DesafioDeUsuario desafio) {
		return desafio.porcentajeDeCompletitud();
	}
	
	public int porcentajeDeCompletitudGeneral() {
		int resultado = 0; 
		for (DesafioDeUsuario desafio : desafiosAceptados) {
			resultado += desafio.porcentajeDeCompletitud();
		}
		return (resultado + (this.desafiosCompletados.size() * 100)) / 
					(this.desafiosAceptados.size() + 
					this.desafiosCompletados.size());
	}
	
}
