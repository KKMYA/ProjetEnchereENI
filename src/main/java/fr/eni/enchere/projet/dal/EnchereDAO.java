package fr.eni.enchere.projet.dal;

import java.util.List;

import fr.eni.enchere.projet.bo.ArticleEnVente;
import fr.eni.enchere.projet.bo.Enchere;
import fr.eni.enchere.projet.bo.Utilisateur;

public interface EnchereDAO {

	public List<Enchere> selectEnchere();

	public void insert(Utilisateur utilisateur, Enchere enchere, ArticleEnVente articleEnVente);

	public List<Enchere> selectEnchereById(int no_utilisateur);
	
	
	
}
