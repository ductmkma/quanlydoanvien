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
			<li class="active">Vai trò</li>
		</ol>
	</section>
	<!-- Main content -->
	<section class="content">

		<!-- Default box -->
		<div class="box">
			<div id='test'></div>
			<div class="box-header with-border"></div>
			<div class="box-body">
				<table
					class="table table-striped table-responsive table-hover table-bordered"
					id='tablePermissionRole'>
					<thead>
						<tr>
							<th class="text-center">Id</th>
							<th class="text-center">Tên hiển thị</th>
							<th class="text-center">Quyền hạn</th>
							<th class="text-center">Mô tả</th>
							<th class="text-center">Ngày tạo</th>
							<th class="text-center">Hành động</th>
						</tr>
					</thead>
					<tbody>
					<c:set var="roleid" value="${param.roleid}" />
						<c:forEach items="${listPermission}" var="permission">
							<tr>
								<c:set value="fa-circle-o" var="check"></c:set>
								<c:set value="" var="checkval"></c:set>
								<td><c:out value="${permission.id}"></c:out></td>
								<td><c:out value="${permission.display_name}"></c:out></td>
								<td><c:out value="${permission.name}"></c:out></td>
								<td><c:out value="${permission.description}"></c:out></td>
								<td><c:out value="${permission.created_at}"></c:out></td>
								<td class="text-center"><input type="hidden" id="checked-${permission.id}" value="<c:forEach items="${listPerRole}" var="perRole"><c:if test="${perRole.permission_id==permission.id&&perRole.status==1&&roleid==perRole.role_id}"><c:set value="1" var="checkval"></c:set></c:if></c:forEach><c:out value="${checkval}"></c:out>"><i id="action-${permission.id}" class="fa <c:forEach items="${listPerRole}" var="perRole"><c:if test="${perRole.permission_id==permission.id&&perRole.status==1&&roleid==perRole.role_id}"><c:set value="fa-check-circle" var="check"></c:set></c:if></c:forEach><c:out value="${check}"></c:out>" title="Thêm" onclick="addPermission(<%=request.getParameter("roleid") %>,${permission.id})" aria-hidden="true" style="cursor: pointer; color: #3598dc;font-size: 20px;"></i></td>
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
 <script type="text/javascript">

$(document).ready(function(){
	$("#tablePermissionRole").DataTable();
});
function addPermission(role_id, permission_id) {
    var checked = $('#checked-' + permission_id).val();
    $.ajax({
          type: "POST",
          url: "http://localhost:8080/QuanLyDoan/vaitro/quyenhan",
          data: {
            role_id: role_id,
            permission_id: permission_id,
            checked: checked,
          },
          success: function(res)
          {
            if (res == 'deleted') {
              $('#action-' + permission_id).removeClass('fa-check-circle').addClass('fa-circle-o');
              $('#checked-' + permission_id).val(0);
              toastr.success('Xóa thành công');
            } 

            if (res == 'added') {
              $('#action-' + permission_id).removeClass('fa-circle-o').addClass('fa-check-circle');
              $('#checked-' + permission_id).val(1);
              toastr.success('Thêm thành công');
            }
            

          },
          error: function (xhr, ajaxOptions, thrownError) {


            toastr.error(thrownError);
          }
    });
}


</script> -->