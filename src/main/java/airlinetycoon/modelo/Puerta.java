package airlinetycoon.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Puerta extends ObjetoDominio implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3335773948160463151L;
	@Id
	@GeneratedValue
	private long id;
	private String nombre;
	@ManyToOne
	@JoinColumn(name="aeropuerto_id")
	private Aeropuerto aeropuerto;
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
	public Aeropuerto getAeropuerto() {
		return aeropuerto;
	}
	public void setAeropuerto(Aeropuerto aeropuerto) {
		this.aeropuerto = aeropuerto;
	}
}
