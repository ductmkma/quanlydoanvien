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
		<h1>ĐÁNH GIÁ XẾP LOẠI ĐOÀN VIÊN</h1>
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i> Trang chủ</a></li>
			<li><a href="#"> Danh mục quản lý</a></li>
			<li class="active">Đánh giá xếp loại ĐV</li>
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
					id='tableRate'>
					<thead>
						<tr>
							<th class="text-center">Id</th>
							<th class="text-center">Mã đoàn viên</th>
							<th class="text-center">Họ tên đoàn viên</th>
							<th class="text-center">Ngày sinh</th>
							<th class="text-center">Đơn vị</th>
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
	
	 var table = $('#tableRate').DataTable({
         "ajax": contextPath+"/listunionist",
         "columnDefs" : [ {
				"className" : "text-center",
				"targets" : 0
			},{
				"className" : "text-center",
				"targets" : 1
			},{
				"className" : "text-center",
				"targets" : 3
			},{
				"className" : "text-center",
				"targets" : 4
			}
			,{
				"className" : "text-center",
				"targets" : 5
			}
         
         ],
         "columns": [
            { "data": "id" },
            { "data": "code_unionist" },
            { "data": "name" },{ "data": "birthday" },
            { "data": "units_name" },
            { "data": "action",
            	render: function (data, type, row) {
                    return ' <select  name="rate" id="rate-'+row.code+'" class="form-control rate" required="required"> <option disabled selected value=""> -- Xếp loại -- </option>  <option value="1">Xuất sắc</option> <option value="2">Khá</option><option value="3">Trung bình</option> <option value="4">Yếu</option> </select>';
            	}}
        ]
    });
	$("#tableRate").on('change','.rate',function(){
			var code = $(this).parent().parent().find('td:eq(1)').html();
			var name = $(this).parent().parent().find('td:eq(2)').html();
			var ratevalue = $("select#rate-"+code+" option:selected").val();
			   $.ajax({
	                type:'POST',
	                url:  contextPath+"/danhgiaxeploai",
	                data:{
	                	code:code,
			   			ratevalue:ratevalue
	                },
	                success:function(data){
	                    if(!data.error) {
	                        toastr.success("Xếp loại ĐV "+name+" thành công!"); 
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