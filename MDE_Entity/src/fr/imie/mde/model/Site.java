package fr.imie.mde.model;

import java.io.Serializable;

import javax.inject.Named;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the site database table.
 * 
 */

@Entity
@NamedQuery(name="Site.findAll", query="SELECT s FROM Site s")
public class Site implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="site_id")
	private Integer siteId;

	@Column(name="site_nom")
	private String siteNom;

	public Site() {
	}

	public Integer getSiteId() {
		return this.siteId;
	}

	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}

	public String getSiteNom() {
		return this.siteNom;
	}

	public void setSiteNom(String siteNom) {
		this.siteNom = siteNom;
	}
}