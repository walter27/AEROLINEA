package org.programacionv.aerolinea.infraestructura;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.programacionv.aerolinea.modelo.Reserva;
import org.programacionv.aerolinea.modelo.ReservaRepository;

@ApplicationScoped
public class JPAReservaRepository implements ReservaRepository {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public void create(Reserva reserva) {

		em.persist(reserva);
	}

	@Override
	public void delete(Reserva reserva) {

		Reserva reserva1 = em.find(Reserva.class, reserva.getId());
		em.remove(reserva1);
		em.flush();
	}

	@Override
	public void update(Reserva reserva) {

		em.merge(reserva);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Reserva> findAll() {

		try {
			List<Reserva> reservas = null;
			reservas = em
					.createQuery(
							"select p from org.programacionv.aerolinea.modelo.Reserva p")
					.getResultList();
			return reservas;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
