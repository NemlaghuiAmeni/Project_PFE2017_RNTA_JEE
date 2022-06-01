package edu.rnta.web;

	import java.io.Serializable;

	import javax.ejb.EJB;
	import javax.faces.bean.ManagedBean;
	import javax.faces.bean.SessionScoped;

import edu.rnta.ejb.entities.Utilisateur;
import edu.rnta.ejb.services.GestionUtilisateurRemote;
	@ManagedBean
	@SessionScoped
	public class loginManagedBean implements Serializable {

		private static final long serialVersionUID = 1L;
		@EJB
		private GestionUtilisateurRemote utilisateurSessionBean;
		private Utilisateur utilisateur = new Utilisateur();
		private String message = "";
		private String message1 = " ";

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public String login() {
			System.out.println("S'authentifier " + utilisateur);
			String redirectTo=null;
			Utilisateur u = utilisateurSessionBean.loginUtilisateur(utilisateur.getEmail(), utilisateur.getPassword());
			if (u != null) {
				message1 = "Bienvenue " + u.getNom() + " " +u.getPrenom();
				redirectTo="ListUtilisateur";
				 return redirectTo ;
				
			} else
			{
			System.out.println("eurreur");
			 redirectTo= "inscription";
			 //System.out.println(redirectTo);
			 return redirectTo ;
			}
		}

		public Utilisateur getUtilisateur() {
			return utilisateur;
		}

		public void setEtudiant(Utilisateur utilisateur) {
			this.utilisateur = utilisateur;
		}

		public String getMessage1() {
			return message1;
		}

		public void setMessage1(String message1) {
			this.message1 = message1;
		}

		public String deconnexion() {
			utilisateur = new Utilisateur();
			return "Login";
		}
		
		
		public String showLoginPage()
		{
			return "faces?logintest.xhtml";
		}
	}






