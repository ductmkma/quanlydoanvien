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
		<h1>QUẢN LÝ TÀI KHOẢN</h1>
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i> Trang chủ</a></li>
			<li><a href="#"> Quản trị hệ thống</a></li>
			<li class="active"> Quản lý tài khoản</li>
		</ol>
	</section>
	<!-- Main content -->
	<section class="content">

		<!-- Default box -->
		<div class="box">
			<div class="box-header with-border"></div>
			<div class="box-body">
				<table
					class="table table-striped table-responsive table-hover table-bordered"
					id='tableUser'>
					<thead>
						<tr>
							<th class="text-center">Id</th>
							<th class="text-center">Code</th>
							<th class="text-center">Họ và tên</th>
							<th class="text-center">Email</th>
							<th class="text-center">Loại TK</th>
							<th class="text-center">Ngày tạo</th>
							<th class="text-center">Hành động</th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
				<div class="modal fade" id="edit-acc">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal"
												aria-hidden="true">&times;</button>
											<h4 class="modal-title">Chỉnh sửa tài khoản</h4>
										</div>
										<div class="modal-body">
											<form name="frm-edit-acc" id="frm-edit-acc" action="" method="post" accept-charset="utf-8"
												enctype="multipart/form-data">
												Họ và tên <span style='color: red;'>*</span><input
													type="text" name="display_name" id="display_name_edit" class="form-control"
													value='' required="required"
													placeholder="Họ và tên" title="" />
											  Email <span style='color: red;'>*</span><input type="text" name="email" id="email_edit" readonly="readonly" class="form-control" value=""
													required="required" placeholder="Email" title="" />
											  Loại tài khoản <span style='color: red;'>*</span>
											    <select name="typeacc" id="typeacc" class="form-control" required="required">
     												  <option value="">--Loại tài khoản--</option>
   												</select>
											 <input type="hidden" name="codeUnionist" id="codeUnionist" class="form-control" value=""
													title="" />
											<input type="hidden" name="action" id="action" class="form-control" value="edit-acc"
													title="" />
												<div class="modal-footer">
													<button type="submit" name='update'
														class="btn btn-primary">Cập nhật</button>
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
	var contextPath = "${pageContext.request.contextPath}";
    var table = $('#tableUser').DataTable({
         "ajax": contextPath+"/listuser",
         "columnDefs" : [ {
				"className" : "text-center",
				"targets" : 0
			},{
				"className" : "text-center",
				"targets" : 6
			},{
				"className" : "text-center",
				"targets" : 1
			},{
				"className" : "text-center",
				"targets" : 5
			}],
         "columns": [
			{ "data": "id" },
            { "data": "code" },
            { "data": "name" },
            { "data": "email" },
            { "data": "role_display_name" },
            { "data": "created_at" },
            { "data": "action",
            	render: function (data, type, row) {
                    return '<a class="btn btn-circle btn-xs btn-outline blue"  href="quanlytaikhoan/vaitro?id='+row.id+'&username='+row.name+'" title="Vai trò"><i class="fa fa-shield" aria-hidden="true"></i> Vai trò</a> <a class="btn btn-circle btn-xs btn-outline purple btn-edit" href="javascript:;" id="'+row.id+'"  title="Sửa"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> Sửa</a> <a id="'+row.id+'" class="btn btn-circle btn-xs btn-outline red btn-delete" href="javascript:;" title="Xóa" ><i id="deleteUnit" class="fa fa-trash-o" aria-hidden="true"></i> Xóa</a>';
            	}}
        ]
    });
   
    //delete role
    $('#tableUser').on('click', '.btn-delete', function (){
    	var contextPath = "${pageContext.request.contextPath}";
    	var code = $(this).parent().parent().find('td:eq(1)').html();
		var path = contextPath+"/quanlytaikhoan";
	    swal({
	        title: "Bạn có chắc chắn muốn xóa tài khoản này?",
	        type: "warning",
	        showCancelButton: true,
	        confirmButtonColor: "#e84242",
	        cancelButtonText: "Không",
	        confirmButtonText: "Có",
	    },
	    function(isConfirm) {

	        if (isConfirm) {  

		        $.ajax({
		              type: "POST",
		              url: path,
		              data:{
		            	  action: 'delete',
		            	  id: code
		              },
		              dataType : 'json',
		              success: function(res)
		              {
		                if(!res.error) {
		                    toastr.success('Xóa thành công!');
		                    table.ajax.reload();             
		                }
		              },
		              error: function (xhr, ajaxOptions, thrownError) {
		                toastr.error(thrownError);
		              }
		        });   
	        } 
	    });
    });
  //edit role
    $('#tableUser').on('click', '.btn-edit', function () {
    	$("#typeacc").html("");
		$('#edit-acc').modal('show');
        var id = $(this).attr('id');
        var name = $(this).parent().parent().find('td:eq(2)').html();
        $("#display_name_edit").val(name);
        var email = $(this).parent().parent().find('td:eq(3)').html();
        $("#email_edit").val(email);
        var code = $(this).parent().parent().find('td:eq(1)').html();
        $("#codeUnionist").val(code);
        $.ajax({
              type: "POST",
              url: contextPath+"/listuser",
              data:{
            	action:'getRole'
              },
              success: function(res)
              {
            	  $("#typeacc").append("<option value='' disabled='disabled' selected='selected'>--Loại tài khoản--</option>");
            	  $.each(res.data, function (key, item) {
            	  $("#typeacc").append("<option value='"+item.id+"'>"+ item.display_name+ "</option>"); });
              },
              error: function (xhr, ajaxOptions, thrownError) {
                toastr.error(thrownError);
              }
        });
        $('#frm-edit-acc').on('submit',function(e){

              e.preventDefault();

              var form= $('#frm-edit-acc');
              var formData= form.serialize();
              $.ajax({
                type:'POST',
                url:  contextPath+"/quanlydoanvien",
                data:
                	formData,
                success:function(data){
                    if(!data.error) {
                        toastr.success("Cập nhật vai trò thành công"); 
                        $('#edit-acc').modal('hide');
                      	table.ajax.reload();
						
                    } else {
                        if(!IsNull(data.message.name )) {
                            toastr.error(data.message.name[0]);
                        }
                        if(!IsNull(data.message.display_name)) {
                            toastr.error(data.message.display_name[0]);
                        }
                        
                    }
                  
                },
                error: function (xhr, ajaxOptions, thrownError)
                {

                  toastr.error(thrownError);
                }
              });

        });
    });
});

</script>