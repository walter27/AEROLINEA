package org.programacionv.aerolinea.servicios;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.programacionv.aerolinea.modelo.Aerolinea;
import org.programacionv.aerolinea.modelo.AerolineaRepository;

@Stateless
public class DefaultAerolineaService implements AerolineaService {

	@Inject
	AerolineaRepository aerolineaRepository;

	@Override
	public void create(Aerolinea aerolinea) {

		aerolineaRepository.create(aerolinea);
	}

	@Override
	public void delete(Aerolinea aerolinea) {

		aerolineaRepository.delete(aerolinea);
	}

	@Override
	public void update(Aerolinea aerolinea) {

		aerolineaRepository.update(aerolinea);
	}

	@Override
	public List<Aerolinea> findAll() {

		return aerolineaRepository.findAll();
	}

}
