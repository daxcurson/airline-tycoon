package airlinetycoon.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Aeropuerto extends ObjetoDominio implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2648732181364814003L;
	@Id
	@GeneratedValue
	private int id;
	private Ciudad ciudad;
	private String codigo;
	private String nombre;
	private List<Puerta> puertas;
	private List<Pista> pistas;
	private List<Hangar> hangares;
	public Ciudad getCiudad() {
		return ciudad;
	}
	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Puerta> getPuertas() {
		return puertas;
	}
	public void setPuertas(List<Puerta> puertas) {
		this.puertas = puertas;
	}
	public List<Pista> getPistas() {
		return pistas;
	}
	public void setPistas(List<Pista> pistas) {
		this.pistas = pistas;
	}
	public List<Hangar> getHangares() {
		return hangares;
	}
	public void setHangares(List<Hangar> hangares) {
		this.hangares = hangares;
	}
}
