/**
 * @module creerUtilisateurService
 * Service de vérification de saisie pour la création d'un utilisateur.
 * @author P42
 * @name creerUtilisateurService.js
 * @link ng.$http
 * @link ng.$filter
 */
//var services = angular.module('services', []);

services.factory('creerUtilisateurService', ['$http', '$filter', function ($http, $filter) {
	var creerUtilisateurService = {};
	
	
	/**
	 * @function Création d'un utilisateur
	 * @utilisateur {{Utilisateur}} objet utilisateur à persister
	 * @callback {{function}} fonction à éxécuter par l'appelant
	 */
	creerUtilisateurService.creerUtilisateur = function (utilisateur, callback) {
		

		$http
			.post("/MDE_Rest/Api/utilisateur", utilisateur)
			.success(function(data, status) {
					callback(data);
				})
			.error(function(data, status, headers, config) {
					var retour = {};
					retour.statut = 'KO';
					retour.serviceErreur = true;
					retour.libelle = '/MDE_Rest/Api/utilisateur';
					retour.data = data;
					retour.status = status;
					retour.headers = headers;
					retour.config = config;
//					$scope.erreur = {statut : true, retour : retour};
				});

	};


	/**
	 * @function Contrôle de saisie de la création d'un utilisateur
	 * @param {{Utilisateur}} utilisateur  Objet utilisateur à contrôler
	 */
	creerUtilisateurService.controleSaisie = function (utilisateur) {
		var retour = {};
		retour.statut = true;

		if (utilisateur === undefined || utilisateur.utilNom === undefined || utilisateur.utilNom === '') {
			retour.statut = false;
			retour.bUtilNomErreur = true;
		}
		if (utilisateur === undefined || utilisateur.utilPrenom === undefined || utilisateur.utilPrenom === '') {
			retour.statut = false;
			retour.bUtilPrenomErreur = true;
		}
		if (utilisateur === undefined || utilisateur.utilLogin === undefined || utilisateur.utilLogin === '') {
			retour.statut = false;
			retour.bUtilLoginErreur = true;
		}
		if (utilisateur === undefined || utilisateur.utilMdp === undefined || utilisateur.utilMdp === '') {
			retour.statut = false;
			retour.bUtilMdpErreur = true;
		}

		
		return retour;
	};

	return creerUtilisateurService;
}]);