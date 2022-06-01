package edu.rnta.ejb.services;


import java.util.List;

import javax.ejb.Local;

import edu.rnta.ejb.entities.DemandeFourniture;




@Local
public interface DemandeFournitureLocal {
	public void addDemandeFourniture(DemandeFourniture demandeFourniture); 
	public void updateDemandeFourniture(DemandeFourniture demandeFourniture); 
	public DemandeFourniture findDemandeFournitureById(int cin); 
	public void deleteDemandeFourniture(DemandeFourniture DemandeFourniture); 
	public List<DemandeFourniture> findAllDemandeFournitures(); 
	
	
}
