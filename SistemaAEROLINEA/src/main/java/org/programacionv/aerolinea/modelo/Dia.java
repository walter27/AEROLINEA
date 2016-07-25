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
@Table(name = "DIA")
public class Dia {

	private int id;
	private Vuelo vueloLlegada;
	private Vuelo vueloSalida;
	private Hora hora;

	public Dia() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ID_DIA_PK", columnDefinition = "NUMERIC (10,0)")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "VUELO_LLEGADA_FK")
	public Vuelo getVueloLlegada() {
		return vueloLlegada;
	}

	public void setVueloLlegada(Vuelo vueloLlegada) {
		this.vueloLlegada = vueloLlegada;
	}

	@ManyToOne
	@JoinColumn(name = "VUELO_SALIDA_FK")
	public Vuelo getVueloSalida() {
		return vueloSalida;
	}

	public void setVueloSalida(Vuelo vueloSalida) {
		this.vueloSalida = vueloSalida;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_HORA_PK")
	public Hora getHora() {
		return hora;
	}

	public void setHora(Hora hora) {
		this.hora = hora;
	}

}
