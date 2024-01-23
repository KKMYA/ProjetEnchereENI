package fr.eni.enchere.projet.gestion;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.projet.bll.IdentificationPseudo;
import fr.eni.enchere.projet.bo.Utilisateur;
import fr.eni.enchere.projet.dal.DAOFactory;
import fr.eni.enchere.projet.utilisateur.dal.UtilisateurDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

	/**
	 * Servlet implementation class ServletAffichageProfil
	 */
	@WebServlet("/affichageProfil")
	public class ServletAffichageProfil extends HttpServlet {
		private static final long serialVersionUID = 1L;
		UtilisateurDAO utilisateurdao = DAOFactory.getUtilisateurDAO();
		
		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession(false); // Récupérer la session sans en créer une nouvelle
			if (session != null && session.getAttribute("noUtilisateur") != null) {
				int idSession = Integer.parseInt(session.getAttribute("noUtilisateur").toString());
				//IdentificationPseudo.identification(idSession);
				System.out.println(idSession);
				
				try {
				
				Utilisateur utilisateur =	utilisateurdao.select(idSession);
				System.out.println(utilisateur);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			request.getRequestDispatcher("WEB-INF/affichageProfil.jsp").forward(request, response);;
			
			
		}
	
		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doGet(request, response);
		}
	
	}
