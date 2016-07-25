package org.programacionv.aerolinea.infraestructura;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.programacionv.aerolinea.modelo.Vuelo;
import org.programacionv.aerolinea.modelo.VueloRepository;

@ApplicationScoped
public class JPAVueloRepository implements VueloRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void create(Vuelo vuelo) {

		em.persist(vuelo);
	}

	@Override
	public void delete(Vuelo vuelo) {

		Vuelo Vuelo1 = em.find(Vuelo.class, vuelo.getId());
		em.remove(Vuelo1);
		em.flush();
	}

	@Override
	public void update(Vuelo vuelo) {

		em.merge(vuelo);
	}

	@SuppressWarnings("unchecked")
	@Override
	
	public List<Vuelo> findAll() {

		try {
			List<Vuelo> Vuelos = null;
			Vuelos = em
					.createQuery(
							"select p from org.programacionv.Vuelo.modelo.Vuelo p")
					.getResultList();
			return Vuelos;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
