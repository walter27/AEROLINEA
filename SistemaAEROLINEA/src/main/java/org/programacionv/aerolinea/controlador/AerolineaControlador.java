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
import org.programacionv.aerolinea.modelo.Aerolinea;
import org.programacionv.aerolinea.servicios.AerolineaService;

@Named
@SessionScoped
public class AerolineaControlador implements Serializable {

	private static final long serialVersionUID = 1L;
	private Aerolinea actualAerolinea;
	private List<Aerolinea> listaAerolineas;

	@Inject
	private AerolineaService aerolineaservice;

	@PostConstruct
	private void init() {

		actualAerolinea = new Aerolinea();
		listaAerolineas = aerolineaservice.findAll();

	}

	public void addAerolinea() {

		aerolineaservice.create(actualAerolinea);
		listaAerolineas.add(actualAerolinea);
		actualAerolinea = new Aerolinea();

	}

	public void eliminarAerolinea(Aerolinea aerolinea) {

		aerolineaservice.delete(aerolinea);
		listaAerolineas.remove(aerolinea);
		actualAerolinea = new Aerolinea();
	}

	public void editarAerolinea(Aerolinea aerolinea) {

		aerolineaservice.update(aerolinea);
		aerolinea = new Aerolinea();
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

	public Aerolinea getActualAerolinea() {
		return actualAerolinea;
	}

	public void setActualAerolinea(Aerolinea actualAerolinea) {
		this.actualAerolinea = actualAerolinea;
	}

	public List<Aerolinea> getListaAerolineas() {
		return listaAerolineas;
	}

	public void setListaAerolineas(List<Aerolinea> listaAerolineas) {
		this.listaAerolineas = listaAerolineas;
	}

}
