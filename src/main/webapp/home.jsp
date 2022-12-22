<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page errorPage="errorhome.jsp"%>
<%@ page session="true"%>
<fmt:setLocale value="${sessionScope.lang}" />
<fmt:setBundle basename="i18n.messages" />
<!DOCTYPE html>
<html lang="vi_VN">
<head>

<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title><fmt:message key="menu.title.home"></fmt:message></title>
<link rel="shortcut icon" type="image/png" href="./img/logo.jpg" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>


<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

<link rel="stylesheet" href="./css/bsgrid.min.css" />
<link rel="stylesheet" href="./css/style.min.css" />

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css" />

</head>

<style>
.countries {
	border: none;
	outline: none;
	padding: 3px;
	border: 1px solid #ccc;
}

.countries>option {
	border: none;
	outline: none;
	padding: 3px;
	border: 1px solid #ccc;
}

.btn {
	line-height: 50px;
	position: absolute;
	right: 25px;
	border: none;
	outline: none;
	background: unset;
}
</style>

<body>

	<!-- header -->
	<!-- -->
	<div class="header">

		<div class="navbar">
			<div class="navbar__left">
				<a href="home" class="navbar__logo"> <img
					src="./img/logo.jpg" alt="">
				</a>
				<!-- hiển thị thông tin đăng nhập lưu ở secssion -->
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
			<!-- Tìm kiếm theo từ khóa -->
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


					<!-- Đa ngôn ngữ -->
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
				<!-- Seecsion người dùng -->
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

	<div class="post-slider">
		<i class="fa fa-chevron-left prev" aria-hidden="true"></i> <i
			class="fa fa-chevron-right next" aria-hidden="true"></i>

		<div class="post-wrapper">
			<div class="post">
				<img src="./img/BG-1.jpg" alt="">
			</div>
			<div class="post">
				<img src="./img/BG-2.jpg" alt="">
			</div>
			<div class="post">
				<img src="./img/BG-3.jpg" alt="">
			</div>
		</div>

	</div>

	<div class="row" style="width: 70% !important; margin: 20px auto;">
		<div class="col-lg-2 col-md-4">
			<h4 style="font-size: 18px;">
				<fmt:message key="body.suggestions"></fmt:message>
			</h4>
			<hr>

			<style>
.body__mainTitle>h3 {
	font-size: 17px;
}

.body__mainTitle>h4 {
	font-size: 15px;
}
</style>

			<div class="body__mainTitle">
				<h3>
					<div class="maincolor">
						<fmt:message key="body.filter"></fmt:message>
					</div>
				</h3>
				<!-- Hiển thị ra tất cả danh mục -->
				<c:forEach items="${listCategory}" var="lscategory">
					<h4>
						<li class="list-group-item text-while ${cate == lscategory.cid ? "active" : "" }" ><a
							href="category?fromid=${lscategory.cid}" class="text-secondary">${lscategory.cname}</a>
						</li>
					</h4>
				</c:forEach>
			</div>


		</div>

		<div class="col-lg-10 col-md-8">
			<!-- product -->
			<!-- Sản phẩm nổi bật -->
			<div class="body" style="width: unset !important;">

				<div class="body__mainTitle"
					style="margin-bottom: unset !important;">
					<h2>
						<fmt:message key="body.itemnew"></fmt:message>
					</h2>
				</div>
				<div class="post-slider2">
					<i class="fa fa-chevron-left prev2" aria-hidden="true"></i> <i
						class="fa fa-chevron-right next2" aria-hidden="true"></i>
					<!-- Hiển thị ra sản phẩm sắp xếp từ dưới lên -->
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
													<span class="Price"> <bdi>
														${lsproductdesc.price} <span class="currencySymbol"><fmt:message
																key="money"></fmt:message></span> </bdi>
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
				</div>
			</div>
		</div>
		<!-- Hiển thị tất cả sản phẩm -->
		<div class="body" style="width: unset !important;">
			<div class="body__mainTitle"
				style="display: flex; justify-content: space-between;">
				<h2>
					<fmt:message key="body.allitem"></fmt:message>
				</h2>
			</div>

			<div>
				<div class="row">
					<div class="col-12">
						<div class="row">
							<!-- listProduct = danh sách sản phẩm -->
							<c:forEach items="${listProduct}" var="lsproduct">
								<div class="col-lg-3 col-md-4 col-6 mb-3">
									<a href="detailServlet?fromitem=${lsproduct.id}"
										class="aProduct">
										<div class="product">
											<div class="product__img">
												<img src="${lsproduct.image}" alt="">
											</div>
											<div class="product__sale">
												<h4>
													<fmt:message key="body.hot"></fmt:message>
												</h4>
											</div>
											<div class="product__content">
												<div class="product__title">${lsproduct.name}</div>

												<div class="product__pride-oldPride">
													<span class="Price"> <bdi>${lsproduct.price} <span
															class="currencySymbol"><fmt:message key="money"></fmt:message></span>
														</bdi>
													</span>
												</div>

											</div>
										</div>

										<div>
											<div class="product__pride-newPride">
												<span class="Price"> <bdi>
													${lsproduct.sellprice}<span class="currencySymbol"><fmt:message
															key="money"></fmt:message></span>
													<td><form action="cart" method="post">
															<input type="hidden" name="productCode"
																value="<c:out value='${lsproduct.id}'/>"> <input
																type="submit" value="Add To Cart">
														</form></td>
													</bdi>
												</span>
											</div>
										</div>
									</a>
								</div>

							</c:forEach>
						</div>
						<!-- Phân trang -->
						<div class="d-flex justify-content-center mt-3">
							<div class="MenuTrang">
								<c:forEach begin="1" end="${endCount}" var="countnum">
									<ul class="pagination">
										<li class="${pageid == countnum?"active" : "" }" ><a
											href="home?page=${countnum}">${countnum}</a></li>
									</ul>
								</c:forEach>
							</div>
						</div>
					</div>
				</div>
			</div>
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
			slidesToShow : 4,
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
