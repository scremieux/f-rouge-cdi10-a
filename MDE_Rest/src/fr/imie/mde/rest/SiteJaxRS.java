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

import fr.imie.mde.interfaceServices.ISiteService;
import fr.imie.mde.model.Poste;
import fr.imie.mde.model.Salle;
import fr.imie.mde.model.Site;
import fr.imie.mde.model.Structure;
import fr.imie.mde.model.Usager;

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
	
	@POST()
	public Response creerSiteRest(Site site){
		site = siteService.creerSite(site);
		return Response.ok(site).build();		
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
		Site site = null;
		if (id != null) {
			site = new Site();
			site.setSiteId(id);
			try {
				site = siteService.obtenirSite(site);
			} catch (Exception e) {
				return Response.noContent().build();
			}
		}
		return Response.ok(site).build();
	}
	
	@PUT
	@Path("/{id}")
	public Response modifierSiteRest(Site site, @PathParam("id") String idString) {
		Integer id = null;
		try {
			id = Integer.valueOf(idString);
		} catch (Exception e) {
			return Response.noContent().build();
		}
		if (id != null) {

			site.setSiteId(id);
			try {
				site = siteService.modifierSite(site);
			} catch (Exception e) {
				return Response.noContent().build();
			}
		}
		return Response.ok(site).build();
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
		Site site = null;
		if (id != null) {
			site = new Site();
			site.setSiteId(id);
			try {
				siteService.supprimerSite(site);
			} catch (Exception e) {
				return Response.noContent().build();
			}
		}
		return Response.ok(id).build();
	}
	
	@GET()
	@Path("/salle")
	public Response listerSallesRest(){
		List<Salle> salles = new ArrayList<Salle>();
		salles = siteService.listerSalles();
		return Response.ok(salles).build();
	}
	
	@POST()
	@Path("/salle")
	public Response creerSalleRest(Salle salle){
		salle = siteService.creerSalle(salle);
		return Response.ok(salle).build();		
	}
	
	@GET()
	@Path("/salle/{id}")
	public Response obtenirSalleRest(@PathParam("id") String idString) {
		Integer id = null;
		try {
			id = Integer.valueOf(idString);
		} catch (Exception e) {
			return Response.noContent().build();
		}
		Salle salle = null;
		if (id != null) {
			salle  = new Salle();
			salle.setSalleId(id);
			try {
				salle= siteService.obtenirSalle(salle);
			} catch (Exception e) {
				return Response.noContent().build();
			}
		}
		return Response.ok(salle).build();
	}
	@PUT
	@Path("/salle/{id}")
	public Response modifierSalleRest(Salle salle, @PathParam("id") String idString) {
		Integer id = null;
		try {
			id = Integer.valueOf(idString);
		} catch (Exception e) {
			return Response.noContent().build();
		}
		if (id != null) {

			salle.setSalleId(id);
			try {
				salle= siteService.modifierSalle(salle);
			} catch (Exception e) {
				return Response.noContent().build();
			}
		}
		return Response.ok(salle).build();
	}
	
	@DELETE
	@Path("/salle/{id}")
	public Response supprimerSalleRest(@PathParam("id") String idString) {
		Integer id = null;
		try {
			id = Integer.valueOf(idString);
		} catch (Exception e) {
			return Response.noContent().build();
		}
		Salle salle = null;
		if (id != null) {
			salle  = new Salle();
			salle.setSalleId(id);
			try {
				siteService.supprimerSalle(salle);
			} catch (Exception e) {
				return Response.noContent().build();
			}
		}
		return Response.ok(id).build();
	}
	
	
	
	@GET()
	@Path("/salle/poste")
	public Response listerPostesRest(){
		List<Poste> postes = new ArrayList<Poste>();
		postes = siteService.listerPostes();
		return Response.ok(postes).build();
	}
	
	@POST()
	@Path("/salle/poste")
	public Response creerPosteRest(Poste poste){
		poste = siteService.creerPoste(poste);
		return Response.ok(poste).build();		
	}
	
	@GET()
	@Path("/salle/poste/{id}")
	public Response obtenirPosteRest(@PathParam("id") String idString) {
		Integer id = null;
		try {
			id = Integer.valueOf(idString);
		} catch (Exception e) {
			return Response.noContent().build();
		}
		Poste poste = null;
		if (id != null) {
			poste = new Poste();
			poste.setPosteId(id);
			try {
				poste = siteService.obtenirPoste(poste);
			} catch (Exception e) {
				return Response.noContent().build();
			}
		}

		return Response.ok(poste).build();
	}
	
	@PUT
	@Path("/salle/poste/{id}")
	public Response modifierPosteRest(Poste poste, @PathParam("id") String idString) {
		Integer id = null;
		try {
			id = Integer.valueOf(idString);
		} catch (Exception e) {
			return Response.noContent().build();
		}
		if (id != null) {

			poste.setPosteId(id);
			try {
				poste = siteService.modifierPoste(poste);
			} catch (Exception e) {
				return Response.noContent().build();
			}
		}
		return Response.ok(poste).build();
	}
	
	
	@DELETE
	@Path("/salle/poste/{id}")
	public Response supprimerPosteRest(@PathParam("id") String idString) {
		Integer id = null;
		try {
			id = Integer.valueOf(idString);
		} catch (Exception e) {
			return Response.noContent().build();
		}
		Poste poste = null;
		if (id != null) {
			poste = new Poste();
			poste.setPosteId(id);
			try {
				siteService.supprimerPoste(poste);
			} catch (Exception e) {
				return Response.noContent().build();
			}
		}

		return Response.ok(id).build();
	}
	
	
	
}
