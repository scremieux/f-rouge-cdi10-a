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
		console.log('je passe par templateControleur');
		$rootScope.cacheNav= true;
		$rootScope.cacheHead= false;
		$rootScope.cacheTuile= false;
		$scope.deconnexion = function() {
			sessionStorage.clear();
			$rootScope.utilConn = undefined;
			$rootScope.cacheNav= true;
			$rootScope.cacheHead= false;
			$rootScope.cacheTuile= false;
			$location.path('/MDE_GUI_POC/');
		}
		$scope.btnAccueil = function() {
			$rootScope.utilConn = undefined;
			$rootScope.cacheNav= true;
			$rootScope.cacheHead= false;
			$rootScope.cacheTuile= false;
			$location.path('/MDE_GUI_POC/');
			
		}
	}
);