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
		<h1>Quản lý đoàn phí</h1>
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i> Trang chủ</a></li>
			<li><a href="#"> Danh mục quản lý</a></li>
			<li class="active">Quản lý đoàn phí</li>
		</ol>
	</section>
	<!-- Main content -->
	<section class="content">
		
		<!-- Default box -->
		<div class="box">
			<div id='test'>
			
			</div>
			<div class="box-header with-border">
				<h3 class="box-title">Danh sách đóng đoàn phí chi đoàn + (tên chi đoàn)</h3>
	
			</div>
			<div class="box-body">
				<table class="table table-striped table-responsive table-hover table-bordered" id='tabledoanphi'>
					<thead>
						<tr>
							<th class="text-center" rowspan="2">Id</th>
							<th class="text-center" rowspan="2">Mã ĐV</th>
							<th class="text-center" rowspan="2">Họ và tên</th>
							<th class="text-center" colspan="12">Đã nộp đoàn phí tháng</th>
						</tr>
						<tr>
							<th class="text-center">1</th>
							<th class="text-center">2</th>
							<th class="text-center">3</th>
							<th class="text-center">4</th>
							<th class="text-center">5</th>
							<th class="text-center">6</th>
							<th class="text-center">7</th>
							<th class="text-center">8</th>
							<th class="text-center">9</th>
							<th class="text-center">10</th>
							<th class="text-center">11</th>
							<th class="text-center">12</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listUnionist}" var="unionist">
							<tr>
								<td class="text-center"><c:out value="${unionist.id}"></c:out> </td>
								<td class="text-center"><c:out value="${unionist.code}"></c:out> </td>
								<td class="text-center"><c:out value="${unionist.name}"></c:out></td>
								<c:forEach begin="1" end="12" var="month" step="1">
									<c:set value="fa-circle-o" var="check"></c:set>
									<td class="text-center"><input type="hidden" id="checked-${month}-${unionist.id}" value=""><i id="action-${month}-${unionist.id}" class="fa <c:forEach items="${listPay}" var="pay"><c:if test="${pay.unionist_id==unionist.id&&pay.status==1&&pay.month==month}"><c:set value="fa-check-circle" var="check"></c:set></c:if></c:forEach><c:out value="${check}"></c:out>" title="Nộp" onclick="payUnionist(${month}, ${unionist.id})" aria-hidden="true" style="cursor: pointer; color: #3598dc;font-size: 20px;"></i></td>
								</c:forEach>
							</tr>
							</c:forEach>
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
	function payUnionist(a,b){
		var addclass = document.getElementById("action-"+a+"-"+b).classList;
		 if (addclass.contains("fa-circle-o")) {
			 addclass.remove("fa-circle-o");
			 addclass.add("fa-check-circle");
			 document.getElementById("checked-"+a+"-"+b).value="1";
		}else if(addclass.contains("fa-check-circle")){
			 addclass.remove("fa-check-circle");
			 addclass.add("fa-circle-o");
			 document.getElementById("checked-"+a+"-"+b).value="0";
		}
		
		 var xhttp = new XMLHttpRequest();
		 var contextPath = "${pageContext.request.contextPath}";
		 var checkedvalue = document.getElementById("checked-"+a+"-"+b).value;
		  xhttp.open("POST", contextPath+"/quanlydoanphi", true);
		  xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		  xhttp.send("month="+a+"&unionist_id="+b+"&checked="+checkedvalue);
		  xhttp.onreadystatechange = function() {
		        if (this.readyState == 4 && this.status == 200) {
		        	if(this.response=="added"){
		        		toastr.success("Nộp thành công !")
		        	}else if(this.response=="deleted"){
		        		toastr.success("Xóa thành công !")
		        	}
		       }
		    };
	}
</script>