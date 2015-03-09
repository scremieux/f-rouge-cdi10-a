// modèle javascript pour vue 'gestion des salles'

var app = angular.module("templateApp", ['ngRoute']);
app.config(['$routeProvider', '$locationProvider',
  function($routeProvider, $locationProvider) {
    $routeProvider.
      when('/MDE_GUI_POC/listerSalles', {
        templateUrl: '/MDE_GUI_POC/html/listerSalles.html',
        controller: 'listerSallesControleur'
      }).
      when('/MDE_GUI_POC/gererSalle/:salleId', {
          templateUrl: '/MDE_GUI_POC/html/gererSalle.html',
          controller: 'gererSalleControleur'
        }).
      when('/MDE_GUI_POC/affecterPoste', {
        templateUrl: '/MDE_GUI_POC/html/affecterPoste.html',
        controller: 'affecterPosteControleur'
      }).
      when('/MDE_GUI_POC/affecterPoste/:posteId', {
        templateUrl: '/MDE_GUI_POC/html/affecterPoste.html',
        controller: 'affecterPosteControleur'
      }).
      when('/MDE_GUI_POC/creerUsager', {
//        templateUrl: '/MDE_GUI_POC/html/creerUsager.html',
        templateUrl: '/MDE_GUI_POC/html/workInProgress.html',
        controller: 'affecterPosteControleur'
      }).
      when('/MDE_GUI_POC/detailsUsager', {
//        templateUrl: '/MDE_GUI_POC/html/detailsUsager.html',
        templateUrl: '/MDE_GUI_POC/html/workInProgress.html',
        controller: 'affecterPosteControleur'
      }).
      when('/MDE_GUI_POC/historique', {
        templateUrl: '/MDE_GUI_POC/html/historique.html',
        //        templateUrl: '/MDE_GUI_POC/html/workInProgress.html',
        controller: 'historiqueControleur'
      }).
      when('/MDE_GUI_POC/creerSalle', {
//        templateUrl: '/MDE_GUI_POC/html/creerSalle.html',
        templateUrl: '/MDE_GUI_POC/html/workInProgress.html',
        controller: 'affecterPosteControleur'
      }).
      when('/MDE_GUI_POC/configurerPoste', {
//        templateUrl: '/MDE_GUI_POC/html/configurerPoste.html',
        templateUrl: '/MDE_GUI_POC/html/workInProgress.html',
        controller: 'affecterPosteControleur'
      }).
      when('/MDE_GUI_POC/statistiques', {
//        templateUrl: '/MDE_GUI_POC/html/statistiques.html',
        templateUrl: '/MDE_GUI_POC/html/workInProgress.html',
        controller: 'affecterPosteControleur'
      }).
      when('/MDE_GUI_POC/creerUtilisateur', {
//        templateUrl: '/MDE_GUI_POC/html/creerUtilisateur.html',
        templateUrl: '/MDE_GUI_POC/html/workInProgress.html',
        controller: 'affecterPosteControleur'
      }).
      when('/MDE_GUI_POC/listerUtilisateurs', {
//        templateUrl: '/MDE_GUI_POC/html/listerUtilisateurs.html',
        templateUrl: '/MDE_GUI_POC/html/workInProgress.html',
        controller: 'affecterPosteControleur'
      }).
      otherwise({
        redirectTo: '/MDE_GUI_POC'
      });

      $locationProvider.html5Mode(true);
  }]);