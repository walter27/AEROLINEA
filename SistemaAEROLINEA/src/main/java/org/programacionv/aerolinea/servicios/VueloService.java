package org.programacionv.aerolinea.servicios;

import java.util.List;

import org.programacionv.aerolinea.modelo.Vuelo;

public interface VueloService {
	
	public void create (Vuelo vuelo);

	public void update(Vuelo vuelo);

	public void delete(Vuelo vuelo);

	public List<Vuelo> findAll();

}
