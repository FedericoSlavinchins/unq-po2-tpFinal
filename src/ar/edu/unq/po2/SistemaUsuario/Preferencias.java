package ar.edu.unq.po2.SistemaUsuario;

public class Preferencias {
	private int cantMuestrasPreferidas;
	private int dificultadPreferida;
	private double recompensaPreferida;
	
	public Preferencias(int cantMuestrasPreferidas, int dificultadPreferida, double recompensaPreferida) {
		this.setCantMuestrasPreferidas(cantMuestrasPreferidas);
		this.setDificultadPreferida(dificultadPreferida);
		this.setRecompensaPreferida(recompensaPreferida);
	}

	public int getCantMuestrasPreferidas() {
		return cantMuestrasPreferidas;
	}

	public void setCantMuestrasPreferidas(int cantMuestrasPreferidas) {
		this.cantMuestrasPreferidas = cantMuestrasPreferidas;
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
