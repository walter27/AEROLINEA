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
import org.programacionv.aerolinea.modelo.Reserva;
import org.programacionv.aerolinea.servicios.ReservaService;


@Named
@SessionScoped
public class ReservaControlador implements Serializable {

	private static final long serialVersionUID = 9016278795689566752L;
	private Reserva actualReserva;
	private List<Reserva> listaReservas;

	@Inject
	private ReservaService reservaService;

	@PostConstruct
	private void init() {

		actualReserva = new Reserva();
		listaReservas = reservaService.findAll();

	}

	public void addReserva() {

		reservaService.create(actualReserva);
		listaReservas.add(actualReserva);
		actualReserva = new Reserva();

	}

	public void eliminarReserva(Reserva reserva) {

		reservaService.delete(reserva);
		listaReservas.remove(reserva);
		actualReserva = new Reserva();
	}

	public void editarReserva(Reserva reserva) {

		reservaService.update(reserva);
		reserva = new Reserva();
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

	public Reserva getActualReserva() {
		return actualReserva;
	}

	public void setActualReserva(Reserva actualReserva) {
		this.actualReserva = actualReserva;
	}

	public List<Reserva> getListaReservas() {
		return listaReservas;
	}

	public void setListaReservas(List<Reserva> listaReservas) {
		this.listaReservas = listaReservas;
	}

}
