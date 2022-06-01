package edu.pfe.ameni;

import java.util.List;

public interface ProfilRemote{

		 void create(ProfilRemote profil);

		    void edit(ProfilRemote profil);

		    void remove(ProfilRemote profil);

		    ProfilRemote find(Object id);

		    List<ProfilRemote> findAll();

		    List<ProfilRemote> findRange(int[] range);

		    int count();
		    ProfilRemote Connexion(ProfilRemote pr);
		    List<ProfilRemote> getListCinProfil(ProfilRemote pro);
	    
	}



