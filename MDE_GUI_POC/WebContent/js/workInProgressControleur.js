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
	 	function workInProgressControleur ($scope, $window, $location) {
	 		$scope.workInProgressRetour = function () {
	 			$window.history.back();
	 		};

	 		$scope.workInProgressAccueil = function () {
	 			$location.path('/MDE_GUI_POC');
	 		};

	 	}
	]
);
