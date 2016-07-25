package org.programacionv.aerolinea.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "AEROPUERTO")
public class Aeropuerto {

	private int id;
	private String nombre;
	private String ciudad;
	private String pais;
	private Vuelo vuelo;
	private Vuelo vueloEscalas;

	public Aeropuerto() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ID_AERP_PK", columnDefinition = "NUMERIC (10,0)")
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

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_VUEL_PK")
	public Vuelo getVuelo() {
		return vuelo;
	}

	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}

	@ManyToOne
	@JoinColumn(name = "VUELO_ESCALAS_FK")
	public Vuelo getVueloEscalas() {
		return vueloEscalas;
	}

	public void setVueloEscalas(Vuelo vueloEscalas) {
		this.vueloEscalas = vueloEscalas;
	}

}
