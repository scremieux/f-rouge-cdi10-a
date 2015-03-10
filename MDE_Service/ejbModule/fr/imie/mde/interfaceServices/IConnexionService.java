package fr.imie.mde.interfaceServices;

import java.util.List;

import javax.ejb.Local;

import fr.imie.mde.model.Connexion;
import fr.imie.mde.model.Motif;
import fr.imie.mde.model.Usager;

/**
 * Interface publique du service de gestion des connexions.
 * @author P42
 * @version 1.0
 */
@Local
public interface IConnexionService {
	/**
	 * Retourne la liste exhaustive des connexions.
	 * @return liste d'objets Connexion.
	 */
	List<Connexion> listerConnexions();

	/**
	 * Retourne la liste exhaustive des motifs de connexion.
	 * @return liste d'objets Motif
	 */
	List<Motif> listerMotifs();

	/**
	 * Retourne les informations d'une connexion.
	 * @param connexion   objet Connexion recherchée
	 * @return objet Connexion , null si pas de correspondance trouvée.
	 */
	Connexion rechercherConnexionParId(Connexion connexion);

	/**
	 * Retourne les informations d'un motif.
	 * @param motif   objet Motif recherché.
	 * @return objet Motif, null si pas de correspondance trouvée.
	 */
	Motif rechercherMotifParId(Motif motif);

	/**
	 * Retourne la liste exhaustive des connexions pour l'usager correspondant à l'ID donné dans l'URL.
	 * @param usager   objet Usager concerné.
	 * @return liste d'objets Connexion.
	 */
	List<Connexion> rechercherConnexionsParUsager(Usager usager);

	/**
	 * Supprime les données d'une connexion.
	 * @param connexion		objet Connexion à supprimer.
	 */
	void supprimerConnexion(Connexion connexion);

	/**
	 * Supprime les données d'un motif de connexion.
	 * @param motif		objet Motif à supprimer.
	 */
	void supprimerMotif(Motif motif);

	/**
	 * Supprime les données de connexion d'un usager.
	 * @param usager		objet Usager concerné.
	 */
	void supprimerConnexionsUsager(Usager usager);

	/**
	 * Crée une connexion.
	 * @param csp   objet Connexion à persister.
 	 * @return objet Connexion persisté.
	 */
	Connexion creerConnexion(Connexion connexion);

	/**
	 * Crée un motif.
	 * @param motif   objet Motif à persister.
 	 * @return objet Motif persisté.
	 */
	Motif creerMotif(Motif motif);

	/**
	 * Met à jour les données d'une connexion.
	 * @param connexion		objet Connexion avec les données à mettre à jour.
 	 * @return objet Connexion modifié.
	 */
	Connexion modifierConnexion(Connexion connexion);

	/**
	 * Met à jour les données d'un motif de connexion.
	 * @param motif		objet Motif avec les données à mettre à jour.
 	 * @return objet Motig modifié.
	 */
	Motif modifierMotif(Motif motif);

	/**
	 * Met à jour les données d'une connexion.
	 * @param motif		objet Connexion avec les données à mettre à jour.
 	 * @return objet Connexion modifié.
	 */
	Connexion terminerConnexion(Connexion connexion);
}
