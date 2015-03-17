/**
 * @module gererSalleControleur
 * Contrôleur pour vue 'Gestion des salles'.
 * @author P42
 * @name gererSalleControleur.js
 * @link ng.$scope
 * @link ng.$http
 * @link ng.$window
 * @link ng.$rootScope
 * @link ngRoute.$routeParams
 * @link ngRoute.$routeLocation
 */
app.controller('gererSalleControleur',
	[
		'$scope',
		'$http',
	 	'$routeParams',
		'$location',
		'$route',
		'$window',
		'$rootScope',
		function gererSalleControleur ($scope, $http, $routeParams, $location, $route, $window, $rootScope) {
			
			if ($scope.utilConn ===undefined){
				$rootScope.cheminVoulu ='/MDE_GUI_POC/listerSalles';
				$location.path('/MDE_GUI_POC/login');	
			}
			
			$scope.salleId = $routeParams.salleId;
			
			// Requête : obtenir les informations de la salle
			$http
				.get('/MDE_Rest/Api/site/salle/' + $scope.salleId)
				.success(function (response) {
					$scope.salle = response;
					
					
					// Requête : obtenir la liste des postes de la salle
					$http
					.get('/MDE_Rest/Api/site/salle/' + $scope.salle.salleId + '/postes')
					.success(function (response) {
						$scope.salle.postes = response;
					});

				});

			/**
			 * @function Boutons "Attribuer" : Attribuer un poste
			 * @param {int} idPoste  identifiant du poste à attribuer 
			 */
			$scope.attribuerPoste = function (idPoste) {
				$location
					.path('/MDE_GUI_POC/affecterPoste/' + idPoste);
			};

			/**
			 * @function Boutons "Configurer" : Configurer un poste
			 * @param {int} idPoste  identifiant du poste à configurer 
			 */
			$scope.configurerPoste = function (idPoste) {
				$location
					.path('/MDE_GUI_POC/configurerPoste/' + idPoste);
			};

			/**
			 * @function Boutons "Libérer" : Libérer un poste
			 * @param {int} idPoste  identifiant du poste à libérer 
			 */
			$scope.libererPoste = function (idPoste) {
				var poste = {};
				
				// Récupérer les informations du poste
				$http
					.get('/MDE_Rest/Api/site/salle/poste/' + idPoste)
					.success(function (response) {
						var poste = response;
						$http
							.put('/MDE_Rest/Api/site/liberer/poste/' + idPoste, poste)
							.success(function (response) {
								// Rechargement de la page
								$route.reload();
							})
							.error(function(data, status, headers, config) {
								console.log('libererPoste - ', '/MDE_Rest/Api/site/liberer/' + idPoste, 'error');
								console.log('data', data);
								console.log('status',status);
								console.log('headers',headers);
								console.log('config', config);
							});
						})
					.error(function(data, status, headers, config) {
						console.log('libererPoste - ', '/MDE_Rest/Api/site/salle/poste/' + idPoste, 'error');
						console.log('data', data);
						console.log('status',status);
						console.log('headers',headers);
						console.log('config', config);
					});
			};
			
			/**
			 * @function Boutons "Libérer tous les postes" : Libère tous les postes d'une salle
			 * @param {int} idSalle  identifiant de la salle à libérer 
			 */
			$scope.libererTousLesPostes = function (idSalle) {
					$http
						.put('/MDE_Rest/Api/site/liberer/salle/' + $scope.salle.salleId)
						.success(function (response) {
								$scope.salle = response;

								// Rechargement de la page
								$route.reload();
						})
						.error(function(data, status, headers, config) {
							console.log('libererPoste - ', '/MDE_Rest/Api/site/salle/' + $scope.salle.salleId, 'error');
							console.log('data', data);
							console.log('status',status);
							console.log('headers',headers);
							console.log('config', config);
						});
			}
		}
	]
);

