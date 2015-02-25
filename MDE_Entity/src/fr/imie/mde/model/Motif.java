package fr.imie.mde.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the motif database table.
 * 
 */
@Entity
@NamedQuery(name="Motif.findAll", query="SELECT m FROM Motif m")
public class Motif implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="mt_id")
	private Integer mtId;

	@Column(name="mt_libelle")
	private String mtLibelle;

	//bi-directional many-to-one association to Connexion
	@OneToMany(mappedBy="motif")
	private List<Connexion> connexions;

	public Motif() {
	}

	public Integer getMtId() {
		return this.mtId;
	}

	public void setMtId(Integer mtId) {
		this.mtId = mtId;
	}

	public String getMtLibelle() {
		return this.mtLibelle;
	}

	public void setMtLibelle(String mtLibelle) {
		this.mtLibelle = mtLibelle;
	}

	public List<Connexion> getConnexions() {
		return this.connexions;
	}

	public void setConnexions(List<Connexion> connexions) {
		this.connexions = connexions;
	}

	public Connexion addConnexion(Connexion connexion) {
		getConnexions().add(connexion);
		connexion.setMotif(this);

		return connexion;
	}

	public Connexion removeConnexion(Connexion connexion) {
		getConnexions().remove(connexion);
		connexion.setMotif(null);

		return connexion;
	}

}