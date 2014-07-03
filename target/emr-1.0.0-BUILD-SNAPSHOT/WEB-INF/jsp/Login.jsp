<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security"
 uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<link rel="stylesheet"  href='${pageContext.request.contextPath}/resources/css/demo.css'>
<link rel="stylesheet"  href='${pageContext.request.contextPath}/resources/css/style1.css'>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/modernizr.custom.86080.js"></script>

<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- Bootstrap -->
<script src='${pageContext.request.contextPath}/resources/app/bower_components/jquery/jquery.min.js' type="text/javascript"></script>
<link rel="stylesheet" media="screen" href='${pageContext.request.contextPath}/resources/css/bootstrap.css'>
<link rel="stylesheet" href='${pageContext.request.contextPath}/resources/css/bootstrap.min.css'>
<link rel="stylesheet"  type="text/css" media="all" href='${pageContext.request.contextPath}/resources/css/jquery.pnotify.default.css' />
<link rel="stylesheet"  type="text/css" media="all" href='${pageContext.request.contextPath}/resources/css/jquery.pnotify.default.icons.css' />
<script src='${pageContext.request.contextPath}/resources/js/jquery.pnotify.js' type="text/javascript"></script>

<div id="loginPannel">
	 <ul class="cb-slideshow">
	     <li><span>Image 01</span></li>
	     <li><span>Image 02</span></li>
	     <li><span>Image 03</span></li>
	     <li><span>Image 04</span></li>
	     <li><span>Image 05</span></li>
	     <li><span>Image 06</span></li>
	 </ul> 
 
	 <div class="container">
			<div class="heading">
				<security:authorize access="!isAuthenticated()">
				  <h1>Magic EMR Portal</h1>
				   
				  <c:if test="${loginFailed}">
				   <div style="color: red">Could not sign in, please check your login/password...</div>
				  </c:if>  
				 
				  <form method="post" class="signin" class="form-horizontal" action="j_spring_security_check">
				  	<fieldset id="login_field">
				  		<div class="well" style="width: 350px;background-color: rgba(0, 0, 0, 0.2);">
				  			<p>
								<input type="text" name="j_username"
									id="username_or_email"
									placeholder="User name" rel="popover" required="required"
									data-content="What is Username?">
							</p>
	
							<p>
								<input type="password" id="password" name="j_password" placeholder="Password"
									rel="popover" required="required"
									data-content="What is your Password?">
							</p>
							<p>
								<button name="commit" class="btn btn-success" type="submit" value="Sign In">Login</button>
							</p>
							<p>
				  		</div>
				  	</fieldset>
				  	<div class="pull-left">
				  	<h4 class="text-danger">
						Not Registered yet?
						<span><a href="${pageContext.request.contextPath}/register">Register here</a></span>
					</h4>
				  	</div>
				  </form>
				</security:authorize>
			</div>
	 </div>
</div>

<script src='${pageContext.request.contextPath}/resources/js/bootstrap.min.js'></script>
<script src='${pageContext.request.contextPath}/resources/js/jqBootstrapValidation.js'></script>
<script type="${pageContext.request.contextPath}/resources/js/jquery.validate.js"></script>

<script type="text/javascript">
	$('#login_field input').on('mouseenter',function() {
		$(this).popover('show')
	});
	$('#login_field input').on('mouseleave',function() {
		$(this).popover('hide')
	});
	$(document).ready(function(){
		if(localStorage.getItem("notification_mesg")){
			
			$.pnotify({
				history:false,
		        
		        text: localStorage.getItem("notification_mesg")
		    });
			localStorage.removeItem("notification_mesg")
		}
	});
</script>