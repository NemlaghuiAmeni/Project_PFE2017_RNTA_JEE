package edu.rnta.test;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;

import edu.rnta.ejb.entities.Utilisateur;
import edu.rnta.ejb.services.GestionDemandeReparation;
import edu.rnta.ejb.services.GestionDemandeReparationRemote;
import edu.rnta.ejb.services.GestionUtilisateurRemote;

public class TestDemandeReparation{



	@Before
	public void setUp() {
		try {
			Context context = new InitialContext();
			GestionDemandeReparationRemote repartionservice= (GestionDemandeReparationRemote) context
					.lookup("/edu.rnta.web/GestionUtilisateur!edu.rnta.ejb.services.GestionUtilisateurRemote");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	
}
