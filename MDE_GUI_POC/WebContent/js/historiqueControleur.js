app.controller('historiqueControleur', 
	[
		'$scope',
		'$http',
		function historiqueControleur($scope, $http) {
			// Requête de la liste des connexions
			$http
				.get('/MDE_Rest/Api/connexion')
				.success(function (response) {
					$scope.listeConnexions = response;
					$scope.listeConnexionsCrit = $scope.listeConnexions;
				});
			// Requête de la liste des sites
			$http
				.get('/MDE_Rest/Api/site')
				.success(function (response) {
					$scope.listeSites = response;
				});
			// Requête de la liste des motifs de connexions
			$http
				.get('/MDE_Rest/Api/connexion/motif')
				.success(function (response) {
					$scope.listeMotifs = response;
				});
			// Requête de la liste des motifs de connexions
			$http
				.get('/MDE_Rest/Api/usager')
				.success(function (response) {
					$scope.listeUsagers = response;
				});
			
			/**
			 * Boutons "Valider" : Valider les critères
			 */
			$scope.validerCriteres = function () {
			
				var listeMaJConnexions =[]; 
				for ( var i in $scope.listeConnexions) {
					// 
					var conn = $scope.listeConnexions[i];
					var site = conn.poste.salle.site.siteNom;
					var motif = conn.motif.mtLibelle;
					var usagePrenom = conn.usager.usagerPrenom;
					var usageNom = conn.usager.usagerNom;
					var dateConn = conn.cnxDate;
					
					
					// récupération des critères 
					var choixSite = ($scope.siteChoisi ? $scope.siteChoisi.replace(/\t/g,"").replace(/\n/g,"") : "" );
					var choixMotif = ($scope.motifChoisi ? $scope.motifChoisi.replace(/\t/g,"").replace(/\n/g,"") : "" );
					var choixUsageNom = ($scope.usagerSaisi ? $scope.usagerSaisi.split(" ")[1] : "" );
					var choixUsagePrenom = ($scope.usagerSaisi ? $scope.usagerSaisi.split(" ")[0] : "" );
					var choixDateConn = ($scope.dateChoisi ? $scope.dateChoisi : "" );
					console.log("dateCritère : " + choixDateConn );
					console.log("date : " + dateConn );
					// variables booléennes 
					var boolSite = ((choixSite == site)||(choixSite == ""));
					var boolUsagerNom = ((choixUsageNom == usageNom)||(choixUsageNom == ""));
					var boolUsagerPrenom = ((choixUsagePrenom == usagePrenom)||(choixUsagePrenom == ""));
					var boolMotif = ((choixMotif == motif)||(choixMotif == ""));
					var boolDate = ((choixDateConn == dateConn)||(choixDateConn == ""));

					
					if(boolSite && boolUsagerNom && boolUsagerPrenom && boolMotif && boolDate){
						listeMaJConnexions.push(conn);
					}
				}
				$scope.listeConnexionsCrit = listeMaJConnexions;
			};
			
			/**
			 * Boutons "Effacer les critères" : Effacer les critères
			 */
			$scope.resetCriteres = function () {
				$scope.listeConnexionsCrit = $scope.listeConnexions;
			};
		}
	]
);
