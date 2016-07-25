package org.programacionv.aerolinea.controlador;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.CellEditEvent;
import org.programacionv.aerolinea.modelo.Vuelo;
import org.programacionv.aerolinea.servicios.VueloService;

;

@Named
@SessionScoped
public class VueloControlador implements Serializable {

	private static final long serialVersionUID = 1L;
	private Vuelo actualVuelo;
	private List<Vuelo> listaVuelos;

	@Inject
	private VueloService vueloService;

	@PostConstruct
	private void init() {

		actualVuelo = new Vuelo();
		listaVuelos = vueloService.findAll();

	}

	public void addVuelo() {

		vueloService.create(actualVuelo);
		listaVuelos.add(actualVuelo);
		actualVuelo = new Vuelo();

	}

	public void eliminarVuelo(Vuelo vuelo) {

		vueloService.delete(vuelo);
		listaVuelos.remove(vuelo);
		actualVuelo = new Vuelo();
	}

	public void editarVuelo(Vuelo vuelo) {

		vueloService.update(vuelo);
		vuelo = new Vuelo();
	}

	public void editcelda(CellEditEvent event) {
		Object oldValue = event.getOldValue();
		Object newValue = event.getNewValue();

		if (newValue != null && !newValue.equals(oldValue)) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Cell Changed", "Old: " + oldValue + ", New:" + newValue);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	public Vuelo getActualVuelo() {
		return actualVuelo;
	}

	public void setActualVuelo(Vuelo actualVuelo) {
		this.actualVuelo = actualVuelo;
	}

	public List<Vuelo> getListaVueloes() {
		return listaVuelos;
	}

	public void setListaVueloes(List<Vuelo> listaVueloes) {
		this.listaVuelos = listaVueloes;
	}

}
