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
				$location
					.path('/MDE_GUI_POC/gererSalles');
			};
			
			/**
			 * Bouton "Libérer tous les postes" : Libère tous les postes d'une salle
			 */
//			$scope.selectionnerSalle = function (idSalle) {
//				$http
//				.get('/MDE_Rest/Api/site/salle/' + idSalle)
//				.success(function (response) {
//					$scope.listePostes = response.postes;
//				});
//				return $scope.listePostes;
//			}
			$scope.libererTousLesPostes = function (idSalle) {
console.log("Pas implémenté");
			}
		}
	]
);

