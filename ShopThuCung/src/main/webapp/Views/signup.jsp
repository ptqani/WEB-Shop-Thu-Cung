<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Đăng kí tài khoản</title>
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
						<li><a href="index.php">Trang chủ</a></li>
						<li><a href="index.php?page=congiong">Sản phẩm</a></li>
						<li><a href="index.php?page=yourorder">Đơn hàng</a></li>
					</ul>
				</div>

			</div>

			<div class="navbar__center">
				<form action="signup" method="GET" class="navbar__search">
					<input type="text" value="" placeholder="Nhập để tìm kiếm..."
						name="txtsearch" class="search" required> <i
						class="fa fa-search" id="searchBtn"></i>
				</form>
			</div>

			<div class="navbar__right">

				<div class="login">
					<a href="index.php?page=login"><i class="fa fa-user"></i></a>
				</div>

				<a href="index.php?page=cart" class="navbar__shoppingCart"> <img
					src="./img/shopping-cart.svg" style="width: 24px;" alt=""> <span>0</span>
				</a>
			</div>
		</div>

	</div>

	<!--Main-->
	<div class="login-form"
		style="height: unset !important; margin-top: -105px !important;">
		<div class="main"
			style="padding-top: 100px; padding-bottom: 15px; margin-bottom: 0;">
			<form action="signup" method="POST" class="form" id="form-1">
				<h3 class="heading">Đăng ký tài khoản</h3>
				<div class="dont-have-account">
					Bạn đã có tài khoản? <a class="account-register" href="login.html">Đăng
						nhập</a>
				</div>

				<div class="spacer"></div>

				<div class="form-group">
					<label class="control-label text-left">Tên đăng nhập</label>
					<div>
						<input type="text" name="username" class="form-control">
					</div>
				</div>

				<div class="form-group">
					<label class="control-label text-left">Mật khẩu</label>
					<div>
						<input type="password" name="pass" class="form-control">
					</div>
				</div>
				<div class="form-group">
					<label class="control-label text-left">Email</label>
					<div>
						<input type="email" name="email" class="form-control">
					</div>
				</div>

				<div class="form-group">
					<label class="control-label text-left">Điện thoại</label>
					<div>
						<input type="text" name="number" class="form-control">
					</div>
				</div>

				<label for="checkbox2" class="term-service"> <input
					type="checkbox" id="checkbox2">

					<div class="checked-box" style="font-size: 13px;">
						Tôi đã đọc và đồng ý với <a href="#" class="a-hover"> điều
							khoản và điều kiện</a>
					</div>

				</label>

				<button type="submit" value="Create" class="form-submit"
					name="register_submit">Đăng ký</button>

			</form>
		</div>
	</div>

	<div class="go-to-top">
		<i class="fas fa-chevron-up"></i>
	</div>

	<footer>
		<div class="footer">
			<div class="footer__title">
				<span>Liên hệ</span>
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
				<h3>Giới thiệu</h3>
				<p>Website quản lý, mua bán thức ăn và phụ kiện thú cưng</p>
			</div>



			<div class="footer__info-content">
				<h3>Liên hệ</h3>
				<p>Địa chỉ: KTX Khu B, DH Quốc Gia TPHCM</p>
				<p>Email: shopthucung@gmail.com</p>
				<p>Sđt: 123456789</p>
			</div>

			<div class="footer__info-content">
				<h3>Fanpage</h3>
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
			<center>2022 All rights reserved.</center>
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