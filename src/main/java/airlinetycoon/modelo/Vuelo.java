package airlinetycoon.modelo;

// Generated Nov 13, 2011 7:42:50 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

/**
 * Un vuelo es generado por una agencia de viajes, para ser satisfecho por una aerolinea.
 * Esta oferta caduca despues de un determinado tiempo, en segundos. Despues de lo cual
 * expira y ya no puede ser satisfecha.
 */
@Entity
@Table(name = "vuelo")
public class Vuelo extends ObjetoDominio implements java.io.Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Aeropuerto origen;
	private Aeropuerto destino;
	private double pago;
	private int pasajeros;
	private Date fecha_creacion;
	private long vigencia;

	public Vuelo() {
	}

	public Vuelo(Aeropuerto origenId, Aeropuerto destinoId, double pago, int cantPasajeros) {
		this.origen = origenId;
		this.destino = destinoId;
		this.pago = pago;
		this.pasajeros = cantPasajeros;
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

	@ManyToOne
	@Basic(fetch=FetchType.LAZY)
	@JoinColumn(name="origen_id",referencedColumnName="id")
	public Aeropuerto getOrigen() {
		return this.origen;
	}

	public void setOrigen(Aeropuerto origenId) {
		this.origen = origenId;
	}

	@ManyToOne
	@Basic(fetch=FetchType.LAZY)
	@JoinColumn(name="destino_id",referencedColumnName="id")
	public Aeropuerto getDestino() {
		return this.destino;
	}

	public void setDestino(Aeropuerto destinoId) {
		this.destino = destinoId;
	}

	@Column(name = "pago", nullable = false, precision = 22, scale = 0)
	public double getPago() {
		return this.pago;
	}

	public void setPago(double pago) {
		this.pago = pago;
	}

	@Column(name = "pasajeros", nullable = false)
	public int getPasajeros() {
		return this.pasajeros;
	}

	public void setPasajeros(int cantPasajeros) {
		this.pasajeros = cantPasajeros;
	}

	public long getVigencia() {
		return vigencia;
	}

	public void setVigencia(long vigencia) {
		this.vigencia = vigencia;
	}

	public Date getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

}
