package edu.rnta.ejb.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class DemandeFourniture implements Serializable{
	@Id
	private int id ;
	
	@Temporal(TemporalType.DATE)
	private Date DateEnvoie;
	private String Quantite;
	private String EtatDemande;
   
	
	public DemandeFourniture() {
		super();
	}

	public DemandeFourniture(int id, Date dateEnvoie, String quantite, String etatDemande) {
		super();
		this.id = id;
		DateEnvoie = dateEnvoie;
		Quantite = quantite;
		EtatDemande = etatDemande;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateEnvoie() {
		return DateEnvoie;
	}

	public void setDateEnvoie(Date dateEnvoie) {
		DateEnvoie = dateEnvoie;
	}


	public String getEtatDemande() {
		return EtatDemande;
	}

	public void setEtatDemande(String etatDemande) {
		EtatDemande = etatDemande;
	}
    
	public String getQuantite() {
		return Quantite;
	}

	public void setQuantite(String quantite) {
		Quantite = quantite;
	}

	@Override
	public String toString() {
		return "DemandeFourniture [id=" + id + ", DateEnvoie=" + DateEnvoie + ", Quantite=" + Quantite
				+ ", EtatDemande=" + EtatDemande + "]";
	}




	

}


