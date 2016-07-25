package org.programacionv.aerolinea.modelo;

import java.util.List;

public interface AerolineaRepository {
	
	public void create (Aerolinea aerolinea);

	public void update(Aerolinea aerolinea);

	public void delete(Aerolinea aerolinea);

	public List<Aerolinea> findAll();

}
