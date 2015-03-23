app.controller('listerSallesControleur',
		[
			'$scope',
			'$http',
			'$location',
			'$rootScope',
			function listerSallesControleur($scope, $http, $location, $rootScope) {
				$rootScope.cacheNav= false;
				$rootScope.cacheHead= false;
				$rootScope.cacheTuile= true;
				
				if (sessionStorage.getItem("utilConn") === null) {
					$rootScope.utilConn = sessionStorage
							.getItem("utilConn");
					$rootScope.cheminVoulu = '/MDE_GUI_POC/listerSalles';
					$location.path('/MDE_GUI_POC/login');
				}else{
				
				// manipulation DOM pour navigation accordion
					$("#salles").addClass("in");
					$("#utilisateurs").removeClass("in");
					$("#statistiques").removeClass("in");
					$("#usagers").removeClass("in");
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

			}
		]
);