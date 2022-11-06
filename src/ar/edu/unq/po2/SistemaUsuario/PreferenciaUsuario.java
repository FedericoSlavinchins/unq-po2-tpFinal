package ar.edu.unq.po2.SistemaUsuario;

public class PreferenciaUsuario {
	
	private int cantidadDeMestrasARecolectar;
	private int dificultadPreferida;
	private double recompensaPreferida;
	
	public PreferenciaUsuario(int cantidadDeMestrasARecolectar, int dificultadPreferida, double recompensaPreferida) {
		this.setCantidadDeMestrasARecolectar(cantidadDeMestrasARecolectar);
		this.setDificultadPreferida(dificultadPreferida);
		this.setRecompensaPreferida(recompensaPreferida);
	}


	public int getCantidadDeMestrasARecolectar() {
		return cantidadDeMestrasARecolectar;
	}
	
	
	public void setCantidadDeMestrasARecolectar(int cantidadDeMestrasARecolectar) {
		this.cantidadDeMestrasARecolectar = cantidadDeMestrasARecolectar;
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
