package airlinetycoon.modelo;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Pista extends ObjetoDominio implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8908538678117798781L;
	@Id
	@GeneratedValue
	private long id;
	private String nombre;
	private long longitud;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public long getLongitud() {
		return longitud;
	}
	public void setLongitud(long longitud) {
		this.longitud = longitud;
	}
}
