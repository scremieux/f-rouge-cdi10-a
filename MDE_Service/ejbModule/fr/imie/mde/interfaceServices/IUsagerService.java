package fr.imie.mde.interfaceServices;

import java.util.List;

import javax.ejb.Local;

import fr.imie.mde.model.Csp;
import fr.imie.mde.model.NiveauFormation;
import fr.imie.mde.model.Quartier;
import fr.imie.mde.model.Usager;

@Local
public interface IUsagerService {
	List<Usager> listerUsagers();
	Usager rechercherUsagerParId(Usager usager);
	List<Csp> listerCsp();
	Csp rechercherCspParId(Csp csp);
	List<Quartier> listerQuartiers();
	Quartier rechercherQuartierParId(Quartier quartier);
	List<NiveauFormation> listerNiveauxFormation();
	NiveauFormation rechercherNiveauFormationParId(NiveauFormation niveauFormation);
	void supprimerUsager(Usager usager);
	void supprimerCsp(Csp csp);
	void supprimerQuartier(Quartier quartier);
	void supprimerNiveauFormation(NiveauFormation niveauFormation);
	Usager creerUsager(Usager usager);
	Csp creerCsp(Csp csp);
	Quartier creerQuartier(Quartier quartier);
	NiveauFormation creerNiveauFormation(NiveauFormation niveauFormation);
	Usager modifierUsager(Usager usager);
	Csp modifierCsp(Csp csp);
	Quartier modifierQuartier(Quartier quartier);
	NiveauFormation modifierNiveauFormation(NiveauFormation niveauFormation);
}
