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
public class Equipement implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int Id;
	private String Catégorie;
	private String Libelle;
	@Temporal(TemporalType.DATE)

	private Date DateAccusation;
	private String fournisseur;
	@OneToMany(mappedBy = "equipement")
	private List<Pannes> pannes;

	public Equipement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getCatégorie() {
		return Catégorie;
	}

	public void setCatégorie(String catégorie) {
		Catégorie = catégorie;
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

	@Override
	public String toString() {
		return "Equipement [Id=" + Id + ", Catégorie=" + Catégorie + ", Libelle=" + Libelle + ", DateAccusation="
				+ DateAccusation + ", fournisseur=" + fournisseur + "]";
	}

	public List<Pannes> getPannes() {
		return pannes;
	}

	public void setPannes(List<Pannes> pannes) {
		this.pannes = pannes;
	}

}
