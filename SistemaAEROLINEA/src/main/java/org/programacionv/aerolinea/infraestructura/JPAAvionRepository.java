package org.programacionv.aerolinea.infraestructura;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.programacionv.aerolinea.modelo.Avion;
import org.programacionv.aerolinea.modelo.AvionRepository;

@ApplicationScoped
public class JPAAvionRepository implements AvionRepository{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public void create(Avion avion) {

		em.persist(avion);
	}

	@Override
	public void delete(Avion avion) {

		Avion avion1 = em.find(Avion.class, avion.getId());
		em.remove(avion1);
		em.flush();
	}

	@Override
	public void update(Avion avion) {

		em.merge(avion);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Avion> findAll() {

		try {
			List<Avion> aviones = null;
			aviones = em
					.createQuery(
							"select p from org.programacionv.aerolinea.modelo.Avion p")
					.getResultList();
			return aviones;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
