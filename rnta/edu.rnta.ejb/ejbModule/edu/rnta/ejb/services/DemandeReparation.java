package edu.rnta.ejb.services;
import java.sql.SQLException;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import edu.rnta.ejb.services.DemandeReparation;

import org.hibernate.validator.constraints.Email;

@Stateless
public  class DemandeReparation implements DemandeReparationRemote, DemandeReparationLocal {

	@PersistenceContext(name = "rntaPU")
	private EntityManager em;


		@Override
		public void addDemandeReparation(DemandeReparation demandeReparation) {
			em.persist(demandeReparation);
			
		}

		@Override
		public void updateReparation(DemandeReparation demandeReparation) {
			em.merge(demandeReparation);
			
		}

		//@Override
	//	public DemandeReparation findDemandeReparationById(int id) {
			//return em.find(DemandeReparation.class,id);
		//	return null;
		//}

		@Override
		public void deleteReparation(DemandeReparation DemandeReparation) {
			em.remove(em.merge(DemandeReparation));
			
		}


		@Override
		public List findAllDemandeReparations() {
			Query q = em.createQuery("select e from DemandeFourniture e", DemandeFournitureService.class);
			return q.getResultList();
			
		}


		@Override
		public DemandeReparation findDemandeReparationById(int id) {
			return em.find(DemandeReparation.class,id);
			//return null;
			
		}

		@Override
		public List<DemandeReparation> findAllDemandeReparation() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void addDemandeReparation(Object demandeReparation) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateUtilisateur(Object DemandeReparation) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void deleteDemandeReparation(Object DemandeReparation) {
			// TODO Auto-generated method stub
			
		}

		

}

