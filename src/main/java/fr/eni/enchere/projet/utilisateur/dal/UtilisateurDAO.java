package fr.eni.enchere.projet.utilisateur.dal;

import fr.eni.enchere.projet.bo.Utilisateur;

public interface UtilisateurDAO {
	public void insert(Utilisateur utilisateur);
	
	public void delete(int id);
	
	public Utilisateur select(int id);

	

	void updatePseudo(Utilisateur utilisateur);
}
