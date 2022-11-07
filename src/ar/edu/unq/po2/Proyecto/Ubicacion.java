package ar.edu.unq.po2.Proyecto;

public class Ubicacion {
	private float latitud;
	private float longitud;
	
	public Ubicacion (float latitud, float longitud) {
		this.latitud = latitud;
		this.longitud = longitud;
	}

	public float getLatitud() {
		return latitud;
	}

	public float getLongitud() {
		return longitud;
	}
	
	//Calcula la distancia entre dos ubicaciones
	public float distancia(Ubicacion ubicacion) {
		//El resultado es calculado en metros.
		float resultado = this.distFrom(this.getLatitud(), 
										this.getLongitud(), 
										ubicacion.getLatitud(), 
										ubicacion.getLongitud());
		return resultado;
	}
	
	private float distFrom(float lat1, float lng1, float lat2, float lng2) {
		/*Fuente: https://www.iteramos.com/pregunta/26930/calcular-la-distancia-en-metros-cuando-se-conoce-la-longitud-y-latitud-en-java*/
		double earthRadius = 6371; //kilometers 
		double dLat = Math.toRadians(lat2-lat1); 
		double dLng = Math.toRadians(lng2-lng1); 
		double a = 	Math.sin(dLat/2) * Math.sin(dLat/2) + 
					Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * 
					Math.sin(dLng/2) * Math.sin(dLng/2); 
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a)); 
		float dist = (float) (earthRadius * c); 
		return dist;
	}
	
}
