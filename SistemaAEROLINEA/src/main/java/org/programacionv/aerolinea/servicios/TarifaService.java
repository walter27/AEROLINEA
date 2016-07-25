package org.programacionv.aerolinea.servicios;

import java.util.List;

import org.programacionv.aerolinea.modelo.Tarifa;;

public interface TarifaService {
	
	public void create(Tarifa tarifa);

	public void update(Tarifa tarifa);

	public void delete(Tarifa tarifa);

	public List<Tarifa> findAll();

}
