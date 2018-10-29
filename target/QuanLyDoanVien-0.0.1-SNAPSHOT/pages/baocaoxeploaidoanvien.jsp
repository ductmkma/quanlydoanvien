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
		<h1>BÁO CÁO XẾP LOẠI ĐOÀN VIÊN</h1>
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i> Trang chủ</a></li>
			<li><a href="#"> Báo cáo thống kê</a></li>
			<li class="active">Báo cáo xếp loại đoàn viên</li>
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
				<div class="btn btn-primary" id="print" onclick="myFunction()">
						<form  action="<%=request.getContextPath() %>/readfileexcel" method="post" id="formImport" enctype="multipart/form-data">
					<span><i class="fa fa-print" aria-hidden="true"></i> In báo cáo</span>
				</form>
				</div>
			</div>
			<div class="box-body">
				
				<table
					class="table table-striped table-responsive table-hover table-bordered"
					id='tableRateReport'>
					<thead>
						<tr>
							<th class="text-center">Tổng số đoàn viên xếp loại</th>
							<th class="text-center">Đoàn viên loại xuất sắc</th>
							<th class="text-center">Đoàn viên loại khá</th>
							<th class="text-center">Đoàn viên loại trung bình</th>
							<th class="text-center">Đoàn viên loại yếu</th>
							<th class="text-center">Đoàn viên chưa xếp loại</th>
							<th class="text-center">Hành động</th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
				 <div class="modal fade" id="modal-chart">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title">Biểu đồ</h4>
                </div>
                <div class="modal-body">
                    <div id="chart" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
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
function myFunction() {
    window.print();
}
$(function() {
	var contextPath = "${pageContext.request.contextPath}";
     var table = $('#tableRateReport').DataTable({
         "ajax": contextPath+"/listrate",
         "columnDefs" : [ {
				"className" : "text-center",
				"targets" : "_all"
			}],
         "columns": [
            { "data": "sumRated" },
            { "data": "sumExcellent" },
            { "data": "sumRather" },
            { "data": "sumMedium" },
            { "data": "sumWeak" },
            { "data": "sumNotRate" },
            { "data": "action",
            	render: function (data, type, row) {
                    return '<a id="btn-chart" data-toggle="modal" class="btn btn-circle btn-xs btn-outline blue"  href="#modal-chart" title="Xem biểu đồ"><i class="fa fa-bar-chart" aria-hidden="true"></i> Xem biểu đồ</a>';
            	}}
        ]
    });
    $("#tableRateReport").on('click','#btn-chart',function(){
    	var sum = parseInt($(this).parent().parent().find('td:eq(0)').html());
    	var excellent = parseInt($(this).parent().parent().find('td:eq(1)').html())/(sum);
    	var rather = parseInt($(this).parent().parent().find('td:eq(2)').html())/(sum);
    	var medium = parseInt($(this).parent().parent().find('td:eq(3)').html())/(sum);
    	var weak = parseInt($(this).parent().parent().find('td:eq(4)').html())/(sum);
    	
    	Highcharts.chart('chart', {
     	    chart: {
     	        plotBackgroundColor: null,
     	        plotBorderWidth: null,
     	        plotShadow: false,
     	        type: 'pie'
     	    },
     	    title: {
     	        text: 'Biểu đồ thống kê xếp loại đoàn viên năm 2018'
     	    },
     	    tooltip: {
     	        pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
     	    },
     	    plotOptions: {
     	        pie: {
     	            allowPointSelect: true,
     	            cursor: 'pointer',
     	            dataLabels: {
     	                enabled: false
     	            },
     	            showInLegend: true
     	        }
     	    },
     	    series: [{
     	        name: 'Tỉ lệ',
     	        colorByPoint: true,
     	        data: [{
     	            name: 'Xuất sắc',
     	            y: excellent,
     	        }, {
     	            name: 'Khá',
     	            y: rather,
     	            sliced: true,
     	            selected: true
     	        }, {
     	            name: 'Trung bình',
     	            y: medium
     	        }, {
     	            name: 'Yếu',
     	            y: weak,
     	        }]
     	    }]
     	});
    });
});
</script>