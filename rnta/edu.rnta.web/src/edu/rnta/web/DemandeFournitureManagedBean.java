package edu.rnta.web;

	import java.io.Serializable;
	import java.util.ArrayList;
import java.util.Date;
import java.util.List;

	import javax.annotation.PostConstruct;
	import javax.ejb.EJB;
	import javax.faces.bean.ManagedBean;
	import javax.faces.bean.ViewScoped;

import edu.rnta.ejb.entities.DemandeFourniture;
	import edu.rnta.ejb.services.DemandeFournitureRemote;

	@ManagedBean(name = "DemandeFournitureManagedBean")
	@ViewScoped
	public class DemandeFournitureManagedBean implements Serializable {
		
		@EJB
		private DemandeFournitureRemote service;
		
		private List<DemandeFourniture>liste;
		
		private DemandeFourniture demande;
		
		private DemandeFourniture selectedDemande;
		
		private boolean showAddDForm=false,showModifForm=false;
		
		@PostConstruct
		public void init()
		{
			liste=service.findAllDemandeFournitures();
			demande=new DemandeFourniture();
			selectedDemande=new DemandeFourniture();
		}
		
		public String showListeFournitures()
		{
			return "ListeFournitures.xhtml";
		}
		
		public void showModifForm(DemandeFourniture d)
		{
			showModifForm=true;
			selectedDemande=d;
		}
		
		public String modifDemande()
		{
			showModifForm=false;
			service.updateDemandeFourniture(selectedDemande);
			return "ListeFournitures.xhtml";
		}
        public DemandeFourniture getSelectedDemande() {
			return selectedDemande;
		}

		public void setSelectedDemande(DemandeFourniture selectedDemande) {
			this.selectedDemande = selectedDemande;
		}

		public boolean isShowModifForm() {
			return showModifForm;
		}

		public void setShowModifForm(boolean showModifForm) {
			this.showModifForm = showModifForm;
		}

		public String doAddDemancde()
        {
        	demande.setDateEnvoie(new Date());
        	service.addDemandeFourniture(demande);
        	showAddDForm=false;
            return "ListFourniture.xhtml";
        }
        
        public String deleteDemande(DemandeFourniture d)
        {
        	service.deleteDemandeFourniture(d);
        	return "ListFourniture.xhtml";
        }
		public DemandeFournitureRemote getService() {
			return service;
		}

		public void setService(DemandeFournitureRemote service) {
			this.service = service;
		}

		public List<DemandeFourniture> getListe() {
			return liste;
		}

		public void setListe(List<DemandeFourniture> liste) {
			this.liste = liste;
		}
		
		public void showAddPage()
		{
			showAddDForm=true;
		}

		public boolean isShowAddDForm() {
			return showAddDForm;
		}

		public void setShowAddDForm(boolean showAddDForm) {
			this.showAddDForm = showAddDForm;
		}

		public DemandeFourniture getDemande() {
			return demande;
		}

		public void setDemande(DemandeFourniture demande) {
			this.demande = demande;
		}
		
		
		

}
