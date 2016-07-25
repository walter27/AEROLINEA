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
import org.programacionv.aerolinea.modelo.Pasajero;
import org.programacionv.aerolinea.servicios.PasajeroService;

@Named
@SessionScoped
public class PasajeroControlador implements Serializable {

	private static final long serialVersionUID = 9016278795689566752L;
	private Pasajero actualPasajero;
	private List<Pasajero> listaPasajeros;

	@Inject
	private PasajeroService pasajeroservice;

	@PostConstruct
	private void init() {

		actualPasajero = new Pasajero();
		listaPasajeros = pasajeroservice.findAll();

	}

	public void addPasajero() {
		
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"PASAJERO INGRESADO", "Nombre: "+ actualPasajero.getNombre() +" "+ "CI: "+ actualPasajero.getCedula());
	    FacesContext.getCurrentInstance().addMessage(null, msg);	
		pasajeroservice.create(actualPasajero);
		listaPasajeros.add(actualPasajero);
		actualPasajero = new Pasajero();

	}

	public void eliminarPasajero(Pasajero pasajero) {

		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"PASAJERO ELIMINADO", "Nombre: "+ actualPasajero.getNombre() +" "+ "CI: "+ actualPasajero.getCedula());
	    FacesContext.getCurrentInstance().addMessage(null, msg);			
		pasajeroservice.delete(pasajero);
		listaPasajeros.remove(pasajero);
		actualPasajero = new Pasajero();
	}

	public void editarPasajero(Pasajero pasajero) {

		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,"PASAJERO MODIFICADO", "Nombre: "+ actualPasajero.getNombre() +" "+ "CI: "+ actualPasajero.getCedula());
	    FacesContext.getCurrentInstance().addMessage(null, msg);							
		pasajeroservice.update(pasajero);
		pasajero = new Pasajero();
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

	public Pasajero getActualPasajero() {
		return actualPasajero;
	}

	public void setActualPasajero(Pasajero actualPasajero) {
		this.actualPasajero = actualPasajero;
	}

	public List<Pasajero> getListaPasajeros() {
		return listaPasajeros;
	}

	public void setListaPasajeros(List<Pasajero> listaPasajeros) {
		this.listaPasajeros = listaPasajeros;
	}

}
