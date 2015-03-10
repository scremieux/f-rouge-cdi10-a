package fr.imie.mde.model;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the poste database table.
 * 
 */
@Entity

@NamedQueries({
	@NamedQuery(name="Poste.findAll", query="SELECT p FROM Poste p"),
	@NamedQuery(name="Poste.rechercherParSalle", query = "SELECT p FROM Poste p WHERE salle=:salle")
}) 

public class Poste implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="poste_id")
	private Integer posteId;

	@Column(name="poste_ip")
	private String posteIp;

	@Column(name="poste_nom")
	private String posteNom;

	//bi-directional many-to-one association to Salle
	@ManyToOne
	@JoinColumn(name="salle_id")
	private Salle salle;

	@Column(name="poste_disponible")
	private Boolean posteDisponible;

	public Poste() {
	}

	public Integer getPosteId() {
		return this.posteId;
	}

	public void setPosteId(Integer posteId) {
		this.posteId = posteId;
	}

	public String getPosteIp() {
		return this.posteIp;
	}

	public void setPosteIp(String posteIp) {
		this.posteIp = posteIp;
	}

	public String getPosteNom() {
		return this.posteNom;
	}

	public void setPosteNom(String posteNom) {
		this.posteNom = posteNom;
	}

	public Salle getSalle() {
		return this.salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	public Boolean isPosteDisponible() {
		return this.posteDisponible;
	}

	public void setPosteDisponible(Boolean posteDisponible) {
		this.posteDisponible = posteDisponible;
	}

}