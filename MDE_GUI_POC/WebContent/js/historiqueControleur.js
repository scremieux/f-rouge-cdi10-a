app.controller('historiqueControleur', 
	[
		'$scope',
		'$http',
		function historiqueControleur($scope, $http) {
			// Requête de la liste des connexions
			$http
				.get('/MDE_Rest/Api/connexion')
				.success(function (response) {
					$scope.listeConnexions = response
				});
			// Requête de la liste des sites
			$http
				.get('/MDE_Rest/Api/site')
				.success(function (response) {
					$scope.listeSites = response;
				});
			// Requête de la liste des motifs de connexions
			$http
				.get('/MDE_Rest/Api/connexion/motif')
				.success(function (response) {
					$scope.listeMotifs = response;
				});
			// Requête de la liste des motifs de connexions
			$http
				.get('/MDE_Rest/Api/usager')
				.success(function (response) {
					$scope.listeUsagers = response;
				});
		}
	]
);
