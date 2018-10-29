<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Báo cáo thống kê</title>
</head>
</script>
<body onload="window.print()">
	<div class="container">
		<div style="float: left;" class="col-md-4">
			<p style="font-weight: bold">ĐOÀN TNCS HỒ CHÍ MINH</p>
			<p style="font-weight: bold">BCH ĐOÀN XÃ THANH HÒA</p>
		</div>
		<div style="float: right;" col-md-4>
			<p style="font-weight: bold">CỘNG HÒA XÃ HỘI CHỦ NGHĨA VIỆT NAM</p>
			<p style="font-weight: bold; text-align: center">Độc lập - Tự do
				- Hạnh phúc</p>
		</div>
		<br>
		<br>
		<br>
		<div class="col-md-12 text-center">
			<h3 style="font-weight: bold;">BÁO CÁO THỐNG KÊ CÔNG TÁC ĐOÀN</h3>
			<h5 style="font-style: italic;">Thống kê đến ngày 28 tháng 01
				năm 2018</h5>
		</div>
		<div class="col-md-12">
			<table class="table table-bordered table-hover">
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
					<tr>
						<c:forEach items="${list}" var="test">
							<td class="text-center"><c:out value="${test.sumUnionist}"></c:out></td>
							<td class="text-center"><c:out value="${test.nationUnionist}"></c:out></td>
							<td class="text-center"><c:out value="${test.religionUnionist}"></c:out></td>
							<td class="text-center"><c:out value="${test.party}"></c:out></td>
							<td class="text-center"><c:out value="${test.unionistNew}"></c:out></td>
							<td class="text-center"><c:out value="${test.unionistCard}"></c:out></td>
							<td class="text-center"><c:out value="${test.unionistBook}"></c:out></td>
						</c:forEach>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="col-md-5" style="margin-right:100px;float:right;">
			<h5 style="font-weight: bold;">TM.BCH ĐOÀN XÃ</h5>
			<br><br><br><br>
			<p class="text-center">Trần Minh Đức</p>
		</div>
	</div>
</body>
	<script type="text/javascript">
		$(document).ready(function(){
			window.load(function(){
				$.ajax({
		              type: "POST",
		              url: contextPath+"/inbaocao",
		              data:{
		            	action:'get'  
		              },
		              dataType : 'json',
		              success: function(res)
		              {
		            	 alert(res.sumUnionist);
		              },
		              error: function (xhr, ajaxOptions, thrownError) {
		                toastr.error(thrownError);
		              }
		        }); 
			})
			   
		});
	
	</script>
</html>