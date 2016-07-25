package org.programacionv.aerolinea.servicios;

import java.util.List;

import org.programacionv.aerolinea.modelo.Avion;

public interface AvionService {
	
	public void create (Avion avion);

	public void update(Avion avion);

	public void delete(Avion avion);

	public List<Avion> findAll();

}
