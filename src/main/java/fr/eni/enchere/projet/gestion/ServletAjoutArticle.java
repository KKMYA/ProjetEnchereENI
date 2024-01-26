package fr.eni.enchere.projet.gestion;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import fr.eni.enchere.projet.article.dal.ArticleEnVenteDAO;
import fr.eni.enchere.projet.bo.ArticleEnVente;
import fr.eni.enchere.projet.bo.Retrait;
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

    @Override
    public void init() throws ServletException {
        uploadPath = getServletContext().getRealPath(IMAGE_FOLDER);
        System.out.println(uploadPath);
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/AjoutArticle.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part part = request.getPart("fichier");
        String name = part.getSubmittedFileName();
        System.out.println("test2" + name);
        String[] splittedFile = name.split("\\.");
        System.out.println(Arrays.asList(splittedFile));
        String extension = "." + splittedFile[splittedFile.length - 1];

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
            article.setNoUtilisateur(noUtilisateur);

            retrait.setRue(rueRetrait);
            retrait.setCodePostal(codePostalRetrait);
            retrait.setVille(villeRetrait);
            int noArticle = articleDAO.ajouterArticle(article, noUtilisateur);
            retrait.setNoArticle(noArticle);

            String fileName = ArticleEnVente.IMAGE_BASE_NAME + noArticle + extension;
            String fullPath = uploadPath + File.separator + fileName;
            part.write(fullPath);

            retraitDAO.ajouterRetrait(retrait);
            System.out.println(retrait);
            response.sendRedirect(request.getContextPath() + "/");


        }
    }

}
