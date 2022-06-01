package edu.rnta.test;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;

import edu.rnta.ejb.entities.DemandeFourniture;
import edu.rnta.ejb.entities.Utilisateur;

import edu.rnta.ejb.services.DemandeFournitureRemote;
import edu.rnta.ejb.services.DemandeReparation;
import edu.rnta.ejb.services.GestionUtilisateurRemote;

public class TestDemandeFourniture {

	private DemandeFournitureRemote demandeFournitureRemote;

	@Before
	public void setUp() {
		try {
			Context context = new InitialContext();
			demandeFournitureRemote = (DemandeFournitureRemote) context
					.lookup("/edu.rnta.web/DemandeFourniture!edu.rnta.ejb.services.DemandeFournitureRemote");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testAddDemandeFourniture() {
		DemandeFourniture demandeFourniture= new DemandeFourniture(2,new Date(), "plusieurs", "aucours");
		demandeFournitureRemote.addDemandeFourniture(demandeFourniture);
		
	}

	@Test
	public void findDemandeFournitureByCin() {
		DemandeFourniture e = demandeFournitureRemote.findDemandeFournituresById(2);
		System.out.println(e.toString());
	}
	@Test
	public void findDemandeFournitures() {
		List<DemandeFourniture> listdemandeFournitures = demandeFournitureRemote.findAllDemandeFournitures();
		for (DemandeFourniture e : listdemandeFournitures)
			System.out.println(e.toString());
	}
	@Test
	public void testUpdateDemandeFourniture() {
		DemandeFourniture e =  demandeFournitureRemote.findDemandeFournituresById(2);
		e.setEtatDemande("fjhh");
		demandeFournitureRemote.updateDemandeFourniture(e);
}
	@Test
	public void testDemandeFourniture(){
		DemandeFourniture e =  demandeFournitureRemote.findDemandeFournituresById(2);
		demandeFournitureRemote.deleteDemandeFourniture(e);
	}
	@Test
	public void findAllDemandeFournitures() {
		List<DemandeFourniture> listDemandeFournitures = demandeFournitureRemote.findAllDemandeFournitures();
		for (DemandeFourniture e : listDemandeFournitures)
			System.out.println(e.toString());
	
}
}
