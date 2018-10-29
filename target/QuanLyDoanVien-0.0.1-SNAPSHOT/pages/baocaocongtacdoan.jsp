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
		<h1>BÁO CÁO CÔNG TÁC ĐOÀN VIÊN</h1>
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i> Trang chủ</a></li>
			<li><a href="#"> Báo cáo thống kê</a></li>
			<li class="active">Báo cáo công tác đoàn</li>
		</ol>
	</section>
	<!-- Main content -->
	<section class="content">

		<!-- Default box -->
		<div class="box">
			<div class="box-header with-border">
			
			<div class="fileUpload btn btn-warning" style="display: none;">
						<form  action="<%=request.getContextPath() %>/readfileexcel" method="post" id="formImport" enctype="multipart/form-data">
					<span><i class="fa fa-download" aria-hidden="true"></i> Tải báo cáo</span>
				</form>
				</div>
				<div>
					<a class="btn btn-primary btn-print" href="<%=request.getContextPath()%>/inbaocao">
						<span><i class="fa fa-print" aria-hidden="true"></i> In báo cáo</span>
					</a>
					
				</div>
			</div>
			<div class="box-body">
				
				<table
					class="table table-striped table-responsive table-hover table-bordered"
					id='tableRole'>
					<thead>
						<tr>
							<th class="text-center">Tổng số đoàn viên</th>
							<th class="text-center">Đoàn viên dân tộc thiểu số</th>
							<th class="text-center">Đoàn viên tôn giáo</th>
							<th class="text-center">Đoàn viên là Đảng viên</th>
							<th class="text-center">Đoàn viên mới kết nạp</th>
							<th class="text-center">Đoàn viên có sổ đoàn viên</th>
							<th class="text-center">Đoàn viên có thẻ đoàn viên</th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
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
         "ajax": contextPath+"/listreport",
         "columnDefs" : [ {
				"className" : "text-center",
				"targets" : "_all"
			}],
         "columns": [
            { "data": "sumUnionist" },
            { "data": "nationUnionist" },
            { "data": "religionUnionist" },
            { "data": "party" },
            { "data": "unionistNew" },
            { "data": "unionistBook" },
            { "data": "unionistCard"}  
        ]
    }); 
 	$(document).on('click','.btn-print',function(){
 		var contextPath = "${pageContext.request.contextPath}";
 		
 			
 			
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