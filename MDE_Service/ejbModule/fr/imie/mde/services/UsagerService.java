package fr.imie.mde.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.imie.mde.interfaceServices.IUsagerService;
import fr.imie.mde.model.Csp;

@Stateless
@LocalBean
public class UsagerService implements IUsagerService {
	@PersistenceContext
	EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public UsagerService() {
        // TODO Auto-generated constructor stub
    }

    
	@Override
	public List<Csp> findAllCsp() {
		// TODO Auto-generated method stub
		Query query = entityManager.createNamedQuery("Csp.findAll"); 
    	List<Csp> cspList = query.getResultList();
		return cspList;
	}

}
