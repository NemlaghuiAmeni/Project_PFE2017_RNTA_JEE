package edu.rnta.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;

import edu.rnta.ejb.entities.DemandeReparation;
import edu.rnta.ejb.entities.Equipement;
import edu.rnta.ejb.entities.Panne;
import edu.rnta.ejb.services.GestionDemandeReparationRemote;
import edu.rnta.ejb.services.GestionEquipementRemote;
import edu.rnta.ejb.services.GestionPanneRemote;

public class Main {
	private GestionDemandeReparationRemote m;
	private GestionPanneRemote m1;
	private GestionEquipementRemote m2;
	@Before
	public void setUp(){
		
		try  
		{   Context context = new InitialContext(); 
	           m=(GestionDemandeReparationRemote )context.lookup("/edu.rnta.web/GestionDemandeReparation!edu.rnta.ejb.services.GestionDemandeReparationRemote");
	           m1=(GestionPanneRemote)context.lookup("/edu.rnta.web/GestionPanne!edu.rnta.ejb.services.GestionPanneRemote");
	           m2=(GestionEquipementRemote)context.lookup("/edu.rnta.web/GestionEquipement!edu.rnta.ejb.services.GestionEquipementRemote");
	           }

	catch (NamingException e) 
	{    e.printStackTrace();   } 
}

	@Test
	public void testAddDemande1() {
		DemandeReparation dem = new DemandeReparation();
		dem.setId_demande(1);
		dem.setNom_departement("2");
		Calendar calendar = Calendar.getInstance();
         calendar.set(2015, 03,02);
         dem.setDate_envoie(calendar.getTime());
	    dem.setDescription("clavier en panne");
	    m.addDemande(dem);
	}
	@Test
	public void testAdddemandeetpanne(){
		DemandeReparation d =new DemandeReparation();
		d.setId_demande(2);
		d.setNom_departement("infomequanique");
		Calendar calendar = Calendar.getInstance();
         calendar.set(2016, 02,07);
         d.setDate_envoie(calendar.getTime());
	    d.setDescription("ecron noir");
	    ArrayList<Panne> p=new ArrayList<Panne>();
	    Panne  p1 =new Panne(2,"interne","clavier");
	    p1.setDemandereparation(d);
	    p.add(p1);
	    d.setPanne(p);
	    m.addDemande(d);
	    
		
		
	}

	@Test
	public void testAddequipent(){
		Equipement e= new 	Equipement(12345,"sss","dd",new Date(2017 ,02,01),"Hp");
		m2.add(e);
		
	}
	@Test
	public void testAddequipementetpanne(){
		Equipement eq1 =new Equipement(145678487,"bddb","ssaa",new Date(2017,11,12),"asus");
	    ArrayList<Panne> listpanne=new ArrayList<Panne>();
		Panne p2 =new Panne(8,"externe","ecron");
		p2.setEquipement(eq1);
		listpanne.add(p2);
		eq1.setPannes(listpanne);
	
         m2.add(eq1);
		
		
		
	}
	@Test
	public void teseUpdatedemande(){
		DemandeReparation dr=m.findDemandeReparationById(1);
		dr.setNom_departement("mequanique");
		m.updateDemandeReparation(dr);
	}
	@Test
	public void teseDeletdemande(){
		DemandeReparation d =m.findDemandeReparationById(1);
		m.deleteDemandeReparation(d);
		System.out.print("Demande supprimé...");
	}
	@Test
	public void findAllDemande(){
	     List<DemandeReparation> listdemande = m.findAllDemandeReparation();
		for(DemandeReparation d: listdemande)
		System.out.println(d.toString());
		}
	@Test
	public void findAllPanne(){
	     List<Panne> listp =m1.findAllPanne();
		for(Panne p: listp)
		System.out.println(p.toString());
		}
	@Test
	public void findAllEquipement(){
	     List<Equipement> listeq =m2.findAll();
		for(Equipement eq: listeq)
		System.out.println(eq.toString());
		}
}
