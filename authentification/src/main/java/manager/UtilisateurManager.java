package manager;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import dao.UtilisateurDAO;
import objects.Utilisateur;

public class UtilisateurManager {
	
	@Autowired
	UtilisateurDAO utilisateurDAO;
	
	public Utilisateur getUtilisateurById(String id) {
		
		return utilisateurDAO.getUtilisateurById(id);
	}
	
	public List<Utilisateur> getListeUtilisateur(){
		return utilisateurDAO.getListeUtilisateur();
	}

	
	public void creer(String name, String lastName, String email, String password) {
			System.out.println("coucou du manager");
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setEmail(email);
		utilisateur.setLastName(lastName);
		utilisateur.setName(lastName);
		utilisateur.setPassword(password);
		
		 utilisateurDAO.save(utilisateur);
	}
	
	public Utilisateur modifier(String id, String name, String lastName, String email, String password) {
		
		Utilisateur utilisateur = getUtilisateurById(id);
		utilisateur.setEmail(email);
		utilisateur.setLastName(lastName);
		utilisateur.setName(lastName);
		utilisateur.setPassword(password);
		
		 utilisateurDAO.update(utilisateur);
		
		return utilisateur;
	}
	
}
