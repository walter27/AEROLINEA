package org.programacionv.aerolinea.modelo;

import java.util.List;

public interface AvionRepository {

	public void create (Avion avion);

	public void update(Avion avion);

	public void delete(Avion avion);

	public List<Avion> findAll();

}
