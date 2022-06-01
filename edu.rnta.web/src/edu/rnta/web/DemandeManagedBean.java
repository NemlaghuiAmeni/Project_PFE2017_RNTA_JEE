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

import edu.rnta.ejb.entities.DemandeReparation;
import edu.rnta.ejb.entities.Panne;
import edu.rnta.ejb.services.GestionDemandeReparationRemote;
import edu.rnta.ejb.services.GestionPanneRemote;
@SuppressWarnings("serial")
@ManagedBean(value = "demandeManagedBean")
@ViewScoped
public class DemandeManagedBean implements Serializable{
	@EJB
	private GestionPanneRemote gestionPanneRemote;
	private Panne p = new Panne();
	private List<Panne> pa = new ArrayList<Panne>();
	@EJB
	private GestionDemandeReparationRemote gestionDemandeRepataionRemote;
	private DemandeReparation demande = new DemandeReparation();
	private String message = "";
	private String Action;
	private int selectIddemande;
	private List<DemandeReparation> demandes = new ArrayList<DemandeReparation>();

	@PostConstruct
	public void init() {

		demandes = gestionDemandeRepataionRemote.findAllDemandeReparation();
		pa = gestionPanneRemote.findAllPanne();

	}

	public GestionPanneRemote getGestionPanneRemote() {
		return gestionPanneRemote;
	}

	public void setGestionPanneRemote(GestionPanneRemote gestionPanneRemote) {
		this.gestionPanneRemote = gestionPanneRemote;
	}

	public Panne getP() {
		return p;
	}

	public void setP(Panne p) {
		this.p = p;
	}

	public List<Panne> getPa() {
		return pa;
	}

	public void setPa(List<Panne> pa) {
		this.pa = pa;
	}

	public GestionDemandeReparationRemote getGestionDemandeRepataionRemote() {
		return gestionDemandeRepataionRemote;
	}

	public void setGestionDemandeRepataionRemote(GestionDemandeReparationRemote gestionDemandeRepataionRemote) {
		this.gestionDemandeRepataionRemote = gestionDemandeRepataionRemote;
	}

	public DemandeReparation getDemande() {
		return demande;
	}

	public void setDemande(DemandeReparation demande) {
		this.demande = demande;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getAction() {
		return Action;
	}

	public void setAction(String action) {
		Action = action;
	}

	public int getSelectIddemande() {
		return selectIddemande;
	}

	public void setSelectIddemande(int selectIddemande) {
		this.selectIddemande = selectIddemande;
	}

	public List<DemandeReparation> getDemandes() {
		return demandes;
	}

	public void setDemandes(List<DemandeReparation> demandes) {
		this.demandes = demandes;
	}
	// ajouter demande
		public void Sauvegarder() {
			try{
			DemandeReparation dr = gestionDemandeRepataionRemote.findDemandeReparationById(demande.getId_demande());
			gestionDemandeRepataionRemote.addDemande(demande);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Demande:", "Ajouté avec succès!"));
			} 
			catch (Exception e) {

				e.printStackTrace();
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_FATAL, "Ajout:", "erreur !"));
			}
			demande = new DemandeReparation();
			demandes = gestionDemandeRepataionRemote.findAllDemandeReparation();
		}
		// ajout panne
		public void enregistrer() {

			try {
				demande = gestionDemandeRepataionRemote.findDemandeReparationById(selectIddemande);
				p.setDemandereparation(demande);
				gestionPanneRemote.addPanne(p);
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Panne:", "Ajouté avec succès!"));
			} catch (Exception e) {

				e.printStackTrace();
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_FATAL, "Ajout:", "erreur !"));
			}
			p = new Panne();
			pa = gestionPanneRemote.findAllPanne();
		}

		public void selectDemande() {
			System.out.println("Select id_demande" + demande);
		}
		public void supprimer() {
			try {
				System.out.println("HEREEE!!!");
				DemandeReparation demandeR = gestionDemandeRepataionRemote
						.findDemandeReparationById(demande.getId_demande());
				gestionDemandeRepataionRemote.deleteDemandeReparation(demandeR);
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Suppression", "Supprimée avec succès"));
			} catch (Exception e) {
				e.printStackTrace();
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_FATAL, "Suppression", "erreur de suppression"));
			}
			demandes = gestionDemandeRepataionRemote.findAllDemandeReparation();
			demande = new DemandeReparation();
		}
		public void modifier() {
			try {
				gestionDemandeRepataionRemote.updateDemandeReparation(demande);
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Modification:", "Modifié avec succès!"));
			} catch (Exception e) {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_FATAL, "Modification:", "erreur de modification!"));
			}

			demande = new DemandeReparation();
			demandes = gestionDemandeRepataionRemote.findAllDemandeReparation();
		}

		public void update() {
			System.out.println("modifier demande" + demande);
			gestionDemandeRepataionRemote.updateDemandeReparation(demande);
			demandes = gestionDemandeRepataionRemote.findAllDemandeReparation();
			demande = new DemandeReparation();

		}
}
