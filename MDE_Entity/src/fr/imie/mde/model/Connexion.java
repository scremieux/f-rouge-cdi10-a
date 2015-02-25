package fr.imie.mde.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;


/**
 * The persistent class for the connexion database table.
 * 
 */
@Entity
@NamedQuery(name="Connexion.findAll", query="SELECT c FROM Connexion c")
public class Connexion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cnx_id")
	private Integer cnxId;

	@Column(name="cnx_dt_heure_debut")
	private Timestamp cnxDtHeureDebut;

	@Column(name="cnx_dt_heure_fin")
	private Timestamp cnxDtHeureFin;

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

	public Connexion() {
	}

	public Integer getCnxId() {
		return this.cnxId;
	}

	public void setCnxId(Integer cnxId) {
		this.cnxId = cnxId;
	}

	public Timestamp getCnxDtHeureDebut() {
		return this.cnxDtHeureDebut;
	}

	public void setCnxDtHeureDebut(Timestamp cnxDtHeureDebut) {
		this.cnxDtHeureDebut = cnxDtHeureDebut;
	}

	public Timestamp getCnxDtHeureFin() {
		return this.cnxDtHeureFin;
	}

	public void setCnxDtHeureFin(Timestamp cnxDtHeureFin) {
		this.cnxDtHeureFin = cnxDtHeureFin;
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

}