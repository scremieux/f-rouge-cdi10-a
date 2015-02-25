package fr.imie.mde.interfaceServices;

import java.util.List;

import javax.ejb.Local;

import fr.imie.mde.model.Csp;
import fr.imie.mde.model.Site;

@Local
public interface IUsagerService {
	List<Csp> findAllCsp();


}
