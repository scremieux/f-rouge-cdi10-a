app.controller('loginControleur', 
	[
		'$scope',
		'$http',
		'$location',
		'$rootScope',
	 	function loginControleur($scope, $http, $location,$rootScope) {
			$rootScope.cacheNav= true;
			$rootScope.cacheHead= true;

	 		/**
	 		 * Bouton "Valider" : Connexion à l'application
	 		 */
	 		$scope.loginSeConnecter = function() {
	 			var utilisateur ={};
	 			var mdpOk = false;
	 			utilisateur.utilLogin = $scope.loginSaisi;
	 			//md5($scope.mdpSaisi);
	 			
	 			utilisateur.utilMdp = $scope.mdpSaisi;
	 			
	 			$http.post("/MDE_Rest/Api/login", utilisateur)
	 			.success(function(data, status, headers, config) {
	 					console.log("data : " + data);
	 		 			if (data=="true"){
	 		 				sessionStorage.setItem("utilConn",$scope.loginSaisi);
	 		 				console.log("utilConn : " + $rootScope.utilConn);
	 		 				$rootScope.cacheNav= false;
	 		 				$rootScope.cacheHead= false;
	 		 				if($rootScope.cheminVoulu!==undefined){
	 		 					$location.path($rootScope.cheminVoulu);
	 		 				}else{
	 		 					$location.path('/MDE_GUI_POC/');
	 		 				}
	 		 				
	 		 			}else{
	 		 				$scope.messageErreur = "Saisie incorrecte";
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




