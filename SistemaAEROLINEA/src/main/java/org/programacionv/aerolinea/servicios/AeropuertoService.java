package org.programacionv.aerolinea.servicios;

import java.util.List;

import org.programacionv.aerolinea.modelo.Aeropuerto;;

public interface AeropuertoService {
	
	public void create (Aeropuerto aeropuerto);

	public void update(Aeropuerto aeropuerto);

	public void delete(Aeropuerto aeropuerto);

	public List<Aeropuerto> findAll();
	
	

}
