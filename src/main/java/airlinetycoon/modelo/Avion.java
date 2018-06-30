package airlinetycoon.modelo;

// Generated Nov 13, 2011 7:42:50 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Avion generated by hbm2java
 */
@Entity
@Table(name = "avion")
public class Avion extends ObjetoDominio implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nombre;
	private Modeloavion modelo;
	private int antiguedad;
	private int kilometros_recorridos;
	private Ciudad ubicacion;
	
	@Transient
	private Posicion posicion;

	public Avion() 
	{
	}

	public Avion(String nombre, Modeloavion modelo, int antiguedad,
			int kilometrosRecorridos) 
	{
		this.nombre = nombre;
		this.modelo = modelo;
		this.antiguedad = antiguedad;
		this.kilometros_recorridos= kilometrosRecorridos;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() 
	{
		return this.id;
	}

	public void setId(Integer id) 
	{
		this.id = id;
	}


	@Column(name = "nombre", nullable = false, length = 50)
	public String getNombre() 
	{
		return this.nombre;
	}

	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}

	@ManyToOne
	@Basic(fetch=FetchType.LAZY)
	@JoinColumn(name="modelo_id",referencedColumnName="id")
	public Modeloavion getModeloId() 
	{
		return this.modelo;
	}

	public void setModeloId(Modeloavion modelo) 
	{
		this.modelo = modelo;
	}

	@Column(name = "antiguedad", nullable = false)
	public int getAntiguedad() 
	{
		return this.antiguedad;
	}

	public void setAntiguedad(int antiguedad) 
	{
		this.antiguedad = antiguedad;
	}

	@Column(name = "kilometros_recorridos", nullable = false)
	public int getKilometros_recorridos() 
	{
		return this.kilometros_recorridos;
	}

	public void setKilometros_recorridos(int kilometrosRecorridos) 
	{
		this.kilometros_recorridos= kilometrosRecorridos;
	}
	@ManyToOne
	@Basic(fetch=FetchType.LAZY)
	@JoinColumn(name="ubicacion",referencedColumnName="id")
	public Ciudad getUbicacion() 
	{
		return ubicacion;
	}
	
	public void setUbicacion(Ciudad ubicacion) 
	{
		this.ubicacion = ubicacion;
	}
	public String toString()
	{
		return this.nombre;
	}

	public Posicion getPosicion()
	{
		return posicion;
	}

	public void setPosicion(Posicion posicion)
	{
		this.posicion = posicion;
	}

}
