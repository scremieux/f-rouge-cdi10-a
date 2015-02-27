package fr.imie.mde.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.imie.mde.interfaceServices.ISiteService;
import fr.imie.mde.model.Poste;
import fr.imie.mde.model.Salle;
import fr.imie.mde.model.Site;
import fr.imie.mde.model.Structure;
@Stateless
@LocalBean
public class SiteService implements ISiteService {
	@PersistenceContext
	EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public SiteService() {
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
	public Site obtenirSite(Site site) {
		// TODO Auto-generated method stub
		site = entityManager.find(Site.class, site.getSiteId());
		List<Salle> salles = site.getSalles();
		
		for (Salle salle : salles) {
			entityManager.detach(salle);
			salle.setPostes(null);
			salle.setSite(null);
		}
		return site;
	}
	
	
	@Override
	public List<Salle> listerSalles() {
		// TODO Auto-generated method stub
		Query query = entityManager.createNamedQuery("Salle.findAll"); 
    	List<Salle> salles = query.getResultList();
    	for (Salle salle : salles) {
			salle.setPostes(null);
			salle.getSite().setSalles(null);
			
		}
		return salles;
	}
	
	@Override
	public Salle obtenirSalle(Salle salle) {
		// TODO Auto-generated method stub
		salle = entityManager.find(Salle.class, salle.getSalleId());
		List<Poste> postes = salle.getPostes();
		for (Poste poste : postes) {
			entityManager.detach(poste);
			poste.setSalle(null);
		}
		salle.getSite().setSalles(null);
		return salle;
	}
	
	@Override
	public List<Poste> listerPostes() {
		// TODO Auto-generated method stub
		Query query = entityManager.createNamedQuery("Poste.findAll"); 
    	List<Poste> postes = query.getResultList();
    	for (Poste poste : postes) {
			poste.getSalle().setPostes(null);
			poste.getSalle().getSite().setSalles(null);
		}
		return postes;
	}

	@Override
	public Poste obtenirPoste(Poste poste) {
		// TODO Auto-generated method stub
		poste = entityManager.find(Poste.class, poste.getPosteId());
		
		Salle salle = poste.getSalle();
		Site site = salle.getSite();
    	site.setSalles(null);
    	salle.setPostes(null);
   
		return poste;
	}
	@Override
	public Site creerSite(Site site) {
		// TODO Auto-generated method stub
		entityManager.persist(site);
		return site;
	}
	@Override
	public Salle creerSalle(Salle salle) {
		// TODO Auto-generated method stub
		entityManager.persist(salle);
		return salle;
	}
	@Override
	public Poste creerPoste(Poste poste) {
		// TODO Auto-generated method stub
		entityManager.persist(poste);
		return poste;
	}
	@Override
	public Site modifierSite(Site site) {
		// TODO Auto-generated method stub
		return entityManager.merge(site);
	}
	@Override
	public Salle modifierSalle(Salle salle) {
		// TODO Auto-generated method stub
		return entityManager.merge(salle);
	}
	@Override
	public Poste modifierPoste(Poste poste) {
		// TODO Auto-generated method stub
		return entityManager.merge(poste);
	}
	@Override
	public void supprimerSite(Site site) {
		// TODO Auto-generated method stub
		site = entityManager.merge(site);
		entityManager.remove(site);
	}
	@Override
	public void supprimerSalle(Salle salle) {
		// TODO Auto-generated method stub
		salle = entityManager.merge(salle);
		entityManager.remove(salle);
	}
	@Override
	public void supprimerPoste(Poste poste) {
		// TODO Auto-generated method stub
		poste = entityManager.merge(poste);
		entityManager.remove(poste);
	}
}
