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
		<h1>Quản lý đoàn viên</h1>
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i> Trang chủ</a></li>
			<li><a href="#"> Danh mục quản lý</a></li>
			<li class="active">Quản lý đoàn viên</li>
		</ol>
	</section>
	<!-- Main content -->
	<section class="content">

		<!-- Default box -->
		<div class="box">
			<div class="box-header with-border">
				<h3 class="box-title">Danh sách các đoàn viên trực thuộc </h3>

			</div>
			<div class="box-body">
			<c:forEach items="${sessionScope.listPerRoleUni}" var="permis">
			<c:if test="${permis.permission_id ==6}">
				<a id='themDonVi' class='btn btn-primary' data-toggle="modal"
					href='<%=request.getContextPath()%>/quanlydoanvien/themmoi'
					title='Thêm mới'><i class="fa fa-plus" aria-hidden="true"></i>
					THÊM MỚI</a>
				<div class="fileUpload btn btn-warning">
					<form action="<%=request.getContextPath()%>/readfileexcelunionist"
						method="post" id="formImport" enctype="multipart/form-data">
						<span><i class="fa fa-upload" aria-hidden="true"></i>
							Import file Excel</span> <input id="fileImport" name="fileImport"
							accept="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"
							type="file" class="upload" />
					</form>
				</div>
			</c:if>
			</c:forEach>
				<table class="table table-striped table-responsive table-hover"
					id='tabledoanvien'>
					<thead>
						<tr>
							<th>Mã ĐV</th>
							<th>Họ và tên</th>
							<th>Email</th>
							<th>Ngày vào đoàn</th>
							<th>Nơi vào đoàn</th>
							<th>Đơn vị</th>
							<th id="actionNotFilter">Hành động</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listUnionist}" var='unionist'>
							<tr>
								<td id="code"><c:out value="${unionist.code}"></c:out> </td>
								<input type="hidden" value="${unionist.code}">
								<td id="name"><c:out value="${unionist.name}"></c:out></td>
								<td><c:out value="${unionist.email}"></c:out></td>
								<td id="dayonunionist"><c:out value="${unionist.day_on_unionist}"></c:out></td>
								<td id="addressonunionist"><c:out value="${unionist.address_on_unionist}"></c:out></td>
								<td><c:out value="${unionist.units_name}"></c:out></td>
								<td id=''><a class="btn btn-circle btn-xs btn-outline blue btn-show"
									href="#showinfocode${unionist.code}" id="${unionist.id}" title='Xem'
									data-toggle="modal"><i class="fa fa-eye" aria-hidden="true"></i>
										Chi tiết</a>
									<c:forEach items="${sessionScope.listPerRoleUni}" var="permis">
									<c:if test="${permis.permission_id ==7}">
									<a class="btn btn-circle btn-xs btn-outline purple"
									data-toggle="modal" href="#code${unionist.code}" title='Sửa'><i
										class="fa fa-pencil-square-o" aria-hidden="true"></i> Sửa</a> </c:if>
									<c:if test="${permis.permission_id ==8}">
								   <a
									class="btn btn-delete btn-circle btn-xs btn-outline red" href="javascript:;"
									title='Xóa'><i id="deleteUnit" class="fa fa-trash-o"
										aria-hidden="true"></i> Xóa</a> </c:if>
									<c:if test="${permis.permission_id ==34}">
									<a id="${unionist.id}" class="btn btn-circle btn-xs btn-outline purple btn-convert"
									 href="javascript:;" title='Chuyển đơn vị'><i class="fa fa-rocket" aria-hidden="true"></i> Chuyển ĐV</a>	
									</c:if>
									<c:if test="${permis.permission_id ==35}">
									 <a id="${unionist.id}" class="btn btn-circle btn-xs btn-outline green btn-bonuos"
									 href="javascript:;" title='Khen thưởng - Kỉ luật'><i class="fa fa-bookmark-o" aria-hidden="true"></i> Khen thưởng - Kỉ luật</a>	
									</c:if>				
									</c:forEach>	
							</td>
									
							</tr>
							<!-- Form edit -->
							<div class="modal fade"
								id="code<c:out value="${unionist.code}"></c:out>">
								<div style="width: 1000px;" class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal"
												aria-hidden="true">&times;</button>
											<h4 class="modal-title">Chỉnh sửa thông tin đoàn viên</h4>
										</div>
										<div class="modal-body" style="padding: 0px">
											<form action="<%=request.getContextPath()%>/quanlydoanvien?action=edit&code=${unionist.code}" method="POST" class="form-horizontal" role="form" id="frm-add" enctype="multipart/form-data">
											<div class="panel panel-body" style="margin-bottom: 0px;">
												<div id="file-upload-form"
													class="uploader col-md-4 col-sm-12 col-xs-12">
													<input id="file-upload" type="file" name="avata"
														accept="image/*" /> <label for="file-upload"
														id="file-drag"> <img id="file-image"
														src="${unionist.avata}" alt="Preview" class="">
														<div id="start">
															<i style="display: none;" class="fa fa-picture-o" aria-hidden="true"></i>
															<div style="display: none;">Select a file or drag here</div>
															<div  style="display: none;" id="notimage" class="hidden">Please select an
																image</div>
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
												<div class="col-md-9">
													<div class="col-md-4 col-sm-12 col-xs-12 fm-input">
														<p>
															Họ và tên<span class='format-star'> *</span>
														</p>
														<input type="text" name="name" id="" class="form-control"
															value="<c:out value="${unionist.name}"></c:out>"
															required="required" title="" placeholder="Họ và tên">
													</div>

													<div class="col-md-4 col-sm-12 col-xs-12 fm-input">
														<p>
															Giới tính <span class='format-star'> *</span>
														</p>
														<c:if test="${unionist.gender=='Nam'}">
															<input type="radio" name="gender" id="" checked class="gender"
															value="Nam">Nam
															 <input type="radio" name="gender" id="" class="gender" value="Nữ" >Nữ 
															 <input type="radio" name="gender" id="" class="gender" value="Khác" >Khác
														</c:if>
														<c:if test="${unionist.gender=='Nữ'}">
															<input type="radio" name="gender" id=""  class="gender"
															value="Nam">Nam
															 <input type="radio" name="gender" id="" checked class="gender" value="Nữ" >Nữ 
															 <input type="radio" name="gender" id="" class="gender" value="Khác" >Khác
														</c:if>
														<c:if test="${unionist.gender=='Khác'}">
															<input type="radio" name="gender" id=""  class="gender"
															value="Nam">Nam
															 <input type="radio" name="gender" id=""  class="gender" value="Nữ" >Nữ 
															 <input type="radio" name="gender" id="" checked class="gender" value="Khác" >Khác
														</c:if>
													</div>
													<div class="col-md-4 col-sm-12 col-xs-12 date fm-input">
														<p>
															Ngày sinh <span class='format-star'> *</span>
														</p>
														<div class="input-group ngaysinh">
															<input id="" name="birthday" required="required"
																type='text' class="form-control" placeholder="Ngày sinh"
																value="<c:out value="${unionist.birthday}"></c:out>">
															<span class="input-group-addon"> <span
																class="glyphicon glyphicon-calendar"></span>
															</span>
														</div>
													</div>
													<div class="col-md-4 col-sm-12 col-xs-12 fm-input">
														<p>
															Email <span class='format-star'> *</span>
														</p>
														<input readonly="readonly" placeholder="Email" type="email" name="email" id=""
															class="form-control input-lname"
															value="<c:out value="${unionist.email}"></c:out>"
															required="required">
													</div>
													<div class="col-md-4 col-sm-12 col-xs-12 fm-input">
														<p>
															Điện thoại <span class='format-star'> *</span>
														</p>
														<input placeholder="Điện thoại" type="number" name="phone"
															id="" class="form-control input-lname"
															value="<c:out value='${unionist.phone}'></c:out>"
															required="required">
													</div>
													<div class="col-md-4 col-sm-12 col-xs-12 fm-input">
														<p>
															Quê quán <span class='format-star'> *</span>
														</p>
														<input placeholder="Quê quán" type="text" name="home_town"
															id="" class="form-control"
															value="<c:out value="${unionist.home_town}"></c:out>"
															required="required">
													</div>
													<div class="col-md-4 col-sm-12 col-xs-12 fm-input">
														<p>
															Trình độ học vấn <span class='format-star'> *</span>
														</p>
														<input placeholder="Trình độ học vấn" type="text"
															name="academic_level" id="" class="form-control"
															value="<c:out value="${unionist.academic_level}"></c:out>"
															required="required">
													</div>
													<div class="col-md-4 col-sm-12 col-xs-12 fm-input">
														<p>Trình độ chuyên môn</p>
														<input placeholder="Trình độ chuyên môn" type="text"
															name="qualification" id="" class="form-control"
															value="<c:out value="${unionist.qualification}"></c:out>">
													</div>
													<div class="col-md-4 col-sm-12 col-xs-12 fm-input">
														<p>
															Trình độ lý luận chính trị <span class='format-star'>
																*</span>
														</p>
														<select name="political_theory" class="form-control"
															required="required">
															<c:if test="${unionist.political_theory=='Cao cấp'}">
																<option value="">--Chọn trình độ --</option>
																<option value="Cao cấp" selected="selected">Cao cấp</option>
																<option value="Trung cấp">Trung cấp</option>
																<option value="Sơ cấp">Sơ cấp</option>
																<option value="Phổ cập">Phổ cập</option>
																<option value="Không">Không</option>
															</c:if>
															<c:if test="${unionist.political_theory=='Trung cấp'}">
																<option value="">--Chọn trình độ --</option>
																<option value="Cao cấp" >Cao cấp</option>
																<option value="Trung cấp" selected="selected">Trung cấp</option>
																<option value="Sơ cấp">Sơ cấp</option>
																<option value="Phổ cập">Phổ cập</option>
																<option value="Không">Không</option>
															</c:if>
															<c:if test="${unionist.political_theory=='Sơ cấp'}">
																<option value="">--Chọn trình độ --</option>
																<option value="Cao cấp" >Cao cấp</option>
																<option value="Trung cấp" >Trung cấp</option>
																<option value="Sơ cấp" selected="selected">Sơ cấp</option>
																<option value="Phổ cập">Phổ cập</option>
																<option value="Không">Không</option>
															</c:if>
															<c:if test="${unionist.political_theory=='Phổ cập'}">
																<option value="">--Chọn trình độ --</option>
																<option value="Cao cấp" >Cao cấp</option>
																<option value="Trung cấp" >Trung cấp</option>
																<option value="Sơ cấp" >Sơ cấp</option>
																<option value="Phổ cập" selected="selected">Phổ cập</option>
																<option value="Không">Không</option>
															</c:if>
															<c:if test="${unionist.political_theory=='Không'}">
																<option value="">--Chọn trình độ --</option>
																<option value="Cao cấp" >Cao cấp</option>
																<option value="Trung cấp" >Trung cấp</option>
																<option value="Sơ cấp" >Sơ cấp</option>
																<option value="Phổ cập" >Phổ cập</option>
																<option value="Không" selected="selected">Không</option>
															</c:if>
														</select>
													</div>
													<div class="col-md-4 col-sm-12 col-xs-12 fm-input">
														<p>
															Mã thẻ đoàn <span class='format-star'> *</span>
														</p>
														<input placeholder="Mã thẻ đoàn" type="text"
															name="code_unioinist" id="" class="form-control"
															readonly="readonly"
															value="<c:out value="${unionist.code_unionist}"></c:out>"
															required="required">
													</div>
													<div class="col-md-4 col-sm-12 col-xs-12 date fm-input">
														<p>
															Ngày vào đoàn <span class='format-star'> *</span>
														</p>
														<div class="input-group ngayvaodoan">
															<input id="" name="day_on_unionist" required="required"
																type='text' class="form-control"
																placeholder="Ngày vào Đoàn"
																value="<c:out value="${unionist.day_on_unionist}"></c:out>"><span
																id="span-date-1" class="input-group-addon"> <span
																class="glyphicon glyphicon-calendar"></span>
															</span>
														</div>
													</div>
													<div class="col-md-4 col-sm-12 col-xs-12 fm-input">
														<p>
															Nơi vào đoàn <span class='format-star'> *</span>
														</p>
														<input placeholder="Nơi vào đoàn" type="text"
															name="address_on_unionist" id="" class="form-control"
															value="<c:out value="${unionist.address_on_unionist}"></c:out>"
															required="required">
													</div>


													<div class="col-md-4 col-sm-12 col-xs-12 fm-input">
														<p>
															Chức vụ Đoàn 
														</p>
														<select name="competence" class="form-control">
														<c:if test="${unionist.competence=='BTCĐ'}">
															<option value="">--Chọn chức vụ --</option>
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

															<option value="BTCĐ" selected="selected">Bí thư CĐ</option>
															<option value="PBTCĐ">Phó bí thư CĐ</option>
															<option value="UVBCHCĐ">Ủy viên BCH CĐ</option>
														</c:if>
														<c:if test="${unionist.competence=='BTĐX'}">
															<option value="">--Chọn chức vụ --</option>
															<option value="BTTWĐ">Bí thư TWĐ</option>
															<option value="PBTTWĐ">Phó bí thư TWĐ</option>
															<option value="UVBCHTWĐ">Ủy viên BCH TWĐ</option>

															<option value="BTTĐ">Bí thư TĐ</option>
															<option value="PBTTĐ">Phó bí thư TĐ</option>
															<option value="UVBCHTĐ">Ủy viên BCH TĐ</option>

															<option value="BTCĐHĐ">Bí thư HĐ</option>
															<option value="PBTCĐHĐ">Phó bí thư HĐ</option>
															<option value="UVBCHHĐ">Ủy viên BCH HĐ</option>

															<option value="BTĐX" selected="selected">Bí thư ĐX</option>
															<option value="PBTĐX">Phó bí thư ĐX</option>
															<option value="UVBCHĐX">Ủy viên BCH ĐX</option>

															<option value="BTCĐ" >Bí thư CĐ</option>
															<option value="PBTCĐ">Phó bí thư CĐ</option>
															<option value="UVBCHCĐ">Ủy viên BCH CĐ</option>
														</c:if>
														</select>
													</div>
													<div class="col-md-4 col-sm-12 col-xs-12 date fm-input">
														<p>Ngày vào Đảng</p>
														<div class="input-group ngayvaodang">
															<input id="" type='text' name="day_on_party"
																class="form-control" placeholder="Ngày vào Đảng"
																value="<c:out value="${unionist.day_on_party}"></c:out>"><span
																id="span-date-1" class="input-group-addon"> <span
																class="glyphicon glyphicon-calendar"></span>
															</span>
														</div>
													</div>
													<div class="col-md-4 col-sm-12 col-xs-12 fm-input">
														<p>
															Dân tộc <span class='format-star'> *</span>
														</p>
														<select name="nation" class="form-control" required>
														<c:if test="${unionist.nation=='Kinh'}">
															<option value="">--Chọn dân tộc --</option>
															<option value="Kinh" selected="selected">Kinh</option>
															<option value="Tày">Tày</option>
															<option value="Mường">Mường</option>
														</c:if>
														<c:if test="${unionist.nation=='Tày'}">
															<option value="">--Chọn dân tộc --</option>
															<option value="Kinh" >Kinh</option>
															<option value="Tày" selected="selected">Tày</option>
															<option value="Mường">Mường</option>
														</c:if>
														<c:if test="${unionist.nation=='Mường'}">
															<option value="">--Chọn dân tộc --</option>
															<option value="Kinh" >Kinh</option>
															<option value="Tày">Tày</option>
															<option value="Mường" selected="selected">Mường</option>
														</c:if>
														</select>
													</div>
													<div class="col-md-4 col-sm-12 col-xs-12 fm-input">
														<p>
															Tôn giáo <span class='format-star'> *</span>
														</p>
														<select name="relligion" class="form-control" required>
															<c:if test="${unionist.religion=='Không'}">
																<option value="">--Chọn tôn giáo --</option>
																<option value="Không" selected="selected">Không</option>
																<option value="Thiên chúa giáo">Thiên chúa giáo</option>
																<option value="Phật giáo">Phật giáo</option>
															</c:if>
															<c:if test="${unionist.religion=='Phật giáo'}">
																<option value="">--Chọn tôn giáo --</option>
																<option value="Không" >Không</option>
																<option value="Thiên chúa giáo">Thiên chúa giáo</option>
																<option value="Phật giáo" selected="selected">Phật giáo</option>
															</c:if>
															<c:if test="${unionist.religion=='Thiên chúa giáo'}">
																<option value="">--Chọn tôn giáo --</option>
																<option value="Không">Không</option>
																<option value="Thiên chúa giáo" selected="selected">Thiên chúa giáo</option>
																<option value="Phật giáo">Phật giáo</option>
															</c:if>
															
														</select>
													</div>
													<div class="col-md-4 col-sm-12 col-xs-12 fm-input">
														<p>
															Nghề nghiệp <span class='format-star'> *</span>
														</p>
														<select name="job" class="form-control" required>
															
															<!-- <option value="">--Chọn nghề nghiệp --</option> -->
															<option value="1">Học sinh</option>
															<option value="2">Sinh viên</option>
															<option value="3">Kỹ sư</option>
															<option value="4">Bác sỹ</option>
														</select>
													</div>
													<div class="col-md-4 col-sm-12 col-xs-12 fm-input">
														<p>
															Tỉnh/Thành phố <span class='format-star'> *</span>
														</p>
														<select id="province"name="province" class="form-control" required>
															<option value="" disabled="disabled" selected="selected">--Chọn
																tỉnh/thành phố --</option>
															<c:forEach items="${listProvince}" var="province">
																<option <c:if test="${unionist.provinceId==province.provinceId }">selected</c:if>  value="${province.provinceId }">${province.name }</option>
															</c:forEach>
														</select>
													</div>
													<div class="col-md-4 col-sm-12 col-xs-12 fm-input">
														<p>
															Huyện/TP/Thị xã <span class='format-star'> *</span>
														</p>
														<select id="district" name="district" id="input" class="form-control"
															required>
															<option value="">--Chọn huyện/thị xã --</option>
														</select>
													</div>
													<div class="col-md-4 col-sm-12 col-xs-12 fm-input">
														<p>
															Xã/phường/thị trấn <span class='format-star'> *</span>
														</p>
														<select id="town" name="town" class="form-control" required>
															<option value="">--Chọn xã/phường --</option>
														</select>
													</div>
													<div class="col-md-4 col-sm-12 col-xs-12 fm-input">
														<p>
															Thôn/xóm <span class='format-star'> *</span>
														</p>
														<input placeholder="Thôn xóm" type="text" name="village"
															id="" class="form-control"
															value="<c:out value="${unionist.village}"></c:out>"
															required="required">
													</div>
												</div>
											</div>
											<div class="modal-footer col-md-offset-3"
												style="text-align: center">
												<button type="submit" name='editUnioinist'
													class="btn btn-primary">Cập nhật</button>
											</div>
											</form>
										</div>
									</div>
								</div>
							</div>
							<!-- Hết form edit -->

							<!-- show info doan vien -->
							<div class="modal fade"
								id="showinfocode<c:out value="${unionist.code}"></c:out>">
								<div style="width: 800px;" class="modal-dialog">
									<input id="id" value="<c:out value='${unionist.id}'></c:out>" type='hidden'>
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal"
												aria-hidden="true">&times;</button>
											<h4 class="modal-title">Chi tiết thông tin đoàn viên</h4>
										</div>
										<div class="modal-body" style="padding: 0px">
											<div class="col-md-12" style="padding: 0px;">
												<!-- Widget: user widget style 1 -->
												<div class="box box-widget widget-user">
													<!-- Add the bg color to the header using any of the bg-* classes -->
													<div class="widget-user-header bg-black"
														style="background: url('<%=request.getContextPath()%>/dist/img/photo1.png') center center;">
														<h3 class="widget-user-username">${unionist.name }</h3>
														<h5 class="widget-user-desc">Email: ${unionist.email}</h5>
													</div>
													<div class="widget-user-image">
														<img class="img-circle" src="<%=request.getContextPath() %>/${unionist.avata}"
															alt="User Avatar">
													</div>
													<div class="box-footer">
														<div class="row">
															<div class="col-sm-4 border-right">
																<div class="description-block">
																	<h5 class="description-header">
																		<c:out value="${unionist.units_name}"></c:out>
																	</h5>
																	<span class="description-text">Đơn vị</span>
																</div>
																<!-- /.description-block -->
															</div>
															<!-- /.col -->
															<div class="col-sm-4 border-right">
																<div class="description-block">
																	<h5 class="description-header">
																		<c:out value="${unionist.code_unionist}"></c:out>
																	</h5>
																	<span class="description-text">Mã số đoàn viên</span>
																</div>
																<!-- /.description-block -->
															</div>
															<!-- /.col -->
															<div class="col-sm-4">
																<div class="description-block">
																	<h5 id="" class="status-pay description-header"></h5>
																	<span class="description-text">ĐOÀN PHÍ</span>
																</div>
																<!-- /.description-block -->
															</div>
															<!-- /.col -->
														</div>
														<!-- /.row -->
													</div>
												</div>
												<!-- /.widget-user -->
											</div>
											<div class="panel panel-body">
												<div class="col-md-12" id="detailInfo">
													<div class="col-md-4">
														<strong>Ngày sinh: </strong><span><c:out
																value="${unionist.birthday}"></c:out> </span>
													</div>
													<div class="col-md-4">
														<strong>Giới tính: </strong><span><c:out
																value="${unionist.gender}"></c:out> </span>
													</div>
													<div class="col-md-4">
														<strong>Số điện thoại: </strong><span><c:out
																value="${unionist.phone}"></c:out> </span>
													</div>
													<div class="col-md-4">
														<strong>Quê quán: </strong><span><c:out
																value="${unionist.home_town}"></c:out> </span>
													</div>
													<div class="col-md-4">
														<strong>Dân tộc: </strong><span><c:out
																value="${unionist.nation}"></c:out> </span>
													</div>
													<div class="col-md-4">
														<strong>Tôn giáo: </strong><span><c:out
																value="${unionist.religion}"></c:out> </span>
													</div>
													<div class="col-md-4">
														<strong>Trình độ học vấn: </strong><span><c:out
																value="${unionist.academic_level}"></c:out> </span>
													</div>
													<div class="col-md-4">
														<strong>Trình độ chuyên môn: </strong><span><c:out
																value="${unionist.qualification}"></c:out> </span>
													</div>
													<div class="col-md-4">
														<strong>Trình độ lý luận chính trị: </strong><span><c:out
																value="${unionist.political_theory}"></c:out> </span>
													</div>
													<div class="col-md-4">
														<strong>Chức vụ: </strong><span><c:out
																value="${unionist.competence}"></c:out> </span>
													</div>
													<div class="col-md-4">
														<strong>Ngày vào Đoàn: </strong><span><c:out
																value="${unionist.day_on_unionist}"></c:out> </span>
													</div>
													<div class="col-md-4">
														<strong>Nơi vào Đoàn: </strong><span><c:out
																value="${unionist.address_on_unionist}"></c:out> </span>
													</div>

													<div class="col-md-4">
														<strong>Ngày vào Đảng: </strong><span><c:out
																value="${unionist.day_on_party}"></c:out> </span>
													</div>
													<div class="col-md-4">
														<strong>Nghề nghiệp: </strong><span></span>
													</div>
													<div class="col-md-12">
														<strong>Nơi ở hiện nay: </strong><span><c:out
																value="${unionist.village}"></c:out> <c:out value=" - "></c:out>
															<c:out value="${unionist.townName}"></c:out> <c:out
																value=" - "></c:out> <c:out
																value="${unionist.districtName}"></c:out> <c:out
																value=" - "></c:out> <c:out
																value="${unionist.provinceName}"></c:out></span>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<!-- hết show info doan vien -->
						</c:forEach>
					</tbody>
				</table>
			</div>
			<!-- start form covert unionist -->
			<div class="modal fade" id="modal-convert">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title">THÔNG TIN ĐƠN VỊ CHUYỂN ĐẾN</h4>
				</div>
				<div class="modal-body">
					<form action="" method="post" name="frm-convert" id="frm-convert" accept-charset="utf-8" enctype="multipart/form-data">
							<strong>Mã đoàn viên: </strong>&nbsp&nbsp<span id="code_unionist"></span><br>
							<strong>Họ tên ĐV: </strong><span id="name_unionist"></span><br>
							<strong>Ngày vào đoàn: </strong><span id="day_on_unionist"></span><br>
							<strong>Nơi vào đoàn: </strong><span id="add_on_unionist"></span><br>
							<strong>Tình trạng đóng đoàn phí: </strong><span id="status-pay"></span><br>
							<strong> Đơn vị đến </strong><span style='color: red;'>*</span> <select required
							name='selectUnit' class="form-control" id="selectUnit">
							<option value="" disabled="disabled" selected="selected">--Chọn đơn vị chuyển đến--</option>
						</select>
						<div class="modal-footer">
							<button type="submit" name='convertUnionist' class="btn btn-primary btn-sm-convert"> Chuyển</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

			<!-- finish form covert unionist -->
			
			<!-- start form bonuos -->
			<div class="modal fade" id="modal-bonuos">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title">KHEN THƯỞNG - KỶ LUẬT</h4>
				</div>
				<div class="modal-body">
					<form action="" method="post" name="" id="frm-bonuos" accept-charset="utf-8" enctype="multipart/form-data">
							Hình thức: <span style='color: red;'>*</span><input type="radio" name="hinhthuc" id="" value="0" checked="checked">Khen thưởng<input type="radio" name="hinhthuc" id="" value="1">Kỷ luật
							<br>Mã đoàn viên: <span style='color: red;'>*</span><input readonly="readonly" type="text" name="code" class="form-control" value="" id="madoanvien"/>
							Họ tên đoàn viên: <span style='color: red;'>*</span><input readonly="readonly" type="text" name="name" class="form-control" value="" id="tendoanvien"/>
							Số quyết định: <span style='color: red;'>*</span><input placeholder="Số quyết định" type="text" class="form-control" value="" id="soquyetdinh" name="soquyetdinh">
								<p>
										Ngày ra quyết định <span class='format-star'> *</span>
							   </p>
									<div class="input-group" id="ngayraquyetdinh">
										<input id="date" name="date"
											type='text' class="form-control" placeholder="Ngày ra quyết định">
										<span class="input-group-addon" id="span-date-1"> <span
											class="glyphicon glyphicon-calendar"></span>
										</span>
									</div>
							Nội dung: <span style='color: red;'>*</span><textarea placeholder="Nội dung" type="text" class="form-control" value="" id="noidung" name="noidung"></textarea>
						
						`<div class="modal-footer">
							<button type="submit" name='' class="btn btn-primary btn-sm-bonuos">Lưu</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

			<!-- finish form bonuos -->
			<!-- /.box-body -->
			
		</div>
		<!-- /.box -->

	</section>
	<!-- /.content -->
</div>
<!-- /.content-wrapper -->

<%@include file="footer.jsp"%>
<script type="text/javascript">
	
	document.getElementById("fileImport").onchange = function() {
		swal({
			title : "Bạn có muốn import file Excel này ?",
			type : "warning",
			showCancelButton : true,
			confirmButtonColor : "#e84242",
			cancelButtonText : "Không",
			confirmButtonText : "Có",
		}, function(isConfirm) {
			if (isConfirm) {
				document.getElementById("formImport").submit();
			}

		});

	};
	$(document).ready(function() {
		var contextPath = "${pageContext.request.contextPath}";
		$('.ngayvaodoan').datetimepicker({
			format : 'YYYY-MM-DD',
			 maxDate: moment()
		});
		$('.ngayvaodang').datetimepicker({
			format : 'YYYY-MM-DD',
			 maxDate: moment()
		});
		$('.ngaysinh').datetimepicker({
			format : 'YYYY-MM-DD',
			 maxDate: moment()
		});
		$('#ngayraquyetdinh').datetimepicker({
			format : 'YYYY-MM-DD',
			 maxDate: moment()
		});
		//Xử lý form khen thưởng kỉ luật
		$("#tabledoanvien").on('click','.btn-bonuos',function(){
			$("#modal-bonuos").modal('show');
			var id = $(this).attr('id');
			var madoanvien = $(this).parent().prevAll("#code").html();
			$("#madoanvien").val(madoanvien);
			var tendoanvien = $(this).parent().prevAll("#name").html();
			$("#tendoanvien").val(tendoanvien);
			$('#frm-bonuos').validate({ 
		          errorElement: "span",
		          rules: {
		            soquyetdinh : {
		              required : true,
		              
		            },
		            noidung : {
		              required :true,
		            },
		            ngayraquyetdinh:{
		            	required :true
		            },
		            date:{
		            	required :true
		            },
		            
		          },
		          messages: {
		        	  soquyetdinh : {
		              required : "Vui lòng nhập số quyết định.",
		            },
		            noidung : {
		              required :"Vui lòng nhập nội dung.",
		            },
		            date:{
		            	required :"Vui lòng ngày ra quyết định"
		            }
		          }
			}); 
			$('#frm-bonuos').on('submit', function(e) {
				e.preventDefault();
				var form = $('#frm-bonuos');
				var formData = form.serialize();
				if(! form.valid()) return false;
				$.ajax({
					type : 'POST',
					url : contextPath + "/bonuosdiscipline",
					data :
						formData,
					success : function(data) {
						if (!data.error) {
							toastr.success("Lưu thành công ");
							$('#modal-bonuos').modal('hide');
							$("#frm-bonuos").reset();
						} else {
							if (!IsNull(data.message.name)) {
								toastr.error(data.message.name[0]);
							}
							if (!IsNull(data.message.display_name)) {
								toastr.error(data.message.display_name[0]);
							}

						}

					},
					error : function(xhr, ajaxOptions, thrownError) {

						toastr.error(thrownError);
					}
				});

			});
			});
		});
		//Hết xử lý form khen thưởng kỉ luật
		
		
		
		 //Xử lý chuyển đoàn viên
		 var contextPath = "${pageContext.request.contextPath}";
			$("#tabledoanvien").on('click','.btn-delete',function(){
			var code = $(this).parent().parent().find("td:eq(0)").html(); 
			swal({
			        title: "Bạn có chắc chắn xóa đoàn viên này ?",
			        type: "warning",
			        showCancelButton: true,
			        confirmButtonColor: "#e84242",
			        cancelButtonText: "Không",
			        confirmButtonText: "Có",
			    },
			    function(isConfirm) {
			        if (isConfirm) {  
				        $.ajax({
				              type: "GET",
				              url: contextPath+"/quanlydoanvien",
				              data:{
				            	  action:'delete',
				            	  id:code
				              },
				              dataType : 'json',
				              success: function(res)
				              {
				                if(!res.error) {
				                	toastr.success("Xóa thành công !");
				                	location.reload();
									//table.ajax.reload(); 
				                }
				              },
				              error: function (xhr, ajaxOptions, thrownError) {
				                toastr.error(thrownError);
				              }
				        });   
			        } 
			    });
		    });
		$("#tabledoanvien").on('click','.btn-convert',function(){
			$('#modal-convert').modal('show');
			$("#selectUnit").html("");
			var id = $(this).attr('id');
			var year = (new Date).getFullYear();
			var month = (new Date).getMonth() +1;
			var code_unionist = $(this).parent().prevAll("#code").html();
			$("#code_unionist").html(code_unionist);
			var name_unionist = $(this).parent().prevAll("#name").html();
			$("#name_unionist").html(name_unionist);
			var day_on_unionist = $(this).parent().prevAll("#dayonunionist").html();
			$("#day_on_unionist").html(day_on_unionist);
			var add_on_unionist = $(this).parent().prevAll("#addressonunionist").html();
			$("#add_on_unionist").html(add_on_unionist); 
			  $.ajax({
	              type: "POST",
	              url: contextPath+"/quanlydoanvien",
	              data:{
	            	year: year,
	            	id:id,
	            	action:'check'
	              },
	              success: function(res)
	              {
	            	if(res>month){
	            		$("#status-pay").html("Đã hoàn thành.");
	            		
	            	}else{
	            		 $("#status-pay").html("Chưa hoàn thành.");
	            		 $('.btn-sm-convert').prop('disabled', true);
	            	}
	              },
	              error: function (xhr, ajaxOptions, thrownError) {
	                toastr.error(thrownError);
	              }
	        });
			  $.ajax({
	              type: "POST",
	              url: contextPath+"/quanlydoanvien",
	              data:{
	            	action:'loadunits'
	              },
	              contentType: "application/x-www-form-urlencoded; charset=UTF-8;",
	              success: function(res)
	              {
	            	  $("#selectUnit").append("<option value='' disabled='disabled' selected='selected'>--Chọn đơn vị--</option>");
	            	  $.each(res.data, function (key, item) {
	            	  $("#selectUnit").append("<option value='"+item.id+"'>"+ item.name+ "</option>"); });
	              },
	              error: function (xhr, ajaxOptions, thrownError) {
	                toastr.error(thrownError);
	              }
	        });
		});
		$("#tabledoanvien").on('click','.btn-show',function(){
			var contextPath = "${pageContext.request.contextPath}";
			var id = $(this).attr('id');
			var year = (new Date).getFullYear();
			var month = (new Date).getMonth() +1;
			  $.ajax({
	              type: "POST",
	              url: contextPath+"/quanlydoanvien",
	              data:{
	            	year: year,
	            	id:id,
	            	action:'check'
	              },
	              success: function(res)
	              {
	            	if(res>month){
	            		$(".status-pay").html("Đã hoàn thành");
	            	}else{
	            		$(".status-pay").html("Chưa hoàn thành");
	            	}
	              },
	              error: function (xhr, ajaxOptions, thrownError) {
	                toastr.error(thrownError);
	              }
	        });
		});
		var contextPath = "${pageContext.request.contextPath}";
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
											$("#town").append(
															"<option value='' disabled='disabled' selected='selected'>--Chọn xã/phường/thị trấn</option>");
											$.each(datatown,function(key,item) {$("#town").append("<option value='"+item['townId']+"'>"+ item['name']+ "</option>");});

										},
										type : 'POST' // phương thức sử dụng gửi lên POST hay GET ...
									});
						});
     
		$('#frm-convert').on('submit', function(e){
				     	e.preventDefault();
						var code_unionist = $("#code_unionist").html();
						var units_id_new = $('select#selectUnit option:selected').val();
						var units_name_new = $('select#selectUnit option:selected').html();
								 $.ajax({
								        type:'POST',
								        url: contextPath+"/gioithieusinhhoat",
								        data: {
								        	action:"introduce",
								        	code_unionist:code_unionist,
								        	units_id_new:units_id_new,
								        	units_name_new:units_name_new
								        },
								        success:function(data){

								            if(!data.error) {

								                toastr["success"]("Chuyển thành công. Đang chờ xét duyệt !"); 
								            
								                $('#modal-convert').modal('hide');

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
</script>

