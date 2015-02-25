package fr.imie.mde.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the quartier database table.
 * 
 */
@Entity
@NamedQuery(name="Quartier.findAll", query="SELECT q FROM Quartier q")
public class Quartier implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="quartier_id")
	private Integer quartierId;

	@Column(name="quartier_cp")
	private String quartierCp;

	@Column(name="quartier_nom")
	private String quartierNom;

	@Column(name="quartier_ville")
	private String quartierVille;

	public Quartier() {
	}

	public Integer getQuartierId() {
		return this.quartierId;
	}

	public void setQuartierId(Integer quartierId) {
		this.quartierId = quartierId;
	}

	public String getQuartierCp() {
		return this.quartierCp;
	}

	public void setQuartierCp(String quartierCp) {
		this.quartierCp = quartierCp;
	}

	public String getQuartierNom() {
		return this.quartierNom;
	}

	public void setQuartierNom(String quartierNom) {
		this.quartierNom = quartierNom;
	}

	public String getQuartierVille() {
		return this.quartierVille;
	}

	public void setQuartierVille(String quartierVille) {
		this.quartierVille = quartierVille;
	}

}