package airlinetycoon.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Ciudad
 *
 */
@Entity
public class Ciudad extends ObjetoDominio implements Serializable 
{
	@Id
	@GeneratedValue
	private int id;
	private String nombre;
	private double latitud;
	private double longitud;
	private List<Aeropuerto> aeropuertos;
	private static final long serialVersionUID = 1L;

	public Ciudad() 
	{
		super();
	}

	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public String getNombre() 
	{
		return nombre;
	}

	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}

	public double getLatitud() 
	{
		return latitud;
	}

	public void setLatitud(double latitud) 
	{
		this.latitud = latitud;
	}

	public double getLongitud() 
	{
		return longitud;
	}

	public void setLongitud(double longitud) 
	{
		this.longitud = longitud;
	}
	public String toString()
	{
		return this.nombre;
	}

	public List<Aeropuerto> getAeropuertos() {
		return aeropuertos;
	}

	public void setAeropuertos(List<Aeropuerto> aeropuertos) {
		this.aeropuertos = aeropuertos;
	}
	public boolean equals(Object o)
	{
		boolean resultado=false;
		if(o instanceof Ciudad)
		{
			Ciudad otra=(Ciudad)o;
			if(otra.longitud==this.longitud &&
					otra.latitud==this.latitud &&
					otra.nombre.equals(this.nombre))
			{
				// Si tienen la misma longitud, latitud y nombre
				// asumo que son iguales. No me preocupo por la lista de aeropuertos.
				resultado=true;
			}
		}
		return resultado;
	}
}
