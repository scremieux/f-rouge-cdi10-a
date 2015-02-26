package fr.imie.mde.rest;

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

import fr.imie.mde.interfaceServices.ISiteService;
import fr.imie.mde.model.Poste;
import fr.imie.mde.model.Salle;
import fr.imie.mde.model.Site;
import fr.imie.mde.model.Structure;

@Stateless
@Path("/site")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class SiteJaxRS {
	@EJB ISiteService siteService;
	
	
	@GET()
	public Response listerSitesRest(){
		List<Site> sites = new ArrayList<Site>();
		sites = siteService.listerSites();
		return Response.ok(sites).build();
	}	
	
	@GET()
	@Path("/salle")
	public Response listerSallesRest(){
		List<Salle> salles = new ArrayList<Salle>();
		salles = siteService.listerSalles();
		return Response.ok(salles).build();
	}
	
	@GET()
	@Path("/salle/{id}")
	public Response listerSallesSitesRest(@PathParam("id") Integer id){
		List<Salle> salles = new ArrayList<Salle>();
		Site site = new Site();
		site.setSiteId(id);
		salles = siteService.listerSallesParSite(site);
		return Response.ok(salles).build();
	}
	
	@GET()
	@Path("/salle/poste")
	public Response listerPostesRest(){
		List<Poste> postes = new ArrayList<Poste>();
		postes = siteService.listerPostes();
		return Response.ok(postes).build();
	}
	
	@GET()
	@Path("/salle/poste/{id}")
	public Response listerPostesSalleRest(@PathParam("id") Integer id){
		List<Poste> postes = new ArrayList<Poste>();

		Salle salle = new Salle();
		salle.setSalleId(id);
		postes = siteService.listerPostesParSalle(salle);
		return Response.ok(postes).build();
	}
	
	
	
	
}
