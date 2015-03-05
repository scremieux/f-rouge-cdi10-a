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

import fr.imie.mde.interfaceServices.IUtilisateurService;
import fr.imie.mde.model.Poste;
import fr.imie.mde.model.Requete;
import fr.imie.mde.model.Salle;
import fr.imie.mde.model.Site;
import fr.imie.mde.model.Structure;
import fr.imie.mde.model.Utilisateur;


@Stateless
@Path("/utilisateur")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class UtilisateurJaxRS {
	@EJB IUtilisateurService utilisateurService;
	
	
	@GET()
	public Response listerUtilisateursRest(){
		List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
		utilisateurs = utilisateurService.listerUtilisateurs();
		return Response.ok(utilisateurs).build();
	}	
	
	@POST()
	public Response creerUtilisateurRest(Utilisateur utilisateur){
		utilisateur = utilisateurService.creerUtilisateur(utilisateur);
		return Response.ok(utilisateur).build();		
	}
	
	@GET()
	@Path("/{id}")
	public Response obtenirSiteRest(@PathParam("id") String idString) {
		Integer id = null;
		try {
			id = Integer.valueOf(idString);
		} catch (Exception e) {
			return Response.noContent().build();
		}
		Utilisateur utilisateur = null;
		if (id != null) {
			utilisateur = new Utilisateur();
			utilisateur.setUtilId(id);
			try {
				utilisateur = utilisateurService.obtenirUtilisateur(utilisateur);
			} catch (Exception e) {
				return Response.noContent().build();
			}
		}
		return Response.ok(utilisateur).build();
	}
	
	@PUT
	@Path("/{id}")
	public Response modifierSiteRest(Utilisateur utilisateur, @PathParam("id") String idString) {
		Integer id = null;
		try {
			id = Integer.valueOf(idString);
		} catch (Exception e) {
			return Response.noContent().build();
		}
		if (id != null) {

			utilisateur.setUtilId(id);
			try {
				utilisateur = utilisateurService.modifierUtilisateur(utilisateur);
			} catch (Exception e) {
				return Response.noContent().build();
			}
		}
		return Response.ok(utilisateur).build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response supprimerSiteRest(@PathParam("id") String idString) {
		Integer id = null;
		try {
			id = Integer.valueOf(idString);
		} catch (Exception e) {
			return Response.noContent().build();
		}
		Utilisateur utilisateur = null;
		if (id != null) {
			utilisateur = new Utilisateur();
			utilisateur.setUtilId(id);
			try {
				utilisateurService.supprimerUtilisateur(utilisateur);
			} catch (Exception e) {
				return Response.noContent().build();
			}
		}
		return Response.ok(id).build();
	}
	
	@GET()
	@Path("/structure")
	public Response listerStructuresRest(){
		List<Structure> structures = new ArrayList<Structure>();
		structures = utilisateurService.listerStructures();
		return Response.ok(structures).build();
	}
	
	@POST()
	@Path("/structure")
	public Response creerStructureRest(Structure structure){
		structure = utilisateurService.creerStructure(structure);
		return Response.ok(structure).build();		
	}
	
	@GET()
	@Path("/structure/{id}")
	public Response obtenirStructureRest(@PathParam("id") String idString) {
		Integer id = null;
		try {
			id = Integer.valueOf(idString);
		} catch (Exception e) {
			return Response.noContent().build();
		}
		Structure structure = null;
		if (id != null) {
			structure = new Structure();
			structure.setStructId(id);
			try {
				structure= utilisateurService.obtenirStructure(structure);
			} catch (Exception e) {
				return Response.noContent().build();
			}
		}
		return Response.ok(structure).build();
	}
	@PUT
	@Path("/structure/{id}")
	public Response modifierSalleRest(Structure structure, @PathParam("id") String idString) {
		Integer id = null;
		try {
			id = Integer.valueOf(idString);
		} catch (Exception e) {
			return Response.noContent().build();
		}
		if (id != null) {
			structure.setStructId(id);
			try {
				structure= utilisateurService.modifierStructure(structure);
			} catch (Exception e) {
				return Response.noContent().build();
			}
		}
		return Response.ok(structure).build();
	}
	
	@DELETE
	@Path("/structure/{id}")
	public Response supprimerSalleRest(@PathParam("id") String idString) {
		Integer id = null;
		try {
			id = Integer.valueOf(idString);
		} catch (Exception e) {
			return Response.noContent().build();
		}
		Structure structure = null;
		if (id != null) {
			structure  = new Structure();
			structure.setStructId(id);
			try {
				utilisateurService.supprimerStructure(structure);
			} catch (Exception e) {
				return Response.noContent().build();
			}
		}
		return Response.ok(id).build();
	}
	
	@GET()
	@Path("/requete")
	public Response listerRequetesRest(){
		List<Requete> structures = new ArrayList<Requete>();
		structures = utilisateurService.listerRequetes();
		return Response.ok(structures).build();
	}
	
	@POST()
	@Path("/requete")
	public Response creerRequeteRest(Requete requete){
		requete = utilisateurService.creerRequete(requete);
		return Response.ok(requete).build();		
	}
	
	@GET()
	@Path("/requete/{id}")
	public Response obtenirRequeteRest(@PathParam("id") String idString) {
		Integer id = null;
		try {
			id = Integer.valueOf(idString);
		} catch (Exception e) {
			return Response.noContent().build();
		}
		Requete requete = null;
		if (id != null) {
			requete = new Requete();
			requete.setReqId(id);
			try {
				requete= utilisateurService.obtenirRequete(requete);
			} catch (Exception e) {
				return Response.noContent().build();
			}
		}
		return Response.ok(requete).build();
	}
	
	@GET()
	@Path("/{id}/requete")
	public Response obtenirRequeteParUtilisateurRest(@PathParam("id") String idString) {
		Integer id = null;
		try {
			id = Integer.valueOf(idString);
		} catch (Exception e) {
			return Response.noContent().build();
		}
		Utilisateur utilisateur = null;
		List<Requete> requetes = null;
		if (id != null) {
			utilisateur = new Utilisateur();
			utilisateur.setUtilId(id);
			try {
				requetes= utilisateurService.obtenirRequeteParUtilisateur(utilisateur);
			} catch (Exception e) {
				return Response.noContent().build();
			}
		}
		return Response.ok(requetes).build();
	}
	@PUT
	@Path("/requete/{id}")
	public Response modifierRequeteRest(Requete requete, @PathParam("id") String idString) {
		Integer id = null;
		try {
			id = Integer.valueOf(idString);
		} catch (Exception e) {
			return Response.noContent().build();
		}
		if (id != null) {
			requete.setReqId(id);
			try {
				requete= utilisateurService.modifierRequete(requete);
			} catch (Exception e) {
				return Response.noContent().build();
			}
		}
		return Response.ok(requete).build();
	}
	
	@DELETE
	@Path("/requete/{id}")
	public Response supprimerRequeteRest(@PathParam("id") String idString) {
		Integer id = null;
		try {
			id = Integer.valueOf(idString);
		} catch (Exception e) {
			return Response.noContent().build();
		}
		Requete requete = null;
		if (id != null) {
			requete  = new Requete();
			requete.setReqId(id);
			try {
				utilisateurService.supprimerRequete(requete);
			} catch (Exception e) {
				return Response.noContent().build();
			}
		}
		return Response.ok(id).build();
	}
	
	
	

}
