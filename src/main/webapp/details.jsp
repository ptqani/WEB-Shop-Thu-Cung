<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="${sessionScope.lang}" />
<fmt:setBundle basename="i18n.messages" />
<!DOCTYPE html>
<html lang="vi_VN">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>${productDetail.name}</title>
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
				<a href="home" class="navbar__logo"> <img src="./img/logo.jpg"
					alt="">
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
					<!-- hiện thì tổng số lượng sp -->
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

	<div class="body" style="padding-top: 50px;">
		<a class="buy_continute" href="home"><i
			class="fa fa-arrow-circle-left"></i> <fmt:message key="body.turnback"></fmt:message></a>

		<div class="product__details row">

			<div class="product__details-img col-lg-5 col-md-4">

				<div class="big-img">
					<img src="${productDetail.image}" alt="" id="zoom"
						style="visibility: visible;">
				</div>
				<div class="small-img d-flex mt-5">
					<img src="./img/dohop.jpg"
						onerror="this.onerror=null; this.src='https://i.pinimg.com/originals/ae/4c/9e/ae4c9ea2edf887f6ad1e4e63cfae05b0.jpg'"
						class="small-imgg" alt=""> <img src="./img/dohop.jpg"
						onerror="this.onerror=null; this.src='https://i.pinimg.com/originals/ae/4c/9e/ae4c9ea2edf887f6ad1e4e63cfae05b0.jpg'"
						class="small-imgg" alt=""> <img src="./img/dohop.jpg"
						onerror="this.onerror=null; this.src='https://i.pinimg.com/originals/ae/4c/9e/ae4c9ea2edf887f6ad1e4e63cfae05b0.jpg'"
						class="small-imgg" alt=""> <img src="./img/dohop.jpg"
						onerror="this.onerror=null; this.src='https://i.pinimg.com/originals/ae/4c/9e/ae4c9ea2edf887f6ad1e4e63cfae05b0.jpg'"
						class="small-imgg" alt="">
				</div>
			</div>

			<div class="product__details-info col-lg-7 col-md-8">
				<h3 style="margin-top: unset; line-height: unset;">
					${productDetail.name}</h3>
				<div class="short-des">${productDetail.title}</div>

				<hr />

				<div class="product__pride">
					<div class="product__pride-oldPride"
						style="font-size: 20px; text-align: start;">
						<span class="Price"> <bdi> ${productDetail.price} <span
								class="currencySymbol"><fmt:message key="money"></fmt:message></span>
							</bdi>
						</span>
					</div>
					<div class="product__pride-newPride"
						style="font-size: 40px; text-align: start;">
						<span class="Price"> <bdi> ${productDetail.sellprice}
							<span class="currencySymbol"><fmt:message key="money"></fmt:message></span>
							</bdi>
						</span>
					</div>

				</div>
				<style>
