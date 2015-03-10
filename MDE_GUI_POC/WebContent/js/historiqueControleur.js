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
				// récupération des critères 
				var choixSite = ($scope.siteChoisi ? $scope.siteChoisi.replace(/\t/g,"").replace(/\n/g,"") : "" );
				var choixMotif = ($scope.motifChoisi ? $scope.motifChoisi.replace(/\t/g,"").replace(/\n/g,"") : "" );
				var choixUsageNom = ($scope.usagerSaisi ? $scope.usagerSaisi.split(" ")[1] : "" );
				var choixUsagePrenom = ($scope.usagerSaisi ? $scope.usagerSaisi.split(" ")[0] : "" );
				var choixDateConn = ($scope.dateChoisi ? $scope.dateChoisi : "" );
				
				// 
				var conn;
				var site;
				var motif;
				var usagePrenom;
				var usageNom;
				var dateConn;
				
				// variables booléennes 
				var boolSite;
				var boolUsagerNom;
				var boolUsagerPrenom;
				var boolMotif;
				var boolDate;
				
				for ( var i in $scope.listeConnexions) {
					// 
					conn = $scope.listeConnexions[i];
					site = conn.poste.salle.site.siteNom;
					motif = conn.motif.mtLibelle;
					usagePrenom = conn.usager.usagerPrenom;
					usageNom = conn.usager.usagerNom;
					dateConn = conn.cnxDate;
					
					// variables booléennes 
					boolSite = ((choixSite == site)||(choixSite == ""));
					boolUsagerNom = ((choixUsageNom == usageNom)||(choixUsageNom == ""));
					boolUsagerPrenom = ((choixUsagePrenom == usagePrenom)||(choixUsagePrenom == ""));
					boolMotif = ((choixMotif == motif)||(choixMotif == ""));
					boolDate = ((choixDateConn == dateConn)||(choixDateConn == ""));
					
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
				$scope.siteChoisi = "";
				$scope.motifChoisi="";
				$scope.usagerSaisi="";
				$scope.dateChoisi = null;
			};
		}
	]
);
