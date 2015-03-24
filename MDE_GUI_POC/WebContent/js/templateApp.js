/***
 * Application Cyberbase
 * 
 * @author P42
 * @name templateApp.js
 * @link ngRoute.$routeProvider
 * @link ngRoute.$locationProvider
 * @link creerUSagerService
 */
var app = angular.module("templateApp", [ 'ngRoute', 'services' ]);

/**
 * Configuration des services $routeProvider et $locationProvider
 */
app.config([ '$routeProvider', '$locationProvider',
		function($routeProvider, $locationProvider) {
			$routeProvider
				// Login
			  .when('/MDE_GUI_POC/login', {
				templateUrl : '/MDE_GUI_POC/html/login.html',
				controller : 'loginControleur'
				// Gérer salles
			}).when('/MDE_GUI_POC/listerSalles', {
				templateUrl : '/MDE_GUI_POC/html/listerSalles.html',
				controller : 'listerSallesControleur'
			}).when('/MDE_GUI_POC/gererSalle/:salleId', {
				templateUrl : '/MDE_GUI_POC/html/gererSalle.html',
				controller : 'gererSalleControleur'
			}).when('/MDE_GUI_POC/affecterPoste/:posteId', {
				templateUrl : '/MDE_GUI_POC/html/affecterPoste.html',
				controller : 'affecterPosteControleur'
			}).when('/MDE_GUI_POC/creerSalle', {
				// templateUrl: '/MDE_GUI_POC/html/creerSalle.html',
				templateUrl : '/MDE_GUI_POC/html/workInProgress.html'
				// controller : 'affecterPosteControleur'
			}).when('/MDE_GUI_POC/configurerPoste/:posteId', {
				// templateUrl: '/MDE_GUI_POC/html/configurerPoste.html',
				templateUrl : '/MDE_GUI_POC/html/workInProgress.html'
				// controller : 'affecterPosteControleur'
				// Gérer usagers
			}).when('/MDE_GUI_POC/creerUsager', {
				templateUrl: '/MDE_GUI_POC/html/creerUsager.html',
				controller : 'creerUsagerControleur'
			}).when('/MDE_GUI_POC/detailsUsager', {
				// templateUrl: '/MDE_GUI_POC/html/detailsUsager.html',
				templateUrl : '/MDE_GUI_POC/html/workInProgress.html'
				// controller : 'detailsUsagerControleur'
			}).when('/MDE_GUI_POC/historique', {
				templateUrl : '/MDE_GUI_POC/html/historique.html',
				controller : 'historiqueControleur'
				// Visualiser les statistiques
			}).when('/MDE_GUI_POC/statistiques', {
				// templateUrl: '/MDE_GUI_POC/html/statistiques.html',
				templateUrl : '/MDE_GUI_POC/html/workInProgress.html'
				// controller : 'affecterPosteControleur'
				// Gérer les utilisateurs
			}).when('/MDE_GUI_POC/creerUtilisateur', {
				templateUrl: '/MDE_GUI_POC/html/creerUtilisateur.html',
				controller : 'creerUtilisateurControleur'
			}).when('/MDE_GUI_POC/listerUtilisateurs', {
				// templateUrl: '/MDE_GUI_POC/html/listerUtilisateurs.html',
				templateUrl : '/MDE_GUI_POC/html/workInProgress.html'
				// controller : 'listerUtilisateursControleur'
			}).otherwise({
				redirectTo : '/MDE_GUI_POC'
			});

			$locationProvider.html5Mode(true);
		} ]);