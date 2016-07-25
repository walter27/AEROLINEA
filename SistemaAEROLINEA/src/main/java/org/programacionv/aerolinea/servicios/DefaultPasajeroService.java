package org.programacionv.aerolinea.servicios;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import org.programacionv.aerolinea.modelo.Pasajero;
import org.programacionv.aerolinea.modelo.PasajeroRepository;

@Stateless
public class DefaultPasajeroService implements PasajeroService {

	@Inject
	PasajeroRepository pasajeroRepository;

	@Override
	public void create(Pasajero pasajero) {

		pasajeroRepository.create(pasajero);
	}

	@Override
	public void delete(Pasajero pasajero) {

		pasajeroRepository.delete(pasajero);
	}

	@Override
	public void update(Pasajero pasajero) {

		pasajeroRepository.update(pasajero);
	}

	@Override
	public List<Pasajero> findAll() {

		return pasajeroRepository.findAll();
	}

}
