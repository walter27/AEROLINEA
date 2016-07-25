package org.programacionv.aerolinea.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "AEROLINEA")
public class Aerolinea {

	private int id;
	private String nombre;
	private List<Vuelo> listaVuelos;
	private List<Avion> listaAviones;

	public Aerolinea() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_AERL_PK", columnDefinition = "NUMERIC (10,0)")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@OneToMany(mappedBy = "aerolinea", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public List<Vuelo> getListaVuelos() {
		return listaVuelos;
	}

	public void setListaVuelos(List<Vuelo> listaVuelos) {
		this.listaVuelos = listaVuelos;
	}

	@OneToMany(mappedBy = "aerolinea", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public List<Avion> getListaAviones() {
		return listaAviones;
	}

	public void setListaAviones(List<Avion> listaAviones) {
		this.listaAviones = listaAviones;
	}

}
