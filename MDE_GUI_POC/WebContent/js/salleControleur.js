/**___________________________________________________________
*** Contrôleur Javascript pour vue 'Gestion des salles'
***___________________________________________________________*/
app.controller('salleControleur',
	[
		'$scope',
		'$http',
		'$location',
		function salleControleur($scope, $http, $location) {
			// Requête de la liste des salles
			$http
				.get('/MDE_Rest/Api/site/salle')
				.success(function (response) {
					$scope.listeSalles = response;
				});

			// Requête de la liste des postes de la salle 1
			$http
				.get('/MDE_Rest/Api/site/salle/1')
				.success(function (response) {
					$scope.listePostes = response.postes;
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
		}
	]
);

