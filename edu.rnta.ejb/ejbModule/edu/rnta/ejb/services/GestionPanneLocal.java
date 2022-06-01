package edu.rnta.ejb.services;

import java.util.List;

import javax.ejb.Local;

import edu.rnta.ejb.entities.Panne;

@Local
public interface GestionPanneLocal {
	public void addPanne(Panne pa);
	public  Panne find(int id);
	public void updatePanne(Panne pa);
	public void deletePanne(Panne pa);
	public List<Panne> findAllPanne();

}
