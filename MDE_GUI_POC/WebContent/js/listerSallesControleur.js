app.controller('listerSallesControleur',
		[
			'$scope',
			'$http',
			'$location',
			function listerSallesControleur($scope, $http, $location) {
				// Requête de la liste des salles
				$http
					.get('/MDE_Rest/Api/site/salle')
					.success(function (response) {
						$scope.listeSalles = response;
					});
				
				$scope.gererSalle = function (salleId) {
					$location.path('/MDE_GUI_POC/gererSalle/' + salleId);
				};

			}
		]
);