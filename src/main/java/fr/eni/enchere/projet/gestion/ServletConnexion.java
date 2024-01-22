package fr.eni.enchere.projet.gestion;

import java.io.IOException;

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
@WebServlet("/connexion")
public class ServletConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		request.getRequestDispatcher("/WEB-INF/connexion.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String email = request.getParameter("email");
		String motDePasse =request.getParameter("mot_de_passe");
		
		if(Login.validationConnexion(email, motDePasse)==true) {
			
			int noUtilisateur = CorrespondanceMailID.recuperationID(email);
			HttpSession session = request.getSession();
			session.setAttribute("noUtilisateur", noUtilisateur);
			session.setMaxInactiveInterval(300);

			request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
		}
		else {
			
			doGet(request, response);
		}
	}

}
