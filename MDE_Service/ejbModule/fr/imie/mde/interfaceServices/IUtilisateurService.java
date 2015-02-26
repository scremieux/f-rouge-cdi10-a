package fr.imie.mde.interfaceServices;

import java.util.List;

import javax.ejb.Local;

import fr.imie.mde.model.Requete;
import fr.imie.mde.model.Structure;

@Local
public interface IUtilisateurService {


	List<Structure> listerStructures();

	List<Requete> listerRequetes();

	Requete creerRequete(Requete requete);


}
