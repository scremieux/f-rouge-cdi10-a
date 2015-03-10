package fr.imie.mde.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


/**
 * The persistent class for the connexion database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Connexion.findAll", query="SELECT c FROM Connexion c"),
	@NamedQuery(name="Connexion.rechercherParUsager", query = "SELECT c FROM Connexion c WHERE usager=:usager"),
	@NamedQuery(name="Connexion.rechercherParPoste", query = "SELECT c FROM Connexion c WHERE poste=:poste")
}) 
public class Connexion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cnx_id")
	private Integer cnxId;

	@Column(name="cnx_date")
	private Date cnxDate;

	public Date getCnxDate() {
		return cnxDate;
	}

	public void setCnxDate(Date cnxDate) {
		this.cnxDate = cnxDate;
	}

	@Column(name="cnx_duree_prevue")
	private Time cnxDureePrevue;
	
	//bi-directional many-to-one association to Motif
	@ManyToOne
	@JoinColumn(name="mt_id")
	private Motif motif;

	//uni-directional many-to-one association to Poste
	@ManyToOne
	@JoinColumn(name="poste_id")
	private Poste poste;

	//bi-directional many-to-one association to Usager
	@ManyToOne
	@JoinColumn(name="usager_id")
	private Usager usager;

	//uni-directional many-to-one association to Utilisateur
	@ManyToOne
	@JoinColumn(name="util_id")
	private Utilisateur utilisateur;
	
	@Column(name="cnx_heure_debut")
	private Time cnxHeureDebut;

	@Column(name="cnx_heure_fin")
	private Time cnxHeureFin;


	public Connexion() {
	}

	public Integer getCnxId() {
		return this.cnxId;
	}

	public void setCnxId(Integer cnxId) {
		this.cnxId = cnxId;
	}

	public Time getCnxDureePrevue() {
		return this.cnxDureePrevue;
	}

	public void setCnxDureePrevue(Time cnxDureePrevue) {
		this.cnxDureePrevue = cnxDureePrevue;
	}

	public Motif getMotif() {
		return this.motif;
	}

	public void setMotif(Motif motif) {
		this.motif = motif;
	}

	public Poste getPoste() {
		return this.poste;
	}

	public void setPoste(Poste poste) {
		this.poste = poste;
	}

	public Usager getUsager() {
		return this.usager;
	}

	public void setUsager(Usager usager) {
		this.usager = usager;
	}

	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Time getCnxHeureDebut() {
		return this.cnxHeureDebut;
	}

	public void setCnxHeureDebut(Time cnxHeureDebut) {
		this.cnxHeureDebut = cnxHeureDebut;
	}
	public Time getCnxHeureFin() {
		return this.cnxHeureFin;
	}

	public void setCnxHeureFin(Time cnxHeureFin) {
		this.cnxHeureFin = cnxHeureFin;
	}

}