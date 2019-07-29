package airlinetycoon.simulador;

import java.util.LinkedList;
import java.util.List;

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
		
		return v;
	}
}
