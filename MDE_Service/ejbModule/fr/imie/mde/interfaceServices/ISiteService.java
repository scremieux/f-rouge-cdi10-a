package fr.imie.mde.interfaceServices;

import java.util.List;

import javax.ejb.Local;

import fr.imie.mde.model.Poste;
import fr.imie.mde.model.Salle;
import fr.imie.mde.model.Site;
import fr.imie.mde.model.Structure;

@Local
public interface ISiteService {
	List<Site> listerSites();

	List<Salle> listerSalles();

	List<Poste> listerPostes();

	Site obtenirSite(Site site);

	Salle obtenirSalle(Salle salle);

	Poste obtenirPoste(Poste poste);

	Site creerSite(Site site);

	Salle creerSalle(Salle salle);
	
	Poste creerPoste(Poste poste);

	Site modifierSite(Site site);

	Salle modifierSalle(Salle salle);
	
	Poste modifierPoste(Poste poste);

	void supprimerSite(Site site);

	void supprimerSalle(Salle salle);

	void supprimerPoste(Poste poste);
}
