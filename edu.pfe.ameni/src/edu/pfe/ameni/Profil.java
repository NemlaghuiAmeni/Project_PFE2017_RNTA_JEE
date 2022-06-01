package edu.pfe.ameni;

import java.awt.event.ActionEvent;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.sun.org.glassfish.external.probe.provider.annotations.Probe;

import edu.rnta.ejb.services.ProfilAdmLocal;



/**
 * 
 * @author 
 */
@Stateless
public  class Profil extends AbstractAdm<Profil> implements ProfilAdmLocal,//ProfilAdmRemote{
	@PersistenceContext(unitName = "EJBrntaPU")
	private EntityManager em;

	protected EntityManager getEntityManager() {
		return em;
	}

	public Profil() {
		super();
	}

	public Profil Connexion(Profil pr) {
		Profil profil = null;
		String consult;
		try {
			consult = "FROM Profil p WHERE p.login=?1 and p.pwd=?2";
			Query query = em.createQuery(consult);
			query.setParameter(1, pr.getLogin());
			query.setParameter(2, pr.getPassword());
			@SuppressWarnings("unchecked")
			List<Profil> liste = query.getResultList();
			if (!liste.isEmpty()) {
				profil = liste.get(0);
			}
		} catch (Exception e) {
			 e.printStackTrace();
		}
		

		return profil;
	}

	private Object getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getLogin() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Profil> getListCinProfil(Profil pro) {
		Profil profil = null;
		try {
			Query query = em.createQuery("FROM Profil p WHERE p.cin=?1");
			query.setParameter(1, pro.getId());
			List<Profil> profils = query.getResultList();
			if (!profils.isEmpty()) {
				profil = profils.get(0);
			}
		} catch (Exception e) {
             e.printStackTrace();
		}
		return (List<Profil>) profil;
	}

	private Object getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(ProfilRemote profil) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void edit(ProfilRemote profil) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(ProfilRemote profil) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ProfilRemote find(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProfilRemote> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProfilRemote> findRange(int[] range) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ProfilRemote Connexion(ProfilRemote pr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProfilRemote> getListCinProfil(ProfilRemote pro) {
		// TODO Auto-generated method stub
		return null;
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void create(Profil profil) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void edit(Profil profil) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Probe profil) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Profil find(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

}
