package org.programacionv.aerolinea.modelo;

import java.util.List;

public interface TarifaRepository {
	
	public void create(Tarifa tarifa);

	public void update(Tarifa tarifa);

	public void delete(Tarifa tarifa);

	public List<Tarifa> findAll();

}
