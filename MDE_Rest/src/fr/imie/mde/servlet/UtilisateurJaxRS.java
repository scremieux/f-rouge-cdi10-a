package fr.imie.mde.servlet;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.imie.mde.interfaceServices.IUtilisateurService;
import fr.imie.mde.model.Requete;


@Stateless
@Path("/utilisateur")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class UtilisateurJaxRS {
	@EJB IUtilisateurService utilisateurService;
	
	
	@GET()
	@Path("/requetes")
	public Response listerRequetesRest(){
		List<Requete> requetes = new ArrayList<Requete>();
		requetes = utilisateurService.listerRequetes();
		return Response.ok(requetes).build();
	}
	
	@POST()
	public Response creerRequeteRest(Requete requete){
		requete = utilisateurService.creerRequete(requete);
		return Response.ok(requete).build();
	}
}
