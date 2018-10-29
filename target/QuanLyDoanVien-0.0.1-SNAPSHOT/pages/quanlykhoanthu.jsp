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
		<h1>QUẢN LÝ TÀI CHÍNH</h1>
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i> Trang chủ</a></li>
			<li><a href="#"> Quản trị tài chính</a></li>
			<li class="active">Quản lý khoản thu</li>
		</ol>
	</section>
	<!-- Main content -->
	<section class="content">

		<!-- Default box -->
		<div class="box">
			<div class="box-header with-border"></div>
			<div class="box-body">
				<a style="margin-bottom: 10px;" id='themPhieuThu' class='btn btn-primary btn-add-spent'
					data-toggle="modal" href='' title='Thêm mới'><i
					class="fa fa-plus" aria-hidden="true"></i> TẠO PHIẾU THU</a>
				<table
					class="table table-striped table-responsive table-hover table-bordered"
					id='tableSpent'>
					<thead>
						<tr>
							<th class="text-center">ID</th>
							<th class="text-center">Mã phiếu thu</th>
							<th class="text-center">Nội dung thu</th>
							<th class="text-center">Số tiền</th>
							<th class="text-center">Ngày thu</th>
							<th class="text-center">Người thu</th>
							<th class="text-center">Hành động</th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
				<div class="modal fade" id="edit-spent">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
								<h4 class="modal-title">Chỉnh sửa phiếu thu</h4>
							</div>
							<div class="modal-body">
								<form name="frm-edit-spent" id="frm-edit-spent" action=""
									method="post" accept-charset="utf-8"
									enctype="multipart/form-data">
									Mã phiếu thu <span style='color: red;'>*</span><input
										type="text" name="code" id="code" class="form-control"
										value='' required="required" readonly="readonly"
										placeholder="Mã phiếu thu" title="" /> <p></p> Nội dung thu <span
										style='color: red;'>*</span><input type="text" name="content"
										id="content" class="form-control" value=''
										placeholder="Nội dung thu" title="" /> <p></p> Số tiền <span
										style='color: red;'>*</span><input type="text" name="money"
										id="money" class="form-control" value=""
										placeholder="Số tiền" title="" /> <input type="hidden"
										name="idInputMoney" id="idInputMoney" class="form-control" value=""
										title="" /> <input type="hidden" name="action" id="action"
										class="form-control" value="edit" title="" /> <p></p>Người thu <span
										style='color: red;'>*</span><input type="text" name="receiver"
										id="receiver" class="form-control" value=''
										 placeholder="Người thu" title="" /> <p></p>
									<p>
										Ngày thu <span class='format-star'> *</span>
									</p>
									<div class="input-group" id="edit-ngaythu">
										<input id="date" name="date"
											type='text' class="form-control" placeholder="Ngày thu">
										<span class="input-group-addon" id="span-date-1"> <span
											class="glyphicon glyphicon-calendar"></span>
										</span>
									</div>
									<div class="modal-footer">
										<button type="submit" name='update' class="btn btn-primary">Cập
											nhật</button>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
				<div class="modal fade" id="createModalSpent">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
								<h4 class="modal-title">Thêm mới phiếu thu</h4>
							</div>
							<div class="modal-body">
							<form name="frm-add-spent" id="frm-add-spent" action=""
									method="post" accept-charset="utf-8"
									enctype="multipart/form-data">
										Nội dung thu <span
										style='color: red;'>*</span><input type="text" name="content"
										id="content" class="form-control" value=''
										placeholder="Nội dung thu" title="" /> <p></p> Số tiền <span
										style='color: red;'>*</span><input type="text" name="money"
										id="money" class="form-control" value=""
										placeholder="Số tiền" title="" /><input type="hidden" name="action" id="action"
										class="form-control" value="add" title="" /> <p></p>Người thu <span
										style='color: red;'>*</span><input type="text" name="receiver"
										id="receiver" class="form-control" value=''
										 placeholder="Người thu" title="" /> <p></p>
									<p>
										Ngày thu <span class='format-star'> *</span>
									</p>
									<div class="input-group" id="ngaythu">
										<input id="date" name="date"
											type='text' class="form-control" placeholder="Ngày thu">
										<span class="input-group-addon" id="span-date-1"> <span
											class="glyphicon glyphicon-calendar"></span>
										</span>
									</div>
									<div class="modal-footer">
										<button type="submit" name='create' class="btn btn-primary"> Tạo phiếu thu</button>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>

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
	$(function() {
		$('#ngaythu').datetimepicker({
			format : 'YYYY-MM-DD'
		});
		
		$('#edit-ngaythu').datetimepicker({
			format : 'YYYY-MM-DD'
		});
		var contextPath = "${pageContext.request.contextPath}";
		var table = $('#tableSpent')
				.DataTable(
						{
							"ajax" : contextPath + "/listspent",
							"columnDefs" : [ {
								"className" : "text-center",
								"targets" : [ 5 ]
							}, {
								"className" : "text-center",
								"targets" : [ 4 ]
							} 
							,{	
								"className" : "text-right",
								"targets" : [ 3 ]
							} ,{
								"className" : "text-center",
								"targets" : [ 0 ]
							} ,{
								"className" : "text-center",
								"targets" : [ 1 ]
							} ,{
								"className" : "text-center",
								"targets" : [ 6 ]
							} 
							
							],
							"columns" : [
									{
										"data" : "id"
									},
									{
										"data" : "code"
									},
									{
										"data" : "content"
									},
									{
										"data" : "money",
										"render": $.fn.dataTable.render.number( ',', '.', 0 )
										
									},
									{
										"data" : "date"
									},
									{
										"data" : "receiver"
									},
									{
										"data" : "action",
										render : function(data, type, row) {
											return '<a class="btn btn-circle btn-xs btn-outline blue"  href="vaitro/quyenhan?roleid='
													+ row.id
													+ '" title="Quyền hạn"><i class="fa fa-eye" aria-hidden="true"></i> Chi tiết</a> <a class="btn btn-circle btn-xs btn-outline purple btn-edit" href="javascript:;" id="'+row.id+'"  title="Sửa"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> Sửa</a> <a id="'+row.id+'" class="btn btn-circle btn-xs btn-outline red btn-delete" href="javascript:;" title="Xóa" ><i id="deleteUnit" class="fa fa-trash-o" aria-hidden="true"></i> Xóa</a>';
										}
									} ]
						});

		//delete role
		$('#tableSpent').on('click', '.btn-delete', function() {
			var contextPath = "${pageContext.request.contextPath}";
			var id = $(this).attr('id');
			var path = contextPath + "/quanlytaichinh/khoanthu";
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
								table.ajax.reload();
							}
						},
						error : function(xhr, ajaxOptions, thrownError) {
							toastr.error(thrownError);
						}
					});
				}
			});
		});
		//edit Spent
		$('#tableSpent').on('click', '.btn-edit', function() {
			$('#edit-spent').modal('show');
			var id = $(this).attr('id');
			$('#frm-edit-spent').validate({ 
		          errorElement: "span",
		          rules: {
		            content : {
		              required : true,
		              
		            },
		            money : {
		              required :true,
		              digits: true
		            },
		            receiver:{
		            	required :true
		            },
		            date:{
		            	required :true
		            },
		            
		          },
		          messages: {
		        	  content : {
		              required : "Vui lòng nhập nội dung khoản thu.",
		            },
		            money : {
		              required :"Vui lòng nhập khoản tiền thu.",
		              digits:"Số tiền thu phải là số."
		            },
		            receiver:{
		            	required :"Vui lòng nhập họ tên người thu"
		            },
		            date : {
			              required :"Vui lòng chọn ngày thu",
			            }
		          }
			}); 

			$.ajax({
				type : "POST",
				url : contextPath + "/listspent",
				data : {
					action : 'edit',
					id : id
				},
				success : function(res) {
					$("#idInputMoney").val(res.data[0].id);
					$("#code").val(res.data[0].code);
					$('#content').val(res.data[0].content);
					$('#content').focus();
					$('#money').val(res.data[0].money);
					$('#date').val(res.data[0].date);
					$('#receiver').val(res.data[0].receiver);
				},
				error : function(xhr, ajaxOptions, thrownError) {
					toastr.error(thrownError);
				}
			});

			$('#frm-edit-spent').on('submit', function(e) {
				e.preventDefault();
				var form = $('#frm-edit-spent');
				var formData = form.serialize();

				if(! form.valid()) return false;
				$.ajax({
					type : 'POST',
					url : contextPath + "/quanlytaichinh/khoanthu",
					data : formData,
					success : function(data) {
						if (!data.error) {
							toastr.success("Cập nhật phiếu thu thành công ");
							$('#edit-spent').modal('hide');
							table.ajax.reload();

						} else {
							if (!IsNull(data.message.name)) {
								toastr.error(data.message.name[0]);
							}
							if (!IsNull(data.message.display_name)) {
								toastr.error(data.message.display_name[0]);
							}

						}

					},
					error : function(xhr, ajaxOptions, thrownError) {

						toastr.error(thrownError);
					}
				});

			});
		});
		//addSpent
		$(document).on('click', '.btn-add-spent', function() {
			$('#createModalSpent').modal('show');
			$('#content').val('');
			$('#date').val('');
			$('#receiver').val('');
			$('#money').val('');

			 	$('#frm-add-spent').validate({ 
			          errorElement: "span",
			          rules: {
			            content : {
			              required : true,
			              
			            },
			            money : {
			              required :true,
			              digits: true
			            },
			            receiver:{
			            	required :true
			            },
			            date:{
			            	required :true
			            },
			            
			          },
			          messages: {
			        	  content : {
			              required : "Vui lòng nhập nội dung khoản thu.",
			            },
			            money : {
			              required :"Vui lòng nhập khoản tiền thu.",
			              digits:"Số tiền thu phải là số."
			            },
			            receiver:{
			            	required :"Vui lòng nhập họ tên người thu"
			            },
			            date : {
				              required :"Vui lòng chọn ngày thu",
				            }
			          }
				}); 

			$('#frm-add-spent').on('submit', function(e) {
				e.preventDefault();
				var form = $('#frm-add-spent');
				var formData = form.serialize();

				if(! form.valid()) return false;

				$.ajax({
					type : 'POST',
					url : contextPath + "/quanlytaichinh/khoanthu",
					data : formData,
					success : function(data) {

						if (!data.error) {
							toastr["success"]("Tạo phiếu thu thành công !");
							$('#createModalSpent').modal('hide');
							table.ajax.reload();

						} else {

							if (!IsNull(data.message.name)) {
								toastr.error(data.message.name[0]);
							}
							if (!IsNull(data.message.display_name)) {
								toastr.error(data.message.display_name[0]);
							}

						}

					},
					error : function(xhr, ajaxOptions, thrownError) {

						toastr.error(thrownError);
					}
				});

			});

		});
	});
</script>