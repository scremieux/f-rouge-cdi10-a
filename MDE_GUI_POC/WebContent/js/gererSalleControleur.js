/**___________________________________________________________
*** Contrôleur Javascript pour vue 'Gestion des salles'
***___________________________________________________________*/
app.controller('gererSalleControleur',
	[
		'$scope',
		'$http',
	 	'$routeParams',
		'$location',
		function gererSalleControleur($scope, $http, $routeParams, $location) {
			$scope.salleId = $routeParams.salleId;
			
			// Requête : obtenir les informations de la salle
			$http
				.get('/MDE_Rest/Api/site/salle/' + $scope.salleId)
				.success(function (response) {
					$scope.salle = response;
					
					$http
					.get('/MDE_Rest/Api/site/salle/' + $scope.salleId + '/postes')
					.success(function (response) {
console.log(response);
						$scope.salle.postes = response;
					});

				});

			/**
			 * Boutons "Attribuer" : Attribuer un poste
			 */
			$scope.attribuerPoste = function (idPoste) {
				$location
					.path('/MDE_GUI_POC/affecterPoste/' + idPoste);
			};

			/**
			 * Boutons "Configurer" : Configurer un poste
			 */
			$scope.configurerPoste = function (idPoste) {
				$location
					.path('/MDE_GUI_POC/configurerPoste/' + idPoste);
			};

			/**
			 * Boutons "Libérer" : Libérer un poste
			 */
			$scope.libererPoste = function (idPoste) {
				var poste = {};
				
				// Récupérer les informations du poste
				$http
					.get('/MDE_Rest/Api/site/salle/poste/' + idPoste)
					.success(function (response) {
						var poste = response;
						$http
							.put('/MDE_Rest/Api/site/liberer/' + idPoste, poste)
							.success(function (response) {
								$scope.poste = response;
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
				

				$location
					.path('/MDE_GUI_POC/gererSalle/' + $scope.salleId);
			};
			
			/**
			 * Bouton "Libérer tous les postes" : Libère tous les postes d'une salle
			 */
			$scope.libererTousLesPostes = function (idSalle) {
console.log("Pas implémenté");
			}
		}
	]
);

