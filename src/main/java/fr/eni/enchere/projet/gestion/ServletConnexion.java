package fr.eni.enchere.projet.gestion;

import java.io.IOException;

import fr.eni.enchere.projet.bll.LoginDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
		request.getRequestDispatcher("/WEB-INF/Connexion.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String motDePasse =request.getParameter("mot_de_passe");
		
		if(LoginDao.validationConnexion(email, motDePasse)==true) {
			request.getRequestDispatcher("WEB-INF/accueil.jsp").forward(request, response);
			System.out.println("Connexion réussi");
		}
		else {
			
			doGet(request, response);
			System.out.println("connexion échouée");
		}
	}

}
