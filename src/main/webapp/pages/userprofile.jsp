<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@include file="header.jsp"%>
<!-- Left side column. contains the logo and sidebar -->
<%@include file="sidebar.jsp"%>
<!-- =============================================== -->
<div class="content-wrapper" style="min-height: 1126px;">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        User Profile
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Trang chủ</a></li>
        <li class="active">Trang cá nhân</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">

      <div class="row">
        <div class="col-md-3">

          <!-- Profile Image -->
          <div class="box box-primary">
            <div class="box-body box-profile">
              <img class="profile-user-img img-responsive img-circle" src="<c:out value="${sessionScope.avata}"></c:out>" alt="User profile picture">

              <h3 class="profile-username text-center"><c:out value="${sessionScope.name}"></c:out></h3>

              <p class="text-muted text-center">Đoàn viên</p>
			  <p class="text-muted text-center">
			  	<i style="color:blue;" class="fa fa-star-o" aria-hidden="true"></i>
			  	<i style="color:blue;" class="fa fa-star-o" aria-hidden="true"></i>
			  	<i style="color:blue;" class="fa fa-star-o" aria-hidden="true"></i>
			  	<i style="color:blue;" class="fa fa-star-o" aria-hidden="true"></i>
			  	<i style="color:blue;" class="fa fa-star-o" aria-hidden="true"></i>
			  </p>
              <ul class="list-group list-group-unbordered">
                <li class="list-group-item">
                  <b>Followers</b> <a class="pull-right">1,322</a>
                </li>
                <li class="list-group-item">
                  <b>Following</b> <a class="pull-right">543</a>
                </li>
                <li class="list-group-item">
                  <b>Friends</b> <a class="pull-right">13,287</a>
                </li>
              </ul>

              <a href="#" class="btn btn-primary btn-block"><b>Follow</b></a>
            </div>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->

          <!-- About Me Box -->
          <div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">About Me</h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
              <strong><i class="fa fa-book margin-r-5"></i> Education</strong>

              <p class="text-muted">
                B.S. in Computer Science from the University of Tennessee at Knoxville
              </p>

              <hr>

              <strong><i class="fa fa-map-marker margin-r-5"></i> Location</strong>

              <p class="text-muted">Malibu, California</p>

              <hr>

              <strong><i class="fa fa-pencil margin-r-5"></i> Skills</strong>

              <p>
                <span class="label label-danger">UI Design</span>
                <span class="label label-success">Coding</span>
                <span class="label label-info">Javascript</span>
                <span class="label label-warning">PHP</span>
                <span class="label label-primary">Node.js</span>
              </p>

              <hr>

              <strong><i class="fa fa-file-text-o margin-r-5"></i> Notes</strong>

              <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam fermentum enim neque.</p>
            </div>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->
        </div>
        <!-- /.col -->
        <div class="col-md-9">
          <div class="nav-tabs-custom">
            <ul class="nav nav-tabs">
              <li class="active"><a href="#activity" data-toggle="tab" aria-expanded="true">Hoạt động</a></li>
              <li class=""><a href="#timeline" data-toggle="tab" aria-expanded="false">Lịch sử</a></li>
              <li class=""><a href="#settings" data-toggle="tab" aria-expanded="false">Đổi mật khẩu</a></li>
            </ul>
            <div class="tab-content">
              <div class="tab-pane active" id="activity">
                <!-- Post -->
                <div class="post">
                  <div class="user-block">
                    <img class="img-circle img-bordered-sm" src="<c:out value="${sessionScope.avata}"></c:out>" alt="user image">
                        <span class="username">
                          <a href="#">Trần Minh Đức</a>
                          <a href="#" class="pull-right btn-box-tool"><i class="fa fa-times"></i></a>
                        </span>
                    <span class="description">Shared publicly - 7:30 AM yesterday</span>
                  </div>
                  <!-- /.user-block -->
                  <p>
                   Chiều nay đội tuyển U23 Việt Nam sẽ dành chiến thằng ! 
                   Good luck !
                  </p>
                  <div class="fb-comments" data-href="http://localhost:8080/QuanLyDoan/trangcanhan" data-width="780" data-numposts="4"></div>
                </div>
                <!-- /.post -->
              </div>
              <!-- /.tab-pane -->
              <div class="tab-pane" id="timeline">
                <!-- The timeline -->
                <ul class="timeline timeline-inverse">
                  <!-- timeline time label -->
                  <li class="time-label">
                        <span class="bg-red">
                          10 Feb. 2014
                        </span>
                  </li>
                  <!-- /.timeline-label -->
                  <!-- timeline item -->
                  <li>
                    <i class="fa fa-envelope bg-blue"></i>

                    <div class="timeline-item">
                      <span class="time"><i class="fa fa-clock-o"></i> 12:05</span>

                      <h3 class="timeline-header"><a href="#">Support Team</a> sent you an email</h3>

                      <div class="timeline-body">
                        Etsy doostang zoodles disqus groupon greplin oooj voxy zoodles,
                        weebly ning heekya handango imeem plugg dopplr jibjab, movity
                        jajah plickers sifteo edmodo ifttt zimbra. Babblely odeo kaboodle
                        quora plaxo ideeli hulu weebly balihoo...
                      </div>
                      <div class="timeline-footer">
                        <a class="btn btn-primary btn-xs">Read more</a>
                        <a class="btn btn-danger btn-xs">Delete</a>
                      </div>
                    </div>
                  </li>
                  <!-- END timeline item -->
                  <!-- timeline item -->
                  <li>
                    <i class="fa fa-user bg-aqua"></i>

                    <div class="timeline-item">
                      <span class="time"><i class="fa fa-clock-o"></i> 5 mins ago</span>

                      <h3 class="timeline-header no-border"><a href="#">Sarah Young</a> accepted your friend request
                      </h3>
                    </div>
                  </li>
                  <!-- END timeline item -->
                  <!-- timeline item -->
                  <li>
                    <i class="fa fa-comments bg-yellow"></i>

                    <div class="timeline-item">
                      <span class="time"><i class="fa fa-clock-o"></i> 27 mins ago</span>

                      <h3 class="timeline-header"><a href="#">Jay White</a> commented on your post</h3>

                      <div class="timeline-body">
                        Take me to your leader!
                        Switzerland is small and neutral!
                        We are more like Germany, ambitious and misunderstood!
                      </div>
                      <div class="timeline-footer">
                        <a class="btn btn-warning btn-flat btn-xs">View comment</a>
                      </div>
                    </div>
                  </li>
                  <!-- END timeline item -->
                  <!-- timeline time label -->
                  <li class="time-label">
                        <span class="bg-green">
                          3 Jan. 2014
                        </span>
                  </li>
                  <!-- /.timeline-label -->
                  <!-- timeline item -->
                  <li>
                    <i class="fa fa-camera bg-purple"></i>

                    <div class="timeline-item">
                      <span class="time"><i class="fa fa-clock-o"></i> 2 days ago</span>

                      <h3 class="timeline-header"><a href="#">Mina Lee</a> uploaded new photos</h3>

                      <div class="timeline-body">
                        <img src="http://placehold.it/150x100" alt="..." class="margin">
                        <img src="http://placehold.it/150x100" alt="..." class="margin">
                        <img src="http://placehold.it/150x100" alt="..." class="margin">
                        <img src="http://placehold.it/150x100" alt="..." class="margin">
                      </div>
                    </div>
                  </li>
                  <!-- END timeline item -->
                  <li>
                    <i class="fa fa-clock-o bg-gray"></i>
                  </li>
                </ul>
              </div>
              <!-- /.tab-pane -->

              <div class="tab-pane" id="settings">
                <form class="form-horizontal" method="post" action="" id="frm-change-pass" name="frm-change-pass">
                  <div class="form-group">
                  <input type="hidden" class="form-control" id="id" name="id" placeholder="" value='<c:out value="${sessionScope.email}"></c:out>'>
                    <label for="inputName" class="col-sm-2 control-label">Mật khẩu cũ <span style='color: red;'> *</span></label>
                    <div class="col-sm-10">
                      <input type="password" class="form-control" id="passold" name="passold" placeholder="Mật khẩu cũ">
                      <span style="color:red;" id="err"></span>
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="inputEmail" class="col-sm-2 control-label">Mật khẩu mới <span style='color: red;'> *</span></label>

                    <div class="col-sm-10">
                      <input type="password" class="form-control" id="passnew" name="passnew" placeholder="Mật khẩu mới">
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="inputName" class="col-sm-2 control-label">Xác nhận mật khẩu <span style='color: red;'> *</span></label>
                    <div class="col-sm-10">
                      <input type="password" class="form-control" id="cfpass" name="cfpass" placeholder="Xác nhận mật khẩu">
                    </div>
                  </div>
                  <div class="form-group">
                    <div class="col-md-4 col-md-offset-6">
                      <button type="submit" id="btn-change-pass" class="btn btn-submit blue"><i class="fa fa-key" aria-hidden="true"></i> Đổi mật khẩu</button>
                    </div>
                  </div>
                </form>
              </div>
              <!-- /.tab-pane -->
            </div>
            <!-- /.tab-content -->
          </div>
          <!-- /.nav-tabs-custom -->
        </div>
        <!-- /.col -->
      </div>
      <!-- /.row -->

    </section>
    <!-- /.content -->
  </div>
  <%@include file="footer.jsp"%>
 <script type="text/javascript">
 	var contextPath = "${pageContext.request.contextPath}";
 	$(document).ready(function(){
 		$("#frm-change-pass").on('submit',function(e){
			e.preventDefault();
			var form = $("#frm-change-pass");
			$('#frm-change-pass').validate({ 
		          errorElement: "span",
		          rules: {
		            passold : {
		              required : true,
		              
		            },
		            passnew : {
		              required :true,
		              minlength:8,
		            },
		            cfpass:{
		            	required :true,
		            	equalTo:"#passnew",
		            }
		          },
		          messages: {
		        	  passold : {
		              required : "Vui lòng nhập mật khẩu cũ.",
		            },
		            passnew : {
		              required :"Vui lòng nhập mật khẩu mới.",
		              minlength: "Mật khẩu phải ít nhất 8 ký tự"
		            },
		            cfpass:{
		            	required :"Vui lòng nhập xác nhận mật khẩu",
		            	equalTo:"Mật khẩu không khớp."
		            	
		            }
		          }
			}); 
			if (!form.valid()) return false;
			var id = $("#id").val();
			var passold = $("#passold").val();
			var passnew = $("#passnew").val();
			var cfpass = $("#cfpass").val();
			$.ajax({
				type : "POST",
				url : contextPath + "/trangcanhan",
				data : {
					email : id,
					passold : passold,
					passnew:passnew,
					action:'change'
					
				},
				success : function(res) {
					if(res =="error"){
						toastr.error("Mật khẩu cũ không chính xác !");
						$("#passold").focus();
					}else{
						toastr.success("Đổi mật khẩu thành công !");
						$("#passold").val("");
						 $("#passnew").val("");
						$("#cfpass").val("");
						
					}
				
				},
				error : function(xhr, ajaxOptions, thrownError) {
					toastr.error(thrownError);
				}
			});

	});
 	});
	
		
		
	
</script>