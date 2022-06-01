package edu.rnta.ejb.services;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.rnta.ejb.entities.DemandeFourniture;

@Stateless
public  class DemandeFournitureService implements DemandeFournitureRemote, DemandeFournitureLocal {

	@PersistenceContext(name = "rntaPU")
	private EntityManager em;

	@Override

	public void addDemandeFourniture (DemandeFourniture demandeFourniture) {
		em.persist(demandeFourniture);

	}

	@Override
	public void updateDemandeFourniture(DemandeFourniture DemandeFourniture) {
		em.merge(DemandeFourniture);
	}

	public DemandeFourniture findDemandeFournitureById(int id) {
		return em.find(DemandeFourniture.class, id);
	}

	@Override
	public void deleteDemandeFourniture (DemandeFourniture DemandeFourniture) {
		em.remove(em.merge(DemandeFourniture));
	}

	@Override
	public List<DemandeFourniture> findAllDemandeFournitures() {
		
		Query q = em.createQuery("select d from DemandeFourniture d", DemandeFourniture.class);
		return q.getResultList();
	}

	@Override
	public DemandeFourniture findDemandeFournituresById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

		


	

	
}
