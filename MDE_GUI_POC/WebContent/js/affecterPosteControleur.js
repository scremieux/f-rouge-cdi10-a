app.controller('affecterPosteControleur', 
	[
	 	'$scope',
	 	'$http',
	 	'$routeParams',
	 	'$location',
	 	'$window',
	 	function ($scope, $http, $routeParams, $location, $window) {
	 		$scope.detailVisible = false;

	 		// Requete : liste des usagers pour gestion auto completion
	 		$http.get("/MDE_Rest/Api/usager").success(function(response) {
	 			$scope.listeUsagers = response;
	 		});

	 		// Requete : liste des motifs
	 		$http.get("/MDE_Rest/Api/connexion/motif").success(function(response) {
	 			$scope.listeMotifs = response;
	 		});

	 		// Initialisation de la liste des durées
	 		$scope.listeDurees = [
	 		    {	id : 1, duree:'15 min'	},
				{	id : 2,	duree : '30 min' },
				{	id : 3,	duree : '45 min' },
				{	id : 4,	duree : '1 heure' }
			];

	 		// Requete : informations du poste sélectionné
	 		$http.get("/MDE_Rest/Api/site/salle/poste/" + $routeParams.posteId).success(function(response) {
	 			$scope.poste = response;
	 		});

	 		/**
	 		 * Bouton "Retour" : redirection vers la console 'Gestion de salles'
	 		 */
	 		$scope.affecterPosteRetour = function() {
	 			$location.path('/MDE_GUI_POC/gererSalle/' + $scope.poste.salle.salleId);
	 		};

	 		/**
	 		 * Bouton "Rechercher" : valide la saisie de l'usager
	 		 */
	 		$scope.affecterPosteRechercher = function() {
	 			$scope.usager = null;
	 			$scope.usagerSaisi = this.usagerSaisi;
	 			var usagerTemp = null;
	 			$scope.listeUsagers.forEach(function (usager) {
	 				usagerTemp =  usager.usagerPrenom + ' '+ usager.usagerNom;
	 				if (usagerTemp === $scope.usagerSaisi) {
	 					$scope.usager = usager;
	 					$scope.detailVisible = true;
	 				}
	 			});
	 		};

	 		/**
	 		 * Bouton "Valider" : enregistre l'attribution du poste
	 		 */
	 		$scope.affecterPosteValider = function() {
	 			if ($scope.usager !== undefined && this.mtId !== undefined && this.dureeId != undefined) {
	 				var connexion = new Connexion();
	 				connexion.cnxDureePrevue=null;
	 				connexion.motif.mtId = this.mtId;
	 				connexion.usager.usagerId = $scope.usager.usagerId;
	 				connexion.poste = $scope.poste;
	 				switch (this.dureeId) {
	 					case '1':
	 						connexion.cnxDureePrevue = '00:15:00';
	 					break;
	 					case '2':
	 						connexion.cnxDureePrevue = '00:30:00';
	 					break;
	 					case '3':
	 						connexion.cnxDureePrevue = '00:45:00';
	 					break;
	 					case '4':
	 						connexion.cnxDureePrevue = '00:60:00';
	 						break;
	 				}

	 				$http.post("/MDE_Rest/Api/connexion", connexion)
	 				.success(function(data, status, headers, config) {
							$location.path('/MDE_GUI_POC/gererSalle/' + $scope.poste.salle.salleId);
						})
					.error(function(data, status, headers, config) {
							var retour = {};
							retour.statut = 'KO';
							retour.serviceErreur = true;
							retour.libelle = '/MDE_Rest/Api/connexion';
							retour.data = data;
							retour.status = status;
							retour.headers = headers;
							retour.config = config;
							$scope.erreur = {statut : true, retour : retour};
						});
	 			} else {
	 				var retour = {};
	 				retour.statut = 'KO';
	 				retour.parametresErreur = true;
	 				retour.usager  = ($scope.usager!==undefined);
	 				retour.mtId  = (this.mtId!==undefined);
	 				retour.dureeId  = (this.dureeId!==undefined);
	 				$scope.erreur = {statut : true, retour : retour};
	 			}
	 		};

	 		$scope.affecterPosteCreerUsager = function() {
	 			$location.path('/MDE_GUI_POC/creerUsager');
	 		};
	 	}
	]
);


