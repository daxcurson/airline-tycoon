package airlinetycoon.modelo;

// Generated Nov 13, 2011 7:42:50 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * Modeloavion generated by hbm2java
 */
@Entity
@Table(name = "modeloavion")
public class Modeloavion extends ObjetoDominio implements java.io.Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private int version;
	private String marca;
	private String modelo;
	private double autonomia;
	private double velocidad;
	private double consumo;
	private double capacidad;
	private double tanque;

	public Modeloavion() {
	}

	public Modeloavion(String marca, String modelo, double autonomia, double consumo,
			double capacidad, double tanque) {
		this.marca = marca;
		this.modelo = modelo;
		this.autonomia = autonomia;
		this.consumo = consumo;
		this.capacidad = capacidad;
		this.tanque = tanque;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Version
	@Column(name = "version", nullable = false)
	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Column(name = "marca", nullable = false, length = 20)
	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	@Column(name = "modelo", nullable = false, length = 50)
	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@Column(name = "autonomia", nullable = false)
	public double getAutonomia() {
		return this.autonomia;
	}

	public void setAutonomia(double autonomia) {
		this.autonomia = autonomia;
	}

	@Column(name = "consumo", nullable = false)
	public double getConsumo() {
		return this.consumo;
	}

	public void setConsumo(double consumo) {
		this.consumo = consumo;
	}

	@Column(name = "capacidad", nullable = false)
	public double getCapacidad() {
		return this.capacidad;
	}

	public void setCapacidad(double capacidad) {
		this.capacidad = capacidad;
	}

	@Column(name = "tanque", nullable = false)
	public double getTanque() {
		return this.tanque;
	}

	public void setTanque(double tanque) {
		this.tanque = tanque;
	}
	public String toString()
	{
		return this.modelo;
	}
	@Column(name="velocidad")
	public double getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(double velocidad) {
		this.velocidad = velocidad;
	}

}
