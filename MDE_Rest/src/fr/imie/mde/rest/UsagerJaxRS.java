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

@Stateless
@Path("/usager")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class UsagerJaxRS {
	@EJB IUsagerService usagerService;

	@GET()
	public Response listerUsagersRest(){
		List<Usager> usagers = new ArrayList<Usager>();
		usagers = usagerService.listerUsagers();
		return Response.ok(usagers).build();
	}
	
	@GET()
	@Path("/csp")
	public Response listerCspRest(){
		List<Csp> cspList = new ArrayList<Csp>();
		cspList = usagerService.listerCsp();
		return Response.ok(cspList).build();
	}

	@GET()
	@Path("/quartier")
	public Response listerQuartiersRest(){
		List<Quartier> quartiers = new ArrayList<Quartier>();
		quartiers = usagerService.listerQuartiers();
		return Response.ok(quartiers).build();
	}


	@GET()
	@Path("/nf")
	public Response listerNiveauxFormationRest(){
		List<NiveauFormation> nfList = new ArrayList<NiveauFormation>();
		nfList = usagerService.listerNiveauxFormation();
		return Response.ok(nfList).build();
	}
	
	@GET()
	@Path("/{id}")
	public Response rechercherUsagerParId(@PathParam("id") String idString) {
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
	
	@GET()
	@Path("/csp/{id}")
	public Response rechercherCspParId(@PathParam("id") String idString) {
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
	
	@GET()
	@Path("/quartier/{id}")
	public Response rechercherQuartierParId(@PathParam("id") String idString) {
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
	
	@GET()
	@Path("/nf/{id}")
	public Response rechercherNiveauFormationParId(@PathParam("id") String idString) {
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
	
	@DELETE()
	@Path("/{id}")
	public Response supprimerUsager(@PathParam("id") String idString) {
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

	@DELETE()
	@Path("/csp/{id}")
	public Response supprimerCsp(@PathParam("id") String idString) {
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

	@DELETE()
	@Path("/quartier/{id}")
	public Response supprimerQuartier(@PathParam("id") String idString) {
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

	@DELETE()
	@Path("/nf/{id}")
	public Response supprimerNiveauFormation(@PathParam("id") String idString) {
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
	
	@POST()
	public Response creerUsager(Usager usager) {
		if (usager != null) {
			usagerService.creerUsager(usager);
		}
		return Response.ok(usager).build();
	}

	@POST()
	@Path("/csp")
	public Response creerCsp(Csp csp) {
		if (csp != null) {
			usagerService.creerCsp(csp);
		}
		return Response.ok(csp).build();
	}
	
	@POST()
	@Path("/quartier")
	public Response creerQuartier(Quartier quartier) {
		if (quartier != null) {
			usagerService.creerQuartier(quartier);
		}
		return Response.ok(quartier).build();
	}

	@POST()
	@Path("/nf")
	public Response creerNiveauFormation(NiveauFormation niveauFormation) {
		if (niveauFormation != null) {
			usagerService.creerNiveauFormation(niveauFormation);
		}
		return Response.ok(niveauFormation).build();
	}

	
	
	
	
	
	@PUT
	@Path("/{id}")
	public Response modifierUsager(Usager usager, @PathParam("id") String idString) {
		Integer id = null;
		try {
			id = Integer.valueOf(idString);
		} catch (Exception e) {
			return Response.noContent().build();
		}

		if (id != null && usager != null) {
			usager.setUsagerId(id);
			usagerService.modifierUsager(usager);
			return Response.ok(usager).build();
		} else {
			return Response.noContent().build();
		}
	}

	@PUT
	@Path("/csp/{id}")
	public Response modifierCsp(Csp csp, @PathParam("id") String idString) {
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
	
	@PUT
	@Path("/quartier/{id}")
	public Response modifierQuartier(Quartier quartier, @PathParam("id") String idString) {
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
	
	@PUT
	@Path("/nf/{id}")
	public Response modifierNiveauFormation(NiveauFormation niveauFormation, @PathParam("id") String idString) {
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
