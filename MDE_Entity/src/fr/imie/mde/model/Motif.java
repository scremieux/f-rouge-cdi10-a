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
}