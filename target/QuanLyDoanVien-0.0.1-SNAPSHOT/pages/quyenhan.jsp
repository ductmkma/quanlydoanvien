<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@include file="header.jsp"%>
<!-- Left side column. contains the logo and sidebar -->
<%@include file="sidebar.jsp"%>
<!-- =============================================== -->

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>QUYỀN HẠN</h1>
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i> Trang chủ</a></li>
			<li><a href="#"> Quản trị hệ thống</a></li>
			<li class="active">Quyền hạn</li>
		</ol>
	</section>
	<!-- Main content -->
	<section class="content">

		<!-- Default box -->
		<div class="box">
			<div id='test'></div>
			<div class="box-header with-border">
				<h3> Danh sách chi tiết quyền hạn</h3>
			</div>
			<div class="box-body">
				<table
					class="table table-striped table-responsive table-hover table-bordered"
					id='tablePermission'>
					<thead>
						<tr>
							<th class="text-center">Id</th>
							<th class="text-center">Tên hiển thị</th>
							<th class="text-center">Quyền hạn</th>
							<th class="text-center">Mô tả</th>
							<th class="text-center">Ngày tạo</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listPermission}" var="permission">
							<tr>
								<td class="text-center"><c:out value="${permission.id}"></c:out></td>
								<td><c:out value="${permission.display_name}"></c:out></td>
								<td><c:out value="${permission.name}"></c:out></td>
								<td><c:out value="${permission.description}"></c:out></td>
								<td class="text-center"><c:out value="${permission.created_at}"></c:out></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<!-- /.box-body -->
		</div>
		<!-- /.box -->

	</section>
	<!-- /.content -->
</div>
<!-- /.content-wrapper -->

<%@include file="footer.jsp"%>