app.controller('creerUsagerControleur', 
	[
		'$scope',
		'$http',
		'$location',
		'$rootScope',
	 	function creerUsagerControleur($scope, $http, $location,$rootScope) {
			// Requête de la liste des catégories socio professionnelles
			$http
				.get('/MDE_Rest/Api/usager/csp')
				.success(function (response) {
					$scope.listeCsp = response;
				});

			// Requête de la liste des quartiers
			$http
			.get('/MDE_Rest/Api/usager/quartier')
			.success(function (response) {
				$scope.listeQuartiers = response;
			});

			// Requête de la liste des niveaux de formation
			$http
			.get('/MDE_Rest/Api/usager/nf')
			.success(function (response) {
				$scope.listeNiveauxFormation = response;
			});

			$scope.creerUsager = function () {
				var usager = {} ;
				usager.usagerCivilite = this.civiliteChoisie;
				usager.usagerNom = this.nomSaisi;
				usager.usagerPrenom = this.prenomSaisi;
				usager.usagerDtNaiss = this.dtNaissSaisie;
				usager.usagerEmail = this.emailSaisi;		
				usager.usagerMissionLocale = this.bSuiviMissionLocale;
				usager.usagerExcluService = this.bExcluDeNosServices;
				usager.usagerDtExclusion = this.dtExclusionSaisie;
				usager.csp = {};
				usager.csp.cspId = this.cspChoisi; 
				usager.niveauFormation = {};
				usager.niveauFormation.nfId = this.niveauFormationChoisi;
				usager.quartier = {};
				usager.quartier.quartierId = this.quartierChoisi;
				usager.usagerConnecte = null;
				
				console.log(usager);
 				$http
					.post("/MDE_Rest/Api/usager", usager)
					.success(function(data, status, headers, config) {
//							$location.path('/MDE_GUI_POC/gererSalle/' + $scope.poste.salle.salleId);
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
							$scope.erreur = {statut : true, retour : retour};
						});

			};

		}
		
	]
);
