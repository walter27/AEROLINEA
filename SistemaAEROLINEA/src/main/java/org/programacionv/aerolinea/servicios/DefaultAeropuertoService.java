package org.programacionv.aerolinea.servicios;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.programacionv.aerolinea.modelo.Aeropuerto;
import org.programacionv.aerolinea.modelo.AeropuertoRepository;

@Stateless
public class DefaultAeropuertoService implements AeropuertoService {
	
	@Inject
	AeropuertoRepository aeropuertoRepository;

	@Override
	public void create(Aeropuerto aeropuerto) {

		aeropuertoRepository.create(aeropuerto);
	}

	@Override
	public void delete(Aeropuerto aeropuerto) {

		aeropuertoRepository.delete(aeropuerto);
	}

	@Override
	public void update(Aeropuerto aeropuerto) {

		aeropuertoRepository.update(aeropuerto);
	}

	@Override
	public List<Aeropuerto> findAll() {

		return aeropuertoRepository.findAll();
	}

}
