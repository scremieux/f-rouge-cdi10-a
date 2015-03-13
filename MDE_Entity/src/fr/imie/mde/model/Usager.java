package fr.imie.mde.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the usager database table.
 * 
 */
@Entity
@NamedQuery(name="Usager.findAll", query="SELECT u FROM Usager u")
public class Usager implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="usager_id")
	private Integer usagerId;

	@Column(name="usager_civilite")
	private Integer usagerCivilite;

	@Temporal(TemporalType.DATE)
	@Column(name="usager_dt_exclusion")
	private Date usagerDtExclusion;

	@Temporal(TemporalType.DATE)
	@Column(name="usager_dt_inscription")
	private Date usagerDtInscription;

	@Temporal(TemporalType.DATE)
	@Column(name="usager_dt_naiss")
	private Date usagerDtNaiss;

	@Column(name="usager_email")
	private String usagerEmail;

	@Column(name="usager_exclu_service")
	private Boolean usagerExcluService;

	@Column(name="usager_mission_locale")
	private Boolean usagerMissionLocale;

	@Column(name="usager_nom")
	private String usagerNom;

	@Column(name="usager_prenom")
	private String usagerPrenom;

	//uni-directional many-to-one association to Csp
	@ManyToOne
	@JoinColumn(name="csp_id")
	private Csp csp;

	//uni-directional many-to-one association to NiveauFormation
	@ManyToOne
	@JoinColumn(name="nf_id")
	private NiveauFormation niveauFormation;

	//uni-directional many-to-one association to Quartier
	@ManyToOne
	@JoinColumn(name="quartier_id")
	private Quartier quartier;
	
	@Column(name="usager_connecte")
	private Boolean usagerConnecte;

	public Usager() {
	}

	public Integer getUsagerId() {
		return this.usagerId;
	}

	public void setUsagerId(Integer usagerId) {
		this.usagerId = usagerId;
	}

	public Integer getUsagerCivilite() {
		return this.usagerCivilite;
	}

	public void setUsagerCivilite(Integer usagerCivilite) {
		this.usagerCivilite = usagerCivilite;
	}

	public Date getUsagerDtExclusion() {
		return this.usagerDtExclusion;
	}

	public void setUsagerDtExclusion(Date usagerDtExclusion) {
		this.usagerDtExclusion = usagerDtExclusion;
	}

	public Date getUsagerDtInscription() {
		return this.usagerDtInscription;
	}

	public void setUsagerDtInscription(Date usagerDtInscription) {
		this.usagerDtInscription = usagerDtInscription;
	}

	public Date getUsagerDtNaiss() {
		return this.usagerDtNaiss;
	}

	public void setUsagerDtNaiss(Date usagerDtNaiss) {
		this.usagerDtNaiss = usagerDtNaiss;
	}

	public String getUsagerEmail() {
		return this.usagerEmail;
	}

	public void setUsagerEmail(String usagerEmail) {
		this.usagerEmail = usagerEmail;
	}

	public Boolean getUsagerExcluService() {
		return this.usagerExcluService;
	}

	public void setUsagerExcluService(Boolean usagerExcluService) {
		this.usagerExcluService = usagerExcluService;
	}

	public Boolean getUsagerMissionLocale() {
		return this.usagerMissionLocale;
	}

	public void setUsagerMissionLocale(Boolean usagerMissionLocale) {
		this.usagerMissionLocale = usagerMissionLocale;
	}

	public String getUsagerNom() {
		return this.usagerNom;
	}

	public void setUsagerNom(String usagerNom) {
		this.usagerNom = usagerNom;
	}

	public String getUsagerPrenom() {
		return this.usagerPrenom;
	}

	public void setUsagerPrenom(String usagerPrenom) {
		this.usagerPrenom = usagerPrenom;
	}

//	public List<Connexion> getConnexions() {
//		return this.connexions;
//	}
//
//	public void setConnexions(List<Connexion> connexions) {
//		this.connexions = connexions;
//	}
//
//	public Connexion addConnexion(Connexion connexion) {
//		getConnexions().add(connexion);
//		connexion.setUsager(this);
//
//		return connexion;
//	}
//
//	public Connexion removeConnexion(Connexion connexion) {
//		getConnexions().remove(connexion);
//		connexion.setUsager(null);
//
//		return connexion;
//	}

	public Csp getCsp() {
		return this.csp;
	}

	public void setCsp(Csp csp) {
		this.csp = csp;
	}

	public NiveauFormation getNiveauFormation() {
		return this.niveauFormation;
	}

	public void setNiveauFormation(NiveauFormation niveauFormation) {
		this.niveauFormation = niveauFormation;
	}

	public Quartier getQuartier() {
		return this.quartier;
	}

	public void setQuartier(Quartier quartier) {
		this.quartier = quartier;
	}

	public Boolean isUsagerConnecte() {
		return usagerConnecte;
	}

	public void setUsagerConnecte(Boolean usagerConnecte) {
		this.usagerConnecte = usagerConnecte;
	}

}