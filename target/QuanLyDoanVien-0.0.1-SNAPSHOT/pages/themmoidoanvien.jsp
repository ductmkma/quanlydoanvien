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
		<h1>Thêm mới đoàn viên</h1>
		<ol class="breadcrumb">
			<li><a href="<%=request.getContextPath()%>/trangchu"><i class="fa fa-dashboard"></i> Trang chủ</a></li>
			<li><a href="#"> Danh mục quản lý</a></li>
			<li><a href="<%=request.getContextPath()%>/quanlydoanvien"> Quản lý đoàn viên</a></li>
			<li class="active">Thêm mới đoàn viên</li>
		</ol>
	</section>
	<!-- Main content -->
	<section class="content">

		<!-- Default box -->
		<div class="box">
			<div class="box-body">
				<form
					action="<%=request.getContextPath()%>/quanlydoanvien?action=insert"
					method="POST" class="form-horizontal" role="form" id="frm-add"
					enctype="multipart/form-data">
					<div class="panel panel-body col-md-12 col-sm-12 col-xs-12">
						<div id="file-upload-form"
							class="uploader col-md-4 col-sm-12 col-xs-12">
							<input id="file-upload" type="file" name="avata" accept="image/*" />
							<label for="file-upload" id="file-drag"> <img
								id="file-image" src="#" alt="Preview" class="hidden">
								<div id="start">
									<i class="fa fa-picture-o" aria-hidden="true"></i>
									<div>Select a file or drag here</div>
									<div id="notimage" class="hidden">Please select an image</div>
									<span id="file-upload-btn" class="btn btn-primary">Select
										a file</span>
								</div>
								<div id="response" class="hidden">
									<div id="messages"></div>
									<progress class="progress" id="file-progress" value="0">
										<span>0</span>%
									</progress>
								</div>
							</label>
						</div>
						<div style="width: 80%;" class="col-md-9">
							<div class="col-md-4 col-sm-12 col-xs-12 fm-input">
								<p>
									Họ và tên<span class='format-star'> *</span>
								</p>
								<input type="text" name="name" id="name" class="form-control"
									value="" required="required" title="" placeholder="Họ và tên">
							</div>

							<div class="col-md-4 col-sm-12 col-xs-12 fm-input">
								<p>
									Giới tính <span class='format-star'> *</span>
								</p>
								<input type="radio" name="gender" id="gender" class="gender"
									value="Nam" required="required">Nam <input type="radio"
									name="gender" id="" class="gender" value="Nữ"
									required="required">Nữ <input type="radio"
									name="gender" id="" class="gender" value="Khác"
									required="required">Khác
							</div>
							<div class="col-md-4 col-sm-12 col-xs-12 date fm-input">
								<p>
									Ngày sinh <span class='format-star'> *</span>
								</p>
								<div class="input-group" id="ngaysinh">
									<input id="ngaysinh" name="birthday" required="required" type='text'
										class="form-control" placeholder="Ngày sinh"> <span
										class="input-group-addon" id="span-date-1"> <span
										class="glyphicon glyphicon-calendar"></span>
									</span>
								</div>
							</div>
							<div class="col-md-4 col-sm-12 col-xs-12 fm-input">
								<p>
									Email <span class='format-star'> *</span>
								</p>
								<input placeholder="Email" type="email" name="email" id="email"
									class="form-control input-lname" value="" required="required">
								<%System.out.print(request.getAttribute("exist")); %>
							</div>
							<div class="col-md-4 col-sm-12 col-xs-12 fm-input">
								<p>
									Điện thoại <span class='format-star'> *</span>
								</p>
								<input placeholder="Điện thoại" type="number" name="phone" id="phone"
									class="form-control input-lname" value="" required="required">
							</div>
							<div class="col-md-4 col-sm-12 col-xs-12 fm-input">
								<p>
									Quê quán <span class='format-star'> *</span>
								</p>
								<input placeholder="Quê quán" type="text" name="home_town" id="home_town"
									class="form-control" value="" required="required">
							</div>
							<div class="col-md-4 col-sm-12 col-xs-12 fm-input">
								<p>
									Trình độ học vấn <span class='format-star'> *</span>
								</p>
								<input placeholder="Trình độ học vấn" type="text"
									name="academic_level" id="academic_level" class="form-control" value=""
									required="required">
							</div>
							<div class="col-md-4 col-sm-12 col-xs-12 fm-input">
								<p>Trình độ chuyên môn</p>
								<input placeholder="Trình độ chuyên môn" type="text"
									name="qualification" id="qualification" class="form-control" value="">
							</div>
							<div class="col-md-4 col-sm-12 col-xs-12 fm-input">
								<p>
									Trình độ lý luận chính trị <span class='format-star'> *</span>
								</p>
								<select name="political_theory" class="form-control" id="political_theory"
									required="required">
									<option value="">--Chọn trình độ --</option>
									<option value="Cao cấp">Cao cấp</option>
									<option value="Trung cấp">Trung cấp</option>
									<option value="Sơ cấp">Sơ cấp</option>
									<option value="Phổ cập">Phổ cập</option>
									<option value="Không">Không</option>
								</select>
							</div>
							<div class="col-md-4 col-sm-12 col-xs-12 fm-input">
								<p>
									Mã thẻ Đoàn <span class='format-star'> *</span>
								</p>
								<input placeholder="Mã thẻ đoàn" type="text"
									name="code_unioinist" id="code_unionist" class="form-control" value=""
									required="required">
							</div>
							<div class="col-md-4 col-sm-12 col-xs-12 date fm-input">
								<p>
									Ngày vào Đoàn <span class='format-star'> *</span>
								</p>
								<div class="input-group" id="ngayvaodoan">
									<input id="" name="day_on_unionist" required="required" id="day_on_unionist"
										type='text' class="form-control" placeholder="Ngày vào Đoàn"><span
										id="span-date-1" class="input-group-addon"> <span
										class="glyphicon glyphicon-calendar"></span>
									</span>
								</div>
							</div>
							<div class="col-md-4 col-sm-12 col-xs-12 fm-input">
								<p>
									Nơi vào Đoàn <span class='format-star'> *</span>
								</p>
								<input placeholder="Nơi vào đoàn" type="text"
									name="address_on_unionist" id="address_on_unionist" class="form-control" value=""
									required="required">
							</div>


							<div class="col-md-4 col-sm-12 col-xs-12 fm-input">
								<p>
									Chức vụ đoàn
								</p>
								<select name="competence" class="form-control" id="competence"> 
									<option value="" disabled="disabled" selected="selected">--Chọn chức vụ --</option>
									<option value="BTTWĐ">Bí thư TWĐ</option>
									<option value="PBTTWĐ">Phó bí thư TWĐ</option>
									<option value="UVBCHTWĐ">Ủy viên BCH TWĐ</option>
									
									<option value="BTTĐ">Bí thư TĐ</option>
									<option value="PBTTĐ">Phó bí thư TĐ</option>
									<option value="UVBCHTĐ">Ủy viên BCH TĐ</option>
									
									<option value="BTCĐHĐ">Bí thư HĐ</option>
									<option value="PBTCĐHĐ">Phó bí thư HĐ</option>
									<option value="UVBCHHĐ">Ủy viên BCH HĐ</option>
									
									<option value="BTĐX">Bí thư ĐX</option>
									<option value="PBTĐX">Phó bí thư ĐX</option>
									<option value="UVBCHĐX">Ủy viên BCH ĐX</option>
									
									<option value="BTCĐ">Bí thư CĐ</option>
									<option value="PBTCĐ">Phó bí thư CĐ</option>
									<option value="UVBCHCĐ">Ủy viên BCH CĐ</option>
								</select>
							</div>
							<div class="col-md-4 col-sm-12 col-xs-12 date fm-input">
								<p>Ngày vào Đảng</p>
								<div class="input-group" id="ngayvaodang">
									<input id="day_on_party" type='text' name="day_on_party" 
										class="form-control" placeholder="Ngày vào Đảng"><span
										id="span-date-1" class="input-group-addon"> <span
										class="glyphicon glyphicon-calendar"></span>
									</span>
								</div>
							</div>
							<div class="col-md-4 col-sm-12 col-xs-12 fm-input">
								<p>
									Dân tộc <span class='format-star'> *</span>
								</p>
								<select name="nation" class="form-control" id="nation" required>
									<option value="">--Chọn dân tộc --</option>
									<option value="Kinh">Kinh</option>
									<option value="Tày">Tày</option>
									<option value="Mường">Mường</option>
								</select>
							</div>
							<div class="col-md-4 col-sm-12 col-xs-12 fm-input">
								<p>
									Tôn giáo <span class='format-star'> *</span>
								</p>
								<select name="relligion" id="relligion" class="form-control" required>
									<option value="">--Chọn tôn giáo --</option>
									<option value="Không">Không</option>
									<option value="Thiên chúa giáo">Thiên chúa giáo</option>
									<option value="Phật giáo">Phật giáo</option>
								</select>
							</div>
							<div class="col-md-4 col-sm-12 col-xs-12 fm-input">
								<p>
									Nghề nghiệp <span class='format-star'> *</span>
								</p>
								<select name="job" id="job" class="form-control" required>
									<option value="">--Chọn nghề nghiệp --</option>
									<option value="1">Học sinh</option>
									<option value="2">Sinh viên</option>
									<option value="3">Kỹ sư</option>
								</select>
							</div>
							<div class="col-md-4 col-sm-12 col-xs-12 fm-input">
								<p>
									Tỉnh/Thành phố <span class='format-star'> *</span>
								</p>
								<select id="province" name="province" class="form-control"
									required>
									<option value="" disabled="disabled" selected="selected">--Chọn
										tỉnh/thành phố --</option>
									<c:forEach items="${listProvince}" var="province">
										<option value="${province.provinceId }">${province.name }</option>
									</c:forEach>
								</select>
							</div>
							<div class="col-md-4 col-sm-12 col-xs-12 fm-input">
								<p>
									Huyện/TP/Thị xã <span class='format-star'> *</span>
								</p>
								<select name="district" id="district" class="form-control"
									required>
									<option value="" disabled="disabled" selected="selected">--Chọn
										huyện/thị xã --</option>
								</select>
							</div>
							<div class="col-md-4 col-sm-12 col-xs-12 fm-input">
								<p>
									Xã/phường/thị trấn <span class='format-star'> *</span>
								</p>
								<select name="town" class="form-control" id="town" required>
									<option value="" disabled="disabled" selected="selected">--Chọn
										xã/phường/thị trấn --</option>
								</select>
							</div>
							<div class="col-md-4 col-sm-12 col-xs-12 fm-input">
								<p>
									Thôn/xóm <span class='format-star'> *</span>
								</p>
								<input placeholder="Thôn xóm" type="text" name="village" id="village"
									class="form-control" value="" required="required">
							</div>
						</div>
						
					</div>
					<div class="col-md-10 col-md-offset-2">
							<div class="col-md-5 col-sm-12 col-xs-12 fm-input" id="note-star">
								<p>
									<span class='format-star'> (*)</span> Những trường này không
									được bỏ trống !
								</p>
							</div>
							<div class="col-md-6 col-sm-12 col-xs-12 fm-input">
								<a id="btn-add" class="btn btn-primary pull-right">Thêm mới</a>
							</div>
						</div>
				</form>
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
	$(document).ready(function() {

						$('#ngayvaodoan').datetimepicker({
							format : 'YYYY-MM-DD',
							 maxDate: moment()
						});
						$('#ngayvaodang').datetimepicker({
							format : 'YYYY-MM-DD',
						    maxDate: moment()
						});
						$('#ngaysinh').datetimepicker({
							format : 'YYYY-MM-DD',
							maxDate: moment()
						});
						var contextPath = "${pageContext.request.contextPath}";
						$("#btn-add").on('click',function(){
							var email = $("#email").val();
							var code_unionist = $("#code_unionist").val();
							 $.ajax({
					              type: "POST",
					              url: contextPath+"/quanlydoanvien",
					              data:{
					            	  email: email,
					            	  code_unionist:code_unionist,
					            	  action:'check1'
					              },
					              dataType : 'json',
					              success: function(res)
					              {
					            	var email= res.email;
					            	var code = res.code;
					            	
					               	if(email==false||code==false){
					               		if(email==false){
					               			toastr.error("Email đã tồn tại trong hệ thống !");
					               		}
					               		if(code==false){
					               			toastr.error("Mã đoàn viên đã tồn tại trong hệ thống !");
					               		}
					               	}else{
					               		toastr.success("Thêm mới thành công !",{timeOut:1000});
					               		setTimeout(function(){ $("#frm-add").submit();}, 1000);
					               	}
					              },
					              error: function (xhr, ajaxOptions, thrownError) {
					                toastr.error(thrownError);
					              }
					        });   
							
						});
						
						$('#province').change(function() {
							$("#district").html("");
							var provinceId = $('select#province option:selected').val(); //Lay ra gia tri cua tỉnh
											$.ajax({
														url :  contextPath+'/quanlydoanvien/themmoi',
														data: $.param({
													        provinceId: provinceId
													    }), // dữ liêu đẩy lên
														error : function() {
															// thực hiện thông báo nếu có lỗi trả về
														},
														contentType: "application/x-www-form-urlencoded; charset=UTF-8;",
														dataType : 'json', // kiểu dữ liệu đẩy lên là json
														success : function(data) {
															$("#district").append("<option value='' disabled='disabled' selected='selected'>--Chọn huyện/thị xã</option>");
															var districtId = $("#districtId").val();
															$.each(data,function(key,item) {
																$("#district").append("<option value='"+item['districtId']+"'>"+ item['name']+ "</option>");});

														},
														type : 'POST' // phương thức sử dụng gửi lên POST hay GET ...
													});
										});
						$('#district')
								.change(
										function() {
											$("#town").html("");
											var districtId = $(
													'select#district option:selected')
													.val(); //Lay ra gia tri cua huyện
											$
													.ajax({
														url : contextPath+ '/quanlydoanvien/themmoi',
														data : {
															districtId : $(
																	'select#district option:selected')
																	.val()
														}, // dữ liêu đẩy lên
														error : function() {
															// thực hiện thông báo nếu có lỗi trả về
														},
														contentType: "application/x-www-form-urlencoded; charset=UTF-8;",
														dataType : 'json', // kiểu dữ liệu đẩy lên là json
														success : function(
																datatown) {
															$("#town")
																	.append(
																			"<option value='' disabled='disabled' selected='selected'>--Chọn xã/phường/thị trấn</option>");
															$
																	.each(
																			datatown,
																			function(
																					key,
																					item) {
																				$(
																						"#town")
																						.append(
																								"<option value='"+item['townId']+"'>"
																										+ item['name']
																										+ "</option>");
																			});

														},
														type : 'POST' // phương thức sử dụng gửi lên POST hay GET ...
													});
										});

					});
</script>

