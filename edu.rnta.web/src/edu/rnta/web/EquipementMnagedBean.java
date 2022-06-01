package edu.rnta.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import edu.rnta.ejb.entities.Equipement;
import edu.rnta.ejb.services.GestionEquipementRemote;

@SuppressWarnings("serial")
@ManagedBean(value = "equipementManagedBean")
@ViewScoped
public class EquipementMnagedBean implements Serializable {
	private static final long serialVersionUID = 1L;
	@EJB
	private GestionEquipementRemote gestionEquipementRemote;
	private Equipement equ = new Equipement();
	private String message = "";
	private int SelectCode;
	private List<Equipement> eqs = new ArrayList<Equipement>();

	@PostConstruct
	public void init() {
		eqs = gestionEquipementRemote.findAll();

	}

	public void Sauvegarder() {
		try {
			Equipement eq = gestionEquipementRemote.findE(equ.getCode());
			gestionEquipementRemote.add(equ);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Equipement", "Equipement ajouté avec succès!"));

		} catch (Exception e) {

			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, "Ajout:", "erreur!"));
		}
		equ = new Equipement();
		init();
	}

	public void supprimer() {
		try {
			System.out.println("HEREEE!!!");
			Equipement eq = gestionEquipementRemote.findE(equ.getCode());
			gestionEquipementRemote.delete(eq);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Suppression", "Supprimée avec succès"));
		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, "Suppression", "erreur de suppression"));
		}
		init();

		eqs = gestionEquipementRemote.findAll();
	}

	public GestionEquipementRemote getGestionEquipementRemote() {
		return gestionEquipementRemote;
	}

	public void setGestionEquipementRemote(GestionEquipementRemote gestionEquipementRemote) {
		this.gestionEquipementRemote = gestionEquipementRemote;
	}

	public Equipement getEqu() {
		return equ;
	}

	public void setEqu(Equipement equ) {
		this.equ = equ;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getSelectCode() {
		return SelectCode;
	}

	public void setSelectCode(int selectCode) {
		SelectCode = selectCode;
	}

	public List<Equipement> getEqs() {
		return eqs;
	}

	public void setEqs(List<Equipement> eqs) {
		this.eqs = eqs;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
