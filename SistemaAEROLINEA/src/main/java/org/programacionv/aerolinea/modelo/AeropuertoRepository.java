package org.programacionv.aerolinea.modelo;

import java.util.List;

public interface AeropuertoRepository {
	
	public void create(Aeropuerto aeropuerto);

	public void update(Aeropuerto aeropuerto);

	public void delete(Aeropuerto aeropuerto);

	public List<Aeropuerto> findAll();

}
