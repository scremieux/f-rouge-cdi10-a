/**
 * @module creerUsagerService
 * Service de vérification de saisie pour la création d'un usager.
 * @author P42
 * @name creerUsagerService.js
 * @link ng.$http
 * @link ng.$filter
 */
var services = angular.module('services', []);

services.factory('creerUsagerService', ['$http', '$filter', function ($http, $filter) {
	var creerUsagerService = {};
	
	/**
	 * @function Convertir une date 'dd/MM/yyyy' au format 'yyyy-MM-dd'
	 * @param {{string}} date  Date au format 'dd/MM/yyyy'
	 * @return {{date}} 
	 */
	function convertirDate (date) {
		return Date.parse(date.substring(6,10) 
				+ '-' + date.substring(3,5) 
				+ '-' + date.substring(0,2));

	}
	
	/**
	 * @function Création d'un usager
	 * @usager {{Usager}} objet usager à persister
	 * @callback {{function}} fonction à éxécuter par l'appelant
	 */
	creerUsagerService.creerUsager = function (usager, callback) {
		
		if (usager.usagerDtNaiss !== undefined) {
			usager.usagerDtNaiss = convertirDate(usager.usagerDtNaiss);
		}

		if (usager.usagerDtExclusion !== undefined) {
			usager.usagerDtExclusion = convertirDate(usager.usagerDtExclusion);
		}

		$http
			.post("/MDE_Rest/Api/usager", usager)
			.success(function(data, status) {
					callback(data);
				})
			.error(function(data, status, headers, config) {
					var retour = {};
					retour.statut = 'KO';
					retour.serviceErreur = true;
					retour.libelle = '/MDE_Rest/Api/usager';
					retour.data = data;
					retour.status = status;
					retour.headers = headers;
					retour.config = config;
//					$scope.erreur = {statut : true, retour : retour};
				});

	};


	/**
	 * @function Contrôle de saisie de la création d'un usager
	 * @param {{Usager}} usager  Objet usager à contrôler
	 */
	creerUsagerService.controleSaisie = function (usager) {
		var retour = {};
		//usager = usager || {};
		retour.statut = true;

		if (usager === undefined || usager.usagerCivilite === undefined) {
			retour.statut = false;
			retour.bUsagerCiviliteErreur = true;
		}

		if (usager === undefined || usager.usagerNom === undefined || usager.usagerNom === '') {
			retour.statut = false;
			retour.bUsagerNomErreur = true;
		}
		
		if (usager === undefined || usager.usagerPrenom === undefined || usager.usagerPrenom === '') {
			retour.statut = false;
			retour.bUsagerPrenomErreur = true;
		}

		if (usager === undefined || usager.usagerDtNaiss === undefined || usager.usagerDtNaiss === '') {
			retour.statut = false;
			retour.bUsagerDtNaissErreur = true;
		}
		/*
		if (usager.usagerEmail === undefined || usager.usagerEmail === '') {
			err.push({bUsagerEmailErreur : true});
		}
		<input type="date" data-ng-model="usagerSaisi.usagerDtNaiss"  class="form-control" id="inputDtNaiss" placeholder="jj/mm/aaaa" />
		<input type="email" data-ng-model="usagerSaisi.usagerEmail" class="form-control" id="inputEmail" placeholder="john.doe@gmail.com" />
		 */
		
		return retour;
	};

	return creerUsagerService;
}]);