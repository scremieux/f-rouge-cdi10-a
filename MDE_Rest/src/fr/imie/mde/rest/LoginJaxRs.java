package fr.imie.mde.rest;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.imie.mde.interfaceServices.ILoginService;
import fr.imie.mde.model.Utilisateur;


@Stateless
@Path("/login")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class LoginJaxRs {
	@EJB ILoginService loginService;
	@Context HttpServletRequest req;
	@Context HttpServletResponse res;
	
	@POST()
	public Response verifLoginRest(Utilisateur utilisateur) {
		Boolean utilAuth = false;
		if (utilisateur != null) {
			utilAuth = loginService.verifLogin(utilisateur);
			if (utilAuth){
				req.getSession().setAttribute("utilConn", utilisateur.getUtilLogin());
			}
		}
		return Response.ok(utilAuth).build();
	}
}
