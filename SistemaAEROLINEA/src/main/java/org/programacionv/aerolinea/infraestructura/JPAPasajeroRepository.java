package org.programacionv.aerolinea.infraestructura;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.programacionv.aerolinea.modelo.Pasajero;
import org.programacionv.aerolinea.modelo.PasajeroRepository;

@ApplicationScoped
public class JPAPasajeroRepository implements PasajeroRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void create(Pasajero pasajero) {

		em.persist(pasajero);
	}

	@Override
	public void delete(Pasajero pasajero) {

		Pasajero pasajero1 = em.find(Pasajero.class, pasajero.getId());
		em.remove(pasajero1);
		em.flush();
	}

	@Override
	public void update(Pasajero pasajero) {

		em.merge(pasajero);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pasajero> findAll() {

		try {
			List<Pasajero> pasajeros = null;
			pasajeros = em
					.createQuery(
							"select p from org.programacionv.aerolinea.modelo.Pasajero p")
					.getResultList();
			return pasajeros;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
