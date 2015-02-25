package fr.imie.mde.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the csp database table.
 * 
 */
@Entity
@NamedQuery(name="Csp.findAll", query="SELECT c FROM Csp c")
public class Csp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="csp_id")
	private Integer cspId;

	@Column(name="csp_nom")
	private String cspNom;

	public Csp() {
	}

	public Integer getCspId() {
		return this.cspId;
	}

	public void setCspId(Integer cspId) {
		this.cspId = cspId;
	}

	public String getCspNom() {
		return this.cspNom;
	}

	public void setCspNom(String cspNom) {
		this.cspNom = cspNom;
	}

}