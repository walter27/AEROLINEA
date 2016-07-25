package org.programacionv.aerolinea.infraestructura;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.programacionv.aerolinea.modelo.Aerolinea;
import org.programacionv.aerolinea.modelo.AerolineaRepository;

@ApplicationScoped
public class JPAAerolineaRepository implements AerolineaRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void create(Aerolinea aerolinea) {

		em.persist(aerolinea);
	}

	@Override
	public void delete(Aerolinea aerolinea) {

		Aerolinea aerolinea1 = em.find(Aerolinea.class, aerolinea.getId());
		em.remove(aerolinea1);
		em.flush();
	}

	@Override
	public void update(Aerolinea aerolinea) {

		em.merge(aerolinea);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Aerolinea> findAll() {

		try {
			List<Aerolinea> aerolineas = null;
			aerolineas = em
					.createQuery(
							"select p from org.programacionv.aerolinea.modelo.Aerolinea p")
					.getResultList();
			return aerolineas;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
