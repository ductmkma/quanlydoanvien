<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/dist/css/login.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/dist/css/slideshow.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">
<link href="https://fonts.googleapis.com/css?family=Roboto:400,700" rel="stylesheet">
<link rel='stylesheet'
	href='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.0.3/sweetalert2.css'>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
<script
	src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.0.3/sweetalert2.all.min.js'></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/dist/js/login.js"></script>
<title>Đăng nhập hệ thống</title>
</head>
<body>
			<ul class="cb-slideshow">
	        	<li><span></span><div></div></li>
	        	<li><span></span><div></div></li>
	        	<li><span></span><div></div></li>
	       		 <li><span></span><div></div></li>
	       		 <li><span></span><div></div></li>
	        	<li><span></span><div></div></li>
	    	</ul>
			<div class="row" id="pwd-container">
			<div class="col-md-4">
			
			</div>
			<div class="col-md-4" id="form-div" style="margin-top: 40px;">
				<section class="login-form">
				 
				<form method="post" action="" role="login">
				<img width="100px" height="100px" src="https://upload.wikimedia.org/wikipedia/vi/1/1c/Huy_hi%E1%BB%87u_%C4%90o%C3%A0n_TNCS_HCM.svg" class="img-responsive" alt="" />
					<h3 id="titleLogin">QUÊN MẬT KHẨU</h3>
					<p class="text-center">Vui lòng điền địa chỉ email của bạn</p>
					<input <c:if test="${check==0}"><c:out value=""></c:out></c:if>
						type="email" id="email" name="email" placeholder="Email" required 
						class="form-control input-lg" value="" />
					<button type="submit" name="go"
						class="btn btn-lg btn-block btn-reset" id="login"> RESET</button>
					<div>
					Remembered your password ? <a  href="<%=request.getContextPath() %>/login" style="text-decoration: none;">Login</a>
					</div>
				</form>
				
				</section>
			</div>
			<div class="col-md-12" id="license">
					<p>Copyright © 2017. Design by <a href="https://minhduckma.blogspot.com/">Tran Minh Duc</a>. All Rights Reserved.</p>
			</div>
		</div>
		<script type="text/javascript">
			var contextPath = "${pageContext.request.contextPath}";
			$(document).ready(function(){
				 $(document).on('click', '.btn-reset', function() {
						var email = $("#email").val();
						 $.ajax({
						        type:'POST',
						        url: contextPath+"/forgotpassword",
						        data:{
						        	email: email
						        },
						        success:function(data){

						            if(data=="notExist") {
						               	
						            } else {
						              
						                
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
</body>
</html>