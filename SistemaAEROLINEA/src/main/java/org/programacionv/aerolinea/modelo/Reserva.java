package org.programacionv.aerolinea.modelo;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "RESERVA")
public class Reserva {

	private int id;
	private String clave;
	private String costoFinal;
	private List<Pago> listaPagos;
	private Set<Pasajero> listaPasajeros = new HashSet<Pasajero>();
	private Set<Vuelo> listaVuelos = new HashSet<Vuelo>();

	public Reserva() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ID_RESV_PK", columnDefinition = "NUMERIC (10,0)")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getCostoFinal() {
		return costoFinal;
	}

	public void setCostoFinal(String costoFinal) {
		this.costoFinal = costoFinal;
	}

	@OneToMany(mappedBy = "reserva", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public List<Pago> getListaPagos() {
		return listaPagos;
	}

	public void setListaPagos(List<Pago> listaPagos) {
		this.listaPagos = listaPagos;
	}

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "RESERVA_PASAJERO", joinColumns = @JoinColumn(name = "ID_RESV_PK"), inverseJoinColumns = @JoinColumn(name = "ID_PSJ_PK"))
	public Set<Pasajero> getListaPasajeros() {
		return listaPasajeros;
	}

	public void setListaPasajeros(Set<Pasajero> listaPasajeros) {
		this.listaPasajeros = listaPasajeros;
	}

	@ManyToMany(mappedBy = "listaReservas")
	public Set<Vuelo> getListaVuelos() {
		return listaVuelos;
	}

	public void setListaVuelos(Set<Vuelo> listaVuelos) {
		this.listaVuelos = listaVuelos;
	}

}
