package fr.imie.mde.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the niveau_formation database table.
 * 
 */
@Entity
@Table(name="niveau_formation")
@NamedQuery(name="NiveauFormation.findAll", query="SELECT n FROM NiveauFormation n")
public class NiveauFormation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="nf_id")
	private Integer nfId;

	@Column(name="nf_libelle")
	private String nfLibelle;

	public NiveauFormation() {
	}

	public Integer getNfId() {
		return this.nfId;
	}

	public void setNfId(Integer nfId) {
		this.nfId = nfId;
	}

	public String getNfLibelle() {
		return this.nfLibelle;
	}

	public void setNfLibelle(String nfLibelle) {
		this.nfLibelle = nfLibelle;
	}

}