<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<html class="no-js">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link rel="icon" href="images/logo.png">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- CSS
        ================================================ -->
<!-- Owl Carousel -->
<link rel="stylesheet" href="css/owl.carousel.css">
<!-- bootstrap.min css -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<!-- Font-awesome.min css -->
<link rel="stylesheet" href="css/font-awesome.min.css">
<!-- Main Stylesheet -->
<link rel="stylesheet" href="css/animate.min.css">

<link rel="stylesheet" href="css/main.css">
<!-- Responsive Stylesheet -->
<link rel="stylesheet" href="css/responsive.css">
</head>

<body ng-app="yaraApp">
	<!--<ng-include src="'menuTemplate.html'"></ng-include>-->
	<!--<ng-view></ng-view>-->
	<div ui-view="header"></div>
	<div ui-view="content"></div>
	<div ui-view="footer"></div>

	<!-- Js -->
	<script src="js/vendor/modernizr-2.6.2.min.js"></script>
	<!-- <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script> -->
	<script>
		window.jQuery
				|| document
						.write('<script src="js/vendor/jquery-1.10.2.min.js"><\/script>')
	</script>
	<script src="js/jquery.nav.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/plugins.js"></script>
	<script src="js/wow.min.js"></script>

	<!-- Angular Related Scripts Start -->
	<script src="js/angular.js"></script>
	<script src="js/angular-cookies.min.js"></script>
	<script src="js/angular-ui-router.min.js"></script>
	<script src="js/app.js"></script>
	<script src="js/controllers/MenuController.js"></script>
	<script src="js/controllers/CartController.js"></script>
	<script src="js/controllers/LoginController.js"></script>
	<script src="js/controllers/LogOutController.js"></script>
	<script src="js/service/services.js"></script>
	<!-- Angular Related Scripts Ends -->
</body>

</html>