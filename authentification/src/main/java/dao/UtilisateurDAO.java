package dao;


import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import objects.Utilisateur;

@Repository @Transactional @EnableTransactionManagement
public class UtilisateurDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	public Class<Utilisateur> getReferenceClass(){
		return Utilisateur.class;
	}
	
	public List<Utilisateur> getListeUtilisateur(){
		
		return (List<Utilisateur>)sessionFactory.getCurrentSession().createCriteria(getReferenceClass()).list();
	}
	
	
	public Utilisateur getUtilisateurById(String id) {
		return (Utilisateur)sessionFactory.getCurrentSession().createCriteria((getReferenceClass())).add(Restrictions.eq("id", id));
	}
	
	public void save(Utilisateur utilisateur) {
		System.out.println("coucou");
		sessionFactory.getCurrentSession().save(utilisateur);
	}
	
	public Utilisateur update(Utilisateur utilisateur) {
		
		
		sessionFactory.getCurrentSession().update(utilisateur);
		
		return utilisateur;
	}
	
}
