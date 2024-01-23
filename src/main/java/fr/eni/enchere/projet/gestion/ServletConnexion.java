package fr.eni.enchere.projet.gestion;

import java.io.IOException;

import javax.xml.stream.Location;

import fr.eni.enchere.projet.bll.CorrespondanceMailID;
import fr.eni.enchere.projet.bll.Login;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletConnexion
 */
@WebServlet(urlPatterns = "/connexion")
public class ServletConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		if(session != null && session.getAttribute("noUtilisateur") != null) {
			request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);

		}
		else {
			request.getRequestDispatcher("/WEB-INF/connexion.jsp").forward(request, response);

		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String email = request.getParameter("email");
		String motDePasse =request.getParameter("mot_de_passe");
		
		
		
		if(Login.validationConnexion(email, motDePasse)==true) {
			
			int noUtilisateur = CorrespondanceMailID.recuperationID(email);
			HttpSession session = request.getSession();
			
			session.setAttribute("noUtilisateur", noUtilisateur);
			session.setMaxInactiveInterval(300);

	        response.sendRedirect(request.getContextPath() + "/");
		}
		else {
			
			doGet(request, response);
		}
	}

}
