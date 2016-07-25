package org.programacionv.aerolinea.modelo;

import java.util.List;

public interface PasajeroRepository {

	public void create(Pasajero pasajero);

	public void update(Pasajero pasajero);

	public void delete(Pasajero pasajero);

	public List<Pasajero> findAll();
	
}
