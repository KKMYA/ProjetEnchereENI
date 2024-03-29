package fr.eni.enchere.projet.article.dal;

import java.util.List;

import fr.eni.enchere.projet.bo.ArticleEnVente;

public interface ArticleEnVenteDAO {
	
	public int ajouterArticle(ArticleEnVente articleEnVente, int noUtilisateur);
	
	public void supprimerArticle(int noArticle);
	
	public void modifierNomArticle(ArticleEnVente articleEnVente);
	
	public void modifierDescriptionArticle(ArticleEnVente articleEnVente);
	
	public ArticleEnVente afficherArticleSelonIdArticle(int noArticle);
	
	public List<ArticleEnVente> afficherArticleSelonIdVendeur(int noUtilisateur);
	
	public List<ArticleEnVente> afficherArticleEnVente();

}
