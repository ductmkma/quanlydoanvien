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
		<h1>XÁC NHẬN ĐOÀN VIÊN CHUYỂN ĐẾN</h1>
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i> Trang chủ</a></li>
			<li><a href="#"> Danh mục quản lý</a></li>
			<li><a href="#"> Quản lý chuyển sinh hoạt</a></li>
			<li class="active">Xác nhận đoàn viên đến</li>
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
					id='tableWattingConfirmReceiver'>
					<thead>
						<tr>
							<th class="text-center">Id</th>
							<th class="text-center">Mã đoàn viên</th>
							<th class="text-center">Họ và tên</th>
							<th class="text-center">Đơn vị giới thiệu</th>
							<th class="text-center">Ngày yêu cầu</th>
							<th class="text-center">Hành động</th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>						
			</div>
				<!-- start form covert unionist -->
			<div class="modal fade" id="modal-confirmreceiver">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title">THÔNG TIN CHI ĐOÀN CHUYỂN ĐẾN</h4>
				</div>
				<div class="modal-body">
					<form action="" method="post" name="frm-confirm-receiver" id="frm-confirm-receiver" accept-charset="utf-8" enctype="multipart/form-data">
						<input type="hidden" name="code_unionist" value="" id="code_unionist">
						<input type="hidden" name="id" value="" id="id">
						Chọn chi đoàn cơ sở:<span style='color: red;'> *</span> <select required
							name='selectUnit' class="form-control" id="selectUnit">
						</select>
						<div class="modal-footer">
							<button type="submit" name='convertUnionist' class="btn btn-primary btn-confirm-receiver"> Chuyển</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
			
			<!-- finish form covert unionist -->
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
    var table = $('#tableWattingConfirmReceiver').DataTable({
         "ajax": contextPath+"/waittingconfirmreceiver",
         "columnDefs" : [ {
				"className" : "text-center",
				"targets" : "_all"
			}],
         "columns": [
            { "data": "id" },
            { "data": "code_unionist" },
            { "data": "name_unionist" },
            { "data": "units_name_old"},
            { "data": "updated_at" },
            { "data": "action",
            	render: function (data, type, row) {
                    return '<a class="btn btn-circle btn-xs btn-outline blue btn-confirm"  href="javascript:;" id="'+row.id+'" title="Xác nhận"><i class="fa fa-check-square-o" aria-hidden="true"></i> Xác nhận</a> <a class="btn btn-circle btn-xs btn-outline red btn-edit" href="javascript:;" id="'+row.id+'"  title="Ẩn"><i class="fa fa-eye-slash" aria-hidden="true"></i> Ẩn</a>';
            	}}
        ]
    });
   
    //confirm receiver
    $('#tableWattingConfirmReceiver').on('click', '.btn-confirm', function (){
    	var contextPath = "${pageContext.request.contextPath}";
    	$("#selectUnit").html("");
    	var id = $(this).attr('id');
    	var code = $(this).parent().parent().find('td:eq(1)').html();
    	$("#code_unionist").val(code);
    	$("#id").val(id);
		var path = contextPath+"/quanlychuyensinhhoat";
		$("#modal-confirmreceiver").modal('show');
		$.ajax({
            type:'GET',
            url:  contextPath+"/listunitunder",
            data:{
            	action:"getlistunitunder"
            },
            success:function(res){
                if(res!=null) {
                	 $("#selectUnit").append("<option value='' disabled='disabled' selected='selected'>--Chọn chi đoàn cơ sở--</option>");
	            	  $.each(res.data, function (key, item) {
	            	  $("#selectUnit").append("<option value='"+item.id+"'>"+ item.name+ "</option>"); });
					
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
    $('#frm-confirm-receiver').on('submit',function(e){
    	e.preventDefault();
    	var units_id_new = $('select#selectUnit option:selected').val();
    	var units_name_new = $('select#selectUnit option:selected').html();
    	var code_unionist = $("#code_unionist").val();
    	var id = $("#id").val();
    	$.ajax({
            type:'POST',
            url:  contextPath+"/quanlychuyensinhhoat/xacnhanchuyenden",
            data:{
            	id:id,
            	code_unionist:code_unionist,
            	units_id_new:units_id_new,
            	units_name_new:units_name_new,
            	action:'confirmlevel2'
            },
            dataType:'json',
            success:function(res){
            	if(!res.error) {
                	toastr.success("Xác nhận thành công !");
                	$("#modal-confirmreceiver").modal('hide');
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

</script>