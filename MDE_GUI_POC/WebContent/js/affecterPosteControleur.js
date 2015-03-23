/**
 * @module affecterPosteControleur
 * Contrôleur pour vue 'Attribuer un poste'.
 * @author P42
 * @name affecterPosteControleur.js
 * @link ng.$scope
 * @link ng.$http
 * @link ng.$window
 * @link ngRoute.$routeParams
 * @link ngRoute.$routeLocation
 * @link creerUsagerService
 */
app.controller('affecterPosteControleur', 
	[
	 	'$scope',
	 	'$http',
	 	'$routeParams',
	 	'$location',
	 	'$window',
	 	'creerUsagerService',
	 	function affecterPosteControleur ($scope, $http, $routeParams, $location, $window, creerUsagerService) {
	 		$scope.controleSaisie = {statut : true};
	 		
			$rootScope.cacheNav= false;
			$rootScope.cacheHead= false;
			$rootScope.cacheTuile= true;
			
			if (sessionStorage.getItem("utilConn") === null) {
				$rootScope.utilConn = sessionStorage
						.getItem("utilConn");
				$rootScope.cheminVoulu = '/MDE_GUI_POC/affecterPoste';
				$location.path('/MDE_GUI_POC/login');
			}else{
				// manipulation DOM pour navigation accordion
				$("#salles").addClass("in");
				$("#utilisateurs").removeClass("in");
				$("#statistiques").removeClass("in");
				$("#usagers").removeClass("in");
	 		$scope.detailVisible = false;

	 		// Requete : liste des usagers pour gestion auto completion
	 		$http.get("/MDE_Rest/Api/usager").success(function(response) {
	 			$scope.listeUsagers = response;
	 		});

	 		// Requete : liste des motifs
	 		$http.get("/MDE_Rest/Api/connexion/motif").success(function(response) {
	 			$scope.listeMotifs = response;
	 		});
	 		
			// Requête de la liste des catégories socio professionnelles
			$http
				.get('/MDE_Rest/Api/usager/csp')
				.success(function (response) {
					$scope.listeCsp = response;
				});

			// Requête de la liste des quartiers
			$http
			.get('/MDE_Rest/Api/usager/quartier')
			.success(function (response) {
				$scope.listeQuartiers = response;
			});

			// Requête de la liste des niveaux de formation
			$http
			.get('/MDE_Rest/Api/usager/nf')
			.success(function (response) {
				$scope.listeNiveauxFormation = response;
			});


	 		// Initialisation de la liste des durées
	 		$scope.listeDurees = [
	 		    {	id : 1, duree:'15 min'	},
				{	id : 2,	duree : '30 min' },
				{	id : 3,	duree : '45 min' },
				{	id : 4,	duree : '1 heure' }
			];

	 		// Requete : informations du poste sélectionné
	 		$http.get("/MDE_Rest/Api/site/salle/poste/" + $routeParams.posteId).success(function(response) {
	 			$scope.poste = response;
	 		});

	 		/**
			 * @function Bouton "Retour" : redirection vers la console 'Gestion de salles'
			 */
	 		$scope.affecterPosteRetour = function() {
	 			$location.path('/MDE_GUI_POC/gererSalle/' + $scope.poste.salle.salleId);
	 		};

	 		/**
			 * @function Bouton "Rechercher" : valide la saisie de l'usager
			 */
	 		$scope.affecterPosteRechercher = function() {
	 			$scope.usager = null;
	 			$scope.usagerRecherche = this.usagerRecherche;
	 			var usagerTemp = null;
	 			$scope.listeUsagers.forEach(function (usager) {
	 				usagerTemp =  usager.usagerPrenom + ' '+ usager.usagerNom;
	 				if (usagerTemp === $scope.usagerRecherche) {
	 					$scope.usager = usager;
	 					$scope.detailVisible = true;
	 				}
	 			});
	 		};

	 		/**
			 * @function Bouton "Valider" : enregistre l'attribution du poste
			 */
	 		$scope.affecterPosteValider = function() {
	 			if ($scope.usager !== undefined && this.mtId !== undefined && this.dureeId != undefined) {
	 				var connexion = {};
	 				connexion.cnxDureePrevue=null;
	 				connexion.motif = {mtId : this.mtId};
	 				connexion.usager = $scope.usager;
	 				connexion.poste = $scope.poste;
	 				switch (this.dureeId) {
	 					case '1':
	 						connexion.cnxDureePrevue = '00:15:00';
	 					break;
	 					case '2':
	 						connexion.cnxDureePrevue = '00:30:00';
	 					break;
	 					case '3':
	 						connexion.cnxDureePrevue = '00:45:00';
	 					break;
	 					case '4':
	 						connexion.cnxDureePrevue = '00:60:00';
	 					break;
	 				}
	 				
	 				$http
	 					.post("/MDE_Rest/Api/connexion", connexion)
	 					.success(function(data, status, headers, config) {
	 							$location.path('/MDE_GUI_POC/gererSalle/' + $scope.poste.salle.salleId);
	 						})
	 					.error(function(data, status, headers, config) {
	 							var retour = {};
	 							retour.statut = 'KO';
	 							retour.serviceErreur = true;
	 							retour.libelle = '/MDE_Rest/Api/connexion';
	 							retour.data = data;
	 							retour.status = status;
	 							retour.headers = headers;
	 							retour.config = config;
	 							$scope.erreur = {statut : true, retour : retour};
	 						});
	 			} else {
	 				var retour = {};
	 				retour.statut = 'KO';
	 				retour.parametresErreur = true;
	 				retour.usager  = ($scope.usager!==undefined);
	 				retour.usagerConnecte  = ($scope.usager!==undefined)?$scope.usager.usagerConnecte:false;
	 				retour.mtId  = (this.mtId!==undefined);
	 				retour.dureeId  = (this.dureeId!==undefined);
	 				$scope.erreur = {statut : true, retour : retour};
	 			}
	 		};

	 		/**
			 * @function Bouton "Créer Usager"
			 */
	 		$scope.creerUsagerValider = function() {
	 			var controleSaisie = creerUsagerService.controleSaisie(this.usagerSaisi);
	 			if (controleSaisie.statut === true) {
	 				
	 				creerUsagerService.creerUsager(this.usagerSaisi, function (nouvelUsager) {
	 					$scope.usager = nouvelUsager;
	 					$scope.detailVisible = true;
	 					$scope.listeUsagers.push(nouvelUsager);
	 					$scope.usagerRecherche = nouvelUsager.usagerPrenom + ' ' + nouvelUsager.usagerNom;
	 				});
	 			
	 				// fermeture de la fenêtre modale
	 				$('#modalCreerUsager').modal('hide');
	 			} else {
	 				$scope.controleSaisie = controleSaisie;
	 			}
	 		};
	 		
	 		/**
			 * @function Bouton "Retour"
			 */
	 		$scope.creerUsagerRetour = function() {
	 			// fermeture de la fenêtre modale
	 			$('#modalCreerUsager').modal('hide');
	 		};
			}
	 	}
	]
);


