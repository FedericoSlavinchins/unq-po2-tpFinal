package ar.edu.unq.po2.Proyecto;

public class AreaGeografica {
	private Ubicacion epicentro;
	private float radio;
	
	public AreaGeografica(float latitud, float longitud, float radio) {
		this.epicentro = new Ubicacion(latitud, longitud);
		this.radio = (radio);
	}
	
	public Ubicacion getEpicentro() {
		return epicentro;
	}
	
	public float getRadio() {
		return radio;
	}
	
	//Da True si la ubicacion esta dentro del radio del Area.
	public boolean estaEnRango(Ubicacion geocoordenada) {
		return this.getEpicentro().distancia(geocoordenada) <= this.getRadio();
	}
}
