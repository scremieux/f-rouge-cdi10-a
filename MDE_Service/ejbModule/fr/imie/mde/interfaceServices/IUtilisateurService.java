package fr.imie.mde.interfaceServices;

import java.util.List;

import javax.ejb.Local;

import fr.imie.mde.model.Poste;
import fr.imie.mde.model.Salle;
import fr.imie.mde.model.Site;
import fr.imie.mde.model.Structure;

@Local
public interface IUtilisateurService {

	List<Site> listerSites();

	List<Salle> listerSalles();

	List<Poste> listerPostes();

	List<Structure> listerStructures();

	List<Salle> listerSallesParSite(Site site);

}
