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
import org.programacionv.aerolinea.modelo.Aeropuerto;
import org.programacionv.aerolinea.servicios.AeropuertoService;

@Named
@SessionScoped
public class AeropuertoControlador implements Serializable {

	private static final long serialVersionUID = 1L;
	private Aeropuerto actualAeropuerto;
	private List<Aeropuerto> listaAeropuertos;

	@Inject
	private AeropuertoService aeropuertoService;

	@PostConstruct
	private void init() {

		actualAeropuerto = new Aeropuerto();
		listaAeropuertos = aeropuertoService.findAll();

	}

	public void addAeropuerto() {

		aeropuertoService.create(actualAeropuerto);
		listaAeropuertos.add(actualAeropuerto);
		actualAeropuerto = new Aeropuerto();

	}

	public void eliminarAeropuerto(Aeropuerto aeropuerto) {

		aeropuertoService.delete(aeropuerto);
		listaAeropuertos.remove(aeropuerto);
		actualAeropuerto = new Aeropuerto();
	}

	public void editarAeropuerto(Aeropuerto aeropuerto) {

		aeropuertoService.update(aeropuerto);
		aeropuerto = new Aeropuerto();
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

	public Aeropuerto getActualAeropuerto() {
		return actualAeropuerto;
	}

	public void setActualAeropuerto(Aeropuerto actualAeropuerto) {
		this.actualAeropuerto = actualAeropuerto;
	}

	public List<Aeropuerto> getListaAeropuertos() {
		return listaAeropuertos;
	}

	public void setListaAeropuertos(List<Aeropuerto> listaAeropuertos) {
		this.listaAeropuertos = listaAeropuertos;
	}

}
