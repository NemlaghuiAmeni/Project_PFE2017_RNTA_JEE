package edu.rnta.ejb.services;


import java.util.List;

import javax.ejb.Remote;

import edu.rnta.ejb.entities.DemandeFourniture;
@Remote
public interface DemandeFournitureRemote {
	public void addDemandeFourniture(DemandeFourniture DemandeFourniture); 
	public void updateDemandeFourniture(DemandeFourniture DemandeFourniture);  
	public void deleteDemandeFourniture(DemandeFourniture DemandeFourniture); 
	public List<DemandeFourniture> findAllDemandeFournitures(); 
	public DemandeFourniture findDemandeFournituresById(int id) ;
}


