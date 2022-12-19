<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="${sessionScope.lang}" />
<fmt:setBundle basename="i18n.messages" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title><fmt:message key="body.ttitle"></fmt:message></title>
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
						<c:if test="${sessionScope.sessio != null}">
							<li><a href="oder"><fmt:message key="body.oder"></fmt:message></a>
							</li>
						</c:if>
						<c:if test="${sessionScope.sessio.isAdmin == 0}">
							<li><a href="#registerPro" target="_blank"
								data-toggle="modal" rel="noopener noreferrer"
								rel="noopener noreferrer"><fmt:message key="menu.register"></fmt:message></a></li>
						</c:if>
						<c:if test="${sessionScope.sessio.isAdmin == 1}">
							<li><a href="manage" target="_blank"
								rel="noopener noreferrer"><fmt:message
										key="menu.itemproduct"></fmt:message></a></li>
						</c:if>

					</ul>
				</div>
			</div>

			<div class="navbar__center">
				<form action="search" method="GET" class="navbar__search">
					<input type="text" value="${textvalue}"
						placeholder="<fmt:message key="menu.search" ></fmt:message>"
						name="txtsearch" class="search" required>
					<button class="btnSearch">
						<i class="fa fa-search" id="searchBtn"></i>
					</button>
				</form>
			</div>

			<div class="navbar__right">
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
				<div class="login">
					<c:if test="${sessionScope.sessio == null}">
						<a href="login.jsp"><fmt:message key="menu.login"></fmt:message></a>
					</c:if>
					<c:if test="${sessionScope.sessio != null}">
						<p>
							${sessionScope.sessio.username} <a href="logout"><fmt:message
									key="menu.logout"></fmt:message></a>
					</c:if>
				</div>

				<div>

					<a href="cart.jsp" class="navbar__shoppingCart"> <img
						src="./img/shopping-cart.svg" style="width: 24px;" alt=""> <c:set
							var="count" value="${0}" /> <c:forEach items="${cart.items}"
							var="item">
							<c:set var="count" value="${count + item.quantity}" />
						</c:forEach> <span>${count }</span>
					</a>
				</div>
			</div>
		</div>

	</div>


	<!--Main-->
	<input type="hidden" name="keyid" value="${keyu}">
	<c:forEach items="${billoder}" var="bills">
		<c:if test="${bills.idcustom == keyu}">
			<div class="body fix-width scroll-inner">
				<div class="text-danger"></div>
				<table class="table table-striped">
					<tbody>
						<tr>
							<th>ID</th>
							<th><fmt:message key="body.oder.status"></fmt:message></th>
							<th><fmt:message key="body.oder.date"></fmt:message></th>
							<th><fmt:message key="body.oder.num"></fmt:message></th>
							<th><fmt:message key="body.oder.tt"></fmt:message></th>
						</tr>

						<tr>
							<td>${bills.id_product}</td>
							<td>
								<div style="color: orange;"><fmt:message key="body.oder.processing"></fmt:message></div>
							</td>
							<td>${bills.datetime}</td>

							<td>${bills.quantity}</td>
							<td><a href="detailServlet?fromitem=${bills.id_product}"
								target="_blank" rel="noopener noreferrer"><fmt:message
										key="body.oder.tt"></fmt:message></a></td>
						</tr>
					</tbody>
				</table>

			</div>
		</c:if>
	</c:forEach>
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

			$('.quantity').on('click', '.plus', function(e) {
				let $input = $(this).prev('input.qty');
				let val = parseInt($input.val());
				$input.val(val + 1).change();
			});

			$('.quantity').on('click', '.minus', function(e) {
				let $input = $(this).next('input.qty');
				var val = parseInt($input.val());
				if (val > 0) {
					$input.val(val - 1).change();
				}
			});

			var selectAllItems = "#selectall";
			var checkboxItem = ":checkbox";

			$(selectAllItems).click(function() {

				if (this.checked) {
					$(checkboxItem).each(function() {
						this.checked = true;
					});
				} else {
					$(checkboxItem).each(function() {
						this.checked = false;
					});
				}

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
	<div id="registerPro" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form action="registerproduct" method="post">
					<div class="modal-header">
						<h4 class="modal-title">
							<fmt:message key="menu.register"></fmt:message>
						</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label><fmt:message key="body.nameshop"></fmt:message></label> <input
								name="name" type="text" class="form-control" required>
						</div>
						<div class="form-group">
							<label><fmt:message key="body.sdtshop"></fmt:message></label> <input
								name="sdt" type="text" class="form-control" required>
						</div>
						<div class="form-group">
							<label><fmt:message key="body.addrestshop"></fmt:message></label>
							<input name="address" type="text" class="form-control" required>
						</div>
						<div class="form-group">
							<label><fmt:message key="body.emailshop"></fmt:message></label> <input
								name="email" type="text" class="form-control" required>
						</div>
					</div>
					<div class="modal-footer">
						<input type="button" data-dismiss="modal" value="Cancel">
						<button name="regis" value="1">
							<fmt:message key="body.regisshop"></fmt:message>
						</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>