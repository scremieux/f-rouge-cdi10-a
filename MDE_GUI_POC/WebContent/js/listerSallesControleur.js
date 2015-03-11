app.controller('listerSallesControleur',
		[
			'$scope',
			'$http',
			'$location',
			'$rootScope',
			function listerSallesControleur($scope, $http, $location, $rootScope) {
				
				if ($scope.utilConn ===undefined){
					$rootScope.cheminVoulu ='/MDE_GUI_POC/listerSalles';
					$location.path('/MDE_GUI_POC/login');	
				}
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