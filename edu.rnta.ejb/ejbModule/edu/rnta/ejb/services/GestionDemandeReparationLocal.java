package edu.rnta.ejb.services;

import java.util.List;

import javax.ejb.Local;

import edu.rnta.ejb.entities.DemandeReparation;

@Local
public interface GestionDemandeReparationLocal {
	public void addDemande(DemandeReparation demande);
	public void updateDemandeReparation(DemandeReparation demande);
	public DemandeReparation  findDemandeReparationById(int id);
	public void deleteDemandeReparation(DemandeReparation demande);
	public List<DemandeReparation>findAllDemandeReparation();

}
