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
	<c:set var="name" value="${param.username}"></c:set>
		<h1 style="text-transform: uppercase; font-weight: bold;color:#3c8dbc;"><i class="fa fa-user"></i> <c:out value="${name}"></c:out> : VAI TRÒ</h1>
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
					id='tableRoleUser'>
					<thead>
						<tr>
							<th class="text-center">Id</th>
							<th class="text-center">Vai trò</th>
							<th class="text-center">Mô tả</th>
							<th class="text-center">Quyền hạn</th>
							<th class="text-center">Hành động</th>
						</tr>
					</thead>
					<tbody>
					<c:set var="id" value="${param.id}" />
						<c:forEach items="${listPRGroupByRoleId}" var="roleUser">
							<tr>
								<c:set value="fa-circle-o" var="check"></c:set>
								<c:set value="" var="checkval"></c:set>
								<td><c:out value="${roleUser.role_id}"></c:out></td>
								<td><c:out value="${roleUser.role_display_name}"></c:out></td>
								<td><c:out value="${roleUser.role_description}"></c:out></td>
								<td><c:forEach items="${listRoleUser}" var="perrole">
									<c:if test="${perrole.role_id==roleUser.role_id }">
									<label class="btn blue btn-outline btn-circle btn-xs"><c:out value="${perrole.permission_name}"></c:out> </label>
									</c:if>
								</c:forEach>
								</td>
								<td class="text-center"><input type="hidden" id="checked-${roleUser.role_id}" value="<c:forEach items="${listRoleId}" var="per"><c:if test="${per.role_id==roleUser.role_id&&id==per.id}"><c:set value="1" var="checkval"></c:set></c:if></c:forEach><c:out value="${checkval}"></c:out>"><i id="action-${roleUser.role_id}" class="fa 
								<c:forEach items="${listRoleId}" var="perRole">
									 <c:if test="${perRole.role_id==roleUser.role_id&&id==perRole.id}">
										<c:set value="fa-check-circle" var="check"></c:set>
								   </c:if>
								 </c:forEach><c:out value="${check}"></c:out>" title="Thêm" onclick="addRoleId(${id},${roleUser.role_id})" aria-hidden="true" style="cursor: pointer; color: #3598dc;font-size: 20px;"></i></td>
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
	$("#tableRoleUser").DataTable();
});
function addRoleId(user_id, role_id) {
    var checked = $('#checked-' + role_id).val();
    $.ajax({
          type: "POST",
          url: "http://localhost:8080/QuanLyDoan/quanlytaikhoan/vaitro",
          data: {
            role_id: role_id,
            user_id: user_id,
            checked: checked,
          },
          success: function(res)
          {
            if (res == 'deleted') {
              $('#action-' + role_id).removeClass('fa-check-circle').addClass('fa-circle-o');
              $('#checked-' + role_id).val(0);
              toastr.success('Xóa thành công');
              
            } 

            if (res == 'added') {
              $('#action-' + role_id).removeClass('fa-circle-o').addClass('fa-check-circle');
              $('#checked-' + role_id).val(1);
              toastr.success('Thêm thành công');
            }
            

          },
          error: function (xhr, ajaxOptions, thrownError) {


            toastr.error(thrownError);
          }
    });
}


</script>