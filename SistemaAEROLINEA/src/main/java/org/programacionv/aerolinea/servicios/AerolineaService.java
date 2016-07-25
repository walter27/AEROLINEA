package org.programacionv.aerolinea.servicios;

import java.util.List;

import org.programacionv.aerolinea.modelo.Aerolinea;

public interface AerolineaService {
	
	public void create (Aerolinea aerolinea);

	public void update(Aerolinea aerolinea);

	public void delete(Aerolinea aerolinea);

	public List<Aerolinea> findAll();

}
