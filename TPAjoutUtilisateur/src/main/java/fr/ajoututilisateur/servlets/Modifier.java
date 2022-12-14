package fr.ajoututilisateur.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.ajoututilisateur.bo.Utilisateur;
import fr.ajoututilisateur.dal.DAOFactory;
import fr.ajoututilisateur.dal.UtilisateurDAO;


@WebServlet("/Modifier")
public class Modifier extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int identifiant = Integer.parseInt(request.getParameter("identifiant"));
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");


		
		
		UtilisateurDAO utilisateurDAO = DAOFactory.getUtilisateurDAO();
		utilisateurDAO.update(new Utilisateur(identifiant,nom,prenom,email));

		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/page/confirmation.jsp");
		rd.forward(request, response);
		
	}
	

}
