package ar.edu.unq.po2.SistemaUsuario;

public class PreferenciaUsuario {
	
	private int cantidadDeMuestrasARecolectar;
	private int dificultadPreferida;
	private double recompensaPreferida;
	
	public PreferenciaUsuario(int cantidadDeMuestrasARecolectar, int dificultadPreferida, double recompensaPreferida) {
		this.setCantidadDeMestrasARecolectar(cantidadDeMuestrasARecolectar);
		this.setDificultadPreferida(dificultadPreferida);
		this.setRecompensaPreferida(recompensaPreferida);
	}


	public int getCantidadDeMuestrasARecolectar() {
		return cantidadDeMuestrasARecolectar;
	}
	
	
	public void setCantidadDeMestrasARecolectar(int cantidadDeMestrasARecolectar) {
		this.cantidadDeMuestrasARecolectar = cantidadDeMestrasARecolectar;
	}
	
	
	public int getDificultadPreferida() {
		return dificultadPreferida;
	}
	
	
	public void setDificultadPreferida(int dificultadPreferida) {
		this.dificultadPreferida = dificultadPreferida;
	}
	
	
	public double getRecompensaPreferida() {
		return recompensaPreferida;
	}
	
	
	public void setRecompensaPreferida(double recompensaPreferida) {
		this.recompensaPreferida = recompensaPreferida;
	}
	
	
	
}
