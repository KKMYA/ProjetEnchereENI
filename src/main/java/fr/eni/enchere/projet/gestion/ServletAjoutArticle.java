package fr.eni.enchere.projet.gestion;

import java.io.IOException;

import fr.eni.enchere.projet.article.dal.ArticleEnVenteDAO;
import fr.eni.enchere.projet.bo.ArticleEnVente;
import fr.eni.enchere.projet.bo.Retrait;
import fr.eni.enchere.projet.dal.DAOFactory;
import fr.eni.enchere.projet.dal.RetraitDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet(urlPatterns = "/AjoutArticle")
public class ServletAjoutArticle extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static ArticleEnVenteDAO articleDAO = DAOFactory.GetArticleDAO();
	private static RetraitDAO retraitDAO = DAOFactory.getRetraitDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/AjoutArticle.jsp").forward(request, response);

}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nomArticle = request.getParameter("nom_article");
		String description = request.getParameter("description_article");
		String rueRetrait = request.getParameter("rueRetrait");
		String codePostalRetrait = request.getParameter("code_postal");
		String villeRetrait = request.getParameter("villeRetrait");
		
		int prixInitial = Integer.parseInt(request.getParameter("prix_initial_de_vente"));
		
		ArticleEnVente article = new ArticleEnVente();
		Retrait retrait = new Retrait();
		
		
	    HttpSession session = request.getSession(false); // Récupérer la session sans en créer une nouvelle
	    
	    if (session != null && session.getAttribute("noUtilisateur") != null) {
	    	int noUtilisateur = Integer.parseInt(session.getAttribute("noUtilisateur").toString());
	        session.getAttribute("noUtilisateur");
			int categorieIndex = Integer.valueOf(request.getParameter("categorieChoix"));
			article.setNoCategorie(categorieIndex);
			article.setMiseAPrix(prixInitial);
			article.setNomArticle(nomArticle);
			article.setDescription(description);
			System.out.println(noUtilisateur);
			article.setNoUtilisateur(noUtilisateur);
						
			retrait.setRue(rueRetrait);
			retrait.setCodePostal(codePostalRetrait);
			retrait.setVille(villeRetrait);					
			int noArticle = articleDAO.ajouterArticle(article, noUtilisateur);
			retrait.setNoArticle(noArticle);
			
			retraitDAO.ajouterRetrait(retrait);
					
			response.sendRedirect("/WEB-INF/index.jsp");
			
	        
	    } else {
	        // Gérer le cas où la session n'existe pas ou ne contient pas l'ID
	    }

	}

}
