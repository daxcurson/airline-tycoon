package airlinetycoon.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="hangar")
public class Hangar extends ObjetoDominio implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5439458340022879300L;
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
}
