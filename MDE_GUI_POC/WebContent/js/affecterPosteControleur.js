app.controller('affecterPosteControleur', ['$scope', '$http', '$routeParams', '$location', '$window', function ($scope, $http, $routeParams, $location, $window) {
		$scope.detailVisible = false;

		$http.get("/MDE_Rest/Api/usager").success(function(response) {
			$scope.listeUsagers = response;
		});

		$http.get("/MDE_Rest/Api/connexion/motif").success(function(response) {
			$scope.listeMotifs = response;
		});

		$scope.listeDurees = [
				{	id : 1, duree:'15 min'	},
				{	id : 2,	duree : '30 min' },
				{	id : 3,	duree : '45 min' },
				{	id : 4,	duree : '1 heure' }
			];

		$http.get("/MDE_Rest/Api/site/salle/poste/" + $routeParams.posteId).success(function(response) {
			$scope.poste = response;
		});

		/**
		 * Bouton "Retour" : redirection vers la console 'Gestion de salles'
		 */
		$scope.retour = function() {
			$location.path('/MDE_GUI_POC/gererSalles');
		};


		/**
		 * Bouton "Rechercher" : valide la saisie de l'usager
		 */
		$scope.rechercher = function() {
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
		$scope.valider = function() {
			if ($scope.usager !== undefined && this.mtId !== undefined && this.dureeId != undefined) {
				var connexion = new Connexion();
				connexion.cnxDtHeureDebut=null;
				connexion.cnxDtHeureFin=null;
				connexion.cnxDureePrevue=null;
				connexion.motif.mtId = this.mtId;
				connexion.usager.usagerId = $scope.usager.usagerId;
				connexion.poste.posteId = $scope.poste.posteId;
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
							$location.path('/MDE_GUI_POC/gererSalles');
						})
					.error(function(data, status, headers, config) {
						// called asynchronously if an error occurs
						// or server returns response with an error status.
console.log ('connexion.post.error');
console.log ('data', data);
console.log ('status', status);
console.log ('headers', headers);
console.log ('config', config);
			$location.path('/MDE_GUI_POC/erreur');
						});

			} else {
				// TODO : Pas d'usager sélectionné
				var retour = {};
				retour.statut = 'KO';
				retour.usager  = ($scope.usager!==undefined);
				retour.mtId  = (this.mtId!==undefined);
				retour.dureeId  = (this.dureeId!==undefined);
console.log('retour', retour);
			}
		};

	$scope.creerUsager = function() {
			$location.path('/MDE_GUI_POC/creerUsager');
		};
	}]
);


