package fr.imie.mde.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the salle database table.
 * 
 */
@Entity
@NamedQuery(name="Salle.findAll", query="SELECT s FROM Salle s")

public class Salle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="salle_id")
	private Integer salleId;

	@Column(name="salle_nom")
	private String salleNom;

	//bi-directional many-to-one association to Poste
	@OneToMany(mappedBy="salle", cascade = CascadeType.REMOVE)
	private List<Poste> postes;

	//bi-directional many-to-one association to Site
	@ManyToOne
	@JoinColumn(name="site_id")
	private Site site;

	public Salle() {
	}

	public Integer getSalleId() {
		return this.salleId;
	}

	public void setSalleId(Integer salleId) {
		this.salleId = salleId;
	}

	public String getSalleNom() {
		return this.salleNom;
	}

	public void setSalleNom(String salleNom) {
		this.salleNom = salleNom;
	}

	public List<Poste> getPostes() {
		return this.postes;
	}

	public void setPostes(List<Poste> postes) {
		this.postes = postes;
	}

	public Poste addPoste(Poste poste) {
		getPostes().add(poste);
		poste.setSalle(this);

		return poste;
	}

	public Poste removePoste(Poste poste) {
		getPostes().remove(poste);
		poste.setSalle(null);

		return poste;
	}

	public Site getSite() {
		return this.site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

}