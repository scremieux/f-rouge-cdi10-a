package fr.imie.mde.services;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.imie.mde.interfaceServices.ILoginService;
import fr.imie.mde.model.Connexion;
import fr.imie.mde.model.Motif;
import fr.imie.mde.model.Poste;
import fr.imie.mde.model.Usager;
import fr.imie.mde.model.Utilisateur;

/**
 * Service EJB dédié à la gestion des logins.
 * @author P42
 * @version 1.0
 */
@Stateless
@LocalBean
public class LoginService implements ILoginService {
	@PersistenceContext
	EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public LoginService() {
        super();
    }
	/*@Override
	public Boolean verifLogin(Utilisateur util) {
		// TODO Auto-generated method stub
		Boolean utilAuth = false;
		String loginUtilAVerif = util.getUtilLogin();
		String mdpUtilAVerif = util.getUtilMdp();
		String loginUtilisateur = null;
		String mdpUtilisateur = null;
		
		Query query = entityManager.createNamedQuery("Utilisateur.findAll"); 
		List<Utilisateur> utilisateurs = query.getResultList();
    	for (Utilisateur utilisateur : utilisateurs) {
    		loginUtilisateur = utilisateur.getUtilLogin();
    		mdpUtilisateur = utilisateur.getUtilMdp();

    		if ((loginUtilAVerif.equals(loginUtilisateur)) && (mdpUtilAVerif.equals(mdpUtilisateur))){
    			utilAuth = true;
    		}
		}
		return utilAuth;
	}*/
	
	@Override
	public Utilisateur verifLogin(Utilisateur util) {
		// TODO Auto-generated method stub
		Utilisateur utilAuth = new Utilisateur();
		String loginUtilAVerif = util.getUtilLogin();
		String mdpUtilAVerif = util.getUtilMdp();
		String loginUtilisateur = null;
		String mdpUtilisateur = null;
		
		Query query = entityManager.createNamedQuery("Utilisateur.findAll"); 
		List<Utilisateur> utilisateurs = query.getResultList();
    	for (Utilisateur utilisateur : utilisateurs) {
    		loginUtilisateur = utilisateur.getUtilLogin();
    		mdpUtilisateur = utilisateur.getUtilMdp();

    		if ((loginUtilAVerif.equals(loginUtilisateur)) && (mdpUtilAVerif.equals(mdpUtilisateur))){
    			utilAuth = utilisateur;
    		}
		}
		return utilAuth;
	}

	
}
