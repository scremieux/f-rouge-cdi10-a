package fr.imie.mde.services;

import java.sql.Time;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.imie.mde.interfaceServices.ISiteService;
import fr.imie.mde.model.Connexion;
import fr.imie.mde.model.Poste;
import fr.imie.mde.model.Salle;
import fr.imie.mde.model.Site;
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
		Query query = entityManager.createNamedQuery("Site.findAll"); 
    	List<Site> sites = query.getResultList();
//    	for (Site site : sites) {
//			site.setSalles(null);
//		}

		return sites;
	}

	@Override
	public Site obtenirSite(Site site) {
		site = entityManager.find(Site.class, site.getSiteId());
//		List<Salle> salles = site.getSalles();
		
//		for (Salle salle : salles) {
//			entityManager.detach(salle);
//			salle.setSite(null);
//		}
		return site;
	}
	
	
	@Override
	public List<Salle> listerSalles() {
		// TODO Auto-generated method stub
		Query query = entityManager.createNamedQuery("Salle.findAll"); 
    	List<Salle> salles = query.getResultList();
//    	for (Salle salle : salles) {
//			salle.getSite().setSalles(null);
//			
//		}
		return salles;
	}
	
	@Override
	public Salle obtenirSalle(Salle salle) {
		salle = entityManager.find(Salle.class, salle.getSalleId());

//		salle.getSite().setSalles(null);
		return salle;
	}
	
	@Override
	public List<Poste> listerPostes() {
		Query query = entityManager.createNamedQuery("Poste.findAll"); 
    	List<Poste> postes = query.getResultList();

    	return postes;
	}

	@Override
	public Poste obtenirPoste(Poste poste) {
		poste = entityManager.find(Poste.class, poste.getPosteId());
  
		return poste;
	}
	@Override
	public Site creerSite(Site site) {
		entityManager.persist(site);
		return site;
	}
	@Override
	public Salle creerSalle(Salle salle) {
		entityManager.persist(salle);
		return salle;
	}
	@Override
	public Poste creerPoste(Poste poste) {
		entityManager.persist(poste);
		return poste;
	}
	@Override
	public Site modifierSite(Site site) {
		return entityManager.merge(site);
	}
	@Override
	public Salle modifierSalle(Salle salle) {
		return entityManager.merge(salle);
	}
	@Override
	public Poste modifierPoste(Poste poste) {
		return entityManager.merge(poste);
	}
	@Override
	public void supprimerSite(Site site) {
		site = entityManager.merge(site);
		entityManager.remove(site);
	}
	
	@Override
	public void supprimerSalle(Salle salle) {
		salle = entityManager.merge(salle);
		entityManager.remove(salle);
	}
	
	@Override
	public void supprimerPoste(Poste poste) {
		poste = entityManager.merge(poste);
		entityManager.remove(poste);
	}
	
	@Override
	public Poste libererPoste(Poste poste) {
		poste.setPosteDisponible(true);
		Query query = entityManager.createNamedQuery("Connexion.rechercherParPoste").setParameter("poste", poste); 
    	List<Connexion> connexionList = query.getResultList();

		for (Connexion connexion : connexionList) {
			if (connexion.getCnxHeureFin() == null) {
				connexion.setCnxHeureFin(new Time(System.currentTimeMillis()));

				entityManager.merge(connexion);
			}
		}
		poste = entityManager.merge(poste);
		return poste;
	}
	
	@Override
	public List<Poste> obtenirPostesParSalle(Salle salle) {
		Query query = entityManager.createNamedQuery("Poste.rechercherParSalle").setParameter("salle", salle); 
    	List<Poste> posteList = query.getResultList();
		return posteList;
	}

}
