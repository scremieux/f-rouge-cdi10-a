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

		$rootScope.cacheNav= true;
		$rootScope.cacheHead= false;
		$rootScope.cacheTuile= false;
		$rootScope.cacheAdmin= true;
		$rootScope.cacheDeconn= true;
		$rootScope.cacheConn= false;
		
		$scope.deconnexion = function() {
			sessionStorage.clear();
			$rootScope.utilConnecte = undefined;
			$rootScope.cacheNav= true;
			$rootScope.cacheHead= false;
			$rootScope.cacheTuile= false;
			$rootScope.cacheAdmin= true;
			$rootScope.cacheDeconn= true;
			$rootScope.cacheConn= false;
			$location.path('/MDE_GUI_POC/');
		}
		$scope.connexion = function() {
			$location.path('/MDE_GUI_POC/login');
		}
		$scope.btnAccueil = function() {
			//$rootScope.utilConn = undefined;
			$rootScope.cacheNav= true;
			$rootScope.cacheHead= false;
			$rootScope.cacheTuile= false;
			$location.path('/MDE_GUI_POC/');
			
		}
	}
);