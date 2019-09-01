angular.module('yaraApp').controller(
		'LogOutController',
		[ '$scope', '$window', '$store', 
				function($scope, $window, $store) {
			
					console.log("himanshu");
					$store.remove("loginStatus");
					$window.location.href = '#/menu';
				} ]);