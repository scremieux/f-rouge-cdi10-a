app.controller('historiqueControleur', 
	[
		'$scope',
		'$http',
		'$location',
		function historiqueControleur($scope, $http, $routeParams, $location, $window) {
			$http
				.get('/MDE_Rest/Api/connexion')
				.success(function (response) {
					$scope.listeSalles = response
				});
		}
	]
);
