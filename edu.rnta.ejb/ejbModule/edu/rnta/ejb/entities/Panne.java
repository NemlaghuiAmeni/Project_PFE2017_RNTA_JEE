package edu.rnta.ejb.entities;

import java.io.Serializable;

import javax.persistence.*;
import javax.persistence.ManyToOne;
@Entity
public class Panne implements Serializable{
	@Id
	private int id_panne;
	private String Type_panne;
	private String Descriptif;
	
	@ManyToOne
	private DemandeReparation demandereparation;
	@ManyToOne
	private Equipement equipement;
	public Panne() {
		super();
	}
	
	

	public Panne(int id_panne, String type_panne, String descriptif) {
		super();
		this.id_panne = id_panne;
		Type_panne = type_panne;
		Descriptif = descriptif;
	}



	public int getId_panne() {
		return id_panne;
	}
	public void setId_panne(int id_panne) {
		this.id_panne = id_panne;
	}
	public String getType_panne() {
		return Type_panne;
	}
	public void setType_panne(String type_panne) {
		Type_panne = type_panne;
	}
	public DemandeReparation getDemandereparation() {
		return demandereparation;
	}
	public void setDemandereparation(DemandeReparation demandereparation) {
		this.demandereparation = demandereparation;
	}
	public Equipement getEquipement() {
		return equipement;
	}
	public void setEquipement(Equipement equipement) {
		this.equipement = equipement;
	}
	
	public String getDescriptif() {
		return Descriptif;
	}



	public void setDescriptif(String descriptif) {
		Descriptif = descriptif;
	}


	@Override
	public String toString() {
		return "Panne [id_panne=" + id_panne + ", Type_panne=" + Type_panne + ", Descriptif=" + Descriptif
				+ ", demandereparation=" + demandereparation + ", equipement=" + equipement + "]";
	}
	
	
}
