package tpalt.projet_tpalt.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import manager.UtilisateurManager;
import objects.Utilisateur;

@Controller
public class InscriptionController {

	@Autowired
	UtilisateurManager utilisateurManager;
	
	@RequestMapping(value="/inscription.htm")
	private String inscription(HttpServletResponse response, HttpServletRequest request) {
		
		String name = request.getParameter("name");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		System.out.println(name);
		System.out.println(lastName);
		System.out.println(email);
		System.out.println(password);
		
		utilisateurManager.creer(name, lastName, email, password);
		
		
		
		return "connexion";
	}
	
}
