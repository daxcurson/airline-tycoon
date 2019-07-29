package airlinetycoon.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Hangar extends ObjetoDominio implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5439458340022879300L;
	@Id
	@GeneratedValue
	private long id;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
}
