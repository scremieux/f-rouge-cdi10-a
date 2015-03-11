package fr.imie.mde.interfaceServices;

import javax.ejb.Local;

import fr.imie.mde.model.Utilisateur;

/**
 * Interface publique du service de login.
 * @author P42
 * @version 1.0
 */
@Local
public interface ILoginService {
	/**
	 * Retourne un booléen à true lorsque l'utilisateur saisie son MdP.
	 * @return un booléen .
	 */
	Boolean verifLogin(Utilisateur utilisateur);
	
}
	
