/**
 * @module creerUtilisateurControleur Contrôleur pour vue 'Créer un
 *         utilisateur'.
 * @author P42
 * @name creerUtilisateurControleur.js
 * @link ng.$scope
 * @link ng.$http
 * @link ngRoute.$location
 * @link ng.$rootScope
 * @link ng.$window
 * 
 */
app
		.controller(
				'creerUtilisateurControleur',
				[
						'$scope',
						'$http',
						'$location',
						'$rootScope',
						'$window',
						function creerUtilisateurControleur($scope, $http,
								$location, $rootScope, $window) {

							if (sessionStorage.getItem("utilConn") === null) {
								$rootScope.utilConn = sessionStorage
										.getItem("utilConn");
								$rootScope.cheminVoulu = '/MDE_GUI_POC/creerUtilisateur';
								$location.path('/MDE_GUI_POC/login');
							} else {
								$rootScope.cacheNav = false;
								$rootScope.cacheHead = false;
								$rootScope.cacheTuile = true;
								// manipulation DOM pour navigation accordion
								$("#utilisateurs").addClass("in");
								$("#usagers").removeClass("in");
								$("#salles").removeClass("in");
								$("#statistiques").removeClass("in");
							
							
								
								// Requête de la liste des sites maison de
								// l'emploi
								$http.get('/MDE_Rest/Api/site').success(
										function(response) {
											$scope.listeSites = response;
										});
								

								// Requête de la liste des structures
								$http
										.get(
												'/MDE_Rest/Api/utilisateur/structure')
										.success(function(response) {
											$scope.listeStructures = response;
										});
								
								/**
								 * @function Création d'un utilisateur
								 */
								$scope.creerUtilisateurValider = function() {
									var utilisateur = $scope.utilisateurSaisi;
									var controleSaisie = {};
									controleSaisie.statut = true;

									if (utilisateur === undefined
											|| utilisateur.utilNom === undefined
											|| utilisateur.utilNom === '') {
										controleSaisie.statut = false;
										controleSaisie.bUtilNomErreur = true;
									}
									if (utilisateur === undefined
											|| utilisateur.utilPrenom === undefined
											|| utilisateur.utilPrenom === '') {
										controleSaisie.statut = false;
										controleSaisie.bUtilPrenomErreur = true;
									}
									if (utilisateur === undefined
											|| utilisateur.utilLogin === undefined
											|| utilisateur.utilLogin === '') {
										controleSaisie.statut = false;
										controleSaisie.bUtilLoginErreur = true;
									}
									if (utilisateur === undefined
											|| utilisateur.utilMdp === undefined
											|| utilisateur.utilMdp === '') {
										controleSaisie.statut = false;
										controleSaisie.bUtilMdpErreur = true;
									}
									if (controleSaisie.statut == true) {
										utilisateur.utilMdp = md5(utilisateur.utilMdp);
										$http
												.post(
														"/MDE_Rest/Api/utilisateur",
														utilisateur)
												.success(
														function(data, status) {
															utilisateur.utilNom ='';
															utilisateur.utilPreom ='';
															utilisateur.utilLogin ='';
															utilisateur.utilMdp ='';
															utilisateur.site.siteId =null;
															utilisateur.structure.structId =null;
															$scope.utilisateurSaisi = utilisateur;
															
														})
												.error(
														function(data, status,
																headers, config) {
															var retour = {};
															retour.statut = 'KO';
															retour.serviceErreur = true;
															retour.libelle = '/MDE_Rest/Api/utilisateur';
															retour.data = data;
															retour.status = status;
															retour.headers = headers;
															retour.config = config;
														});
									}
									$scope.controleSaisie = controleSaisie;
								}
							}
						}

				]);
