package edu.rnta.ejb.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.RollbackException;

import org.hibernate.validator.constraints.Email;

import edu.rnta.ejb.entities.Utilisateur;

/**
 * Session Bean implementation class GestionUtilisateur
 */
@Stateless 
public class GestionUtilisateur implements GestionUtilisateurRemote, GestionUtilisateurLocal {
	@PersistenceContext(unitName = "rntaPU")
	private EntityManager em;

	
	@Override
	public void addUtilisateur(Utilisateur u) {
        try 
        {
		
		em.persist(em.merge(u));
       
        }
        catch (RollbackException ex)
        {
        	System.out.println(ex.getMessage());
        }
	}

	@Override
	public void updateUtilisateur(Utilisateur u) {
		em.merge(u);

	}

	@Override
	public Utilisateur findUtilisateurById(int id) {
		Utilisateur utilisateur = em.find(Utilisateur.class, id);
		return utilisateur;
	}

	@Override
	public void deleteUtilisateur(Utilisateur utilisateur) {
		try {
		em.remove(em.merge(utilisateur));
		}
		
		   catch (RollbackException ex)
        {
        	System.out.println(ex.getMessage());
        }

	}

	@Override
	public List<Utilisateur> findAllUtilisateurs() {
		Query q = em.createQuery("select u from Utilisateur u", Utilisateur.class);
		return q.getResultList();

	}
	@Override
	public Utilisateur loginUtilisateur(String mailUtilisateur, String passwordUtilisateur) {
		Utilisateur found = null;
		try {
			String jpql = "select u from Utilisateur u where u.email=:param1 and u.password=:param2";
			Query query = em.createQuery(jpql);
			query.setParameter("param1", mailUtilisateur);
			query.setParameter("param2", passwordUtilisateur);
			found = (Utilisateur) query.getSingleResult();
		} catch (RollbackException ex) {
			System.out.println(ex.getMessage());
			return null;
		}
		return found;
	}
	

	

	

}
