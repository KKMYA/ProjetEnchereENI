package fr.eni.enchere.projet.utilisateur.dal;

import java.sql.SQLException;

import fr.eni.enchere.projet.bo.Utilisateur;

public interface UtilisateurDAO {
	
	public void insert(Utilisateur utilisateur);
	
	public void delete(int id);
	
	public Utilisateur select(int id) throws SQLException;

	public void updatePseudo(Utilisateur utilisateur);

	public void updateNom(Utilisateur utilisateur);

	public void updatePrenom(Utilisateur utilisateur);
	
	public void updateEmail(Utilisateur utilisateur);
	
	public void updateTelephone(Utilisateur utilisateur);
	
	public void updateRue(Utilisateur utilisateur);
	
	public void updateCodePostal(Utilisateur utilisateur);
	
	public void updateVille(Utilisateur utilisateur);
	
	public void updateMotDePasse(Utilisateur utilisateur);
}
