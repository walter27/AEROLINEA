package org.programacionv.aerolinea.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TARIFA")
public class Tarifa {

	private int id;
	private String clase;
	private Double impuesto;
	private Double precioTarifa;
	private Vuelo vueloIda;
	private Vuelo vueloOfertas;

	public Tarifa() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ID_TARF_PK", columnDefinition = "NUMERIC (10,0)")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	public Double getImpuesto() {
		return impuesto;
	}

	public void setImpuesto(Double impuesto) {
		this.impuesto = impuesto;
	}

	public Double getPrecioTarifa() {
		return precioTarifa;
	}

	public void setPrecioTarifa(Double precioTarifa) {
		this.precioTarifa = precioTarifa;
	}

	@ManyToOne
	@JoinColumn(name = "VUELOIDs_FK")
	public Vuelo getVueloIda() {
		return vueloIda;
	}

	public void setVueloIda(Vuelo vueloIda) {
		this.vueloIda = vueloIda;
	}

	@ManyToOne
	@JoinColumn(name = "VUELOOFR_FK")
	public Vuelo getVueloOfertas() {
		return vueloOfertas;
	}

	public void setVueloOfertas(Vuelo vueloOfertas) {
		this.vueloOfertas = vueloOfertas;
	}

}
