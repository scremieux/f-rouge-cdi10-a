package fr.imie.mde.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.imie.mde.interfaceServices.IConnexionService;
@Stateless
@LocalBean
public class ConnexionService implements IConnexionService {
	@PersistenceContext
	EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public ConnexionService() {
        // TODO Auto-generated constructor stub
    }
}
