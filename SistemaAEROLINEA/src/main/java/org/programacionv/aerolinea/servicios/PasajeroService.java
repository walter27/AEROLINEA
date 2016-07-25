package org.programacionv.aerolinea.servicios;

import java.util.List;

import org.programacionv.aerolinea.modelo.Pasajero;
public interface PasajeroService {
	
	public void create(Pasajero pasajero);

	public void update(Pasajero pasajero);

	public void delete(Pasajero pasajero);

	public List<Pasajero> findAll();

}