.number__count {
	padding-left: 10px;
}
</style>


				<div class="product__cart">
					<form action="cart" method="post">
						<input type="hidden" name="productCode"
							value="<c:out value='${productDetail.id}'/>"> <input
							class="product__cart-add" type="submit"
							value="<fmt:message key="body.addcart"></fmt:message>">
					</form>
					<form action="cart" method="post">
						<input type="hidden" name="productCode"
							value="<c:out value='${productDetail.id}'/>"> <input
							type="submit" class="product__cart-buy" name="buy-now"
							value="<fmt:message
							key="body.buynow"></fmt:message>">
					</form>
				</div>
			</div>
		</div>

		<div class="body__mainTitle">

			<div class="d-flex justify-content-between align-items-center">

				<div class="d-flex">

					<img src="./img/user.jpg" width="50" height="50"
						style="border-radius: 50%;" />
					<!-- Hiển thị sản phẩm -->
					<div class="pl-3">
						<input type="hidden" name="useridshop" value="${userID.userid}">
						<input type="hidden" name="idproductshop"
							value="${productDetail.id_product}">
						<c:if test="${useridshop == idproductshop}">
							<b>${userID.name}</b>
							<div style="line-height: 30px;">
								<fmt:message key="body.phonecontac"></fmt:message>
								${userID.sdt}
							</div>
							<div>
								<fmt:message key="body.addressshop"></fmt:message>
								${userID.address}
							</div>
							<div>
								<fmt:message key="body.emailshop"></fmt:message>
								${userID.email}
							</div>
						</c:if>

					</div>

				</div>

			</div>

			<hr />
		</div>
		<!--Mô tả sản phẩm-->
		<div class="body__mainTitle">
			<h2>
				<fmt:message key="body.description"></fmt:message>
			</h2>
		</div>
		${productDetail.description}
		<hr />
		<form action="comment" method="post">
			<div>
				<fmt:message key="body.yourname"></fmt:message>
				<input type="text" name="nameuser" size="15"
					style="outline: none; margin-bottom: 5px;">
			</div>
			<div class="d-flex justify-content-between align-items-center">



				<div>
					<fmt:message key="body.command"></fmt:message>
				</div>
				<div class="d-flex align-items-center">
					<input type="hidden" id="rating" name="rating" value="0" /> <input
						name="idpro" type="hidden" value="${productDetail.id}" readonly
						class="form-control" required>
				</div>


			</div>
			<textarea name="content" class="form-control"
				style="outline: none; margin-bottom: 5px;"></textarea>

			<div>
				<input class="btn btn-danger" type="submit"
					value="<fmt:message key="body.de.sent"></fmt:message>" /> <input
					data-val="true" data-val-number="The field id_sp must be a number."
					data-val-required="The id_sp field is required." id="id_sp"
					name="id_sp" type="hidden" value="0" />

			</div>
		</form>
		<!--Bình luận sản phẩm-->
		<div class="body__mainTitle">
			<h2>
				<fmt:message key="body.command"></fmt:message>
			</h2>
		</div>

		<c:forEach items="${listComment}" var="lscomment">
			<div class="body__mainTitle">

				<div class="d-flex justify-content-between align-items-center">

					<div class="d-flex">
						<img src="./img/user.jpg" width="45" height="45"
							style="border-radius: 50%;" />

						<div class="pl-3">
							<c:if test="${lscomment.idpro == productDetail.id}">
								<b> ${lscomment.name}</b>
								<div style="line-height: 30px;">${lscomment.command}</div>
								<div>${lscomment.datetime}</div>
							</c:if>
						</div>

					</div>

				</div>

				<hr />
			</div>
		</c:forEach>

		<hr>
		<!-- Sản phẩm ngẫu nhiên -->
		<div class="body__mainTitle">
			<h2>
				<fmt:message key="body.itemnew"></fmt:message>
			</h2>
		</div>
		<div class="row">
			<div class="post-wrapper2">
				<c:forEach begin="1" end="6" items="${listProductdesc}"
					var="lsproductdesc">

					<div class="col-lg-2_5 col-md-4 col-6 post2">
						<a href="detailServlet?fromitem=${lsproductdesc.id}"
							class="aProduct">
							<div class="product">
								<div class="product__img" style="height: 150px !important;">
									<img src="${lsproductdesc.image}" alt=""
										style="height: 150px !important;">
								</div>
								<div class="product__sale">
									<h4>
										<fmt:message key="body.new"></fmt:message>
									</h4>
								</div>
								<div class="product__content">
									<div class="product__title">${lsproductdesc.name}</div>

									<div class="product__pride-oldPride">
										<span class="Price"> <bdi> ${lsproductdesc.price}
											<span class="currencySymbol">₫</span> </bdi>
										</span>
									</div>

								</div>
							</div>

							<div>
								<div class="product__pride-newPride">
									<span class="Price"> <bdi>
										${lsproductdesc.sellprice} <span class="currencySymbol">₫</span>
										</bdi>
									</span>
								</div>
							</div>
						</a>
					</div>
				</c:forEach>
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
							width="100%" height="150px"
							style="border: none; overflow: hidden" scrolling="no"
							frameborder="0" allowfullscreen="true"
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
									name="image" type="text" class="form-control" required>
							</div>
							<div class="form-group">
								<label><fmt:message key="body.addrestshop"></fmt:message></label>
								<input name="price" type="text" class="form-control" required>
							</div>
							<div class="form-group">
								<label><fmt:message key="body.emailshop"></fmt:message></label>
								<input name="sellprice" type="text" class="form-control"
									required>
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