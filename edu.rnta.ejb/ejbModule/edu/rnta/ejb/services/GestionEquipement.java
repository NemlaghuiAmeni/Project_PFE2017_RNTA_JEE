package edu.rnta.ejb.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.rnta.ejb.entities.Equipement;

/**
 * Session Bean implementation class GestionEquipement
 */
@Stateless
@LocalBean
public class GestionEquipement implements GestionEquipementRemote, GestionEquipementLocal {


	@PersistenceContext(unitName = "rntaPU")
	private EntityManager entityManager;
    public GestionEquipement() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void add(Equipement e) {
		entityManager.persist(e);
		
	}

	@Override
	public Equipement findE(int code) {
		Equipement eq=entityManager.find(Equipement.class, code);
		return eq;
	}

	@Override
	public void update(Equipement e) {
		entityManager.merge(e);
		
	}

	@Override
	public void delete(Equipement e) {
		entityManager.remove(entityManager.merge(e));
		
	}

	@Override
	public List<Equipement> findAll() {
		Query q = entityManager.createQuery("select e from Equipement e", Equipement.class);
		return q.getResultList();
	}

}
