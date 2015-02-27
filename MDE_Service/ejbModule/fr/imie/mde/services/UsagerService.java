package fr.imie.mde.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.imie.mde.interfaceServices.IUsagerService;
import fr.imie.mde.model.Csp;
import fr.imie.mde.model.NiveauFormation;
import fr.imie.mde.model.Quartier;
import fr.imie.mde.model.Usager;

/**
 * Service EJB dédié à la gestion des usagers.
 * @author P42
 * @version 1.0
 */
@Stateless
@LocalBean
public class UsagerService implements IUsagerService {
	@PersistenceContext
	EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public UsagerService() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see IUsagerService#listerUsagers()
	 */
    @Override
	public List<Usager> listerUsagers() {
		Query query = entityManager.createNamedQuery("Usager.findAll"); 
    	List<Usager> usagerList = query.getResultList();
		return usagerList;
	}

	/**
	 * @see IUsagerService#rechercherUsagerParId(Usager usager)
	 */
	@Override
	public Usager rechercherUsagerParId(Usager usager) {
		Usager returnedUsager; 
		returnedUsager = entityManager.find(Usager.class, usager.getUsagerId());
		
		return returnedUsager;
	}

	/**
	 * @see IUsagerService#listerNiveauxCsp()
	 */
	@Override
	public List<Csp> listerCsp() {
		Query query = entityManager.createNamedQuery("Csp.findAll"); 
    	List<Csp> cspList = query.getResultList();
		return cspList;
	}

	/**
	 * @see IUsagerService#rechercherCspParId(Csp csp)
	 */
	@Override
	public Csp rechercherCspParId(Csp csp) {
		return entityManager.find(Csp.class, csp.getCspId());
	}
	
	/**
	 * @see IUsagerService#listerQuartiers()
	 */
	@Override
	public List<Quartier> listerQuartiers() {
		Query query = entityManager.createNamedQuery("Quartier.findAll"); 
    	List<Quartier> quartierList = query.getResultList();
		return quartierList;
	}

	/**
	 * @see IUsagerService#rechercherQuartierParId(Quartier quartier)
	 */
	@Override
	public Quartier rechercherQuartierParId(Quartier quartier) {
		return entityManager.find(Quartier.class, quartier.getQuartierId());
	}
	
	/**
	 * @see IUsagerService#listerNiveauxFormation()
	 */
	@Override
	public List<NiveauFormation> listerNiveauxFormation() {
		Query query = entityManager.createNamedQuery("NiveauFormation.findAll"); 
    	List<NiveauFormation> niveauFormationList = query.getResultList();
		return niveauFormationList;
	}
	
	/**
	 * @see IUsagerService#rechercherNiveauFormationParId(NiveauFormation niveauFormation)
	 */
	@Override
	public NiveauFormation rechercherNiveauFormationParId(NiveauFormation niveauFormation) {
		return entityManager.find(NiveauFormation.class, niveauFormation.getNfId());
	}

	/**
	 * @see IUsagerService#supprimerUsager(Usager usager)
	 */
	@Override
	public void supprimerUsager(Usager usager) {
		usager = entityManager.merge(usager);
		entityManager.remove(usager);
	}
	
	/**
	 * @see IUsagerService#supprimerCsp(Csp csp)
	 */
	@Override
	public void supprimerCsp(Csp csp) {
		csp = entityManager.merge(csp);
		entityManager.remove(csp);
	}

	/**
	 * @see IUsagerService#supprimerQuartier(Quartier quartier)
	 */
	@Override
	public void supprimerQuartier(Quartier quartier) {
		quartier = entityManager.merge(quartier);
		entityManager.remove(quartier);
	}

	/**
	 * @see IUsagerService#supprimerNiveauFormation(NiveauFormation niveauFormation)
	 */
	@Override
	public void supprimerNiveauFormation(NiveauFormation niveauFormation) {
		niveauFormation = entityManager.merge(niveauFormation);
		entityManager.remove(niveauFormation);
	}

	/**
	 * @see IUsagerService#creerUsager(Usager usager)
	 */
	@Override
	public Usager creerUsager(Usager usager) {
		entityManager.persist(usager);
		return usager;
	}

	/**
	 * @see IUsagerService#creerCsp(Csp csp)
	 */
	@Override
	public Csp creerCsp(Csp csp) {
		entityManager.persist(csp);
		return csp;
	}

	/**
	 * @see IUsagerService#creerQuartier(Quartier quartier)
	 */
	@Override
	public Quartier creerQuartier(Quartier quartier) {
		entityManager.persist(quartier);
		return quartier;
	}

	/**
	 * @see IUsagerService#creerNiveauFormation(NiveauFormation niveauFormation)
	 */
	@Override
	public NiveauFormation creerNiveauFormation(NiveauFormation niveauFormation) {
		entityManager.persist(niveauFormation);
		return niveauFormation;
	}

	/**
	 * @see IUsagerService#modifierUsager(Usager usager)
	 */
	@Override
	public Usager modifierUsager(Usager usager) {
		return entityManager.merge(usager);
	}
	
	/**
	 * @see IUsagerService#modifierCsp(Csp csp)
	 */
	@Override
	public Csp modifierCsp(Csp csp) {
		return entityManager.merge(csp);
	}
	
	/**
	 * @see IUsagerService#modifierQuartier(Quartier quartier)
	 */
	@Override
	public Quartier modifierQuartier(Quartier quartier) {
		return entityManager.merge(quartier);
	}
	
	/**
	 * @see IUsagerService#modifierNiveauFormation(NiveauFormation niveauFormation)
	 */
	@Override
	public NiveauFormation modifierNiveauFormation(NiveauFormation niveauFormation) {
		return entityManager.merge(niveauFormation);
	}    
}
