package ar.edu.unq.po2.Proyecto;

public class AreaGeografica {
	private String nombre;
	private Ubicacion epicentro;
	private float radio;
	
	public AreaGeografica(String nombre, float latitud, float longitud, float radio) {
		this.setNombre(nombre);
		this.setEpicentro(latitud, longitud);
		this.setRadio(radio);
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Ubicacion getEpicentro() {
		return epicentro;
	}
	public void setEpicentro(float latitud, float longitud) {
		this.epicentro = new Ubicacion(latitud, longitud);
	}
		public float getRadio() {
		return radio;
	}
	public void setRadio(float radio) {
		this.radio = radio;
	}
	
	//Da True si la ubicacion esta dentro del radio del Area.
	public boolean estaEnRango(Ubicacion geocoordenada) {
		return this.epicentro.distancia(geocoordenada) < this.radio;
	}
	
	//Da True si dos Areas se solapan una con otra.
	public boolean seSolapan(AreaGeografica area) {
		return (this.radio + area.radio >= 
				this.getEpicentro().distancia(area.getEpicentro()));
	}
}
