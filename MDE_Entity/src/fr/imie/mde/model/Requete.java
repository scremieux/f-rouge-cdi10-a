package fr.imie.mde.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the requete database table.
 * 
 */
@Entity
@NamedQuery(name="Requete.findAll", query="SELECT r FROM Requete r")
public class Requete implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="req_id")
	private Integer reqId;

	@Column(name="req_nom")
	private String reqNom;

	@Column(name="req_requete")
	private String reqRequete;

	//uni-directional many-to-one association to Utilisateur
	@ManyToOne
	@JoinColumn(name="util_id")
	private Utilisateur utilisateur;

	public Requete() {
	}

	public Integer getReqId() {
		return this.reqId;
	}

	public void setReqId(Integer reqId) {
		this.reqId = reqId;
	}

	public String getReqNom() {
		return this.reqNom;
	}

	public void setReqNom(String reqNom) {
		this.reqNom = reqNom;
	}

	public String getReqRequete() {
		return this.reqRequete;
	}

	public void setReqRequete(String reqRequete) {
		this.reqRequete = reqRequete;
	}

	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

}