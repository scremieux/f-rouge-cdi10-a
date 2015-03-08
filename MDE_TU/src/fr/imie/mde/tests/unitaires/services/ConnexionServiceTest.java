/**
 * 
 */
package fr.imie.mde.tests.unitaires.services;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import fr.imie.mde.interfaceServices.IConnexionService;
import fr.imie.mde.model.Connexion;
import fr.imie.mde.model.Motif;
import fr.imie.mde.model.Usager;
import fr.imie.mde.services.ConnexionService;

/**
 * @author sebastien
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class ConnexionServiceTest {
	Query query = mock(Query.class);
	
	@Mock
	EntityManager entityManager;

	@InjectMocks
	IConnexionService connexionService = new ConnexionService();

	List<Connexion> connexions;
	List<Motif> motifs;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		connexions = new ArrayList<Connexion>();
		motifs = new ArrayList<Motif>();
	}

	@Test
	public void testListerConnexionsNamedQueryOK() {
		when(entityManager.createNamedQuery(eq("Connexion.findAll"))).thenReturn(query);
		when(query.getResultList()).thenReturn(connexions);
		Assert.assertEquals(connexions, connexionService.listerConnexions());
	}

	@Test
	public void testListerMotifsNamedQueryOK() {
		when(entityManager.createNamedQuery(eq("Motif.findAll"))).thenReturn(query);
		when(query.getResultList()).thenReturn(motifs);
		Assert.assertEquals(motifs, connexionService.listerMotifs());
	}
	
	@Test
	public void testRechercherConnexionParIdConnexionNullOK() {
		Connexion connexion = connexionService.rechercherConnexionParId(null);
		Assert.assertEquals(null, connexion);
	}

	@Test
	public void testRechercherConnexionParIdFindOK() {
		Connexion connexion = new Connexion();
		connexionService.rechercherConnexionParId(connexion);
		verify(entityManager).find(eq(Connexion.class), any(Connexion.class));
	}

	@Test
	public void testRechercherConnexionParIdConnexionNonNullOK() {
		Connexion connexion = new Connexion();
		connexion.setCnxId(1);
		when(entityManager.find(eq(Connexion.class), any(Integer.class))).thenReturn(connexion);
		Assert.assertEquals(connexion, connexionService.rechercherConnexionParId(connexion));
	}

	@Test
	public void testRechercherConnexionsParUsagerNamedQueryOK() {
		when(entityManager.createNamedQuery(eq("Connexion.rechercherParUsager"))).thenReturn(query);
		when(query.setParameter(eq("usager"), any(Usager.class))).thenReturn(query);
		when(query.getResultList()).thenReturn(connexions);
		Assert.assertEquals(connexions, connexionService.rechercherConnexionsParUsager(new Usager()));
	}

	// Motif rechercherMotifParId(Motif motif);

	@Test
	public void testSupprimerConnexionMergeOK() {
		Connexion connexion = new Connexion();
		connexionService.supprimerConnexion(connexion);
		verify(entityManager).merge(any(Connexion.class));
	}

	@Test
	public void testSupprimerConnexionRemoveOK() {
		Connexion connexion = new Connexion();
		connexionService.supprimerConnexion(connexion);
		verify(entityManager).remove(any(Connexion.class));
	}

	@Test
	public void testSupprimerMotifMergeOK() {
		Motif motif = new Motif();
		connexionService.supprimerMotif(motif);
		verify(entityManager).merge(any(Motif.class));
	}

	@Test
	public void testSupprimerMotifRemoveOK() {
		Motif motif = new Motif();
		connexionService.supprimerMotif(motif);
		verify(entityManager).remove(any(Motif.class));
	}

	@Test
	public void testSupprimerConnexionsUsagerPasDeConnexionRemoveOK() {
		when(entityManager.createNamedQuery(eq("Connexion.rechercherParUsager"))).thenReturn(query);
		when(query.setParameter(eq("usager"), any(Usager.class))).thenReturn(query);
		when(query.getResultList()).thenReturn(connexions);
		connexionService.supprimerConnexionsUsager(new Usager());
		verify(entityManager, never()).remove(any(Connexion.class));
	}

	@Test
	public void testSupprimerConnexionsUsagerUneConnexionRemoveOK() {
		when(entityManager.createNamedQuery(eq("Connexion.rechercherParUsager"))).thenReturn(query);
		when(query.setParameter(eq("usager"), any(Usager.class))).thenReturn(query);
		connexions.add(new Connexion());
		when(query.getResultList()).thenReturn(connexions);
		connexionService.supprimerConnexionsUsager(new Usager());
		verify(entityManager).remove(any(Connexion.class));
	}

	@Test
	public void testSupprimerConnexionsUsagerListeConnexionsRemoveOK() {
		when(entityManager.createNamedQuery(eq("Connexion.rechercherParUsager"))).thenReturn(query);
		when(query.setParameter(eq("usager"), any(Usager.class))).thenReturn(query);
		connexions.add(new Connexion());
		connexions.add(new Connexion());
		connexions.add(new Connexion());
		connexions.add(new Connexion());
		when(query.getResultList()).thenReturn(connexions);
		connexionService.supprimerConnexionsUsager(new Usager());
		verify(entityManager, times(4)).remove(any(Connexion.class));
	}

	@Test
	public void testCreerConnexionPersistOK() {
		connexionService.creerConnexion(new Connexion());
		verify(entityManager).persist(any(Motif.class));
	}

	@Test
	public void testCreerMotifPersistOK() {
		connexionService.creerMotif(new Motif());
		verify(entityManager).persist(any(Motif.class));
	}

	@Test
	public void testModifierConnexionMergeOK() {
		connexionService.modifierConnexion(new Connexion());
		verify(entityManager).merge(any(Motif.class));
	}

	@Test
	public void testModifierMotifMergeOK() {
		connexionService.modifierMotif(new Motif());
		verify(entityManager).merge(any(Motif.class));
	}
}
