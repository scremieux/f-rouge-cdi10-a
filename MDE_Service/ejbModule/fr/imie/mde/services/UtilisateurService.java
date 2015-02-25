package fr.imie.mde.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.imie.mde.interfaceServices.IUtilisateurService;
import fr.imie.mde.model.Poste;
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
	public List<Site> listerSites() {
		// TODO Auto-generated method stub
		Query query = entityManager.createNamedQuery("Site.findAll"); 
    	List<Site> sites = query.getResultList();
    	for (Site site : sites) {
			site.setSalles(null);
		}

		return sites;
	}

	@Override
	public List<Salle> listerSalles() {
		// TODO Auto-generated method stub
		Query query = entityManager.createNamedQuery("Salle.findAll"); 
    	List<Salle> salles = query.getResultList();
    	for (Salle salle : salles) {
			salle.setPostes(null);
			salle.getSite().setSalles(null);
			System.out.println(salle);
		}
		return salles;
	}
	
	@Override
	public List<Poste> listerPostes() {
		// TODO Auto-generated method stub
		Query query = entityManager.createNamedQuery("Poste.findAll"); 
    	List<Poste> postes = query.getResultList();
    	for (Poste poste : postes) {
			poste.getSalle().setPostes(null);
		}
		return postes;
	}

	@Override
	public List<Structure> listerStructures() {
		// TODO Auto-generated method stub
		Query query = entityManager.createNamedQuery("Structure.findAll"); 
    	List<Structure> structures = query.getResultList();
		return structures;
	}

	@Override
	public List<Salle> listerSallesParSite(Site site) {
		// TODO Auto-generated method stub
		
		Site siteSelected = entityManager.find(Site.class, site.getSiteId());
    	List<Salle> salles = siteSelected.getSalles();
    	for (Salle salle : salles) {
			salle.setPostes(null);
			salle.getSite().setSalles(null);
    	}
		return salles;
	}
}
