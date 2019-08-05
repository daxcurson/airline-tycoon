package airlinetycoon.simulador;

import airlinetycoon.modelo.Posicion;

/**
 * Define metodos estaticos para hacer algunos calculos que son "Globales".
 * @author Agustín Villafañe
 *
 */
public class SimuladorUtils 
{
	/**
	 * Asumimos para simplificar que todas las distancias son sobre una esfera 
	 * de diametro 6370 kilometros
	 */
	private static final double DIAMETRO=6370.0;
	/**
	 * Calcula la distancia sobre una esfera entre dos latitudes.
	 * @param desde
	 * @param hasta
	 * @return
	 */
	public static double calcularDistancia(Posicion desde,Posicion hasta)
	{
		// En la wikipedia figura una formula muy interesante y supuestamente
		// numericamente mas estable que la formula comun. Esa formula se llama
		// Formula de Vicenty. 
		// Lo que se podria llegar a hacer es tener ambas funciones, la comun y la
		// de Vicenty y ver en cuanto difieren. La funcion tradicional se vuelve problematica
		// para distancias cortas, mientras que la de vicenti es numericamente mas estable
		// tanto para cortas como para largas distancias.
		double distancia=0;
		
		// En Posicion vienen los datos de longitud y latitud, se los asume como un
		// decimal en grados. Como es asi, hay que pasarlo a radianes.
		Posicion desdeRadianes=new Posicion();
		desdeRadianes.setLongitud(desde.getLongitud()*Math.PI/180);
		desdeRadianes.setLatitud(desde.getLatitud()*Math.PI/180);
		Posicion hastaRadianes=new Posicion();
		hastaRadianes.setLongitud(hasta.getLongitud()*Math.PI/180);
		hastaRadianes.setLatitud(hasta.getLatitud()*Math.PI/180);
		
		// En la formula de la Wikipedia, delta-lambda es la diferencia absoluta
		// en longitud, mientras que phi es el valor de cada latitud.
		double delta_lambda=Math.abs(hastaRadianes.getLongitud()-desdeRadianes.getLongitud());
		double delta_sigma=Math.acos(Math.sin(desdeRadianes.getLatitud())*Math.sin(hastaRadianes.getLatitud())+Math.cos(desdeRadianes.getLatitud())*Math.cos(hastaRadianes.getLatitud())*Math.cos(delta_lambda));
		
		// Ahora con el delta_sigma calculo la distancia multiplicando por el radio.
		distancia=SimuladorUtils.DIAMETRO*delta_sigma;
		return distancia;
	}
}
