package fr.imie.mde.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.imie.mde.interfaceServices.IUtilisateurService;
import fr.imie.mde.model.Poste;
import fr.imie.mde.model.Requete;
import fr.imie.mde.model.Salle;
import fr.imie.mde.model.Site;
import fr.imie.mde.model.Structure;
@Stateless
@LocalBean
public class UtilisateurService implements IUtilisateurService {
	@PersistenceContext
	EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public UtilisateurService() {
        // TODO Auto-generated constructor stub
    }

	

	@Override
	public List<Requete> listerRequetes() {
		// TODO Auto-generated method stub
		Query query = entityManager.createNamedQuery("Requete.findAll"); 
    	List<Requete> requetes = query.getResultList();
		return requetes;
	}

	@Override
	public Requete creerRequete(Requete requete) {
		// TODO Auto-generated method stub
		entityManager.persist(requete);
		return requete;
	}
}
