package edu.rnta.ejb.services;

import java.util.List;

import javax.ejb.Remote;

import edu.rnta.ejb.services.DemandeReparation;



@Remote
public interface DemandeReparationRemote<DemandeReparation> {
	
	public void addDemandeReparation(DemandeReparation demandeReparation);
	public void updateUtilisateur(DemandeReparation DemandeReparation);
	public DemandeReparation findDemandeReparationById(int id);
	public void deleteDemandeReparation(DemandeReparation DemandeReparation);
	public List<DemandeReparation> findAllDemandeReparations();
	}


