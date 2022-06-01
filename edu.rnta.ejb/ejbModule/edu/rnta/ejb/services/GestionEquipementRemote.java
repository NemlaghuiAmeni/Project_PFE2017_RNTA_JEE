package edu.rnta.ejb.services;

import java.util.List;

import javax.ejb.Remote;

import edu.rnta.ejb.entities.Equipement;

@Remote
public interface GestionEquipementRemote {
	public void add(Equipement e);
	public  Equipement findE(int code);

	public void update(Equipement e);
	public void delete(Equipement e);
	public List<Equipement> findAll();

}
