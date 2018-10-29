<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<aside class="main-sidebar">
	<!-- sidebar: style can be found in sidebar.less -->
	<section class="sidebar">
		<!-- Sidebar user panel -->
		<div class="user-panel">
			<div class="pull-left image">
				<img src="<c:out value="${sessionScope.avata}"></c:out>"
					class="img-circle" alt="User Image">
			</div>
			<div class="pull-left info">
				<p>
					<c:out value="${sessionScope.name}"></c:out>
				</p>
				<a href="#"><i class="fa fa-circle text-success"></i> Online</a>
			</div>
		</div>
		<!-- search form -->
		<form action="#" method="get" class="sidebar-form">
			<div class="input-group">
				<input type="text" name="q" class="form-control"
					placeholder="Search..."> <span class="input-group-btn">
					<button type="submit" name="search" id="search-btn"
						class="btn btn-flat">
						<i class="fa fa-search"></i>
					</button>
				</span>
			</div>
		</form>
		<!-- /.search form -->
		<!-- sidebar menu: : style can be found in sidebar.less -->
		<ul class="sidebar-menu" data-widget="tree">
			<li class="header">MAIN NAVIGATION</li>
			<li class="active treeview"><a
				href="<%=request.getContextPath()%>/index.jsp"> <i
					class="fa fa-dashboard"></i> <span>Bảng điều khiển</span>
			</a></li>
			<li class="treeview"><a href="#"> <i
					class="fa fa-building-o" aria-hidden="true"></i> <span>Danh
						mục chức năng</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu">
					<c:forEach items="${sessionScope.listPerRoleUni}" var="per">
						<c:if test="${per.permission_id ==26}">
							<li><a href="<%=request.getContextPath()%>/quanlydonvi"><i
									class="fa fa-university" aria-hidden="true"></i>Quản lý đơn vị</a></li>
						</c:if>
						<c:if test="${per.permission_id==27}">
							<li><a href="<%=request.getContextPath()%>/quanlydoanvien"><i
									class="fa fa-user"></i>Quản lý đoàn viên</a></li>
						</c:if>
						<c:if test="${per.permission_id ==28}">
							<li><a href="<%=request.getContextPath()%>/quanlydoanphi"><i
									class="fa fa-usd" aria-hidden="true"></i> Quản lý đoàn phí</a></li>
						</c:if>
						<c:if test="${per.permission_id ==29}">
							<li class="treeview"><a href="#"><i class="fa fa-money"
									aria-hidden="true"></i> Quản lý tài chính <span
									class="pull-right-container"> <i
										class="fa fa-angle-left pull-right"></i>
								</span> </a>
								<ul class="treeview-menu" style="display: none;">
									<li><a
										href="<%=request.getContextPath()%>/quanlytaichinh/khoanthu"><i
											class="fa fa-rocket" aria-hidden="true"></i> Khoản thu</a></li>
									<li><a
										href="<%=request.getContextPath()%>/quanlytaichinh/khoanchi"><i
											class="fa fa-rocket" aria-hidden="true"></i> Khoản chi</a></li>
								</ul></li>
						</c:if>
					
					<c:if test="${per.permission_id ==32}">
						<li><a href="<%=request.getContextPath()%>/danhgiaxeploai"><i
							class="fa fa-bookmark-o" aria-hidden="true"></i>Đánh giá xếp loại
							ĐV</a></li>
					</c:if>
					<c:if test="${per.permission_id ==30}">
						<li class="treeview"><a href="#"><i
							class="fa fa-envelope-open-o" aria-hidden="true"></i>Quản lý
							chuyển sinh hoạt <span class="pull-right-container"> <i
								class="fa fa-angle-left pull-right"></i>
						</span> </a>
						<ul class="treeview-menu" style="display: none;">
							<li><a
								href="<%=request.getContextPath()%>/quanlychuyensinhhoat/xacnhanchuyendi"><i
									class="fa fa-calendar-check-o" aria-hidden="true"></i> Xác nhận
									chuyển đi</a></li>
							<li><a
								href="<%=request.getContextPath()%>/quanlychuyensinhhoat/xacnhanchuyenden"><i
									class="fa fa-calendar-check-o" aria-hidden="true"></i> Xác nhận
									chuyển đến</a></li>
						</ul></li>
					</c:if>
					</c:forEach>
				</ul>
				</li>
				<c:forEach items="${sessionScope.listPerRoleUni}" var="permis">
					<c:if test="${permis.permission_id ==31}">
				<li class="treeview"><a href="#"> <i class="fa fa-globe"
					aria-hidden="true"></i> <span> Quản trị hệ thống</span> <span
					class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu">
					<li><a href="<%=request.getContextPath()%>/quanlytaikhoan"><i
							class="fa fa-user" aria-hidden="true"></i>Quản lý tài khoản</a></li>
					<li><a href="<%=request.getContextPath()%>/vaitro"><i
							class="fa fa-shield" aria-hidden="true"></i> Vai trò</a></li>
					<li><a href="<%=request.getContextPath()%>/quyenhan"><i
							class="fa fa-lock" aria-hidden="true"></i> Quyền hạn</a></li>
				</ul></li>
				</c:if>
				<c:if test="${permis.permission_id ==33}">
			<li class="treeview"><a href="#"> <i
					class="fa fa-line-chart" aria-hidden="true"></i> <span> Báo
						cáo thống kê</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu">
					<li><a href="<%=request.getContextPath()%>/baocaocongtacdoan"><i
							class="fa fa-file-text-o" aria-hidden="true"></i> Báo cáo công
							tác đoàn viên</a></li>
					<li><a
						href="<%=request.getContextPath()%>/baocaodanhgiaxeploai"><i
							class="fa fa-file-text-o" aria-hidden="true"></i> Báo cáo đánh
							giá xếp loại</a></li>
					<li><a href="#"><i class="fa fa-file-text-o"
							aria-hidden="true"></i> Báo cáo thống kê tài chính</a></li>
				</ul></li>
				</c:if>
			</c:forEach>
			<li><a href="#"><i class="fa fa-book"></i> <span>Hướng
						dẫn sử dụng</span></a></li>
		</ul>
	</section>
	<!-- /.sidebar -->
</aside>