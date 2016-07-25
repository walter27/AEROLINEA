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
import org.programacionv.aerolinea.modelo.Tarifa;
import org.programacionv.aerolinea.servicios.TarifaService;

@Named
@SessionScoped
public class TarifaControlador implements Serializable {

	private static final long serialVersionUID = 9016278795689566752L;
	private Tarifa actualTarifa;
	private List<Tarifa> listaTarifas;

	@Inject
	private TarifaService tarifaService;

	@PostConstruct
	private void init() {

		actualTarifa = new Tarifa();
		listaTarifas = tarifaService.findAll();

	}

	public void addTarifa() {

		tarifaService.create(actualTarifa);
		listaTarifas.add(actualTarifa);
		actualTarifa = new Tarifa();

	}

	public void eliminarTarifa(Tarifa tarifa) {

		tarifaService.delete(tarifa);
		listaTarifas.remove(tarifa);
		actualTarifa = new Tarifa();
	}

	public void editarTarifa(Tarifa tarifa) {

		tarifaService.update(tarifa);
		tarifa = new Tarifa();
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

}
