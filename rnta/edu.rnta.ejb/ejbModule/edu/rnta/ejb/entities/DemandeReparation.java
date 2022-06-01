package edu.rnta.ejb.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@SuppressWarnings("serial")
@Entity

public class DemandeReparation implements Serializable{
	@Id
	private int id ;
	
	@Temporal(TemporalType.DATE)
	private Date DateDemande;
	private String NomDepartement;
	private String EtatDemande;
	@OneToMany
	private List<Equipement> equipemnt ;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateDemande() {
		return DateDemande;
	}

	public void setDateDemande(Date dateDemande) {
		DateDemande = dateDemande;
	}

	public String getNomDepartement() {
		return NomDepartement;
	}

	public void setNomDepartement(String nomDepartement) {
		NomDepartement = nomDepartement;
	}

	public String getEtatDemande() {
		return EtatDemande;
	}

	public void setEtatDemande(String etatDemande) {
		EtatDemande = etatDemande;
	}



	@Override
	public String toString() {
		return "DemandeReparation [id=" + id + ", DateDemande=" + DateDemande + ", NomDepartement=" + NomDepartement
				+ ", EtatDemande=" + EtatDemande + ", TypePanne="+ "]";
	}
	

	
	
	

}
