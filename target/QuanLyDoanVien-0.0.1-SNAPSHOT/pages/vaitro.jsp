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
		<h1>VAI TRÒ</h1>
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
			<div class="box-header with-border"></div>
			<div class="box-body">
			<a id='themDonVi' class='btn btn-primary btn-add-role' data-toggle="modal"
					href='' title='Thêm mới'><i class="fa fa-plus" aria-hidden="true"></i>
					THÊM MỚI</a>
				<table
					class="table table-striped table-responsive table-hover table-bordered"
					id='tableRole'>
					<thead>
						<tr>
							<th class="text-center">Id</th>
							<th class="text-center">Tên hiển thị</th>
							<th class="text-center">Vai trò</th>
							<th class="text-center">Mô tả</th>
							<th class="text-center">Ngày tạo</th>
							<th class="text-center">Hành động</th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
				<div class="modal fade" id="edit-role">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal"
												aria-hidden="true">&times;</button>
											<h4 class="modal-title">Chỉnh sửa vai trò</h4>
										</div>
										<div class="modal-body">
											<form name="frm-edit-role" id="frm-edit-role" action="" method="post" accept-charset="utf-8"
												enctype="multipart/form-data">
												Tên hiển thị <span style='color: red;'>*</span><input
													type="text" name="display_name" id="display_name" class="form-control"
													value='' required="required"
													placeholder="Tên hiển thị" title="" />
											  Vai trò <span style='color: red;'>*</span><input type="text" name="name" id="name" class="form-control" value=""
													required="required" placeholder="Vai trò" title="" />
											 <input type="hidden" name="idRole" id="idRole" class="form-control" value=""
													title="" />
											<input type="hidden" name="action" id="action" class="form-control" value="edit"
													title="" />
											 Mô tả <textarea name="description" id="description" class="form-control" rows="3"></textarea>
												<div class="modal-footer">
													<button type="submit" name='update'
														class="btn btn-primary">Cập nhật</button>
												</div>
											</form>
										</div>
									</div>
								</div>
							</div>
							<div class="modal fade" id="createRoleModal">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal"
												aria-hidden="true">&times;</button>
											<h4 class="modal-title">Thêm mới vai trò</h4>
										</div>
										<div class="modal-body">
											<form name="frm-add-role" id="frm-add-role" action="" method="post" accept-charset="utf-8"
												enctype="multipart/form-data">
												Tên hiển thị <span style='color: red;'>*</span><input
													type="text" name="display_name" id="display_name" class="form-control"
													value='' required="required"
													placeholder="Tên hiển thị" title="" />
											  Vai trò <span style='color: red;'>*</span><input type="text" name="name" id="name" class="form-control" value=""
													required="required" placeholder="Vai trò" title="" />
											<input type="hidden" name="action" id="action" class="form-control" value="add"
													title="" />
											 Mô tả <textarea name="description" id="description" class="form-control" rows="3"></textarea>
												<div class="modal-footer">
													<button type="submit" name='add' id="add"
														class="btn btn-primary">Thêm mới</button>
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
    var table = $('#tableRole').DataTable({
         "ajax": contextPath+"/listrole",
         "columnDefs" : [ {
				"className" : "text-center",
				"targets" : 0
			},
			{
				"className" : "text-center",
				"targets" : 4
			},
			{
				"className" : "text-center",
				"targets" : 5
			}
			
			],
         "columns": [
            { "data": "id" },
            { "data": "display_name" },
            { "data": "name" },
            { "data": "description" },
            { "data": "created_at" },
            { "data": "action",
            	render: function (data, type, row) {
                    return '<a class="btn btn-circle btn-xs btn-outline blue"  href="vaitro/quyenhan?roleid='+row.id+'" title="Quyền hạn"><i class="fa fa-lock" aria-hidden="true"></i> Quyền hạn</a> <a class="btn btn-circle btn-xs btn-outline purple btn-edit" href="javascript:;" id="'+row.id+'"  title="Sửa"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> Sửa</a> <a id="'+row.id+'" class="btn btn-circle btn-xs btn-outline red btn-delete" href="javascript:;" title="Xóa" ><i id="deleteUnit" class="fa fa-trash-o" aria-hidden="true"></i> Xóa</a>';
            	}}
        ]
    });
   
    //delete role
    $('#tableRole').on('click', '.btn-delete', function (){
    	var contextPath = "${pageContext.request.contextPath}";
    	var id = $(this).attr('id');
		var path = contextPath+"/vaitro";
	    swal({
	        title: "Bạn có chắc chắn muốn xóa?",
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
		            	  id: id
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
    $('#tableRole').on('click', '.btn-edit', function () {
		$('#edit-role').modal('show');
        var id = $(this).attr('id');

        $.ajax({
              type: "POST",
              url: contextPath+"/listrole",
              data:{
            	action:'edit',
            	id:id
              },
              success: function(res)
              {
            	$("#idRole").val(res.data[0].id);
                $('#name').val(res.data[0].name);
                $('#name').focus();
                $('#display_name').val(res.data[0].display_name);
                $('#display_name').focus();
                $('#description').val(res.data[0].description);
              },
              error: function (xhr, ajaxOptions, thrownError) {
                toastr.error(thrownError);
              }
        });


        $('#frm-edit-role').on('submit',function(e){

              e.preventDefault();

              var form= $('#frm-edit-role');
              var formData= form.serialize();

              //if(! form.valid()) return false;

              $.ajax({
                type:'POST',
                url:  contextPath+"/vaitro",
                data:
                	formData,
                success:function(data){
                    if(!data.error) {
                        toastr.success("Cập nhật vai trò thành công"); 
                        $('#edit-role').modal('hide');
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
  //addRole
   $(document).on('click', '.btn-add-role', function() {
		$('#createRoleModal').modal('show');
        $('#name').val('');
        $('#display_name').val('');
        $('#description').val('');
		
	/* 	$('#add-role').validate({ 
              errorElement: "span",
              rules: {
                name : {
                  required : true,
                  
                },
                display_name : {
                  required :true,
                },
              },
              messages: {
                name : {
                  required : "Vui lòng nhập vai trò",
                },
                display_name : {
                  required :"Vui lòng nhập tên hiển thị",
                }
              }
    	}); */

    	$('#frm-add-role').on('submit', function(e){
		     e.preventDefault();
		      var form= $('#frm-add-role');
		      var formData= form.serialize();

		      //if(! form.valid()) return false;

		      $.ajax({
		        type:'POST',
		        url: contextPath+"/vaitro",
		        data: formData,
		        success:function(data){

		            if(!data.error) {

		                toastr["success"]("Thêm vai trò thành công"); 
		            
		                $('#createRoleModal').modal('hide');
						
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