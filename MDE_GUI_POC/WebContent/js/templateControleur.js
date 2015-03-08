// app.controller('templateControleur',  
// 	function templateControleur($scope, $http, $window) {
// 		$scope.gererSallesShow = false;
// 		$scope.affecterPosteShow = true;
// 	}
// );

app.controller('templateControleur',  
	function templateControleur($route, $routeParams, $location) {
		this.$route = $route;
		this.$routeParams = $routeParams;
		this.$location = $location;
	}
);