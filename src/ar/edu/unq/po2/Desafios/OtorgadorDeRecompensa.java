package ar.edu.unq.po2.Desafios;

import ar.edu.unq.po2.SistemaUsuario.Usuario;

public class OtorgadorDeRecompensa {
	
	
	private Usuario usuarioARecompensar;
	private double recompensaAOtorgar;
	

	public OtorgadorDeRecompensa(double recompensa) {
		this.recompensaAOtorgar = recompensa;
	}


	public void setUsuarioARecompensar(Usuario usuario) {
		this.usuarioARecompensar = usuario;
	}


	public void otorgarRecompensa() {
		this.usuarioARecompensar.setRecompensasAcumuladas(	this.usuarioARecompensar.getRecompensasAcumuladas() 
															+ 
															this.recompensaAOtorgar	);
	}
	
}
