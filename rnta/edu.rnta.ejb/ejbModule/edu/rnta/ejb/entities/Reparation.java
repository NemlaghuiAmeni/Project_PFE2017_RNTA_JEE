package edu.rnta.ejb.entities;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import edu.rnta.ejb.entities.Pannes;

public class Reparation implements Serializable {
	@Id
	private int id;
	private  Date date_reparation;
	private  String etat_reparation;
	private  int periode_reparation;
	@OneToOne
	 private DemandeReparation demandeReparation ;
	////@ManyToOne(mappedBy="reparation" ,fetch=FetchType.EAGER)
	//private List<Pannes> pannes;

	
	public Reparation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate_reparation() {
		return date_reparation;
	}
	public void setDate_reparation(Date date_reparation) {
		this.date_reparation = date_reparation;
	}
	public String getEtat_reparation() {
		return etat_reparation;
	}
	public void setEtat_reparation(String etat_reparation) {
		this.etat_reparation = etat_reparation;
	}
	public int getPeriode_reparation() {
		return periode_reparation;
	}
	public void setPeriode_reparation(int periode_reparation) {
		this.periode_reparation = periode_reparation;
	}
	

}
