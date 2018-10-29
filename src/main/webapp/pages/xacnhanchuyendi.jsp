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
		<h1>XÁC NHẬN CHUYỂN ĐOÀN VIÊN ĐI</h1>
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i> Trang chủ</a></li>
			<li><a href="#"> Danh mục quản lý</a></li>
			<li><a href="#"> Quản lý chuyển sinh hoạt</a></li>
			<li class="active">Xác nhận chuyển đoàn viên</li>
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
					id='tableWattingConfirmSend'>
					<thead>
						<tr>
							<th class="text-center">Id</th>
							<th class="text-center">Mã đoàn viên</th>
							<th class="text-center">Họ và tên</th>
							<th class="text-center">Đơn vị giới thiệu</th>
							<th class="text-center">Đơn vị tiếp nhận</th>
							<th class="text-center">Ngày yêu cầu</th>
							<th class="text-center">Hành động</th>
						</tr>
					</thead>
					<tbody>
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
$(function() {
	var contextPath = "${pageContext.request.contextPath}";
    var table = $('#tableWattingConfirmSend').DataTable({
         "ajax": contextPath+"/gioithieusinhhoat",
         "columnDefs" : [ {
				"className" : "text-center",
				"targets" : "_all"
			}],
         "columns": [
            { "data": "id" },
            { "data": "code_unionist" },
            { "data": "name_unionist" },
            { "data": "units_name_old"},
            { "data": "units_name_new"},
            { "data": "created_at" },
            { "data": "action",
            	render: function (data, type, row) {
                    return '<a class="btn btn-circle btn-xs btn-outline blue btn-confirm"  href="javascript:;" id="'+row.id+'" title="Xác nhận"><i class="fa fa-check-square-o" aria-hidden="true"></i> Xác nhận</a> <a class="btn btn-circle btn-xs btn-outline red btn-edit" href="javascript:;" id="'+row.id+'"  title="Ẩn"><i class="fa fa-eye-slash" aria-hidden="true"></i> Ẩn</a>';
            	}}
        ]
    });
   
    //confirmSend
    $('#tableWattingConfirmSend').on('click', '.btn-confirm', function (){
    	var contextPath = "${pageContext.request.contextPath}";
    	var id = $(this).attr('id');
		var path = contextPath+"/quanlychuyensinhhoat/xacnhanchuyendi";
	    swal({
	        title: "Bạn có chắc chuyển đoàn viên ?",
	        type: "warning",
	        showCancelButton: true,
	        confirmButtonColor: "#e84242",
	        cancelButtonText: "Không",
	        confirmButtonText: "Có",
	    },
	    function(isConfirm) {
	        if (isConfirm) {  
	        	debugger;
		        $.ajax({
		              type: "POST",
		              url: path,
		              data:{
		            	  action: 'confirmlevel1',
		            	  id:id
		              },
		              dataType : 'json',
		              success: function(res)
		              {
		                if(!res.error) {
		                	toastr.success("Chuyển thành công ! Chờ đơn vị tiếp nhận xác nhận");
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
});

</script>