package edu.rnta.ejb.entities;

import java.io.Serializable;

import javax.persistence.*;
import javax.persistence.ManyToOne;
@Entity
public class Pannes implements Serializable{
	@Id
	private int Id;
	private String Descriptif;
	private String Type;
	@ManyToOne
	private Equipement equipement;
	public Pannes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getDescriptif() {
		return Descriptif;
	}
	public void setDescriptif(String descriptif) {
		Descriptif = descriptif;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	@Override
	public String toString() {
		return "Pannes [Id=" + Id + ", Descriptif=" + Descriptif + ", Type=" + Type + "]";
	}
	public Equipement getEquipement() {
		return equipement;
	}
	public void setEquipement(Equipement equipement) {
		this.equipement = equipement;
	}
	
	
}
