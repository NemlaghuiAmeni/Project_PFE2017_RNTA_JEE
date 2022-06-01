package edu.rnta.ejb.services;

import java.util.List;

import javax.ejb.Remote;

import edu.rnta.ejb.entities.Utilisateur;

@Remote
public interface GestionUtilisateurRemote {

	public void addUtilisateur(Utilisateur utilisateur);
	public void updateUtilisateur(Utilisateur utilisateur);
	public Utilisateur findUtilisateurById(int id);
	public void deleteUtilisateur(Utilisateur utilisateur);
	public List<Utilisateur> findAllUtilisateurs();
	public Utilisateur loginUtilisateur(String login, String password);
	}



