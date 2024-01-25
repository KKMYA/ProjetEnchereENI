package fr.eni.enchere.projet.gestion;

import java.io.IOException;
import java.util.List;

import fr.eni.enchere.projet.bll.CorrespondanceMailID;
import fr.eni.enchere.projet.bll.UserManager;
import fr.eni.enchere.projet.bo.Categorie;
import fr.eni.enchere.projet.dal.CategorieDAO;
import fr.eni.enchere.projet.dal.DAOFactory;
import fr.eni.enchere.projet.utilisateur.dal.UtilisateurDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns= "/panelAdmin")
public class ServletPanelAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategorieDAO categorieDAO = DAOFactory.getCategorieDAO();
	private UtilisateurDAO utilisateurDAO = DAOFactory.getUtilisateurDAO();
	
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    HttpSession session = request.getSession(false);

	    if (session != null) {
	        int idSession = Integer.parseInt(session.getAttribute("noUtilisateur").toString());

	        if (UserManager.checkAdmin(idSession)) {
	            List<Categorie> listeDeCategories = categorieDAO.afficherCategories();
	            request.setAttribute("listeDeCategories", listeDeCategories);
	            request.getRequestDispatcher("WEB-INF/panelAdmin.jsp").forward(request, response);
	        } else {
	            response.sendRedirect(request.getContextPath() + "/");
	        }
	    } else {
	        response.sendRedirect(request.getContextPath() + "/");
	    }
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    HttpSession session = request.getSession(false);
	    
	    int idSession = Integer.parseInt(session.getAttribute("noUtilisateur").toString());

	    if(UserManager.checkAdmin(idSession)==true) {
	        List<Categorie> listeDeCategories = categorieDAO.afficherCategories();
	        request.setAttribute("listeDeCategories", listeDeCategories);

	        if(request.getParameter("userDELETE") != null) {
	            String userMail = request.getParameter("userDELETE").toString();
	            int noUtilisateur = CorrespondanceMailID.recuperationID(userMail);
	            utilisateurDAO.delete(noUtilisateur);
	            response.sendRedirect(request.getContextPath() + "/panelAdmin");
	        } else if(request.getParameter("adminADD") != null) {
	        	String userMail = request.getParameter("adminADD").toString();
	            int noUtilisateur = CorrespondanceMailID.recuperationID(userMail);
	        	utilisateurDAO.adminAdd(noUtilisateur);
	        	response.sendRedirect(request.getContextPath() + "/panelAdmin");
	        } else if(request.getParameter("adminREMOVE") != null) {
	        	String userMail = request.getParameter("adminREMOVE").toString();
	            int noUtilisateur = CorrespondanceMailID.recuperationID(userMail);
	        	utilisateurDAO.adminRemove(noUtilisateur);
	        	response.sendRedirect(request.getContextPath() + "/panelAdmin");
	        } else if(request.getParameter("categorieADD")!=null) {
	            Categorie categorie = new Categorie();
	            String categorieAjout = request.getParameter("categorieADD").toString();
	            categorie.setLibelle(categorieAjout);
	            categorieDAO.ajouterCategorie(categorie);
	            response.sendRedirect(request.getContextPath() + "/panelAdmin");
	        } else if(request.getParameter("categorieChoix")!=null) {
	            int noCategorie = Integer.parseInt(request.getParameter("categorieChoix").toString());
	            categorieDAO.supprimerCategorie(noCategorie);
	            response.sendRedirect(request.getContextPath() + "/panelAdmin");
	        }
	    } else {
	        response.sendRedirect(request.getContextPath() + "/");
	    }
	}			

}
