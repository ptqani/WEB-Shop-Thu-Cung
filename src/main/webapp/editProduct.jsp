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
<meta name="viewport" content="width=device-width, initial-scale=1">
<title><fmt:message key="menu.admin.edit"></fmt:message></title>

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

		<!-- Preloader -->
		<!-- <div class="preloader flex-column justify-content-center align-items-center">
    <img class="animation__shake" src="dist/img/logo.jpg" alt="logo" height="60" width="60">
  </div> -->

		<!-- Navbar -->
		<nav
			class="main-header navbar navbar-expand navbar-white navbar-light">
			<!-- Left navbar links -->
			<ul class="navbar-nav">
				<li class="nav-item d-none d-sm-inline-block"><a href="manage"
					class="nav-link"><fmt:message key="menu.homepage"></fmt:message></a>
				</li>
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
										key="menu.admin.titleedit"></fmt:message></li>
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
			<!-- /.content -->
		</div>
		<!-- /.navbar -->
		<div class="modal-dialog">
			<div class="modal-content">
				<form action="editsave" method="post">
					<div class="modal-header">
						<h4 class="modal-title">
							<fmt:message key="menu.admin.editpro"></fmt:message>
						</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label><fmt:message key="body.idpro"></fmt:message></label> <input
								name="id" type="text" value="${productDetail.id}" readonly
								class="form-control" required>
						</div>
						<div class="form-group">
							<label><fmt:message key="body.namepro"></fmt:message></label> <input
								name="name" type="text" value="${productDetail.name}"
								class="form-control" required>
						</div>
						<div class="form-group">
							<label><fmt:message key="body.imgpro"></fmt:message></label> <input
								name="image" type="text" value="${productDetail.image}"
								class="form-control" required>
						</div>
						<div class="form-group">
							<label><fmt:message key="body.sellpro"></fmt:message></label> <input
								name="price" type="text" value="${productDetail.price}"
								class="form-control" required>
						</div>
						<div class="form-group">
							<label><fmt:message key="body.sellpriproprice"></fmt:message></label>
							<input name="sellprice" type="text"
								value="${productDetail.sellprice}" class="form-control" required>
						</div>
						<div class="form-group">
							<label><fmt:message key="body.titlepro"></fmt:message></label>
							<textarea name="title" class="form-control" required>${productDetail.title}</textarea>
						</div>
						<div class="form-group">
							<label><fmt:message key="body.descriptionpro"></fmt:message></label>
							<textarea name="description" class="form-control" required>${productDetail.description}</textarea>
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
						<a href="manage" class="btn btn-default" data-dismiss="modal"><fmt:message
								key="body.canel"></fmt:message></a> <input type="submit"
							class="btn btn-success"
							value="<fmt:message key="menu.admin.editpro"></fmt:message>">
					</div>
				</form>
			</div>
		</div>

		<aside class="control-sidebar control-sidebar-dark">
			<!-- Control sidebar content goes here -->
		</aside>
		<!-- /.control-sidebar -->
	</div>

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




</body>
</html>
