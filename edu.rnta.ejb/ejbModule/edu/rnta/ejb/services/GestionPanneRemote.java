package edu.rnta.ejb.services;

import java.util.List;

import javax.ejb.Remote;

import edu.rnta.ejb.entities.Panne;

@Remote
public interface GestionPanneRemote {
	public void addPanne(Panne pa);
	public  Panne find(int id);
	public void updatePanne(Panne pa);
	public void deletePanne(Panne pa);
	public List<Panne> findAllPanne();
}
