package fr.imie.mde.services;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.imie.mde.interfaceServices.IConnexionService;
import fr.imie.mde.model.Connexion;
import fr.imie.mde.model.Motif;
import fr.imie.mde.model.Poste;
import fr.imie.mde.model.Usager;

/**
 * Service EJB dédié à la gestion des connexions.
 * @author P42
 * @version 1.0
 */
@Stateless
@LocalBean
public class ConnexionService implements IConnexionService {
	@PersistenceContext
	EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public ConnexionService() {
        super();
    }

	/**
	 * @see IConnexionService#listerConnexions()
	 */
    @Override
	public List<Connexion> listerConnexions() {
		Query query = entityManager.createNamedQuery("Connexion.findAll"); 
    	List<Connexion> connexionList = query.getResultList();
    	//********Partie Maxime************
    	for (Connexion connexion : connexionList) {
    		Poste poste = new Poste();
    		poste = connexion.getPoste();
    		entityManager.detach(poste);
//    		poste.getSalle().getSite().setSalles(null);
//    		poste.getSalle().setPostes(null);

		}
    	//********Fin Partie Maxime********
		return connexionList;
	}

	/**
	 * @see IConnexionService#rechercherConnexionParId(Connexion connexion)
	 */
	@Override
	public Connexion rechercherConnexionParId(Connexion connexion) {
		Connexion returnedConnexion = null;
		if (connexion != null) {
			returnedConnexion = entityManager.find(Connexion.class, connexion.getCnxId());
		}
		return returnedConnexion;
	}

	/**
	 * @see IConnexionService#listerMotifs()
	 */
	@Override
	public List<Motif> listerMotifs() {
		Query query = entityManager.createNamedQuery("Motif.findAll"); 
    	List<Motif> motifList = query.getResultList();
		return motifList;
	}

	/**
	 * @see IConnexionService#rechercherMotifParId(Motif motif)
	 */
	@Override
	public Motif rechercherMotifParId(Motif motif) {
		Motif returnedMotif; 
		returnedMotif = entityManager.find(Motif.class, motif.getMtId());
		return returnedMotif;
	}

	/**
	 * @see IConnexionService#rechercherConnexionsParUsager(Usager usager)
	 */
	@Override
	public List<Connexion> rechercherConnexionsParUsager(Usager usager) {
		Query query = entityManager.createNamedQuery("Connexion.rechercherParUsager").setParameter("usager", usager); 
    	List<Connexion> connexionList = query.getResultList();
		return connexionList;
	}

	/**
	 * @see IConnexionService#supprimerConnexion(Connexion connexion)
	 */
	@Override
	public void supprimerConnexion(Connexion connexion) {
		connexion = entityManager.merge(connexion);
		entityManager.remove(connexion);
	}

	/**
	 * @see IConnexionService#supprimerMotif(Motif motif)
	 */
	@Override
	public void supprimerMotif(Motif motif) {
		motif = entityManager.merge(motif);
		entityManager.remove(motif);
	}

	/**
	 * @see IConnexionService#supprimerConnexionsUsager(Usager usager)
	 */
	@Override
	public void supprimerConnexionsUsager(Usager usager) {
		Query query = entityManager.createNamedQuery("Connexion.rechercherParUsager").setParameter("usager", usager); 
    	List<Connexion> connexionList = query.getResultList();
    	
    	for (Connexion connexion : connexionList) {
    		entityManager.remove(connexion);
    	}
	}

	/**
	 * @see IConnexionService#creerConnexion(Connexion connexion)
	 */
	@Override
	public Connexion creerConnexion(Connexion connexion) {
		connexion.setCnxDate(new Date(System.currentTimeMillis()));
		connexion.setCnxHeureDebut(new Time(System.currentTimeMillis()));
		connexion.getPoste().setPosteDisponible(false);
		entityManager.merge(connexion.getPoste());
		entityManager.persist(connexion);
		return connexion;
	}

	/**
	 * @see IConnexionService#creerMotif(Motif motif)
	 */
	@Override
	public Motif creerMotif(Motif motif) {
		entityManager.persist(motif);
		return motif;
	}

	/**
	 * @see IConnexionService#modifierConnexion(Connexion connexion)
	 */
	@Override
	public Connexion modifierConnexion(Connexion connexion) {
		return entityManager.merge(connexion);
	}

	/**
	 * @see IConnexionService#modifierMotif(Motif motif)
	 */
	@Override
	public Motif modifierMotif(Motif motif) {
		return entityManager.merge(motif);
	}
	
	/**
	 * @see IConnexionService#terminerConnexion(Connexion connexion)
	 */
	@Override
	public Connexion terminerConnexion(Connexion connexion) {
		connexion.setCnxHeureFin(new Time(System.currentTimeMillis()));
		return entityManager.merge(connexion);
	}

}
