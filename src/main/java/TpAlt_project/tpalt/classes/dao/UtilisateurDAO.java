package TpAlt_project.tpalt.classes.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import TpAlt_project.tpalt.classes.Utilisateur;

public class UtilisateurDAO {
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private Session session = sessionFactory.openSession();

	public Utilisateur get(String id) {
		Criteria criteria = sessionFactory.getSessionFactory().getCurrentSession().createCriteria(Utilisateur.class).add( Restrictions.like("id", id));
		return (Utilisateur) criteria.uniqueResult();
	}
	
	public void save(String name, String email, String password) {
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setEmail(email);
		utilisateur.setName(name);
		utilisateur.setPassword(password);
		
		session.save(utilisateur);
		
	}
	
	public void update(String id, String name, String email, String password) {
		Utilisateur utilisateur = get(id);
		utilisateur.setEmail(email);
		utilisateur.setName(name);
		utilisateur.setPassword(password);
		
		session.update(utilisateur);
	}
	
	
}
