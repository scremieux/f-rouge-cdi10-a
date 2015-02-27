package fr.imie.mde.interfaceServices;

import java.util.List;

import javax.ejb.Local;

import fr.imie.mde.model.Csp;
import fr.imie.mde.model.NiveauFormation;
import fr.imie.mde.model.Quartier;
import fr.imie.mde.model.Usager;

/**
 * Interface publique du service de gestion des usagers.
 * @author P42
 * @version 1.0
 */
@Local
public interface IUsagerService {

	/**
	 * Retourne la liste exhaustive des usagers.
	 * @return liste d'objets Usager.
	 */
	List<Usager> listerUsagers();

	/**
	 * Retourne la liste exhaustive des catégories socio professionnelles.
	 * @return liste d'objets Csp.
	 */
	List<Csp> listerCsp();

	/**
	 * Retourne la liste exhaustive des quartiers.
	 * @return liste d'objets Quartier.
	 */
	List<Quartier> listerQuartiers();

	/**
	 * Retourne la liste exhaustive des niveaux de formation.
	 * @return liste d'objets NiveauFormation.
	 */
	List<NiveauFormation> listerNiveauxFormation();

	/**
	 * Retourne les informations de l'usager correspondant à l'ID donné dans l'URL.
	 * @param usager	objet Usager recherché.
	 * @return objet Usager, null si pas de correspondance trouvée.
	 */
	Usager rechercherUsagerParId(Usager usager);

	/**
	 * Retourne les informations de la CSP correspondant à l'ID donné dans l'URL.
	 * @param csp		objet Csp recherché.
	 * @return objet Csp, null si pas de correspondance trouvée.
	 */
	Csp rechercherCspParId(Csp csp);

	/**
	 * Retourne les informations du quartier correspondant à l'ID donné dans l'URL.
	 * @param quartier		objet Quartier recherché.
	 * @return objet Quartier, null si pas de correspondance trouvée.
	 */
	Quartier rechercherQuartierParId(Quartier quartier);

	/**
	 * Retourne les informations du niveau de formation correspondant à l'ID donné dans l'URL.
	 * @param niveauFormation		objet NiveauFormation récherché.
	 * @return objet NiveauFormation, null si pas de correspondance trouvée.
	 */
	NiveauFormation rechercherNiveauFormationParId(NiveauFormation niveauFormation);

	/**
	 * Supprime les données d'un usager.
	 * @param usager		objet Usager à supprimer.
	 */
	void supprimerUsager(Usager usager);

	/**
	 * Supprime les données d'une CSP.
	 * @param csp		objet Csp à supprimer.
	 */
	void supprimerCsp(Csp csp);

	/**
	 * Supprime les données d'un quartier.
	 * @param quartier		objet Quartier à supprimer.
	 */
	void supprimerQuartier(Quartier quartier);

	/**
	 * Supprime les données d'un niveau de formation.
	 * @param niveauFormation		objet NiveauFormation à supprimer.
	 */
	void supprimerNiveauFormation(NiveauFormation niveauFormation);

	/**
	 * Crée un usager.
	 * @param usager   objet Usager à persister.
 	 * @return objet Usager persisté.
	 */
	Usager creerUsager(Usager usager);

	/**
	 * Crée une CSP.
	 * @param csp   objet Csp à persister.
 	 * @return objet Csp persisté.
	 */
	Csp creerCsp(Csp csp);

	/**
	 * Crée un quartier.
	 * @param quartier   objet Quartier à persister.
 	 * @return objet Quartier persisté.
	 */
	Quartier creerQuartier(Quartier quartier);

	/**
	 * Crée un niveau de formation.
	 * @param quartier   objet NiveauFormation à persister.
 	 * @return objet NiveauFormation persisté.
	 */
	NiveauFormation creerNiveauFormation(NiveauFormation niveauFormation);

	/**
	 * Met à jour les données d'un usager.
	 * @param usager		objet Usager avec les données à mettre à jour.
 	 * @return objet Usager modifié.
	 */
	Usager modifierUsager(Usager usager);

	/**
	 * Met à jour les données d'une CSP.
	 * @param csp		objet Csp avec les données à mettre à jour.
 	 * @return objet Csp modifié.
	 */
	Csp modifierCsp(Csp csp);

	/**
	 * Met à jour les données d'un quartier.
	 * @param quartier		objet Quartier avec les données à mettre à jour.
 	 * @return objet Quartier modifié.
	 */
	Quartier modifierQuartier(Quartier quartier);

	/**
	 * Met à jour les données d'un niveau de formation.
	 * @param niveauFormation		objet NiveauFormation avec les données à mettre à jour.
 	 * @return objet NiveauFormation modifié.
	 */
	NiveauFormation modifierNiveauFormation(NiveauFormation niveauFormation);

}
