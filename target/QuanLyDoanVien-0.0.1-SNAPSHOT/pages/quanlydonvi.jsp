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
		<h1>Quản lý đơn vị</h1>
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i> Trang chủ</a></li>
			<li><a href="#"> Danh mục quản lý</a></li>
			<li class="active">Quản lý đơn vị</li>
		</ol>
	</section>
	<!-- Main content -->
	<section class="content">

		<!-- Default box -->
		<div class="box">
			<div class="box-header with-border">
				<h3 class="box-title">Danh sách các đơn vị trực thuộc</h3>
			</div>
			<div class="box-body">
				<c:forEach items="${sessionScope.listPerRoleUni}" var="per">
					<c:if test="${per.permission_id ==2}">
						<a id='themDonVi' class='btn btn-primary' data-toggle="modal"
							href='#modal-add' title='Thêm mới'><i class="fa fa-plus"
							aria-hidden="true"></i> THÊM MỚI</a>
						<div class="fileUpload btn btn-warning">
						<form  action="<%=request.getContextPath() %>/readfileexcel" method="post" id="formImport" enctype="multipart/form-data">
					<span><i class="fa fa-upload" aria-hidden="true"></i> Import
						file Excel</span> <input id="fileImport" name="fileImport" accept="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" type="file" class="upload" />
				</form>
				</div>
					</c:if>
				</c:forEach>

				

				</script>
				<table class="table table-striped table-responsive table-hover"
					id='tableDonVi'>
					<thead>
						<tr>
							<th>Mã đơn vị</th>
							<th>Tên đơn vị</th>
							<th>Địa chỉ</th>
							<th>Email</th>
							<th>Số điện thoại</th>
							<th id="actionNotFilter">Hành động</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listUnitsExceptDeleted}" var='units'>
							<tr>
								<td><c:out value="${units.id}"></c:out></td>
								<td><c:out value="${units.name}"></c:out></td>
								<td><c:out value="${units.address}"></c:out></td>
								<td><c:out value="${units.email}"></c:out></td>
								<td><c:out value="${units.phone}"></c:out></td>
								<td id='action'>
									<a class="btn btn-circle btn-xs btn-outline purple"
									data-toggle="modal" href="#id${units.id}" title='Sửa'><i
										class="fa fa-pencil-square-o" aria-hidden="true"></i> Sửa</a> <a
									id="${units.id}"
									class="btn btn-circle btn-xs btn-outline red btn-delete"
									href="javascript:;" title='Xóa'><i id="deleteUnit"
										class="fa fa-trash-o" aria-hidden="true"></i> Xóa</a></td>
							</tr>
							<!-- Form edit -->
							<div class="modal fade"
								id="id<c:out value="${units.id}"></c:out>">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal"
												aria-hidden="true">&times;</button>
											<h4 class="modal-title">Chỉnh sửa đơn vị</h4>
										</div>
										<div class="modal-body">
											<form
												action="<%=request.getContextPath()%>/quanlydonvi?action=edit"
												method="post" accept-charset="utf-8"
												enctype="multipart/form-data">
												<input
													type="hidden" name="code" id="code" class="form-control"
													value='<c:out value="${units.id}"></c:out>'
													readonly="readonly" required="required"
													placeholder="Mã đơn vị" title="" /> <input type="hidden"
													readonly="readonly" name="parent-id" id="parent-id"
													class="form-control"
													value="<c:out value="${units.parentId}"></c:out>"
													required="required" placeholder="Mã trực thuộc" title="" />

												Loại đơn vị <span style='color: red;'>*</span> <select
													required="required" name='typeUnit' class="form-control">
													<c:if test="${units.typeUnit==1}">
														<option value="1">Trung ương Đoàn</option>
														<option value="2" disabled="disabled">Tỉnh đoàn hoặc tương đương</option>
														<option value="3" disabled="disabled">Huyện đoàn hoặc tương đương</option>
														<option value="4" disabled="disabled">Đoàn cơ sở hoặc tương đương</option>
														<option value="5" disabled="disabled">Chi đoàn cơ sở</option>
													</c:if>
													<c:if test="${units.typeUnit==2}">
														<option value="2">Tỉnh đoàn hoặc tương đương</option>
														<option value="1" disabled="disabled">Trung ương Đoàn</option>
														<option value="3" disabled="disabled">Huyện đoàn hoặc tương đương</option>
														<option value="4" disabled="disabled">Đoàn cơ sở hoặc tương đương</option>
														<option value="5" disabled="disabled">Chi đoàn cơ sở</option>
													</c:if>
													<c:if test="${units.typeUnit==3}">
														<option value="3">Huyện đoàn hoặc tương đương</option>
														<option value="2" disabled="disabled">Tỉnh đoàn hoặc tương đương</option>
														<option value="1" disabled="disabled">Trung ương Đoàn</option>
														<option value="4" disabled="disabled">Đoàn cơ sở hoặc tương đương</option>
														<option value="5" disabled="disabled">Chi đoàn cơ sở</option>
													</c:if>
													<c:if test="${units.typeUnit==4}">
														<option value="4">Đoàn cơ sở hoặc tương đương</option>
														<option value="2" disabled="disabled">Tỉnh đoàn hoặc tương đương</option>
														<option value="1" disabled="disabled">Trung ương Đoàn</option>
														<option value="3" disabled="disabled">Huyện đoàn hoặc tương đương</option>
														<option value="5" disabled="disabled">Chi đoàn cơ sở</option>
													</c:if>
													<c:if test="${units.typeUnit==5}">
														<option value="5">Chi đoàn cơ sở</option>
														<option value="2" disabled="disabled">Tỉnh đoàn hoặc tương đương</option>
														<option value="1" disabled="disabled">Trung ương Đoàn</option>
														<option value="3" disabled="disabled">Huyện đoàn hoặc tương đương</option>
														<option value="4" disabled="disabled">Đoàn cơ sở hoặc tương đương</option>
													</c:if>

												</select> Tên đơn vị <span style='color: red;'>*</span><input
													type="text" name="name" id="name" class="form-control"
													value="<c:out value="${units.name}"></c:out>"
													required="required" placeholder="Tên đơn vị" title="" />
												Địa chỉ <span style='color: red;'>*</span><input type="text"
													name="address" id="address" class="form-control"
													value="<c:out value="${units.address}"></c:out>"
													required="required" placeholder="Địa chỉ" title="" />
												Email <span style='color: red;'>*</span> <input type="email"
													name="email" id="email" class="form-control"
													value="<c:out value="${units.email}"></c:out>"
													required="required" placeholder="Email" title="" /> Phone
												<span style='color: red;'>*</span> <input type="number"
													name="phone" id="phone" class="form-control"
													value="<c:out value="${units.phone}"></c:out>"
													required="required" placeholder="Phone" title="" />
												<div class="modal-footer">
													<button type="submit" name='editUnit'
														class="btn btn-primary">Cập nhật</button>
												</div>
											</form>
										</div>
									</div>
								</div>
							</div>
							<!-- Hết form edit -->

						</c:forEach>

					</tbody>
				</table>
			</div>
			<!-- /.box-body -->
		</div>
		<!-- /.box -->

	</section>
	<!-- Form thêm mới -->
	<div class="modal fade" id="modal-add">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title">Thêm mới đơn vị</h4>
				</div>
				<div class="modal-body">
					<form
						action="<%=request.getContextPath()%>/quanlydonvi?action=insert"
						method="post" accept-charset="utf-8" enctype="multipart/form-data">
						<input type="hidden" name="code" id="code" class="form-control"
							value='${fn:length(listUnits)+1}' readonly="readonly"
							required="required" placeholder="Mã đơn vị" title="" /> <input type="hidden"
							name="parent-id" id="parent-id" class="form-control" value="${sessionScope.units_id}"
							required="required" placeholder="Mã trực thuộc" title="" />Tên đơn vị <span style='color: red;'>*</span><input type="text"
							name="name" id="name" class="form-control" value=""
							required="required" placeholder="Tên đơn vị" title="" /> Địa chỉ
						<span style='color: red;'>*</span><input type="text"
							name="address" id="address" class="form-control" value=""
							required="required" placeholder="Địa chỉ" title="" /> Email <span
							style='color: red;'>*</span> <input type="email" name="email"
							id="email" class="form-control" value="" required="required"
							placeholder="Email" title="" /> Phone <span style='color: red;'>*</span>
						<input type="number" name="phone" id="phone" class="form-control"
							value="" required="required" placeholder="Phone" title="" />
						Loại
						đơn vị <span style='color: red;'>*</span> <select required
							name='typeUnit' class="form-control">
							<option value="">Chọn loại đơn vị</option>
							<option value="1">Trung ương Đoàn</option>
							<option value="2">Tỉnh đoàn hoặc tương đương</option>
							<option value="3">Huyện đoàn hoặc tương đương</option>
							<option value="4">Đoàn cơ sở hoặc tương đương</option>
							<option value="5">Chi đoàn cơ sở</option>
						</select>
						<div class="modal-footer">
							<button type="submit" name='addUnit' class="btn btn-primary">Thêm
								mới</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- Hết form thêm mới -->

	<!-- /.content -->
