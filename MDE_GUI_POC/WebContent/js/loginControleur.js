app.controller('loginControleur', 
	[
		'$scope',
		'$http',
		'$location',
		'$rootScope',
	 	function loginControleur($scope, $http, $location,$rootScope) {
			
			console.log("controleur login");
	 		/**
	 		 * Bouton "Valider" : Connexion à l'application
	 		 */
	 		$scope.loginSeConnecter = function() {
	 			var utilisateur ={};
	 			var mdpOk = false;
	 			utilisateur.utilLogin = $scope.loginSaisi;
	 			utilisateur.utilMdp = $scope.mdpSaisi;
	 			console.log(utilisateur);
	 			$http.post("/MDE_Rest/Api/login", utilisateur)
	 			.success(function(data, status, headers, config) {
	 					console.log("data : " + data);
	 		 			if (data=="true"){
	 		 				$rootScope.utilConn = $scope.loginSaisi;
	 		 				console.log("utilConn : " + $rootScope.utilConn);
	 		 				$location.path('/MDE_GUI_POC/');
	 		 			}else{
	 		 				$scope.messageErreur = "Erreur de saisie, veuillez recommencer";
	 		 				$scope.loginSaisi="";
	 			 			$scope.mdpSaisi="";
	 		 			}
					})
				.error(function(data, status, headers, config) {
					console.log("error");
						var retour = {};
							retour.statut = 'KO';
							retour.serviceErreur = true;
							retour.libelle = '/MDE_Rest/Api/login';
							retour.data = data;
							retour.status = status;
							retour.headers = headers;
							retour.config = config;
							$scope.erreur = {statut : true, retour : retour};
					});
	 			
	 			
	 			
	 		};
	 		
	 	

	 	
	 	}
		]
);




