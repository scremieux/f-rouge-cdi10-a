package fr.imie.mde.rest;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.imie.mde.interfaceServices.IConnexionService;
import fr.imie.mde.model.Connexion;
import fr.imie.mde.model.Motif;
import fr.imie.mde.model.Usager;

/**
 * Services REST dédiés à la gestion des connexions.
 * <br>
 * Routes :
 * <ul>
 *   <li>/Api/connexion : GET, POST</li>
 *   <li>/Api/connexion/{id} : GET, DELETE, PUT</li>
 *   <li>/Api/connexion/motif : GET, POST</li>
 *   <li>/Api/connexion/motif/{id} : GET, DELETE, PUT</li>
 *   <li>/Api/connexion/usager/{id}	: GET, DELETE</li>
 * </ul>
 * @author P42
 * @version 1.0
 */
@Stateless
@Path("/connexion")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class ConnexionJaxRS {
	@EJB IConnexionService connexionService;

	/**
	 * Retourne la liste exhaustive des connexions.
	 * <br>Route : /Api/connexion
	 * <br>Methode : GET
	 * @return liste d'objets Connexion au format JSON.
	 */
	@GET()
	public Response listerConnexionsRest() {
		List<Connexion> connexions = new ArrayList<Connexion>();
		connexions = connexionService.listerConnexions();
		return Response.ok(connexions).build();
	}

	/**
	 * Retourne la liste exhaustive des motifs de connexion.
	 * <br>Route : /Api/connexion/motif
	 * <br>Methode : GET
	 * @return liste d'objets Motif au format JSON.
	 */
	@GET()
	@Path("/motif")
	public Response listerMotifsRest() {
		List<Motif> motifs = new ArrayList<Motif>();
		motifs = connexionService.listerMotifs();
		return Response.ok(motifs).build();
	}

	/**
	 * Retourne les informations de la connexion correspondant à l'ID donné dans l'URL.
	 * <br>Route : /Api/connexion/{id}
	 * <br>Methode : GET
	 * @param idString   Clé primaire de la connexion recherchée
	 * @return objet Connexion au format JSON, noContent si pas de correspondance trouvé
	 */
	@GET()
	@Path("/{id}")
	public Response rechercherConnexionParIdRest(@PathParam("id") String idString) {
		Integer id = null;
		try {
			id = Integer.valueOf(idString);
		} catch (Exception e) {
			return Response.noContent().build();
		}
		
		Connexion connexion = null;
		if (id != null) {
			connexion = new Connexion();
			connexion.setCnxId(id);
			try {
				connexion = connexionService.rechercherConnexionParId(connexion);
			} catch (Exception e) {
				return Response.noContent().build();
			}
		}
		return Response.ok(connexion).build();
	}

	/**
	 * Retourne les informations du motif correspondant à l'ID donné dans l'URL.
	 * <br>Route : /Api/connexion/motif/{id}
	 * <br>Methode : GET
	 * @param idString   Clé primaire du motif recherché.
	 * @return objet Motif au format JSON, noContent si pas de correspondance trouvé.
	 */
	@GET()
	@Path("/motif/{id}")
	public Response rechercherMotifParIdRest(@PathParam("id") String idString) {
		Integer id = null;
		try {
			id = Integer.valueOf(idString);
		} catch (Exception e) {
			return Response.noContent().build();
		}
		
		Motif motif = null;
		if (id != null) {
			motif = new Motif();
			motif.setMtId(id);;
			try {
				motif = connexionService.rechercherMotifParId(motif);
			} catch (Exception e) {
				return Response.noContent().build();
			}
		}
		return Response.ok(motif).build();
	}

	/**
	 * Retourne la liste exhaustive des connexions pour l'usager correspondant à l'ID donné dans l'URL.
	 * <br>Route : /Api/connexion/usager/{id}
	 * <br>Methode : GET
	 * @param idString   Clé primaire de l'usager recherché.
	 * @return liste d'objets Connexion au format JSON, noContent si pas de correspondance d'usager trouvé.
	 */
	@GET()
	@Path("/usager/{id}")
	public Response rechercherConnexionsParUsagerRest(@PathParam("id") String idString) {
		Integer id = null;
		try {
			id = Integer.valueOf(idString);
		} catch (Exception e) {
			return Response.noContent().build();
		}
		
		Usager usager = null;
		List<Connexion> connexions = new ArrayList<Connexion>(); 
		if (id != null) {
			usager = new Usager();
			usager.setUsagerId(id);;
			try {
				connexions = connexionService.rechercherConnexionsParUsager(usager);
			} catch (Exception e) {
				return Response.noContent().build();
			}
		}
		return Response.ok(connexions).build();
	}
	
	/**
	 * Supprime les données de la connexion correspondante à l'ID donné dans l'URL.
	 * <br>Route : /Api/connexion/{id}
	 * <br>Methode : DELETE
	 * @param idString   Clé primaire de la connexion concernée.
	 * @return objet Connexion au format JSON, noContent si pas de correspondance trouvée.
	 */
	@DELETE()
	@Path("/{id}")
	public Response supprimerConnexionRest(@PathParam("id") String idString) {
		Integer id = null;
		try {
			id = Integer.valueOf(idString);
		} catch (Exception e) {
			return Response.noContent().build();
		}
		
		Connexion connexion = null;
		if (id != null) {
			connexion = new Connexion();
			connexion.setCnxId(id);
			try {
				connexionService.supprimerConnexion(connexion);
			} catch (Exception e) {
				return Response.noContent().build();
			}
		}
		return Response.ok(connexion).build();
	}
	
	/**
	 * Supprime les données du motif correspondant à l'ID donné dans l'URL.
	 * <br>Route : /Api/connexion/motif/{id}
	 * <br>Methode : DELETE
	 * @param idString   Clé primaire du motif concerné.
	 * @return objet Motif au format JSON, noContent si pas de correspondance trouvée.
	 */
	@DELETE()
	@Path("/motif/{id}")
	public Response supprimerMotifRest(@PathParam("id") String idString) {
		Integer id = null;
		try {
			id = Integer.valueOf(idString);
		} catch (Exception e) {
			return Response.noContent().build();
		}
		
		Motif motif = null;
		if (id != null) {
			motif = new Motif();
			motif.setMtId(id);
			try {
				connexionService.supprimerMotif(motif);
			} catch (Exception e) {
				return Response.noContent().build();
			}
		}
		return Response.ok(motif).build();
	}

	/**
	 * Supprime les données de connexion de l'usager correspondant à l'ID donné dans l'URL.
	 * <br>Route : /Api/connexion/usager/{id}
	 * <br>Methode : DELETE
	 * @param idString   Clé primaire du motif concerné.
	 * @return objet Usager au format JSON, noContent si pas de correspondance trouvée.
	 */
	@DELETE()
	@Path("/usager/{id}")
	public Response supprimerConnexionsUsagerRest(@PathParam("id") String idString) {
		Integer id = null;
		try {
			id = Integer.valueOf(idString);
		} catch (Exception e) {
			return Response.noContent().build();
		}
		
		Usager usager = null;
		if (id != null) {
			usager = new Usager();
			usager.setUsagerId(id);
			try {
				connexionService.supprimerConnexionsUsager(usager);
			} catch (Exception e) {
				return Response.noContent().build();
			}
		}
		return Response.ok(usager).build();
	}
	
	/**
	 * Crée une connexion.
	 * <br>Route : /Api/connexion
	 * <br>Methode : POST
	 * @param connexion   objet Connexion à persister.
 	 * @return objet Connexion persisté au format JSON.
	 */
	@POST()
	public Response creerConnexionRest(Connexion connexion) {
		if (connexion != null) {
			connexionService.creerConnexion(connexion);
		}
		return Response.ok(connexion).build();
	}

	/**
	 * Crée un motif.
	 * <br>Route : /Api/connexion/motif
	 * <br>Methode : POST
	 * @param motif   objet Motif à persister.
 	 * @return objet Motif persisté au format JSON.
	 */
	@POST()
	public Response creerMotifRest(Motif motif) {
		if (motif != null) {
			motif = connexionService.creerMotif(motif);
		}
		return Response.ok(motif).build();
	}
	
	
	/**
	 * Met à jour les données de la connexion correspondante à l'ID donné dans l'URL.
	 * <br>Route : /Api/connexion/{id}
	 * <br>Methode : PUT
	 * @param connexion		objet Connexion avec les données à mettre à jour.
	 * @param idString		Clé primaire de la connexion à mettre à jour.
 	 * @return objet Connexion au format JSON, noContent si pas de correspondance trouvée.
	 */
	@PUT
	@Path("/{id}")
	public Response modifierConnexionRest(Connexion connexion, @PathParam("id") String idString) {
		Integer id = null;
		try {
			id = Integer.valueOf(idString);
		} catch (Exception e) {
			return Response.noContent().build();
		}

		if (id != null && connexion != null) {
			connexion.setCnxId(id);
			connexion = connexionService.modifierConnexion(connexion);
			return Response.ok(connexion).build();
		} else {
			return Response.noContent().build();
		}
	}

	/**
	 * Met à jour les données du motif correspondant à l'ID donné dans l'URL.
	 * <br>Route : /Api/connexion/motif/{id}
	 * <br>Methode : PUT
	 * @param motif		objet Motif avec les données à mettre à jour.
	 * @param idString		Clé primaire de l'usager à mettre à jour.
 	 * @return objet Motif au format JSON, noContent si pas de correspondance trouvée.
	 */
	@PUT
	@Path("/motif/{id}")
	public Response modifierMotifRest(Motif motif, @PathParam("id") String idString) {
		Integer id = null;
		try {
			id = Integer.valueOf(idString);
		} catch (Exception e) {
			return Response.noContent().build();
		}

		if (id != null && motif != null) {
			motif.setMtId(id);
			motif = connexionService.modifierMotif(motif);
			return Response.ok(motif).build();
		} else {
			return Response.noContent().build();
		}
	}
}
