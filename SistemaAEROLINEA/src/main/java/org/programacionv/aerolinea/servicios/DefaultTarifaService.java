package org.programacionv.aerolinea.servicios;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.programacionv.aerolinea.modelo.Tarifa;
import org.programacionv.aerolinea.modelo.TarifaRepository;


@Stateless
public class DefaultTarifaService implements TarifaService {

	@Inject
	TarifaRepository tarifaRepository;

	@Override
	public void create(Tarifa tarifa) {

		tarifaRepository.create(tarifa);
	}

	@Override
	public void delete(Tarifa tarifa) {

		tarifaRepository.delete(tarifa);
	}

	@Override
	public void update(Tarifa tarifa) {

		tarifaRepository.update(tarifa);
	}

	@Override
	public List<Tarifa> findAll() {

		return tarifaRepository.findAll();
	}

}
