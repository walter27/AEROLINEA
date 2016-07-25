package org.programacionv.aerolinea.servicios;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.programacionv.aerolinea.modelo.Reserva;
import org.programacionv.aerolinea.modelo.ReservaRepository;;

@Stateless
public class DefaultReservaService implements ReservaService {
	
	@Inject
	ReservaRepository reservaRepository;

	@Override
	public void create(Reserva reserva) {

		reservaRepository.create(reserva);
	}

	@Override
	public void delete(Reserva reserva) {

		reservaRepository.delete(reserva);
	}

	@Override
	public void update(Reserva reserva) {

		reservaRepository.update(reserva);
	}

	@Override
	public List<Reserva> findAll() {

		return reservaRepository.findAll();
	}

}