</div>
<!-- /.content-wrapper -->

<%@include file="footer.jsp"%>
<script type="text/javascript">
	document.getElementById("fileImport").onchange = function() {
		swal({
			title : "Bạn có muốn import file Excel này ?",
			type : "warning",
			showCancelButton : true,
			confirmButtonColor : "#e84242",
			cancelButtonText : "Không",
			confirmButtonText : "Có",
		}, function(isConfirm) {
			if(isConfirm){
				document.getElementById("formImport").submit();
			}
			
		});
   		 
	};
	$(document).ready(function() {
		
		$('#tableDonVi').on('click', '.btn-delete', function() {
			var contextPath = "${pageContext.request.contextPath}";
			var id = $(this).attr('id');
			var path = contextPath + "/quanlydonvi";
			swal({
				title : "Bạn có chắc chắn muốn xóa?",
				type : "warning",
				showCancelButton : true,
				confirmButtonColor : "#e84242",
				cancelButtonText : "Không",
				confirmButtonText : "Có",
			}, function(isConfirm) {

				if (isConfirm) {

					$.ajax({
						type : "POST",
						url : path,
						data : {
							action : 'delete',
							id : id
						},
						dataType : 'json',
						success : function(res) {
							if (!res.error) {
								toastr.success('Xóa thành công!');
							}
						},
						error : function(xhr, ajaxOptions, thrownError) {
							toastr.error(thrownError);
						}
					});
				}
			});
		});
	});
</script>