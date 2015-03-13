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
		}
	]
);
