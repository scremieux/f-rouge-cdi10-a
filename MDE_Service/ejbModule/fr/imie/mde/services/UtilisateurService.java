package fr.imie.mde.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.imie.mde.interfaceServices.IUtilisateurService;
import fr.imie.mde.model.Requete;
import fr.imie.mde.model.Salle;
import fr.imie.mde.model.Site;
import fr.imie.mde.model.Structure;
import fr.imie.mde.model.Utilisateur;

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
	public List<Utilisateur> listerUtilisateurs() {
		Query query = entityManager.createNamedQuery("Utilisateur.findAll"); 
		List<Utilisateur> utilisateurs = query.getResultList();
    	for (Utilisateur utilisateur : utilisateurs) {
    		entityManager.detach(utilisateur);
			utilisateur.setStructure(null);
			utilisateur.setSite(null);
		}

		return utilisateurs;

	}
	@Override
	public Utilisateur creerUtilisateur(Utilisateur utilisateur) {
		entityManager.persist(utilisateur);
		return utilisateur;
	}
	@Override
	public Utilisateur obtenirUtilisateur(Utilisateur utilisateur) {
		utilisateur = entityManager.find(Utilisateur.class, utilisateur.getUtilId());
		return utilisateur;
	}
	@Override
	public Utilisateur modifierUtilisateur(Utilisateur utilisateur) {
		return entityManager.merge(utilisateur);
	}
	@Override
	public void supprimerUtilisateur(Utilisateur utilisateur) {
		utilisateur = entityManager.merge(utilisateur);
		entityManager.remove(utilisateur);
	}
	@Override
	public List<Structure> listerStructures() {
		Query query = entityManager.createNamedQuery("Structure.findAll"); 
		List<Structure> structures = query.getResultList();
		return structures;
	}
	@Override
	public Structure creerStructure(Structure structure) {
		entityManager.persist(structure);
		return structure;
	}
	@Override
	public Structure obtenirStructure(Structure structure) {
		structure = entityManager.find(Structure.class, structure.getStructId());
		return structure;
	}
	@Override
	public Structure modifierStructure(Structure structure) {
		return entityManager.merge(structure);
	}
	@Override
	public void supprimerStructure(Structure structure) {
		structure = entityManager.merge(structure);
		entityManager.remove(structure);
		
	}
	@Override
	public List<Requete> listerRequetes() {
		Query query = entityManager.createNamedQuery("Requete.findAll"); 
		List<Requete> requetes = query.getResultList();
    	for (Requete requete : requetes) {
    		entityManager.detach(requete);
    		requete.setUtilisateur(null);
		}
		return requetes;
	}
	@Override
	public Requete creerRequete(Requete requete) {
		entityManager.persist(requete);
		return requete;
	}
	@Override
	public Requete obtenirRequete(Requete requete) {
		requete = entityManager.find(Requete.class, requete.getReqId());
		Utilisateur utilisateur = requete.getUtilisateur();
		entityManager.detach(utilisateur);
		utilisateur.setSite(null);
		utilisateur.setStructure(null);
		return requete;
	}
	@Override
	public Requete modifierRequete(Requete requete) {
		return entityManager.merge(requete);
	}
	@Override
	public void supprimerRequete(Requete requete) {
		// TODO Auto-generated method stub
		requete = entityManager.merge(requete);
		entityManager.remove(requete);
	}
	@Override
	public List<Requete> obtenirRequeteParUtilisateur(Utilisateur utilisateur) {
		Query query = entityManager.createQuery("select requete where requete.util_id = ?1");
		query.setParameter(1, utilisateur.getUtilId());
		List<Requete> requetes = query.getResultList();
    	for (Requete requete : requetes) {
    		entityManager.detach(requete);
    		requete.setUtilisateur(null);
		}
		return requetes;
	}

	
}
