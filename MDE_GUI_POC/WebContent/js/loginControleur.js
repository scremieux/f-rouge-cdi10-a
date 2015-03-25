app.controller('loginControleur', 
	[
		'$scope',
		'$http',
		'$location',
		'$rootScope',
	 	function loginControleur($scope, $http, $location,$rootScope) {
			$rootScope.cacheNav= true;
			$rootScope.cacheHead= true;
			$rootScope.cacheTuile= true;

	 		/**
	 		 * Bouton "Valider" : Connexion à l'application
	 		 */
	 		$scope.loginSeConnecter = function() {
	 			var utilisateur ={};
	 			var mdpOk = false;
	 			utilisateur.utilLogin = $scope.loginSaisi;

	 			
	 			utilisateur.utilMdp = md5($scope.mdpSaisi);
	 			
	 			$http.post("/MDE_Rest/Api/login", utilisateur)
	 			.success(function(data, status, headers, config) {
	 		
	 		 			/*if (data=="true"){
	 		 				sessionStorage.setItem("utilConn",$scope.loginSaisi);
	 		 				$rootScope.utilConn = utilisateur.utilLogin;
	 		 				$rootScope.cacheNav= false;
	 		 				$rootScope.cacheHead= false;
	 		 				if($rootScope.cheminVoulu!==undefined){
	 		 					$location.path($rootScope.cheminVoulu);
	 		 				}else{
	 		 					$location.path('/MDE_GUI_POC/');
	 		 				}*/
	 					if (data.utilNom!=null){
 		 				sessionStorage.setItem("utilConn",data);
 		 				$rootScope.utilConnecte = data.utilPrenom +' '+data.utilNom;
 		 				
 		 				$rootScope.cacheDeconn= false;
 		 				$rootScope.cacheConn= true;
 		 				
 		 					if(data.utilAdmin){
 		 						$rootScope.cacheAdmin= false;
 		 					}
 		 					if($rootScope.cheminVoulu!==undefined){
 		 						$rootScope.cacheNav= false;
 		 		 				$rootScope.cacheHead= false;
 		 						$location.path($rootScope.cheminVoulu);
 		 					}else{
 		 						$rootScope.cacheTuile= false;
 		 		 				$rootScope.cacheHead= false;
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




