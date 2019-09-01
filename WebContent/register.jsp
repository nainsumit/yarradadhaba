<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<sec:authorize access="isAuthenticated()">
	<c:redirect url="/#/menu" />
</sec:authorize>


<html class="no-js">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Order Online Late Night Food in Pune - Yaradadhaba</title>
<meta name="description="
	content="Yaradadhaba, Pune delivers North Indian, and Fast Food all night long at extremely affordable prices. Order now at our website or call">
<meta property="og:description"
	content="Yaradadhaba, Pune delivers North Indian, and Fast Food all night long at extremely affordable prices. Order now at our website or call" />
<link rel="icon" href="images/logo.png">
<meta name="description" content="">
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

<script>
	window.jQuery
			|| document.write(
					'<script src="js/vendor/jquery-1.10.2.min.js"><\/script>')
</script>

<script src="js/jquery-sticky-div.js"></script>
<script src="js/jquery.sticky.js"></script>
<script src="js/main.js"></script>
</head>

<body ng-app="yaraApp">
	<!--<ng-include src="'menuTemplate.html'"></ng-include>-->
	<!--<ng-view></ng-view>-->
	<!--
	header-img start 
	============================== -->
	<div class="jumbotron">
		<section id="footer">
		<div class="container">
			<div class="row">
				<div class="col-md-3"></div>
				<!-- .col-md-4 close -->
				<div class="col-md-5">
					<div class="block wow fadeInLeft" data-wow-delay="1100ms">
						<div class="social-media-link">
							<h4>
								Order-<span>Online</span> (000) 123 456 78- (000) 123 4567 89
							</h4>
							<h4>
								Follow <span>US</span>
							</h4>
							<ul>
								<li><a href="#"> <i class="fa fa-twitter"></i>
								</a></li>
								<li><a href="#"> <i class="fa fa-facebook"></i>
								</a></li>
								<li><a href="#"> <i class="fa fa-dribbble"></i>
								</a></li>
								<li><a href="#"> <i class="fa fa-behance"></i>
								</a></li>
							</ul>
						</div>
					</div>
				</div>
				<!-- .col-md-4 close -->
				<div class="col-md-4"></div>
				<!-- .col-md-4 close -->
			</div>
			<!-- .row close -->
		</div>
		<!-- .containe close --> </section>
	</div>
	<!--
    Header start 
	============================== -->
	<nav id="navigation">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="block">
					<nav class="navbar navbar-default"> <!-- Brand and toggle get grouped for better mobile display -->
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed"
							data-toggle="collapse"
							data-target="#bs-example-navbar-collapse-1">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
						<a class="navbar-brand"
							onclick="location.href = '<%=request.getContextPath()%>/#'"
							style="cursor: pointer; cursor: hand"> <img
							src="images/logo.png" alt="Logo">
						</a>
					</div>

					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse"
						id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav navbar-right" id="top-nav">
							<li class="active"><a
								onclick="location.href = '<%=request.getContextPath()%>/#'"
								style="cursor: pointer; cursor: hand"><i class="fa fa-home"></i>
									Home</a></li>
							<li><a href="<%=request.getContextPath()%>/#/menu"><i
									class="fa fa-shopping-cart "></i> order-online</a></li>
						</ul>
					</div>
					<!-- /.navbar-collapse -->
				</div>
				<!-- /.container-fluid -->
	</nav>
	</div>
	</div>
	<!-- .col-md-12 close -->
	</div>
	<!-- .row close -->
	</div>
	<!-- .container close -->
	</nav>
	<!-- header close -->
	<section id="price" style="background: url("
		../images/blog/blog-bg.jpg");" ng-controller="MenuController">
	<div class="container">
		<div class="row " style="padding-top: 5em">
			<div class="col-md-12">
				<div class="block" style="margin-top: -200px">
					<div class="pricing-list">
						<div class="row">
							<div>
								<div class="border-menu">
									<ul>
										<li style="padding-left: 1em; padding-right: 1em"
											class="wow fadeInUp" data-wow-duration="300ms"
											data-wow-delay="300ms">
											<div class="item">
												<div style="height: 40px" class="item-title">
													<h4 style="font-weight: bold">REGISTRATION FORM</h4>
													<div class="border-bottom"></div>
												</div>
												<div class="row" style="padding-bottom: 20px">
													<div class="col-xs-3"
														style="border-right: 1px solid black; padding-right: 1em"></div>
													<div class="col-xs-6" style="padding-left: 1em">
														<div class="row">
															<div class="col-md-12">
																<div class="block">
																	<h3 class="title wow fadeInLeft"
																		data-wow-duration="500ms" data-wow-delay="300ms">
																		Sign <span>UP</span>
																	</h3>
																	<form name="registerForm" action=""
																		method='POST'>
																		<div class="form-group wow fadeInDown"
																			data-wow-duration="500ms" data-wow-delay="600ms">
																			<input type="email" class="form-control"
																				id="exampleInputEmail1" placeholder="Name">
																		</div>
																		<div class="form-group wow fadeInDown"
																			data-wow-duration="500ms" data-wow-delay="800ms">
																			<input type="text" class="form-control"
																				placeholder="Email Address">
																		</div>
																		<div class="form-group wow fadeInDown"
																			data-wow-duration="500ms" data-wow-delay="800ms">
																			<input type="text" class="form-control"
																				placeholder="Phone">
																		</div>
																		<div class="form-group wow fadeInDown"
																			data-wow-duration="500ms" data-wow-delay="1000ms">
																			<textarea class="form-control" rows="3"
																				placeholder="Address"></textarea>
																		</div>
																		<div class="form-group wow fadeInDown"
																			data-wow-duration="500ms" data-wow-delay="800ms">
																			<input type="text" class="form-control"
																				placeholder="Area">
																		</div>
																		<div class="form-group wow fadeInDown"
																			data-wow-duration="500ms" data-wow-delay="800ms">
																			<input type="text" class="form-control"
																				placeholder="City">
																		</div>
																		<div>
																			<input class="buttonCheckOut" style="width: 100%"
																				name="submit" type="submit" value="REGISTER" />
																		</div>
																	</form>
																</div>
															</div>
														</div>
													</div>
													<div class="col-xs-3"
														style="border-right: 1px solid black; padding-right: 1em"></div>
												</div>
											</div>
										</li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</section>
	<!--
    footer  start
    ============================= -->
	<section id="footer">
	<div class="container">
		<div class="row">
			<div class="col-md-4">
				<div class="block wow fadeInLeft" data-wow-delay="200ms">
					<h3>
						CONTACT <span>INFO</span>
					</h3>
					<div class="info">
						<ul>
							<li>
								<h4>
									<i class="fa fa-phone"></i>Telefone
								</h4>
								<p>(000) 123 456 78- (000) 123 4567 89</p>

							</li>
							<li>
								<h4>
									<i class="fa fa-map-marker"></i>Address
								</h4>
								<p>2046 Blue Spruce Lane Laurel Canada</p>
							</li>
							<li>
								<h4>
									<i class="fa fa-envelope"></i>E mail
								</h4>
								<p>rest@gmail.com - rest@mail.ru</p>

							</li>
						</ul>
					</div>
				</div>
			</div>
			<!-- .col-md-4 close -->
			<div class="col-md-4">
				<div class="block wow fadeInLeft" data-wow-delay="700ms">
					<h3>
						LATEST <span>BLOG POSTS</span>
					</h3>
					<div class="blog">
						<ul>
							<li>
								<h4>
									<a href="#">Nov 9-2014</a>
								</h4>
								<p>Lorem ipsum dolor sit amet, consectetur adip iscing elit.
									Curabitur ut blandit sapien</p>
							</li>
							<li>
								<h4>
									<a href="#">Sep 8-2014</a>
								</h4>
								<p>Lorem ipsum dolor sit amet, consectetur adip iscing elit.
									Curabitur ut blandit sapien</p>
							</li>
						</ul>
					</div>
				</div>
			</div>
			<!-- .col-md-4 close -->
			<div class="col-md-4">
				<div class="block wow fadeInLeft" data-wow-delay="1100ms">
					<div class="gallary">
						<h3>
							PHOTO <span>STREAM</span>
						</h3>
						<ul>
							<li><a href="#"><img src="images/photo/photo-1.jpg"
									alt=""></a></li>
							<li><a href="#"><img src="images/photo/photo-2.jpg"
									alt=""></a></li>
							<li><a href="#"><img src="images/photo/photo-3.jpg"
									alt=""></a></li>
							<li><a href="#"><img src="images/photo/photo-4.jpg"
									alt=""></a></li>
						</ul>
					</div>
					<div class="social-media-link">
						<h3>
							Follow <span>US</span>
						</h3>
						<ul>
							<li><a href="#"> <i class="fa fa-twitter"></i>
							</a></li>
							<li><a href="#"> <i class="fa fa-facebook"></i>
							</a></li>
							<li><a href="#"> <i class="fa fa-dribbble"></i>
							</a></li>
							<li><a href="#"> <i class="fa fa-behance"></i>
							</a></li>
						</ul>
					</div>
				</div>
			</div>
			<!-- .col-md-4 close -->
		</div>
		<!-- .row close -->
	</div>
	<!-- .containe close --> </section>
	<!-- #footer close -->

	<!-- Js -->
	<script src="js/vendor/modernizr-2.6.2.min.js"></script>
	<!-- <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script> -->
	<script src="js/jquery.nav.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/plugins.js"></script>
	<script src="js/wow.min.js"></script>

	<!-- Angular Related Scripts Start -->
	<script src="js/angular.min.js"></script>
	<script src="js/angular-ui-router.min.js"></script>
	<script src="js/app.js"></script>
	<script src="js/controllers.js"></script>
	<script src="js/services.js"></script>
	<!-- Angular Related Scripts Ends -->
</body>

</html>