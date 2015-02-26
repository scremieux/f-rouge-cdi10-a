package fr.imie.mde.interfaceServices;

import java.util.List;

import javax.ejb.Local;

import fr.imie.mde.model.Requete;

@Local
public interface IUtilisateurService {



	List<Requete> listerRequetes();

	Requete creerRequete(Requete requete);


}
