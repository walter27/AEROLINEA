package org.programacionv.aerolinea.modelo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "AVION")
public class Avion {

	private int id;
	private String compañia;
	private String tipo;
	private int numPasajeros;
	private Aerolinea aerolinea;
	private Set<Vuelo> listaVuelos = new HashSet<Vuelo>();

	public Avion() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ID_AVN_PK", columnDefinition = "NUMERIC (10,0)")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompañia() {
		return compañia;
	}

	public void setCompañia(String compañia) {
		this.compañia = compañia;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getNumPasajeros() {
		return numPasajeros;
	}

	public void setNumPasajeros(int numPasajeros) {
		this.numPasajeros = numPasajeros;
	}

	@ManyToOne
	@JoinColumn(name = "AEROLINEA_FK")
	public Aerolinea getAerolinea() {
		return aerolinea;
	}

	public void setAerolinea(Aerolinea aerolinea) {
		this.aerolinea = aerolinea;
	}

	@ManyToMany(mappedBy = "listaAviones")
	public Set<Vuelo> getListaVuelos() {
		return listaVuelos;
	}

	public void setListaVuelos(Set<Vuelo> listaVuelos) {
		this.listaVuelos = listaVuelos;
	}

}
