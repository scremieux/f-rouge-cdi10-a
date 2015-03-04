package fr.imie.mde.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

/**
 * Servlet Filter implementation class CORSFilter
 */
@Provider
public class CORSFilter implements ContainerResponseFilter {

    /**
     * Default constructor. 
     */
    public CORSFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ContainerResponseFilter#filter(ContainerRequestContext, ContainerResponseContext)
     */
    @Override
    public void filter(final ContainerRequestContext requestContext,
                       final ContainerResponseContext cres) throws IOException {
       cres.getHeaders().add("Access-Control-Allow-Origin", "*");
       cres.getHeaders().add("Access-Control-Allow-Headers", "origin, content-type, accept, authorization");
       cres.getHeaders().add("Access-Control-Allow-Credentials", "false");
       cres.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
       cres.getHeaders().add("Access-Control-Max-Age", "1209600");
    }
}
