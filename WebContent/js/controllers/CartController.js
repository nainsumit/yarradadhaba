angular
		.module('yaraApp').controller(
				'CartController',
				[
						'$scope',
						'$window',
						'$store',
						'$interval',
						function($scope, $window, $store, $interval) {

							$scope.totalItems = 0;

							$scope.cartErrorMessage = '';

							$scope.total = 0.0;

							$scope.cartArray = [];

							$scope.deliveryCharges = 20;

							var cachedeliveryCharges = $store
									.get("deliveryCharges");

							if (cachedeliveryCharges != null) {
								$scope.deliveryCharges = cachedeliveryCharges;
							}

							var cacheCart = $store.get("cartArray");

							if (cacheCart != null) {
								$scope.cartArray = cacheCart;
							}

							var cachetotal = $store.get("total");

							if (cachetotal != null) {
								$scope.total = cachetotal;
							}

							var cachetotalItems = $store.get("totalItems");

							if (cachetotalItems != null) {
								$scope.totalItems = cachetotalItems;
							}

							$scope.checkCart = function() {
								if ($scope.total < 150
										|| $scope.cartArray.length <= 0) {

									$window.location.href = '#/menu';
								}
							}

							$scope.validateCartBeforeCheckOut = function() {
								if ($scope.total < 150
										|| $scope.cartArray.length <= 0) {

									$scope.cartErrorMessage = 'The order placed is less than minimum order amount'
								} else {
									$window.location.href = '#/checkOut';
								}
							}

							$scope.checkCart();
							
							
							$scope.loginSubmit = function() {

								requestheaders = {
									"Authorization" : "Basic "
											+ btoa($scope.user.username + ":"
													+ $scope.user.password)
								};
								/*
								 * alert($scope.user.username);
								 * alert($scope.user.password);
								 */

								$http({
									method : 'POST',
									url : 'app/yara/login',
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
													
													$scope.loginErrorMessage = 'wrong username or password';
													$store.bind($scope,
															'loginStatus',
															false);
												});
							};

							$scope.addItem = function(dish) {

								$scope.StopTimer();
								$scope.StartTimer();

								$scope.cartErrorMessage = ''

								var finalitem = {
									quantity : 1,
									name : dish.name,
									price : dish.price
								}

								$scope.total = $scope.total
										+ parseFloat(finalitem.price);

								deliveryCharges();

								$scope.totalItems = $scope.totalItems + 1;

								$store.remove('totalItems');

								$store.bind($scope, 'totalItems',
										$scope.totalItems);

								$store.remove('total');

								$store.bind($scope, 'total', $scope.total);

								for (var i = 0; i < $scope.cartArray.length; i++) {
									if ($scope.cartArray[i].name === finalitem.name) {
										$scope.cartArray[i].quantity = $scope.cartArray[i].quantity + 1;

										$store.remove('cartArray');

										$store.bind($scope, 'cartArray',
												$scope.cartArray);

										return;
									}
								}

								$scope.cartArray.push(finalitem);

								$store.remove('cartArray');

								$store.bind($scope, 'cartArray',
										$scope.cartArray);
							}

							$scope.plusOneItem = function(dish) {

								$scope.StopTimer();
								$scope.StartTimer();

								var i = 0;
								for (i = 0; i < $scope.cartArray.length; i++) {
									if ($scope.cartArray[i].name === dish.name) {

										$scope.cartArray[i].quantity = $scope.cartArray[i].quantity + 1;

										$scope.totalItems = $scope.totalItems + 1;

										$scope.total = $scope.total
												+ parseFloat(dish.price);

										break;
									}
								}

								deliveryCharges();

								$store.remove('cartArray');

								$store.bind($scope, 'cartArray',
										$scope.cartArray);

								$store.remove('totalItems');

								$store.bind($scope, 'totalItems',
										$scope.totalItems);

								$store.remove('total');

								$store.bind($scope, 'total', $scope.total);

							}

							var deliveryCharges = function() {
								if ($scope.total < 250) {
									$scope.deliveryCharges = 20;
								} else {
									$scope.deliveryCharges = '0';
								}

								$store.remove('deliveryCharges');

								$store.bind($scope, 'deliveryCharges',
										$scope.deliveryCharges);
							}

							$scope.minusOneItem = function(dish) {

								$scope.StopTimer();
								$scope.StartTimer();

								var i = 0;
								for (i = 0; i < $scope.cartArray.length; i++) {
									if ($scope.cartArray[i].name === dish.name) {
										if ($scope.cartArray[i].quantity == 1) {
											$scope.cartArray.splice(i, 1);
										} else {
											$scope.cartArray[i].quantity = $scope.cartArray[i].quantity - 1;
										}

										$scope.totalItems = $scope.totalItems - 1;
										$scope.total = $scope.total
												- parseFloat(dish.price);

										break;
									}
								}

								deliveryCharges();

								$store.remove('cartArray');

								$store.bind($scope, 'cartArray',
										$scope.cartArray);

								$store.remove('totalItems');

								$store.bind($scope, 'totalItems',
										$scope.totalItems);

								$store.remove('total');

								$store.bind($scope, 'total', $scope.total);
							}

							$scope.clearCart = function() {
								$store.remove('cartArray');
								$store.remove('total');
								$store.remove('totalItems');
								$store.remove('deliveryCharges');
								$scope.cartArray = [];
								$scope.total = 0;
								$scope.totalItems = 0;
								$scope.deliveryCharges = 0;
							};

							$scope.StartTimer = function() {
								$scope.Timer = $interval(function() {
									$scope.clearCart();
									$window.location.href = '#/checkOut';
								}, (15 * 60 * 1000));
							};

							$scope.StopTimer = function() {
								// Cancel the Timer.
								if (angular.isDefined($scope.Timer)) {
									$interval.cancel($scope.Timer);
								}
							};

							$scope.StopTimer();
							$scope.StartTimer();

						} ])