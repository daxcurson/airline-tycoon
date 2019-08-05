package airlinetycoon.modelo;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Aerolinea 
{
	@Id
	@GeneratedValue
	private long id;
	@OneToMany(mappedBy="aerolinea")
	private List<Avion> aviones;
	@OneToMany(mappedBy="aerolinea")
	private List<AeropuertoAerolinea> aeropuertos;
	private double dinero;
	private String nombre;
	
	public Aerolinea()
	{
		aviones=new LinkedList<Avion>();
		aeropuertos=new LinkedList<AeropuertoAerolinea>();
		dinero=0.00;
	}
	
	public List<Avion> getAviones() {
		return aviones;
	}
	public void setAviones(List<Avion> aviones) {
		this.aviones = aviones;
	}
	public List<AeropuertoAerolinea> getAeropuertos() {
		return aeropuertos;
	}
	public void setAeropuertos(List<AeropuertoAerolinea> aeropuertos) {
		this.aeropuertos = aeropuertos;
	}

	public double getDinero() {
		return dinero;
	}

	public void setDinero(double dinero) {
		this.dinero = dinero;
	}

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
