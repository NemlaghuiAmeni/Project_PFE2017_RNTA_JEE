package edu.rnta.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import edu.rnta.ejb.entities.Utilisateur;
import edu.rnta.ejb.services.GestionUtilisateurRemote;

@ManagedBean(name = "utilisateurManagedBean")
public class UtilisateurManagedBean implements Serializable {
	@EJB
	private GestionUtilisateurRemote utilisateurSessionBean;
	private Utilisateur utilisateur = new Utilisateur();
	private Utilisateur selectUser = new Utilisateur();
	private String message = "";
	private List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
    private boolean showList=false;
    private boolean showModif=false;
	@PostConstruct
	public void init() {
		utilisateurs = utilisateurSessionBean.findAllUtilisateurs();
	} // Methode d’ajout

	
	public void showList()
	{
		showList=true;
	}
	public String showAddPage()
	{
		return "redirect=faces?Formulairexhtml.xhtml";
	}
	public void showModif(Utilisateur u)
	{
		selectUser=u;
		showModif=true;
		showList=true;
	}
	
	public void modifierUser()
	{
		utilisateurSessionBean.updateUtilisateur(selectUser);
	}
	
	public void reset()
	{
		utilisateur=new Utilisateur();
	}
	
	public String inscrire() {

		
	       utilisateurSessionBean.addUtilisateur(utilisateur);
			System.out.println("Ajout Utilisateur " + utilisateur);
		
		utilisateur = new Utilisateur();
		init();
		
		return "faces?login.xhtml";
	}
	public String sauvegarder() {

	
	       utilisateurSessionBean.addUtilisateur(utilisateur);
			System.out.println("Ajout Utilisateur " + utilisateur);
		
		utilisateur = new Utilisateur();
		init();
		
		return "faces?ListUtilisateur.xhtml";
	}

	// Methode de selection
	public void selectEtudiant() {
		System.out.println("Select Utilisateur " + utilisateur);
	}

	// Methode de mise a jour
	public void update(Utilisateur utilisateur) {
	
		utilisateurSessionBean.updateUtilisateur(utilisateur);
		init();
	}

	// Methode de suppression
	public String delete(Utilisateur utilisateur) {
	
		System.err.println(utilisateur);
		utilisateurSessionBean.deleteUtilisateur(utilisateur);
		init();
		return "faces?ListUtilisateur.xhtml";
	
	}

	
	
	public String showListUtilisateur()
	{
		return "faces?ListUtilisateur.xhtml";
	}
	public UtilisateurManagedBean() {
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}

	public void setUtilisateur(List<Utilisateur> Utilisateurs) {
		this.utilisateurs = utilisateurs;
	}


	public GestionUtilisateurRemote getUtilisateurSessionBean() {
		return utilisateurSessionBean;
	}


	public void setUtilisateurSessionBean(GestionUtilisateurRemote utilisateurSessionBean) {
		this.utilisateurSessionBean = utilisateurSessionBean;
	}


	public boolean isShowList() {
		return showList;
	}


	public void setShowList(boolean showList) {
		this.showList = showList;
	}


	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}


	public Utilisateur getSelectUser() {
		return selectUser;
	}


	public void setSelectUser(Utilisateur selectUser) {
		this.selectUser = selectUser;
	}


	public boolean isShowModif() {
		return showModif;
	}


	public void setShowModif(boolean showModif) {
		this.showModif = showModif;
	}
	
}
