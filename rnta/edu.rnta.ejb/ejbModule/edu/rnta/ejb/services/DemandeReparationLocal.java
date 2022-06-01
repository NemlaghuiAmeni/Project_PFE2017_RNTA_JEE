package edu.rnta.ejb.services;

import java.util.List;

import javax.ejb.Local;
import edu.rnta.ejb.services.DemandeReparation;;



@Local
public interface DemandeReparationLocal {
	
	public void addDemandeReparation(DemandeReparation demandeReparation);
	public void updateReparation(DemandeReparation demandeReparation);
	public DemandeReparation findDemandeReparationById(int id);
	public void deleteReparation(DemandeReparation DemandeReparation);
	public List<DemandeReparation> findAllDemandeReparations();
	List<DemandeReparation> findAllDemandeReparation();
	}


