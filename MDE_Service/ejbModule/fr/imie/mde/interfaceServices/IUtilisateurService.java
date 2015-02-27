package fr.imie.mde.interfaceServices;

import java.util.List;

import javax.ejb.Local;

import fr.imie.mde.model.Requete;
import fr.imie.mde.model.Structure;
import fr.imie.mde.model.Utilisateur;

@Local
public interface IUtilisateurService {

	List<Utilisateur> listerUtilisateurs();

	Utilisateur creerUtilisateur(Utilisateur utilisateur);

	Utilisateur obtenirUtilisateur(Utilisateur utilisateur);

	Utilisateur modifierUtilisateur(Utilisateur utilisateur);

	void supprimerSite(Utilisateur utilisateur);

	List<Structure> listerStructures();

	Structure creerStructure(Structure structure);

	Structure obtenirStructure(Structure structure);

	Structure modifierStructure(Structure structure);

	void supprimerStructure(Structure structure);

	List<Requete> listerRequetes();

	Requete creerRequete(Requete requete);

	Requete obtenirRequete(Requete requete);

	Requete modifierRequete(Requete requete);

	void supprimerRequete(Requete requete);

	List<Requete> obtenirRequeteParUtilisateur(Utilisateur utilisateur);




}
