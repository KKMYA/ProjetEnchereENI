package fr.eni.enchere.projet.gestion;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.eni.enchere.projet.article.dal.ArticleEnVenteDAO;
import fr.eni.enchere.projet.bo.ArticleEnVente;
import fr.eni.enchere.projet.bo.Categorie;
import fr.eni.enchere.projet.bo.Retrait;
import fr.eni.enchere.projet.dal.CategorieDAO;
import fr.eni.enchere.projet.dal.DAOFactory;
import fr.eni.enchere.projet.dal.RetraitDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;


@WebServlet(urlPatterns = "/AjoutArticle")
@MultipartConfig  
	
public class ServletAjoutArticle extends HttpServlet {
	public static final String IMAGE_FOLDER = "/img";
	
	
	public String uploadPath;
	
	private static final long serialVersionUID = 1L;
	private static ArticleEnVenteDAO articleDAO = DAOFactory.GetArticleDAO();
	private static RetraitDAO retraitDAO = DAOFactory.getRetraitDAO();
	private static CategorieDAO categorieDAO = DAOFactory.getCategorieDAO();
	
	@Override
	public void init() throws ServletException{
		uploadPath = getServletContext().getRealPath(IMAGE_FOLDER);
		System.out.println(uploadPath);
		File uploadDir = new File(uploadPath);
		if(  ! uploadDir.exists()) {
			uploadDir.mkdir();
		}
		
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Categorie>listeDesCategories = new ArrayList<>();
		listeDesCategories = categorieDAO.afficherCategories();
		request.setAttribute("listeDesCategories", listeDesCategories);
		request.getRequestDispatcher("/WEB-INF/AjoutArticle.jsp").forward(request, response);

}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Part part = request.getPart("fichier");
		String name = part.getSubmittedFileName();
		System.out.println("test2"+name);
		String[] splittedFile = name.split("\\.");
		System.out.println(Arrays.asList(splittedFile));
		String extension ="."+ splittedFile[splittedFile.length-1];
		
		String nomArticle = request.getParameter("nom_article");
		String description = request.getParameter("description_article");
		String rueRetrait = request.getParameter("rueRetrait");
		String codePostalRetrait = request.getParameter("code_postal");
		String villeRetrait = request.getParameter("villeRetrait");
		
		
		String dateDebutEnchere = request.getParameter("dateDebut");
		String dateFinEnchere = request.getParameter("dateFin");
		LocalDateTime dateDebut = null;
		LocalDateTime dateFin = null;
		LocalDateTime dateNow = LocalDateTime.now();

		try {
		    if (dateDebutEnchere != null && !dateDebutEnchere.isEmpty() && dateFinEnchere != null && !dateFinEnchere.isEmpty()) {
		        // Convertir la chaîne de date en LocalDateTime
		        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		        dateDebut = LocalDateTime.parse(dateDebutEnchere, formatter);
		        dateFin = LocalDateTime.parse(dateFinEnchere, formatter);

		        if (dateDebut.isBefore(dateNow)) {
		            dateDebut = dateNow;
		        }
		    } else {
		        // Gérez le cas où les paramètres de requête sont nuls ou vides
		        // Vous pouvez afficher un message d'erreur ou effectuer une autre action appropriée.
		    }
		} catch (DateTimeParseException e) {
		    // Gérez les exceptions liées à la conversion des chaînes en LocalDateTime
		    e.printStackTrace();
		}
		
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
			article.setNoUtilisateur(noUtilisateur);
			article.setDateDebutEncheres(dateDebut);
			article.setDateFinEncheres(dateFin);
						
			retrait.setRue(rueRetrait);
			retrait.setCodePostal(codePostalRetrait);
			retrait.setVille(villeRetrait);					
			int noArticle = articleDAO.ajouterArticle(article, noUtilisateur);
			retrait.setNoArticle(noArticle);
			
			String fileName = ArticleEnVente.IMAGE_BASE_NAME+ noArticle + extension ;
			String fullPath = uploadPath + File.separator + fileName;
			part.write(fullPath);
			
			retraitDAO.ajouterRetrait(retrait);
					System.out.println(retrait);
			response.sendRedirect(request.getContextPath() + "/");
			
	        
	    } 
	}

}
