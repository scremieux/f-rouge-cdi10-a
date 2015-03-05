/**___________________________________________________________
*** Contrôleur Javascript pour vue 'Gestion des salles'
*** Fonction pour récupérer tableau des salles sur serveur
***___________________________________________________________*/
	app.controller("salleControleur",function salleControleur($scope,$http) {
	  $http.get("http://10.0.10.92:8080/MDE_Rest/Api/site/salle").success(function(response) {$scope.listeSalles = response})
	});


	

	//Variable correspondant au nom d'une nouvelle salle
	// $scope.nouveauNomSalle = "";

	//fonction pour créer une salle
	// $scope.nouveau = function  () {

	// };

	//fonction pour modifier une salle
	// $scope.modifier = function() {

	// };

	//fonction pour valider la création ou la modification d'une salle
	// $scope.valider = function  () {

	// };

	//fonction pour supprimer une salle
	// $scope.supprimer = function  () {

	// };

// });

