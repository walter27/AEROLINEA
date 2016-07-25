package org.programacionv.aerolinea.infraestructura;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.programacionv.aerolinea.modelo.Tarifa;
import org.programacionv.aerolinea.modelo.TarifaRepository;

public class JPATarifaRepository implements TarifaRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void create(Tarifa tarifa) {

		em.persist(tarifa);
	}

	@Override
	public void delete(Tarifa tarifa) {

		Tarifa tarifa1 = em.find(Tarifa.class, tarifa.getId());
		em.remove(tarifa1);
		em.flush();
	}

	@Override
	public void update(Tarifa tarifa) {

		em.merge(tarifa);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tarifa> findAll() {

		try {
			List<Tarifa> tarifas = null;
			tarifas = em
					.createQuery(
							"select p from org.programacionv.aerolinea.modelo.Tarifa p")
					.getResultList();
			return tarifas;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
