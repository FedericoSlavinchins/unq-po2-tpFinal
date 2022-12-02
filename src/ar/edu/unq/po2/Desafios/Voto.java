package ar.edu.unq.po2.Desafios;

public class Voto {
	
	private int valorVoto;
	
	public Voto(int valorVoto) throws Exception {
		this.colocarVoto(valorVoto);
	}

	public int getValorVoto() {
		return valorVoto;
	}
	
	public void colocarVoto(int numero) throws Exception {
		if(numero >= 0 && numero <= 5 ) {
			this.valorVoto = numero;
		} else { 
			throw new Exception("El voto debe ser entre 0 y 5"); 
		}
	} 
	// guarda el numero n si esta entre 0 y 5 
	// sino lanza una excepción.
	
}
