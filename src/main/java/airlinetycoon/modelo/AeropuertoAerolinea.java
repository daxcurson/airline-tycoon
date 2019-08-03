package airlinetycoon.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="aeropuerto_aerolinea")
public class AeropuertoAerolinea extends ObjetoDominio implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9116520255171168274L;
	@Id
	@GeneratedValue
	private long id;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@ManyToOne
	@JoinColumn(name="aeropuerto_id")
	private Aeropuerto aeropuerto;
	@ManyToOne
	@JoinColumn(name="aerolinea_id")
	private Aerolinea aerolinea;
}
