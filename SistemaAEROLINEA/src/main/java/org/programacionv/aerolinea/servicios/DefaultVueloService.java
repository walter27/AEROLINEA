package org.programacionv.aerolinea.servicios;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.programacionv.aerolinea.modelo.Vuelo;
import org.programacionv.aerolinea.modelo.VueloRepository;


@Stateless
public class DefaultVueloService implements VueloService {

	@Inject
	VueloRepository vueloRepository;

	@Override
	public void create(Vuelo vuelo) {

		vueloRepository.create(vuelo);
	}

	@Override
	public void delete(Vuelo Vuelo) {

		vueloRepository.delete(Vuelo);
	}

	@Override
	public void update(Vuelo Vuelo) {

		vueloRepository.update(Vuelo);
	}

	@Override
	public List<Vuelo> findAll() {

		return vueloRepository.findAll();
	}

}
