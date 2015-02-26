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
	@Override
	public List<Usager> listerUsagers() {
		Query query = entityManager.createNamedQuery("Usager.findAll"); 
    	List<Usager> usagerList = query.getResultList();
    	
    	for (Usager usager : usagerList) {
			usager.setConnexions(null);
		}
		return usagerList;
	}
	@Override
	public Usager rechercherUsagerParId(Usager usager) {
		Usager returnedUsager; 
		returnedUsager = entityManager.find(Usager.class, usager.getUsagerId());
		
		if (returnedUsager != null) {
			returnedUsager.setConnexions(null);
		}
		return returnedUsager;
	}
	@Override
	public List<Csp> listerCsp() {
		Query query = entityManager.createNamedQuery("Csp.findAll"); 
    	List<Csp> cspList = query.getResultList();
		return cspList;
	}
	@Override
	public Csp rechercherCspParId(Csp csp) {
		return entityManager.find(Csp.class, csp.getCspId());
	}
	@Override
	public List<Quartier> listerQuartiers() {
		Query query = entityManager.createNamedQuery("Quartier.findAll"); 
    	List<Quartier> quartierList = query.getResultList();
		return quartierList;
	}
	@Override
	public Quartier rechercherQuartierParId(Quartier quartier) {
		return entityManager.find(Quartier.class, quartier.getQuartierId());
	}
	@Override
	public List<NiveauFormation> listerNiveauxFormation() {
		Query query = entityManager.createNamedQuery("NiveauFormation.findAll"); 
    	List<NiveauFormation> niveauFormationList = query.getResultList();
		return niveauFormationList;
	}
	@Override
	public NiveauFormation rechercherNiveauFormationParId(
			NiveauFormation niveauFormation) {
		return entityManager.find(NiveauFormation.class, niveauFormation.getNfId());
	}
	@Override
	public void supprimerUsager(Usager usager) {
		usager = entityManager.merge(usager);
		entityManager.remove(usager);
	}
	@Override
	public void supprimerCsp(Csp csp) {
		csp = entityManager.merge(csp);
		entityManager.remove(csp);
	}
	@Override
	public void supprimerQuartier(Quartier quartier) {
		quartier = entityManager.merge(quartier);
		entityManager.remove(quartier);
	}
	@Override
	public void supprimerNiveauFormation(NiveauFormation niveauFormation) {
		niveauFormation = entityManager.merge(niveauFormation);
		entityManager.remove(niveauFormation);
	}
	@Override
	public Usager creerUsager(Usager usager) {
		entityManager.persist(usager);
		return usager;
	}
	@Override
	public Csp creerCsp(Csp csp) {
		entityManager.persist(csp);
		return csp;
	}
	@Override
	public Quartier creerQuartier(Quartier quartier) {
		entityManager.persist(quartier);
		return quartier;
	}
	@Override
	public NiveauFormation creerNiveauFormation(NiveauFormation niveauFormation) {
		entityManager.persist(niveauFormation);
		return niveauFormation;
	}
	@Override
	public Usager modifierUsager(Usager usager) {
		return entityManager.merge(usager);
	}
	@Override
	public Csp modifierCsp(Csp csp) {
		return entityManager.merge(csp);
	}
	@Override
	public Quartier modifierQuartier(Quartier quartier) {
		return entityManager.merge(quartier);
	}
	@Override
	public NiveauFormation modifierNiveauFormation(
			NiveauFormation niveauFormation) {
		return entityManager.merge(niveauFormation);
	}
    
}
