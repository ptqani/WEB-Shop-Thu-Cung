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
<meta name="viewport" content="width=device-width, initial-scale=1">
<title><fmt:message key="menu.admin"></fmt:message></title>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

<!-- Theme style -->
<link rel="stylesheet" href="admin/css/adminlte.min.css">
<!-- Google Font: Source Sans Pro -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" />
<!-- Ionicons -->
<link rel="stylesheet"
	href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">

</head>
<body class="hold-transition sidebar-mini layout-fixed">
	<div class="wrapper">

		<!-- Navbar -->
		<nav
			class="main-header navbar navbar-expand navbar-white navbar-light">
			<!-- Left navbar links -->
			<ul class="navbar-nav">
				<li class="nav-item d-none d-sm-inline-block"><a href="manage"
					class="nav-link"><fmt:message key="menu.homepage"></fmt:message></a></li>
			</ul>
		</nav>
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<div class="content-header">
				<div class="container-fluid">
					<div class="row mb-2">
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-left">
								<li class="breadcrumb-item active"><fmt:message
										key="menu.admin.title"></fmt:message></li>
							</ol>
						</div>
						<!-- /.col -->
					</div>
					<!-- /.row -->
				</div>
				<!-- /.container-fluid -->
			</div>
			<!-- /.content-header -->

			<!-- Main content -->
			<section class="content">
				<div class="col-lg-12 padding-8">
					<div class="list">

						<div class="d-flex align-items-center justify-content-between">
							<div>
								<div class="menu_option-head">
									<fmt:message key="body.listpro"></fmt:message>
								</div>
								<div class="add-product">
									<a href="#addEmployeeModal" class="btn btn-success"
										data-toggle="modal"><i class="material-icons"></i> <span><fmt:message
												key="body.addpro"></fmt:message></span></a>
								</div>
							</div>

							<form action="/Admin/QLSanPham" method="get">
								<b class="pr-2"><fmt:message key="menu.search"></fmt:message></b>
								<div class="d-flex align-items-center">
									<input id="search" name="search" required="" type="text"
										class="form-control mr-1"> <input type="submit"
										value="Search" class="btn btn-danger">

								</div>
							</form>
						</div>


						<div class="body fix-width scroll-inner">
							<table class="table table-striped">
								<thead>
									<tr>
										<th><fmt:message key="body.idpro"></fmt:message></th>
										<th><fmt:message key="body.namepro"></fmt:message></th>
										<th><fmt:message key="body.imgpro"></fmt:message></th>
										<th><fmt:message key="body.sellpro"></fmt:message></th>
										<th><fmt:message key="body.sellpripro"></fmt:message></th>
										<th><fmt:message key="body.optoinpro"></fmt:message></th>
									</tr>
								</thead>

								<tbody>

									<c:forEach items="${listProduct}" var="lsproduct">
										<tr>
											<td>${lsproduct.id}</td>
											<td>${lsproduct.name}</td>
											<td><img src=" ${lsproduct.image}" height="70px">
											<td>${lsproduct.price}</td>

											<td>${lsproduct.sellprice}</td>
											<td><a href="detailServlet?fromitem=${lsproduct.id}"
												class="text-primary f2" target="_blank"
												rel="noopener noreferrer"><img alt=""
													src="./img/eye-solid.svg"
													style="width: 20px; height: 20px;"></a> <a
												href="editProduct?editpro=${lsproduct.id}"
												class="text-primary f2" target="_blank"
												rel="noopener noreferrer"><img alt=""
													src="./img/pen-to-square-solid.svg"
													style="width: 20px; height: 20px;"></a> <a
												href="DeleteProductServlet?fromitem=${lsproduct.id}"
												class="text-primary f2"><img alt=""
													src="./img/trash-solid.svg"
													style="width: 20px; height: 20px; color: red;"></a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>

					</div>

					<div class="d-flex justify-content-center">
						<div class="MenuTrang">
							<div class="pagination-container">
								<ul class="pagination">
									<li class="active"><a>1</a></li>
									<li><a href="/Admin/QLSanPham?page=2">2</a></li>
									<li><a href="/Admin/QLSanPham?page=3">3</a></li>
									<li><a href="/Admin/QLSanPham?page=4">4</a></li>
									<li><a href="/Admin/QLSanPham?page=5">5</a></li>
								</ul>
							</div>
						</div>
					</div>

				</div>
			</section>

			<!-- /.content -->
		</div>
		<aside class="control-sidebar control-sidebar-dark">
			<!-- Control sidebar content goes here -->
		</aside>
		<!-- /.control-sidebar -->
	</div>
	<!-- ./wrapper -->

	<!-- jQuery -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<!-- jQuery UI 1.11.4 -->
	<script src="https://code.jquery.com/ui/1.13.1/jquery-ui.min.js"></script>
	<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->

	<!-- Summernote -->
	<script src="admin/summernote/summernote-bs4.min.js"></script>

	<!-- AdminLTE App -->
	<script src="admin/js/adminlte.min.js"></script>
	<!-- AdminLTE for demo purposes -->
	<script src="admin/js/demo.js"></script>
	<div id="addEmployeeModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form action="addproduct" method="post">
					<div class="modal-header">
						<h4 class="modal-title">
							<fmt:message key="body.addpro"></fmt:message>
						</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label><fmt:message key="body.namepro"></fmt:message></label> <input
								name="name" type="text" class="form-control" required>
						</div>
						<div class="form-group">
							<label><fmt:message key="body.imgpro"></fmt:message></label> <input
								name="image" type="text" class="form-control" required>
						</div>
						<div class="form-group">
							<label><fmt:message key="body.sellpro"></fmt:message></label> <input
								name="price" type="number" class="form-control" required>
						</div>
						<div class="form-group">
							<label><fmt:message key="body.sellpripro"></fmt:message></label>
							<input name="percent" type="number" value="0"
								class="form-control">
						</div>
						<div class="form-group">
							<label></label> <input name="sellprice" type="hidden" value="0"
								class="form-control">
						</div>
						<div class="form-group">
							<label><fmt:message key="body.titlepro"></fmt:message></label>
							<textarea name="title" class="form-control" required></textarea>
						</div>
						<div class="form-group">
							<label><fmt:message key="body.descriptionpro"></fmt:message></label>
							<textarea name="description" class="form-control" required></textarea>
						</div>
						<div class="form-group">
							<label><fmt:message key="body.cate"></fmt:message></label> <select
								name="category" class="form-select"
								aria-label="Default select example">
								<c:forEach items="${listCategory}" var="lscategory">
									<option value="${lscategory.cid}">${lscategory.cname}</option>
								</c:forEach>
							</select>
						</div>

					</div>
					<div class="modal-footer">
						<input type="button" class="btn btn-default" data-dismiss="modal"
							value="Cancel"> <input type="submit"
							class="btn btn-success"
							value="<fmt:message key="body.addp"></fmt:message>">
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
