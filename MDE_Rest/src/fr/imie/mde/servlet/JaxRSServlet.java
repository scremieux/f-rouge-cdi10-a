package fr.imie.mde.servlet;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.imie.mde.interfaceServices.IUtilisateurService;
import fr.imie.mde.model.Poste;
import fr.imie.mde.model.Salle;
import fr.imie.mde.model.Site;
import fr.imie.mde.model.Structure;

@Stateless
@Path("/utilisateur")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class JaxRSServlet {
	@EJB IUtilisateurService utilService;
	
	@GET()
	@Path("/sites")
	public Response listerSitesRest(){
		List<Site> sites = new ArrayList<Site>();
		sites = utilService.listerSites();
		return Response.ok(sites).build();
	}	
	
	@GET()
	@Path("/salles")
	public Response listerSallesRest(){
		List<Salle> salles = new ArrayList<Salle>();
		salles = utilService.listerSalles();
		return Response.ok(salles).build();
	}
	
	@GET()
	@Path("/salles/{id}")
	public Response listerSallesSitesRest(@PathParam("id") Integer id){
		List<Salle> salles = new ArrayList<Salle>();
		Site site = new Site();
		site.setSiteId(id);
		salles = utilService.listerSallesParSite(site);
		return Response.ok(salles).build();
	}
	
	@GET()
	@Path("/postes")
	public Response listerPostesRest(){
		List<Poste> postes = new ArrayList<Poste>();
		postes = utilService.listerPostes();
		return Response.ok(postes).build();
	}
	
	@GET()
	@Path("/postes/{id}")
	public Response listerPostesSalleRest(@PathParam("id") Integer id){
		List<Poste> postes = new ArrayList<Poste>();
		Salle salle = new Salle();
		salle.setSalleId(id);
		postes = utilService.listerPostesParSalle(salle);
		return Response.ok(postes).build();
	}
	
	
	@GET()
	@Path("/structures")
	public Response listerStructuresRest(){
		List<Structure> structures = new ArrayList<Structure>();
		structures = utilService.listerStructures();
		return Response.ok(structures).build();
	}
}
