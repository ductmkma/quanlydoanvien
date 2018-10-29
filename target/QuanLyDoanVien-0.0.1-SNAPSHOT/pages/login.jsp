<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<!-- favion -->
<link rel="shortcut icon" href="<%=request.getContextPath()%>/dist/img/favicon.png" type="image/x-icon" />
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/jquery-validation@1.17.0/dist/jquery.validate.min.js"></script>
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
			<div class="col-md-4" id="form-div">
				<section class="login-form">
				<form method="post" action="" role="login" name="frm-login" id="frm-login">
				<img width="100px" height="100px" src="https://upload.wikimedia.org/wikipedia/vi/1/1c/Huy_hi%E1%BB%87u_%C4%90o%C3%A0n_TNCS_HCM.svg" class="img-responsive" alt="" />
					<h3 id="titleLogin">ĐĂNG NHẬP HỆ THỐNG</h3>
					<input 
						type="email" id="email" name="email" placeholder="Email" required 
						class="form-control input-lg" value="" />
						 <input type="password"
						class="form-control input-lg" id="password" name="password"
						placeholder="Password" required />
						<p id="messeage" style="color:red;"></p>
					<!-- <div class="pwstrength_viewport_progress"></div> -->
					<a name="go" class="btn btn-lg btn-block" id="login"> ĐĂNG NHẬP</a>
					<div>
					<a href="<%=request.getContextPath() %>/forgotpassword" style="text-decoration: none;">Quên mật khẩu ?</a>
					</div>
				</form>
				
				</section>
			</div>
			<div class="col-md-12" id="license">
					<p>Copyright © 2017. Design by <a href="https://minhduckma.blogspot.com/">Tran Minh Duc</a>. All Rights Reserved.</p>
			</div>
		</div>
		<script type="text/javascript">
			$(document).ready(function(){
				var contextPath = "${pageContext.request.contextPath}";
				$("#login").on('click',function(e){
					//e.preventDefault();
					var email = $("#email").val();
					var password = $("#password").val();
					   $.ajax({
			                type:'POST',
			                url:  contextPath+"/login",
			                data:
			                	{
			            			email:email,
			            			password:password
			                	},
			                success:function(data){
			                  	if(data==false){	
			                     	$("#messeage").html("Tài khoản hoặc mật khẩu không đúng !")
			                  	}else{
			                  		window.location.href = contextPath+"/home";
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