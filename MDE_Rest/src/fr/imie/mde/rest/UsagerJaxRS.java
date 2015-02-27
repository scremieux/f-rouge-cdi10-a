package fr.imie.mde.rest;

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

import fr.imie.mde.interfaceServices.IUsagerService;
import fr.imie.mde.model.Csp;
import fr.imie.mde.model.NiveauFormation;
import fr.imie.mde.model.Quartier;
import fr.imie.mde.model.Usager;

/**
 * Services REST dédiés à la gestion des usagers.
 * <br>
 * Routes :
 * <ul>
 *   <li>/Api/usager : GET, POST</li>
 *   <li>/Api/usager/{id} : GET, DELETE, PUT</li>
 *   <li>/Api/usager/csp : GET, POST</li>
 *   <li>/Api/usager/csp/{id} : GET, DELETE, PUT</li>
 *   <li>/Api/usager/quartier : GET, POST</li>
 *   <li>/Api/usager/quartier/{id} : GET, DELETE, PUT</li>
 *   <li>/Api/usager/nf : GET, POST</li>
 *   <li>/Api/usager/nf/{id} : GET, DELETE, PUT</li>
 * </ul>
 * @author P42
 * @version 1.0
 */
@Stateless
@Path("/usager")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class UsagerJaxRS {
	@EJB IUsagerService usagerService;

	/**
	 * Retourne la liste exhaustive des usagers.
	 * <br>Route : /Api/usager
	 * <br>Methode : GET
	 * @return liste d'objets Usager au format JSON.
	 */
	@GET()
	public Response listerUsagersRest(){
		List<Usager> usagers = new ArrayList<Usager>();
		usagers = usagerService.listerUsagers();
		return Response.ok(usagers).build();
	}
	
	/**
	 * Retourne la liste exhaustive des catégories socio professionnelles.
	 * <br>Route : /Api/usager/csp
	 * <br>Methode : GET
	 * @return liste d'objets Csp au format JSON.
	 */
	@GET()
	@Path("/csp")
	public Response listerCspRest(){
		List<Csp> cspList = new ArrayList<Csp>();
		cspList = usagerService.listerCsp();
		return Response.ok(cspList).build();
	}

	/**
	 * Retourne la liste exhaustive des quartiers.
	 * <br>Route : /Api/quartier
	 * <br>Methode : GET
	 * @return liste d'objets Quartier au format JSON.
	 */
	@GET()
	@Path("/quartier")
	public Response listerQuartiersRest(){
		List<Quartier> quartiers = new ArrayList<Quartier>();
		quartiers = usagerService.listerQuartiers();
		return Response.ok(quartiers).build();
	}

	/**
	 * Retourne la liste exhaustive des niveaux de formation.
	 * <br>Route : /Api/nf
	 * <br>Methode : GET
	 * @return liste d'objets NiveauFormation au format JSON.
	 */
	@GET()
	@Path("/nf")
	public Response listerNiveauxFormationRest(){
		List<NiveauFormation> nfList = new ArrayList<NiveauFormation>();
		nfList = usagerService.listerNiveauxFormation();
		return Response.ok(nfList).build();
	}
	
	/**
	 * Retourne les informations de l'usager correspondant à l'ID donné dans l'URL.
	 * <br>Route : /Api/usager/{id}
	 * <br>Methode : GET
	 * @param idString   Clé primaire de l'usager recherché.
	 * @return objet Usager au format JSON, noContent si pas de correspondance trouvée.
	 */
	@GET()
	@Path("/{id}")
	public Response rechercherUsagerParIdRest(@PathParam("id") String idString) {
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
				usager = usagerService.rechercherUsagerParId(usager);
			} catch (Exception e) {
				return Response.noContent().build();
			}
		}
		return Response.ok(usager).build();
	}
	
	/**
	 * Retourne les informations de la CSP correspondant à l'ID donné dans l'URL.
	 * <br>Route : /Api/usager/csp/{id}
	 * <br>Methode : GET
	 * @param idString   Clé primaire de la csp recherchée.
	 * @return objet Csp au format JSON, noContent si pas de correspondance trouvée.
	 */
	@GET()
	@Path("/csp/{id}")
	public Response rechercherCspParIdRest(@PathParam("id") String idString) {
		Integer id = null;
		try {
			id = Integer.valueOf(idString);
		} catch (Exception e) {
			return Response.noContent().build();
		}
		
		Csp csp = null;
		if (id != null) {
			csp = new Csp();
			csp.setCspId(id);
			try {
				csp = usagerService.rechercherCspParId(csp);
			} catch (Exception e) {
				return Response.noContent().build();
			}
		}
		return Response.ok(csp).build();
	}
	
	/**
	 * Retourne les informations du quartier correspondant à l'ID donné dans l'URL.
	 * <br>Route : /Api/usager/quartier/{id}
	 * <br>Methode : GET
 	 * @param idString   Clé primaire du quartier recherché.
 	 * @return objet Quartier au format JSON, noContent si pas de correspondance trouvée.
	 */
	@GET()
	@Path("/quartier/{id}")
	public Response rechercherQuartierParIdRest(@PathParam("id") String idString) {
		Integer id = null;
		try {
			id = Integer.valueOf(idString);
		} catch (Exception e) {
			return Response.noContent().build();
		}
		
		Quartier quartier = null;
		if (id != null) {
			quartier = new Quartier();
			quartier.setQuartierId(id);
			try {
				quartier = usagerService.rechercherQuartierParId(quartier);
			} catch (Exception e) {
				return Response.noContent().build();
			}
		}
		return Response.ok(quartier).build();
	}
	
	/**
	 * Retourne les informations du niveau de formation correspondant à l'ID donné dans l'URL.
	 * <br>Route : /Api/usager/nf/{id}
	 * <br>Methode : GET
	 * @param idString   Clé primaire du niveau de formation recherché.
	 * @return objet NiveauFormation au format JSON, noContent si pas de correspondance trouvée.
	 */
	@GET()
	@Path("/nf/{id}")
	public Response rechercherNiveauFormationParIdRest(@PathParam("id") String idString) {
		Integer id = null;
		try {
			id = Integer.valueOf(idString);
		} catch (Exception e) {
			return Response.noContent().build();
		}
		
		NiveauFormation niveauFormation = null;
		if (id != null) {
			niveauFormation = new NiveauFormation();
			niveauFormation.setNfId(id);
			try {
				niveauFormation = usagerService.rechercherNiveauFormationParId(niveauFormation);
			} catch (Exception e) {
				return Response.noContent().build();
			}
		}
		return Response.ok(niveauFormation).build();
	}
	
	/**
	 * Supprime les données de l'usager correspondant à l'ID donné dans l'URL.
	 * <br>Route : /Api/usager/{id}
	 * <br>Methode : DELETE
	 * @param idString   Clé primaire de l'usager à supprimer.
 	 * @return objet Usager au format JSON, noContent si pas de correspondance trouvée.
 	 */
	@DELETE()
	@Path("/{id}")
	public Response supprimerUsagerRest(@PathParam("id") String idString) {
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
				usagerService.supprimerUsager(usager);
			} catch (Exception e) {
				return Response.noContent().build();
			}
		}
		return Response.ok(usager).build();
	}

	/**
	 * Supprime les données de la CSP correspondante à l'ID donné dans l'URL.
	 * <br>Route : /Api/usager/csp/{id}
	 * <br>Methode : DELETE
	 * @param idString   Clé primaire de la CSP à supprimer.
 	 * @return objet Csp au format JSON, noContent si pas de correspondance trouvée.
 	 */
	@DELETE()
	@Path("/csp/{id}")
	public Response supprimerCspRest(@PathParam("id") String idString) {
		Integer id = null;
		try {
			id = Integer.valueOf(idString);
		} catch (Exception e) {
			return Response.noContent().build();
		}
		
		Csp csp = null;
		if (id != null) {
			csp = new Csp();
			csp.setCspId(id);
			try {
				usagerService.supprimerCsp(csp);
			} catch (Exception e) {
				return Response.noContent().build();
			}
		}
		return Response.ok(csp).build();
	}

	/**
	 * Supprime les données du quartier correspondant à l'ID donné dans l'URL.
	 * <br>Route : /Api/usager/quartier/{id}
	 * <br>Methode : DELETE
	 * @param idString   Clé primaire du quartier à supprimer.
 	 * @return objet Quartier au format JSON, noContent si pas de correspondance trouvée.
 	 */
	@DELETE()
	@Path("/quartier/{id}")
	public Response supprimerQuartierRest(@PathParam("id") String idString) {
		Integer id = null;
		try {
			id = Integer.valueOf(idString);
		} catch (Exception e) {
			return Response.noContent().build();
		}
		
		Quartier quartier = null;
		if (id != null) {
			quartier = new Quartier();
			quartier.setQuartierId(id);
			try {
				usagerService.supprimerQuartier(quartier);
			} catch (Exception e) {
				return Response.noContent().build();
			}
		}
		return Response.ok(quartier).build();
	}

	/**
	 * Supprime les données du niveau de formation correspondant à l'ID donné dans l'URL.
	 * <br>Route : /Api/usager/nf/{id}
	 * <br>Methode : DELETE
	 * @param idString   Clé primaire du niveau de formation à supprimer.
 	 * @return objet NiveauFormation au format JSON, noContent si pas de correspondance trouvée.
 	 */
	@DELETE()
	@Path("/nf/{id}")
	public Response supprimerNiveauFormationRest(@PathParam("id") String idString) {
		Integer id = null;
		try {
			id = Integer.valueOf(idString);
		} catch (Exception e) {
			return Response.noContent().build();
		}
		
		NiveauFormation niveauFormation = null;
		if (id != null) {
			niveauFormation = new NiveauFormation();
			niveauFormation.setNfId(id);
			try {
				usagerService.supprimerNiveauFormation(niveauFormation);
			} catch (Exception e) {
				return Response.noContent().build();
			}
		}
		return Response.ok(niveauFormation).build();
	}
	
	/**
	 * Crée un usager.
	 * <br>Route : /Api/usager
	 * <br>Methode : POST
	 * @param usager   objet Usager à persister.
 	 * @return objet Usager persisté au format JSON.
	 */
	@POST()
	public Response creerUsagerRest(Usager usager) {
		if (usager != null) {
			usagerService.creerUsager(usager);
		}
		return Response.ok(usager).build();
	}

	/**
	 * Crée une CSP.
	 * <br>Route : /Api/usager/csp
	 * <br>Methode : POST
	 * @param csp   objet Csp à persister.
 	 * @return objet Csp persisté au format JSON.
	 */
	@POST()
	@Path("/csp")
	public Response creerCspRest(Csp csp) {
		if (csp != null) {
			usagerService.creerCsp(csp);
		}
		return Response.ok(csp).build();
	}
	
	/**
	 * Crée un quartier.
	 * <br>Route : /Api/usager/quartier
	 * <br>Methode : POST
	 * @param quartier   objet Quartier à persister.
 	 * @return objet Quartier persisté au format JSON.
	 */
	@POST()
	@Path("/quartier")
	public Response creerQuartierRest(Quartier quartier) {
		if (quartier != null) {
			usagerService.creerQuartier(quartier);
		}
		return Response.ok(quartier).build();
	}

	/**
	 * Crée un niveau de formation.
	 * <br>Route : /Api/usager/nf
	 * <br>Methode : POST
	 * @param niveauFormation   objet NiveauFormation à persister.
 	 * @return objet NiveauFormation persisté au format JSON.
	 */
	@POST()
	@Path("/nf")
	public Response creerNiveauFormationRest(NiveauFormation niveauFormation) {
		if (niveauFormation != null) {
			usagerService.creerNiveauFormation(niveauFormation);
		}
		return Response.ok(niveauFormation).build();
	}

	/**
	 * Met à jour les données de l'usager correspondant à l'ID donné dans l'URL.
	 * <br>Route : /Api/usager/{id}
	 * <br>Methode : PUT
	 * @param usager		objet Usager avec les données à mettre à jour.
	 * @param idString		Clé primaire de l'usager à mettre à jour.
 	 * @return objet Usager au format JSON, noContent si pas de correspondance trouvée.
	 */
	@PUT
	@Path("/{id}")
	public Response modifierUsagerRest(Usager usager, @PathParam("id") String idString) {
		Integer id = null;
		try {
			id = Integer.valueOf(idString);
		} catch (Exception e) {
			return Response.noContent().build();
		}

		if (id != null && usager != null) {
			usager.setUsagerId(id);
			usager = usagerService.modifierUsager(usager);
			return Response.ok(usager).build();
		} else {
			return Response.noContent().build();
		}
	}

	/**
	 * Met à jour les données de la CSP correspondante à l'ID donné dans l'URL.
	 * <br>Route : /Api/usager/csp/{id}
	 * <br>Methode : PUT
	 * @param csp			objet Csp avec les données à mettre à jour.
	 * @param idString		Clé primaire de la CSP à mettre à jour.
 	 * @return objet Csp au format JSON, noContent si pas de correspondance trouvée.
	 */
	@PUT
	@Path("/csp/{id}")
	public Response modifierCspRest(Csp csp, @PathParam("id") String idString) {
		Integer id = null;
		try {
			id = Integer.valueOf(idString);
		} catch (Exception e) {
			return Response.noContent().build();
		}

		if (id != null && csp != null) {
			csp.setCspId(id);
			usagerService.modifierCsp(csp);
			return Response.ok(csp).build();
		} else {
			return Response.noContent().build();
		}
	}
	
	/**
	 * Met à jour les données du quartier correspondant à l'ID donné dans l'URL.
	 * <br>Route : /Api/usager/quartier/{id}
	 * <br>Methode : PUT
	 * @param quartier		objet Quartier avec les données à mettre à jour.
	 * @param idString		Clé primaire du quartier à mettre à jour.
 	 * @return objet Quartier au format JSON, noContent si pas de correspondance trouvée.
	 */
	@PUT
	@Path("/quartier/{id}")
	public Response modifierQuartierRest(Quartier quartier, @PathParam("id") String idString) {
		Integer id = null;
		try {
			id = Integer.valueOf(idString);
		} catch (Exception e) {
			return Response.noContent().build();
		}

		if (id != null && quartier != null) {
			quartier.setQuartierId(id);
			usagerService.modifierQuartier(quartier);
			return Response.ok(quartier).build();
		} else {
			return Response.noContent().build();
		}
	}
	
	/**
	 * Met à jour les données du niveau de formation correspondant à l'ID donné dans l'URL.
	 * <br>Route : /Api/usager/nf/{id}
	 * <br>Methode : PUT
	 * @param niveauFormation	objet NiveauFormation avec les données à mettre à jour.
	 * @param idString			Clé primaire du niveau de formation à mettre à jour.
 	 * @return objet NiveauFormation au format JSON, noContent si pas de correspondance trouvée.
	 */
	@PUT
	@Path("/nf/{id}")
	public Response modifierNiveauFormationRest(NiveauFormation niveauFormation, @PathParam("id") String idString) {
		Integer id = null;
		try {
			id = Integer.valueOf(idString);
		} catch (Exception e) {
			return Response.noContent().build();
		}

		if (id != null && niveauFormation != null) {
			niveauFormation.setNfId(id);
			usagerService.modifierNiveauFormation(niveauFormation);
			return Response.ok(niveauFormation).build();
		} else {
			return Response.noContent().build();
		}
	}
}
