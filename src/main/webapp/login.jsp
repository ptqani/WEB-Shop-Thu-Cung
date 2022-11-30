<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="${sessionScope.lang}" />
<fmt:setBundle basename="i18n.messages" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title><fmt:message key="menu.title.login"></fmt:message></title>
<link rel="shortcut icon" type="image/png" href="./img/logo.jpg" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="./css/bsgrid.min.css" />
<link rel="stylesheet" href="./css/style.min.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css" />

</head>
<body>
	<!-- header -->
	<div class="header">

		<div class="navbar">
			<div class="navbar__left">
				<a href="index.php" class="navbar__logo"> <img
					src="./img/logo.jpg" alt="">
				</a>

				<div class="navbar__menu">
					<i id="bars" class="fa fa-bars" aria-hidden="true"></i>
					<ul>
						<li><a href="home"><fmt:message key="menu.homepage"></fmt:message></a></li>
					</ul>
				</div>

			</div>
			<div class="navbar__right">

				<a href="index.php?page=cart" class="navbar__shoppingCart"> <img
					src="./img/shopping-cart.svg" style="width: 24px;" alt=""> <span>0</span>
				</a>
			</div>
		</div>

	</div>

	<!--Main-->
	<div class="login-form">
		<div class="height360">
			<div class="main">
				<form action="login" method="POST" class="form" id="form-2"
					style="width: 400px;">
					<h3 class="heading">
						<fmt:message key="body.loginform"></fmt:message>
					</h3>


					<div class="form-group">
						<label for="Fullname" class="form-label"><fmt:message
								key="body.usname"></fmt:message></label>
						<p style="display: flex;">
							<input type="text" value="${username}" name="usernamet"
								class="form-control" required>
						</p>

						<span class="form-message"></span>
					</div>

					<div class="form-group">
						<label for="password" class="form-label"><fmt:message
								key="body.pswork"></fmt:message></label>
						<p style="display: flex;">
							<input type="password" name="passt" class="form-control" required>


							<span class="form-message"></span>
					</div>
					<p class="text-danger">${mess.error}</p>
					<button type="submit" class="form-submit" value="Login"
						name="login_submit">
						<fmt:message key="body.loginform"></fmt:message>
					</button>

					<div class="dont-have-account">
						<fmt:message key="body.noacount"></fmt:message>
						<a class="account-register" href="register.jsp"><fmt:message
								key="body.regis"></fmt:message></a>
					</div>
					<div class="dont-have-account">
						<fmt:message key="body.forgotpas"></fmt:message>
						<a class="account-register" href="#"><fmt:message
								key="body.reforgotpas"></fmt:message></a>
					</div>
				</form>
			</div>
		</div>
	</div>

	<div class="go-to-top">
		<i class="fas fa-chevron-up"></i>
	</div>

	<footer>
		<div class="footer">
			<div class="footer__title">
				<span> <fmt:message key="end.contact"></fmt:message></span>
				<div class="footer__social">
					<a href="facebook.com/trieuetam" target="_blank"><i
						class="fab fa-facebook-f"></i></a> <a href="#"><i
						class="fab fa-github"></i></a> <a href="#"><i
						class="fab fa-google"></i></a>
				</div>
			</div>
		</div>

		<div class="footer__info">

			<div class="footer__info-content">
				<h3>
					<fmt:message key="end.introduce"></fmt:message>
				</h3>
				<p>
					<fmt:message key="end.website"></fmt:message>
				</p>
			</div>



			<div class="footer__info-content">
				<h3>
					<fmt:message key="end.contact"></fmt:message>
				</h3>
				<p>
					<fmt:message key="end.address"></fmt:message>
				</p>
				<p>
					<fmt:message key="end.emailshop"></fmt:message>
				</p>
				<p>
					<fmt:message key="end.sdt"></fmt:message>
				</p>
			</div>

			<div class="footer__info-content">
				<h3>
					<fmt:message key="end.fanpage"></fmt:message>
				</h3>
				<p>
					<iframe
						src="https://www.facebook.com/plugins/page.php?href=https%3A%2F%2Fwww.facebook.com%2FC%25E1%25BB%25ADa-h%25C3%25A0ng-S%25E1%25BA%25A3n-ph%25E1%25BA%25A9m-D%25C3%25A0nh-cho-Th%25C3%25BA-C%25C6%25B0ng-100178969197228%2F%3Fref%3Dpages_you_manage&tabs=timeline&width=300px&height=150px&small_header=false&adapt_container_width=true&hide_cover=false&show_facepile=true&appId"
						width="100%" height="150px" style="border: none; overflow: hidden"
						scrolling="no" frameborder="0" allowfullscreen="true"
						allow="autoplay; clipboard-write; encrypted-media; picture-in-picture; web-share"></iframe>
				</p>
			</div>

		</div>

		<div class="footer__copyright">
			<center>
				<fmt:message key="end.yeardaymonth"></fmt:message>
			</center>
		</div>
	</footer>


	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick.min.js"></script>
	<script>
		//Slider using Slick
		$(document).ready(function() {
			$('.post-wrapper').slick({
				slidesToScroll : 1,
				autoplay : true,
				arrow : true,
				dots : true,
				autoplaySpeed : 5000,
				prevArrow : $('.prev'),
				nextArrow : $('.next'),
				appendDots : $(".dot"),
			});
		});

		// Slick mutiple carousel
		$('.post-wrapper2').slick({
			slidesToShow : 5,
			slidesToScroll : 1,
			autoplay : true,
			autoplaySpeed : 2000,
			prevArrow : $('.prev2'),
			nextArrow : $('.next2'),
			responsive : [ {
				breakpoint : 1024,
				settings : {
					slidesToShow : 4,
					slidesToScroll : 3,
					infinite : true,
				}
			}, {
				breakpoint : 600,
				settings : {
					slidesToShow : 3,
					slidesToScroll : 2
				}
			}, {
				breakpoint : 480,
				settings : {
					slidesToShow : 2,
					slidesToScroll : 1
				}
			} ]
		});
	</script>

	<script src="./script/script.js"></script>
</body>
</html>