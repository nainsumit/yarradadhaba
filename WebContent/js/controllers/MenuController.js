angular
		.module('yaraApp')

		.controller('MenuController', [ '$scope'

		, '$location'

		, 'menuFactory'

		, '$store'

		, '$window'

		, function($scope, $location, menuFactroy, $store, $window) {

			$scope.dbDishes;

			var cacheDbDishes = $store.get("dbDishes");

			if (cacheDbDishes == null) {

				menuFactroy.getDbDishes().then(function(response) {
					$scope.dbDishes = response.data.data;
				});

				$store.remove('dbDishes');

				$store.bind($scope, 'dbDishes', $scope.dbDishes);
			} else {
				$scope.dbDishes = cacheDbDishes;
			}

			$scope.isObject = function(value) {
				return angular.isObject(value);
			}

			$scope.isArray = function(value) {
				return angular.isArray(value);
			}

			$scope.gotoElement = function(eID) {

				$location.hash('bottom');

				menuFactroy.scrollTo(eID);

			}

			$scope.gotoElement1 = function() {

				Console.log("Hello");

			}
		} ]);