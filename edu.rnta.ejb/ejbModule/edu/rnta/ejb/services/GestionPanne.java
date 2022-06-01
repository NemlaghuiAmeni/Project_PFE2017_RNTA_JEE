package edu.rnta.ejb.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.rnta.ejb.entities.Panne;

/**
 * Session Bean implementation class GestionPanne
 */
@Stateless
@LocalBean
public class GestionPanne implements GestionPanneRemote, GestionPanneLocal {

	@PersistenceContext(unitName = "rntaPU")
	private EntityManager entityManager;
    public GestionPanne() {
        // TODO Auto-generated constructor stub
    }
	@Override
	public void addPanne(Panne pa) {
		entityManager.persist(pa);
		
	}
	@Override
	public Panne find(int id) {
		Panne p=entityManager.find(Panne.class, id);
		return p;
	}
	@Override
	public void updatePanne(Panne pa) {
		entityManager.merge(pa);
	}
	@Override
	public void deletePanne(Panne pa) {
		entityManager.remove(entityManager.merge(pa));
		
	}
	@Override
	public List<Panne> findAllPanne() {
		Query q = entityManager.createQuery("select p from Panne p", Panne.class);
		return q.getResultList();
	}

}
