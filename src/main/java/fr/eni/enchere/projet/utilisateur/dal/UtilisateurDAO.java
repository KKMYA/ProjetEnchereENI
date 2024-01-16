package fr.eni.enchere.projet.utilisateur.dal;

import fr.eni.enchere.projet.bo.Utilisateur;

public interface UtilisateurDAO {
	public void insert(Utilisateur utilisateur);
	
	public void update(int id);
	
	
	
	public void delete(int id);
	
	
}
