package org.programacionv.aerolinea.modelo;

import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PAGO")
public class Pago implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String tipo;
	private Date fechaPago;
	private double precioPago;
	private Reserva reserva;
	private Set<Tarjeta> listaTarjetas = new HashSet<Tarjeta>();

	public Pago() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ID_PAG_PK", columnDefinition = "NUMERIC (10,0)")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Date getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	public double getPrecioPago() {
		return precioPago;
	}

	public void setPrecioPago(double precioPago) {
		this.precioPago = precioPago;
	}

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "TARJETA_PAGO", joinColumns = @JoinColumn(name = "ID_PAG_PK"), inverseJoinColumns = @JoinColumn(name = "ID_TARJ_PK"))
	public Set<Tarjeta> getListaTarjetas() {
		return listaTarjetas;
	}

	public void setListaTarjetas(Set<Tarjeta> listaTarjetas) {
		this.listaTarjetas = listaTarjetas;
	}

	@ManyToOne
	@JoinColumn(name = "RESERVA_FK")
	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

}
