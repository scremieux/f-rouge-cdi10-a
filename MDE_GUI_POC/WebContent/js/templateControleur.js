// app.controller('templateControleur',  
// 	function templateControleur($scope, $http, $window) {
// 		$scope.gererSallesShow = false;
// 		$scope.affecterPosteShow = true;
// 	}
// );

app.controller('templateControleur',  
	function templateControleur($route, $routeParams, $location, $rootScope, $scope) {
		this.$route = $route;
		this.$routeParams = $routeParams;
		this.$location = $location;
		
		$scope.deconnexion = function() {
			sessionStorage.clear();
			$rootScope.utilConn = undefined;
			$location.path('/MDE_GUI_POC/');
			
			
		}
	}
);