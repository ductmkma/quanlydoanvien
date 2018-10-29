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
			<li class="active">Quản lý khoản chi</li>
		</ol>
	</section>
	<!-- Main content -->
	<section class="content">

		<!-- Default box -->
		<div class="box">
			<div class="box-header with-border"></div>
			<div class="box-body">
				<a style="margin-bottom: 10px;" id='themPhieuchi' class='btn btn-primary btn-add-input-money'
					data-toggle="modal" href='' title='Thêm mới'><i
					class="fa fa-plus" aria-hidden="true"></i> TẠO PHIẾU CHI</a>
				<table
					class="table table-striped table-responsive table-hover table-bordered"
					id='tableInputMoney'>
					<thead>
						<tr>
							<th class="text-center">ID</th>
							<th class="text-center">Mã phiếu chi</th>
							<th class="text-center">Nội dung chi</th>
							<th class="text-center">Số tiền</th>
							<th class="text-center">Ngày chi</th>
							<th class="text-center">Người chi</th>
							<th class="text-center">Hành động</th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
				<div class="modal fade" id="edit-input-money">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
								<h4 class="modal-title">Chỉnh sửa phiếu chi</h4>
							</div>
							<div class="modal-body">
								<form name="frm-edit-input-money" id="frm-edit-input-money" action=""
									method="post" accept-charset="utf-8"
									enctype="multipart/form-data">
									Mã phiếu chi <span style='color: red;'>*</span><input
										type="text" name="code" id="code" class="form-control"
										value='' required="required" readonly="readonly"
										placeholder="Mã phiếu chi" title="" /> <p></p> Nội dung chi <span
										style='color: red;'>*</span><input type="text" name="content"
										id="content" class="form-control" value=''
										placeholder="Nội dung chi" title="" /> <p></p> Số tiền <span
										style='color: red;'>*</span><input type="text" name="money"
										id="money" class="form-control" value=""
										placeholder="Số tiền" title="" /> <input type="hidden"
										name="idIpMoney" id="idIpMoney" class="form-control" value=""
										title="" /> <input type="hidden" name="action" id="action"
										class="form-control" value="edit" title="" /> <p></p>Người chi <span
										style='color: red;'>*</span><input type="text" name="sender"
										id="sender" class="form-control" value=''
										 placeholder="Người chi" title="" /> <p></p>
									<p>
										Ngày chi <span class='format-star'> *</span>
									</p>
									<div class="input-group" id="edit-ngaychi">
										<input id="date" name="date"
											type='text' class="form-control" placeholder="Ngày chi">
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
				<div class="modal fade" id="createModalInputMoney">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
								<h4 class="modal-title">Thêm mới phiếu chi</h4>
							</div>
							<div class="modal-body">
							<form name="frm-add-input-money" id="frm-add-input-money" action=""
									method="post" accept-charset="utf-8"
									enctype="multipart/form-data">
										Nội dung chi <span
										style='color: red;'>*</span><input type="text" name="content"
										id="content" class="form-control" value=''
										placeholder="Nội dung chi" title="" /> <p></p> Số tiền <span
										style='color: red;'>*</span><input type="text" name="money"
										id="money" class="form-control" value=""
										placeholder="Số tiền" title="" /><input type="hidden" name="action" id="action"
										class="form-control" value="add" title="" /> <p></p>Người chi <span
										style='color: red;'>*</span><input type="text" name="sender"
										id="sender" class="form-control" value=''
										 placeholder="Người chi" title="" /> <p></p>
									<p>
										Ngày chi <span class='format-star'> *</span>
									</p>
									<div class="input-group" id="ngaychi">
										<input id="date" name="date"
											type='text' class="form-control" placeholder="Ngày chi">
										<span class="input-group-addon" id="span-date-1"> <span
											class="glyphicon glyphicon-calendar"></span>
										</span>
									</div>
									<div class="modal-footer">
										<button type="submit" name='create' class="btn btn-primary"> Tạo phiếu chi</button>
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
		$('#ngaychi').datetimepicker({
			format : 'YYYY-MM-DD'
		});
		
		$('#edit-ngaychi').datetimepicker({
			format : 'YYYY-MM-DD'
		});
		var contextPath = "${pageContext.request.contextPath}";
		var table = $('#tableInputMoney').DataTable(
						{
							"ajax" : contextPath + "/listinputmoney",
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
										"data" : "sender"
									},
									{
										"data" : "action",
										render : function(data, type, row) {
											return '<a class="btn btn-circle btn-xs btn-outline purple btn-edit" href="javascript:;" id="'+row.id+'"  title="Sửa"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> Sửa</a> <a id="'+row.id+'" class="btn btn-circle btn-xs btn-outline red btn-delete" href="javascript:;" title="Xóa" ><i id="deleteUnit" class="fa fa-trash-o" aria-hidden="true"></i> Xóa</a>';
										}
									} ]
						});

		//delete role
		$('#tableInputMoney').on('click', '.btn-delete', function() {
			var contextPath = "${pageContext.request.contextPath}";
			var id = $(this).attr('id');
			var path = contextPath + "/quanlytaichinh/khoanchi";
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
		$('#tableInputMoney').on('click', '.btn-edit', function() {
			$('#edit-input-money').modal('show');
			var id = $(this).attr('id');
			$('#frm-edit-input-money').validate({ 
		          errorElement: "span",
		          rules: {
		            content : {
		              required : true,
		              
		            },
		            money : {
		              required :true,
		              digits: true
		            },
		            sender:{
		            	required :true
		            },
		            date:{
		            	required :true
		            },
		            
		          },
		          messages: {
		        	  content : {
		              required : "Vui lòng nhập nội dung khoản chi.",
		            },
		            money : {
		              required :"Vui lòng nhập khoản tiền chi.",
		              digits:"Số tiền chi phải là số."
		            },
		            sender:{
		            	required :"Vui lòng nhập họ tên người chi"
		            },
		            date : {
			              required :"Vui lòng chọn ngày chi",
			            }
		          }
			}); 

			$.ajax({
				type : "POST",
				url : contextPath + "/listinputmoney",
				data : {
					action : 'edit',
					id : id
				},
				success : function(res) {
					$("#idIpMoney").val(res.data[0].id);
					$("#code").val(res.data[0].code);
					$('#content').val(res.data[0].content);
					$('#content').focus();
					$('#money').val(res.data[0].money);
					$('#date').val(res.data[0].date);
					$('#sender').val(res.data[0].sender);
				},
				error : function(xhr, ajaxOptions, thrownError) {
					toastr.error(thrownError);
				}
			});

			$('#frm-edit-input-money').on('submit', function(e) {
				e.preventDefault();
				var form = $('#frm-edit-input-money');
				var formData = form.serialize();

				if(! form.valid()) return false;
				$.ajax({
					type : 'POST',
					url : contextPath + "/quanlytaichinh/khoanchi",
					data : formData,
					success : function(data) {
						if (!data.error) {
							toastr.success("Cập nhật phiếu chi thành công ");
							$('#edit-input-money').modal('hide');
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
		$(document).on('click', '.btn-add-input-money', function() {
			$('#createModalInputMoney').modal('show');
			$('#content').val('');
			$('#money').val('');
			$('#sender').val('');
			$('#date').val('');

			 	$('#frm-add-input-money').validate({ 
			          errorElement: "span",
			          rules: {
			            content : {
			              required : true,
			              
			            },
			            money : {
			              required :true,
			              digits: true
			            },
			            sender:{
			            	required :true
			            },
			            date:{
			            	required :true
			            },
			            
			          },
			          messages: {
			        	  content : {
			              required : "Vui lòng nhập nội dung khoản chi.",
			            },
			            money : {
			              required :"Vui lòng nhập khoản tiền chi.",
			              digits:"Số tiền chi phải là số."
			            },
			            sender:{
			            	required :"Vui lòng nhập họ tên người chi"
			            },
			            date : {
				              required :"Vui lòng chọn ngày chi",
				            }
			          }
				}); 

			$('#frm-add-input-money').on('submit', function(e) {
				e.preventDefault();
				var form = $('#frm-add-input-money');
				var formData = form.serialize();

				if(! form.valid()) return false;

				$.ajax({
					type : 'POST',
					url : contextPath + "/quanlytaichinh/khoanchi",
					data : formData,
					success : function(data) {

						if (!data.error) {
							toastr["success"]("Tạo phiếu chi thành công !");
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