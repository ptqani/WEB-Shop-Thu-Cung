<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="${sessionScope.lang}" />
<fmt:setBundle basename="i18n.messages" />
<!DOCTYPE html>
<html lang="vi_VN">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title><fmt:message key="regis.register"></fmt:message></title>
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
				<a href="home" class="navbar__logo"> <img
					src="./img/logo.jpg" alt="">
				</a>

				<div class="navbar__menu">
					<i id="bars" class="fa fa-bars" aria-hidden="true"></i>
					<ul>
						<li><a href="home"><fmt:message key="menu.homepage"></fmt:message></a></li>
					</ul>
				</div>

			</div>
			<div style="margin-right: 5px;">
					<select name="countries" class="countries"
						onchange="location = this.value;">
						<option value=""><fmt:message key="menu.language"></fmt:message></option>

						<option value="?sessionLocale=vi_VN"><fmt:message
								key="menu.vietnames"></fmt:message>
						</option>

						<option value="?sessionLocale=en_US"><fmt:message
								key="menu.englist"></fmt:message>
						</option>
					</select>
				</div>
		</div>

	</div>

	<!--Main-->
	<div class="login-form"
		style="height: unset !important; margin-top: -105px !important;">
		<div class="main"
			style="padding-top: 100px; padding-bottom: 15px; margin-bottom: 0;">
			<form action="signup" method="POST" class="form" id="form-1"
				style="width: 430px;">
				<h3 class="heading">
					<fmt:message key="regis.register"></fmt:message>
				</h3>
				<div class="dont-have-account">
					<fmt:message key="regis.yesacount"></fmt:message>
					<a class="account-register" href="login.jsp"><fmt:message
							key="menu.login">regis.yesacount</fmt:message></a>
				</div>

				<div class="spacer"></div>

				<div class="form-group">
					<label class="control-label text-left"><fmt:message
							key="body.usname"></fmt:message></label>
					<div>
						<input type="text" name="username" value="${usname}"
							class="form-control" required> <span
							style="padding-left: 10px; font-size: 20px; color: red;">${exit}
						</span>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label text-left"><fmt:message
							key="body.pswork"></fmt:message></label>
					<div>
						<input type="password" name="pass" value="${pas}"
							class="form-control" required>

					</div>
				</div>
				<div class="form-group">
					<label class="control-label text-left"><fmt:message
							key="body.repas"></fmt:message></label>
					<div>
						<input type="password" name="repass" value="${rpas}"
							class="form-control" required> <span
							style="padding-left: 10px; font-size: 20px; color: red;">${errore}
						</span>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label text-left"><fmt:message
							key="body.email"></fmt:message></label>
					<div>
						<input type="email" name="email" value="${el}"
							class="form-control" required>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label text-left"><fmt:message
							key="body.phonemunber"></fmt:message></label>
					<div>
						<input type="number" name="phonenumber" value="${nb}"
							class="form-control" required>
					</div>
				</div>
				<button type="submit" value="Create" class="form-submit"
					name="register_submit">
					<fmt:message key="body.regis"></fmt:message>
				</button>

			</form>
		</div>
	</div>

	<div class="go-to-top">
		<i class="fas fa-chevron-up"></i>
	</div>

	<footer>
		<div class="footer">
			<div class="footer__title">
				<span><fmt:message key="end.contact"></fmt:message></span>
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