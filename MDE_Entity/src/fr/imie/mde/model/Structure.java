package fr.imie.mde.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the structure database table.
 * 
 */
@Entity
@NamedQuery(name="Structure.findAll", query="SELECT s FROM Structure s")
public class Structure implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="struct_id")
	private Integer structId;

	@Column(name="struct_libelle")
	private String structLibelle;

	public Structure() {
	}

	public Integer getStructId() {
		return this.structId;
	}

	public void setStructId(Integer structId) {
		this.structId = structId;
	}

	public String getStructLibelle() {
		return this.structLibelle;
	}

	public void setStructLibelle(String structLibelle) {
		this.structLibelle = structLibelle;
	}

}