package edu.rnta.test;

import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;

import edu.rnta.ejb.entities.Utilisateur;
import edu.rnta.ejb.services.GestionUtilisateurRemote;


public class TestGestionUtilisateur {

	private GestionUtilisateurRemote gestionUlilisateurRemote;

	@Before
	public void setUp() {
		try {
			Context context = new InitialContext();
			gestionUlilisateurRemote = (GestionUtilisateurRemote) context
					.lookup("/edu.rnta.web/GestionUtilisateur!edu.rnta.ejb.services.GestionUtilisateurRemote");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testAddUtilisateur() {
		Utilisateur utilisateur1 = new Utilisateur(1, "Hida", "Houcem", "Admin", "Admin", "Hida.houcem@gmail.com",
				"Admin");

		gestionUlilisateurRemote.addUtilisateur(utilisateur1);
		
		Utilisateur utilisateur2 = new Utilisateur(2, "Mejri", "Mohamed", "Admin", "Admin12", "MohamedMejri@insat.tn",
				"Admin");

		gestionUlilisateurRemote.addUtilisateur(utilisateur2);

	}

	@Test
	public void findUtilisateurById() {
		Utilisateur u = gestionUlilisateurRemote.findUtilisateurById(2);
		System.out.println(u.toString());
	}

	@Test
	public void findAllUtilisateurs2() {
		List<Utilisateur> listUtilisateurs = gestionUlilisateurRemote.findAllUtilisateurs();
		for (Utilisateur u : listUtilisateurs)
			System.out.println(u.toString());
	}

	@Test
	public void testUpdateUtilisateur() {
		Utilisateur u = gestionUlilisateurRemote.findUtilisateurById(2);
		u.setNom("fjhh");
		gestionUlilisateurRemote.updateUtilisateur(u);
	}
	@Test
	public void testDeleteUtilisateur(){
	Utilisateur u =  gestionUlilisateurRemote.findUtilisateurById(2);
	gestionUlilisateurRemote.deleteUtilisateur(u);
	}

	@Test
	public void findAllUtilisateurs() {
		List<Utilisateur> listEtudiants = gestionUlilisateurRemote.findAllUtilisateurs();
		for (Utilisateur u : listEtudiants)
			System.out.println(u.toString());
	}
	@Test
	public void testLoginUtilisateur() {
	Utilisateur u = gestionUlilisateurRemote.loginUtilisateur("Hida.houcem@gmail.com","Admin");
	if (u == null) {
	System.out.println("> Login KO....");
	} else {
	System.out.println("> Login OK....");
	System.out.println(u.toString());
	}
	}
	
}
