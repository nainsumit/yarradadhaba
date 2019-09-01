angular.module('yaraApp', [ 'ui.router' ]).config(
		function($stateProvider, $urlRouterProvider) {

			$stateProvider.state('app', {
				url : '/',
				views : {
					'header' : {
						templateUrl : 'views/header.html'
					},
					'content' : {
						templateUrl : 'views/indexTemplate.html',
					},
					'footer' : {
						templateUrl : 'views/footer.html',
					}
				}
			}).state('app.menu', {
				url : 'menu',
				views : {
					'content@' : {
						templateUrl : 'views/menuTemplate.html',
						controller : 'CartController'
					},
					'footer@' : {}
				}
			}).state('app.checkOut', {
				url : 'checkOut',
				views : {
					'content@' : {
						templateUrl : 'views/checkOutTemplate.html',
						controller : 'CartController'
					},
					'footer@' : {}
				}
			}).state('app.login', {
				url : 'login',
				views : {
					'content@' : {
						templateUrl : 'views/loginTemplate.jsp',
						controller : 'LoginController'
					},
					'footer@' : {
						templateUrl : 'views/footer.html',
					}
				}
			}).state('app.logout', {
				url : 'logout',
				views : {
					'content@' : {
						templateUrl : 'views/logOutTemplate.jsp',
						controller : 'LogOutController'
					},
					'footer@' : {}
				}
			});;

			$urlRouterProvider.otherwise('/');
		});
