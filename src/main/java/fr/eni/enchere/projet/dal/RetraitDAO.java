package fr.eni.enchere.projet.dal;

import java.util.List;

import fr.eni.enchere.projet.bo.ArticleEnVente;
import fr.eni.enchere.projet.bo.Retrait;

public interface RetraitDAO {

	public void ajouterRetrait(Retrait retrait);
	
	public void modifierRetrait(Retrait retrait, ArticleEnVente article);
	
	public void deleteRetrait(ArticleEnVente article);
	
	public Retrait afficherRetrait(ArticleEnVente article);
	
}
