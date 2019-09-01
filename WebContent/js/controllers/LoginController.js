angular
		.module('yaraApp').controller(
				'LoginController',
				[
						'$scope',
						'$window',
						'$store',
						'$http',
						function($scope, $window, $store, $http) {

							$scope.user = {};
							$scope.results = [];
							$scope.loginErrorMessage = '';

							var appLoginStatus = $store.get("loginStatus");

							if (appLoginStatus != null && appLoginStatus === true) {
								$window.location.href = '#/menu';
							}

							$scope.loginSubmit = function() {

								requestheaders = {
									"Authorization" : "Basic "
											+ btoa($scope.user.username + ":"
													+ $scope.user.password)
								};

								$http({
									method : 'GET',
									url : 'app/user/login',
									headers : requestheaders
								})
										.then(
												function successCallback(
														response) {
													
													$scope.loginErrorMessage = '';
													$window.location.href = '#/menu';

													$store
															.bind(
																	$scope,
																	'loginStatus',
																	true);
												},
												function errorCallback(response) {
													/*
													 * alert('error');
													 * alert('hi'+response.status);
													 * alert(response.data);
													 */
													$scope.loginErrorMessage = 'wrong username or password';
													$store.bind($scope,
															'loginStatus',
															false);
												});
							};

						} ]);