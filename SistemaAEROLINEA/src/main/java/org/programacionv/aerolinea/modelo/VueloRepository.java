package org.programacionv.aerolinea.modelo;

import java.util.List;

public interface VueloRepository {
	
	public void create (Vuelo Vuelo);

	public void update(Vuelo Vuelo);

	public void delete(Vuelo Vuelo);

	public List<Vuelo> findAll();

}
