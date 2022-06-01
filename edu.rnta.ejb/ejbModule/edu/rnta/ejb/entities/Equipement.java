package edu.rnta.ejb.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Equipement implements Serializable {

	@Id
	private int code;
	private String Cat�gorie;
	private String Libelle;
	@Temporal(TemporalType.DATE)
    private Date DateAccusation;
	private String fournisseur;
	@OneToMany(mappedBy = "equipement",cascade = { CascadeType.ALL})
	private List<Panne> pannes;
	public Equipement() {
		super();
	}
	
	public Equipement(int code, String cat�gorie, String libelle, Date dateAccusation, String fournisseur) {
		super();
		this.code = code;
		Cat�gorie = cat�gorie;
		Libelle = libelle;
		DateAccusation = dateAccusation;
		this.fournisseur = fournisseur;
	}

	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getCat�gorie() {
		return Cat�gorie;
	}
	public void setCat�gorie(String cat�gorie) {
		Cat�gorie = cat�gorie;
	}
	public String getLibelle() {
		return Libelle;
	}
	public void setLibelle(String libelle) {
		Libelle = libelle;
	}
	public Date getDateAccusation() {
		return DateAccusation;
	}
	public void setDateAccusation(Date dateAccusation) {
		DateAccusation = dateAccusation;
	}
	public String getFournisseur() {
		return fournisseur;
	}
	public void setFournisseur(String fournisseur) {
		this.fournisseur = fournisseur;
	}
	public List<Panne> getPannes() {
		return pannes;
	}
	public void setPannes(List<Panne> pannes) {
		this.pannes = pannes;
	}
	@Override
	public String toString() {
		return "Equipement [code=" + code + ", Cat�gorie=" + Cat�gorie + ", Libelle=" + Libelle + ", DateAccusation="
				+ DateAccusation + ", fournisseur=" + fournisseur + ", pannes=" + pannes + "]";
	}

}