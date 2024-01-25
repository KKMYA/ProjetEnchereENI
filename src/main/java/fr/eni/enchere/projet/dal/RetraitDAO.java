package fr.eni.enchere.projet.dal;

import fr.eni.enchere.projet.bo.ArticleEnVente;
import fr.eni.enchere.projet.bo.Retrait;

public interface RetraitDAO {

	public void ajouterRetrait(Retrait retrait);
	
	public void modifierRetrait(Retrait retrait, ArticleEnVente article);
	
	//public void deleteRetrait(ArticleEnVente article);
	
	public Retrait afficherRetrait(int idArticle);

	void deleteRetrait(int noArticle);
	
}
