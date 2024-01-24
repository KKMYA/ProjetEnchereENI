package fr.eni.enchere.projet.dal;

import java.util.List;

import fr.eni.enchere.projet.bo.Categorie;

public interface CategorieDAO {

	public int ajouterCategorie(Categorie categorie);
	
	public int quelleCategorie(String categorie);
	
	public void supprimerCategorie(int noCategorie);
	
	public void modifierCategorie(Categorie categorie, int noCategorie);
	
	public List<Categorie> afficherCategories();

	public String getNomCategorie(int noCategorie);
}
