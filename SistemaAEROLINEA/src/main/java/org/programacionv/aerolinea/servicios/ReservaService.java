package org.programacionv.aerolinea.servicios;

import java.util.List;
import org.programacionv.aerolinea.modelo.Reserva;

public interface ReservaService {
	
	public void create(Reserva reserva);

	public void update(Reserva reserva);

	public void delete(Reserva reserva);

	public List<Reserva> findAll();

}
