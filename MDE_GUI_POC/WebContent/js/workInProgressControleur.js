/**
 * @module workInProgressControleur
 * Contrôleur pour vue 'Work in progress'.
 * @author P42
 * @name workInProgressControleur.js
 * @link ng.$scope
 * @link ng.$window
 * @link ngRoute.$routeLocation
 */
app.controller('workInProgressControleur', 
	[
	 	'$scope',
	 	'$window',
	 	'$location',
	 	'$rootScope',
	 	function workInProgressControleur ($scope, $window, $location, $rootScope) {
	 		$rootScope.cacheNav= false;
			$rootScope.cacheHead= false;
			$rootScope.cacheTuile= true;
			if (sessionStorage.getItem("utilConn") === null) {
				$rootScope.utilConn = sessionStorage
						.getItem("utilConn");
				$rootScope.cheminVoulu = '/MDE_GUI_POC';
				$location.path('/MDE_GUI_POC/login');
			}else{
	 		$scope.workInProgressRetour = function () {
	 			$window.history.back();
	 		};

	 		$scope.workInProgressAccueil = function () {
		 		$rootScope.cacheNav= true;
				$rootScope.cacheHead= false;
				$rootScope.cacheTuile= false;
	 			$location.path('/MDE_GUI_POC');
	 		};
			}
	 	}
	]
);
