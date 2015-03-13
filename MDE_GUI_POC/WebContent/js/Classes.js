function Motif() {
	this.mtId = null;
	this.mtLibelle = null;
}

function NiveauFormation() {
	this.nfId = null;
	this.nfLibelle = null;
}

function Csp() {
	this.cspId = null;
	this.cspNom = null;
}

function Quartier() {
	this.quartierId	= null;
	this.quartierCp	= null;
	this.quartierNom = null;
	this.quartierVille = null;
}

function Usager() {
	this.usagerCivilite = null;
	this.usagerNom = null;
	this.usagerPrenom = null;
	this.usagerDtNaiss = null;
	this.usagerEmail = null;		
	this.usagerMissionLocale = null;
	this.usagerExcluService = null;
	this.usagerDtExclusion = null;
	this.csp = new Csp();
	this.niveauFormation = new NiveauFormation();
	this.quartier = new Quartier();
	this.usagerConnecte = null;
}

function Poste() {
	this.posteId = null;
	this.posteIp = null;
	this.posteNom = null;
	this.posteDisponible = null;
}

function Connexion() {
	this.cnxId = null;
	this.cnxDureePrevue = null;
	this.motif = new Motif();
	this.usager = new Usager();
	this.poste = new Poste();
}

