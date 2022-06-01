package edu.rnta.ejb.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.rnta.ejb.entities.DemandeReparation;

/**
 * Session Bean implementation class GestionDemandeReparation
 */
@Stateless
@LocalBean
public class GestionDemandeReparation implements GestionDemandeReparationRemote, GestionDemandeReparationLocal {

	@PersistenceContext(unitName = "rntaPU")
	private EntityManager entityManager;
    public GestionDemandeReparation() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addDemande(DemandeReparation demande) {
		entityManager.persist(demande);

		
	}

	@Override
	public void updateDemandeReparation(DemandeReparation demande) {
		
		entityManager.merge(demande);
	}

	@Override
	public DemandeReparation findDemandeReparationById(int id) {
		DemandeReparation demande = entityManager.find(DemandeReparation.class, id);
		return demande;
	}

	@Override
	public void deleteDemandeReparation(DemandeReparation demande) {
		entityManager.remove(entityManager.merge(demande));
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DemandeReparation> findAllDemandeReparation() {
		Query q = entityManager.createQuery("select d from DemandeReparation d", DemandeReparation.class);
		return q.getResultList();
	}

}
