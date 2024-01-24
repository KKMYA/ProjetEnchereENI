package fr.eni.enchere.projet.gestion;

import java.io.IOException;
import java.util.List;

import fr.eni.enchere.projet.bll.UserManager;
import fr.eni.enchere.projet.bo.Categorie;
import fr.eni.enchere.projet.dal.CategorieDAO;
import fr.eni.enchere.projet.dal.DAOFactory;
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
	
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    HttpSession session = request.getSession(false);

	    if (session != null) {
	        int idSession = Integer.parseInt(session.getAttribute("noUtilisateur").toString());

	        if (UserManager.checkAdmin(idSession)) {
	            System.out.println("salut cv");
	            List<Categorie> listeDeCategories = categorieDAO.afficherCategories();
	            request.setAttribute("listeDeCategories", listeDeCategories);
	            System.out.println(listeDeCategories);
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
			request.getRequestDispatcher("WEB-INF/panelAdmin.jsp").forward(request, response);
			

		}else {
			response.sendRedirect(request.getContextPath() + "/");
		}
	}			

}
