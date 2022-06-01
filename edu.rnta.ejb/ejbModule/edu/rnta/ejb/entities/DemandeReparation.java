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
	private int id_demande;
	private String Nom_departement;
	
	@Temporal(TemporalType.DATE)
    private Date Date_envoie;
	private String Description;
	
	@OneToMany(mappedBy="demandereparation",fetch=FetchType.EAGER,cascade = { CascadeType.ALL})
     private List<Panne> panne;

	

	public DemandeReparation() {
		super();
	}

	public int getId_demande() {
		return id_demande;
	}

	public void setId_demande(int id_demande) {
		this.id_demande = id_demande;
	}

	public String getNom_departement() {
		return Nom_departement;
	}

	public void setNom_departement(String nom_departement) {
		Nom_departement = nom_departement;
	}

	public Date getDate_envoie() {
		return Date_envoie;
	}

	public void setDate_envoie(Date date_envoie) {
		Date_envoie = date_envoie;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public List<Panne> getPanne() {
		return panne;
	}

	public void setPanne(List<Panne> panne) {
		this.panne = panne;
	}

	@Override
	public String toString() {
		return "DemandeReparation [id_demande=" + id_demande + ", Nom_departement=" + Nom_departement + ", Date_envoie="
				+ Date_envoie + ", Description=" + Description + ", panne=" + panne + "]";
	}
	
	
	

}
