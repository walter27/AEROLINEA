package org.programacionv.aerolinea.servicios;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.programacionv.aerolinea.modelo.Avion;
import org.programacionv.aerolinea.modelo.AvionRepository;

@Stateless
public class DefaultAvionService implements AvionService {

	@Inject
	AvionRepository avionRepository;

	@Override
	public void create(Avion avion) {

		avionRepository.create(avion);
	}

	@Override
	public void delete(Avion avion) {

		avionRepository.delete(avion);
	}

	@Override
	public void update(Avion avion) {

		avionRepository.update(avion);
	}

	@Override
	public List<Avion> findAll() {

		return avionRepository.findAll();
	}

}
