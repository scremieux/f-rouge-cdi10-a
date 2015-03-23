/**
 * @module creerUsagerControleur
 * Contrôleur pour vue 'Créer un usager'.
 * @author P42
 * @name creerUsagerControleur.js
 * @link ng.$scope
 * @link ng.$http
 * @link ngRoute.$location
 * @link ng.$rootScope
 * @link ng.$window
 * @link creerUsagerService
 */
app.controller('creerUsagerControleur', 
	[
		'$scope',
		'$http',
		'$location',
		'$rootScope',
		'$window',
	 	'creerUsagerService',
	 	function creerUsagerControleur($scope, $http, $location, $rootScope, $window, creerUsagerService) {
			$rootScope.cacheNav= false;
			$rootScope.cacheHead= false;
			$rootScope.cacheTuile= true;
			
			if (sessionStorage.getItem("utilConn") === null) {
				$rootScope.utilConn = sessionStorage
						.getItem("utilConn");
				$rootScope.cheminVoulu = '/MDE_GUI_POC/creerUsager';
				$location.path('/MDE_GUI_POC/login');
			}else{
				// manipulation DOM pour navigation accordion
				$("#usagers").addClass("in");
				$("#salles").removeClass("in");
				$("#utilisateurs").removeClass("in");
				$("#statistiques").removeClass("in");
				
			$scope.controleSaisie = true;

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

			/**
			 * @function Création d'un usager
			 */
			$scope.creerUsagerValider = function () {
	 			var controleSaisie = creerUsagerService.controleSaisie(this.usagerSaisi);
	 			if (controleSaisie.statut === true) {
	 				creerUsagerService.creerUsager(this.usagerSaisi, function (nouvelUsager) {
	 					$window.history.back();
	 				});
	 			} else {
	 				$scope.controleSaisie = controleSaisie;
	 			}
			};

			$scope.creerUsagerRetour = function () {
				$window.history.back();
			};
			}
		}
		
	]
);
