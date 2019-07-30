package airlinetycoon.simulador;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import airlinetycoon.modelo.Aeropuerto;
import airlinetycoon.modelo.Ciudad;
import airlinetycoon.modelo.Reloj;
import airlinetycoon.modelo.Vuelo;

/**
 * Genera vuelos entre destinos.
 * @author Agustín Villafañe
 *
 */
public class AgenciaViajes 
{
	private List<Vuelo> vuelos;
	
	public AgenciaViajes()
	{
		vuelos=new LinkedList<Vuelo>();
	}

	public List<Vuelo> getVuelos() {
		return vuelos;
	}

	public void setVuelos(List<Vuelo> vuelos) {
		this.vuelos = vuelos;
	}
	
	/**
	 * Genera un vuelo y lo devuelve.
	 * @return
	 */
	public Vuelo generarVuelo()
	{
		Vuelo v=new Vuelo();
		Random rand = new Random();
		Simulador s=Simulador.getInstance();
		List<Ciudad> list=s.getCiudades();
		Ciudad origen=list.get(rand.nextInt(list.size()));
		// Ahora voy a pedir otra ciudad, y si es la misma que antes, tengo
		// que volver a pedir
		boolean repetido=true;
		int intentos=list.size();
		Ciudad destino=null;
		while(repetido && intentos>0)
		{
			intentos--;
			destino=list.get(rand.nextInt(list.size()));
		}
		// Ahora defino un precio para este vuelo. 
		// Vamos a definir un precio entre 100 y 1000 dolares por persona. 
		// Vamos a generar una cantidad de personas entre 5 y 300, 
		// en principio va a ser por variable uniforme, o sea la funcion Random,
		// pero despues se podria incorporar una cantidad por alguna funcion
		// de distribucion como la normal, con alguna media y desvio.
		int personas=5+rand.nextInt(295);
		double precioPorPersona=100+rand.nextDouble()*900; // Esto es porque el doble esta entre 0 y 1
		double precioVuelo=personas*precioPorPersona;
		// El origen y destino de un vuelo son aeropuertos. Dadas dos ciudades,
		// elegimos uno cualquiera de sus aeropuertos por ahora.
		Aeropuerto aeropuertoOrigen=origen.getAeropuertos().get(rand.nextInt(origen.getAeropuertos().size()));
		Aeropuerto aeropuertoDestino=destino.getAeropuertos().get(rand.nextInt(destino.getAeropuertos().size()));
		v.setOrigen(aeropuertoOrigen);
		v.setDestino(aeropuertoDestino);
		v.setPago(precioVuelo);
		// La vigencia son, digamos, 3 dias.
		v.setVigencia(86400*3);
		// Y la fecha de creacion es la hora actual de la simulacion
		v.setFecha_creacion(Reloj.getInstance().horaSimulada());
		return v;
	}
}
