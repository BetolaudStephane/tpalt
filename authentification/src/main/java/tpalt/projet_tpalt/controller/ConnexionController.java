package tpalt.projet_tpalt.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import form.ConnexionForm;
import manager.UtilisateurManager;
import objects.Utilisateur;



@Controller
@RequestMapping(value="/connexion.htm")
public class ConnexionController {
	@Autowired
	UtilisateurManager utilisateurManager;

	@RequestMapping(method = RequestMethod.GET)
	public String formBackingObject(ModelMap model, HttpServletRequest request) {

		return "connexion";
	}

	@RequestMapping(method = RequestMethod.POST)
	public Map<String, String>  onSubmit(@ModelAttribute("command") @Validated ConnexionForm connexionForm,
			BindingResult bindingResult, HttpServletRequest request, ModelMap model) {

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		System.out.println(email);
		System.out.println(password);
		Map<String, String> retour = new HashMap<String, String>();

		List<Utilisateur> listeUtilisateur = utilisateurManager.getListeUtilisateur();

		for(Utilisateur user : listeUtilisateur) {
			if(user.getEmail().equals(email) && user.getPassword().equals(password)) {
				retour.put("id", user.getId().toString());
				retour.put("email", user.getEmail());
				retour.put("password", user.getPassword());
			}
		}

		return retour;


	}




}
