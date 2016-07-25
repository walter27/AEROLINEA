package org.programacionv.aerolinea.infraestructura;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.programacionv.aerolinea.modelo.Aeropuerto;
import org.programacionv.aerolinea.modelo.AeropuertoRepository;

@ApplicationScoped
public class JPAAeropuertoRepository implements AeropuertoRepository {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public void create(Aeropuerto aeropuerto) {

		em.persist(aeropuerto);
	}

	@Override
	public void delete(Aeropuerto aeropuerto) {

		Aeropuerto aeropuerto1 = em.find(Aeropuerto.class, aeropuerto.getId());
		em.remove(aeropuerto1);
		em.flush();
	}

	@Override
	public void update(Aeropuerto aeropuerto) {

		em.merge(aeropuerto);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Aeropuerto> findAll() {

		try {
			List<Aeropuerto> aeropuertos = null;
			aeropuertos = em
					.createQuery(
							"select p from org.programacionv.aerolinea.modelo.Aeropuerto p")
					.getResultList();
			return aeropuertos;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
