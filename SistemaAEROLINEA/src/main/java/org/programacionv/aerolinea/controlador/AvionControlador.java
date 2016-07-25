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
import org.programacionv.aerolinea.modelo.Avion;
import org.programacionv.aerolinea.servicios.AvionService;

;

@Named
@SessionScoped
public class AvionControlador implements Serializable {

	private static final long serialVersionUID = 1L;
	private Avion actualAvion;
	private List<Avion> listaAviones;

	@Inject
	private AvionService avionService;

	@PostConstruct
	private void init() {

		actualAvion = new Avion();
		listaAviones = avionService.findAll();

	}

	public void addAvion() {

		avionService.create(actualAvion);
		listaAviones.add(actualAvion);
		actualAvion = new Avion();

	}

	public void eliminarAvion(Avion avion) {

		avionService.delete(avion);
		listaAviones.remove(avion);
		actualAvion = new Avion();
	}

	public void editarAvion(Avion avion) {

		avionService.update(avion);
		avion = new Avion();
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

	public Avion getActualAvion() {
		return actualAvion;
	}

	public void setActualAvion(Avion actualAvion) {
		this.actualAvion = actualAvion;
	}

	public List<Avion> getListaAviones() {
		return listaAviones;
	}

	public void setListaAviones(List<Avion> listaAviones) {
		this.listaAviones = listaAviones;
	}

}
