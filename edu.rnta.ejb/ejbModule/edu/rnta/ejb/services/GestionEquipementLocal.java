package edu.rnta.ejb.services;

import java.util.List;

import javax.ejb.Local;

import edu.rnta.ejb.entities.Equipement;

@Local
public interface GestionEquipementLocal {
	public void add(Equipement e);
	public  Equipement findE(int code);

	public void update(Equipement e);
	public void delete(Equipement e);
	public List<Equipement> findAll();

}
