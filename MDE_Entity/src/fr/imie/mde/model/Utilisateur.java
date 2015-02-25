package fr.imie.mde.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the utilisateur database table.
 * 
 */
@Entity
@NamedQuery(name="Utilisateur.findAll", query="SELECT u FROM Utilisateur u")
public class Utilisateur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="util_id")
	private Integer utilId;

	@Column(name="util_admin")
	private Boolean utilAdmin;

	@Column(name="util_login")
	private String utilLogin;

	@Column(name="util_mdp")
	private String utilMdp;

	@Column(name="util_nom")
	private String utilNom;

	@Column(name="util_prenom")
	private String utilPrenom;

	//uni-directional many-to-one association to Site
	@ManyToOne
	@JoinColumn(name="site_id")
	private Site site;

	//uni-directional many-to-one association to Structure
	@ManyToOne
	@JoinColumn(name="struct_id")
	private Structure structure;

	public Utilisateur() {
	}

	public Integer getUtilId() {
		return this.utilId;
	}

	public void setUtilId(Integer utilId) {
		this.utilId = utilId;
	}

	public Boolean getUtilAdmin() {
		return this.utilAdmin;
	}

	public void setUtilAdmin(Boolean utilAdmin) {
		this.utilAdmin = utilAdmin;
	}

	public String getUtilLogin() {
		return this.utilLogin;
	}

	public void setUtilLogin(String utilLogin) {
		this.utilLogin = utilLogin;
	}

	public String getUtilMdp() {
		return this.utilMdp;
	}

	public void setUtilMdp(String utilMdp) {
		this.utilMdp = utilMdp;
	}

	public String getUtilNom() {
		return this.utilNom;
	}

	public void setUtilNom(String utilNom) {
		this.utilNom = utilNom;
	}

	public String getUtilPrenom() {
		return this.utilPrenom;
	}

	public void setUtilPrenom(String utilPrenom) {
		this.utilPrenom = utilPrenom;
	}

	public Site getSite() {
		return this.site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	public Structure getStructure() {
		return this.structure;
	}

	public void setStructure(Structure structure) {
		this.structure = structure;
	}

}