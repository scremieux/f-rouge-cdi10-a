app.controller('detailsUsagerControleur',  
	function detailsUsagerControleur($scope, $http, $window) {
		$scope.detailVisible = false;

		$http.get("http://10.0.11.44:8080/MDE_Rest/Api/usager").success(function(response) {
			$scope.listeUsagers = response
		});

		$scope.afficher = function() {
			$scope.usager = null;
			var usagerTemp = null;
			$scope.listeUsagers.forEach(function (usager) {
				usagerTemp =  usager.usagerPrenom + ' '+ usager.usagerNom;
				if (usagerTemp === $scope.usagerSaisi) {
					$scope.usager = usager;
					$scope.detailVisible = true;
				}
			});
		};

		$scope.supprimer = function() {
			// Suppression dans la base de données
			if ($window.confirm("Voulez-vous vraiment supprimer cet usager ?")) {
				var url = '';
				url = 'http://10.0.11.44:8080/MDE_Rest/Api/usager/';
				url += $scope.usager.usagerId;

				$http.delete(url)
					.success(function(response) {
						$scope.detailVisible = false;
						// Mise à jour du model local
						var indexOfUsager = null;
						for (var i=0; i < $scope.listeUsagers.length; i++) {
							if ($scope.listeUsagers[i].usagerId === $scope.usager.usagerId) {
								indexOfUsager = i;
								break;
							}
						}
						if (indexOfUsager !== null ) {
							$scope.listeUsagers.splice(indexOfUsager, 1);
						}
				});
			}
		};
	}
);


