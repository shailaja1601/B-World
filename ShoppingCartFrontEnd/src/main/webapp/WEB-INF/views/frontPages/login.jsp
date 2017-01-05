    <html>
    <head>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
            <!-- Latest compiled and minified CSS -->
 <link href="<c:url value="/lib/css/bootstrap.css" />" rel="stylesheet">
    <script src="<c:url value="/lib/js/jquery.js" />"></script>
           <!-- Latest compiled and minified JavaScript -->
    <script src="<c:url value="/lib/js/bootstrap.js" />"></script>
         <!-- Font-awesome -->
<link href="<c:url value="/lib/font-awesome/css/font-awesome.min.css"/>" rel="stylesheet">

 <!-- My CSS file-->
  <link href="<c:url value="/lib/styleCSS/header.css" />" rel="stylesheet">
  <link href="<c:url value="/lib/styleCSS/login.css" />" rel="stylesheet">
 

 <head>
<body>
<div class="container">
<div class="row">
  
<div class="col-xs-6 col-md-5">
	 <div class="panel panel-primary">
		
		<div class="panel-heading ">
			<center><b>Login</b></center>
		</div>
		<div class="panel-body">
<%-- 			 <form name="loginForm" action="<c:url value='/login?${_csrf.parameterName}=${_csrf.token} }' />" method="POST"> 
 --%>			 <%-- <form name="loginForm" action="${action}">  --%>
 <form name="loginForm" action="${pageContext.request.contextPath}/login" method="POST"> 
				<div class="input-group margin-bottom-sm">
					<span class="input-group-addon"><i
						class="fa fa-envelope-o fa-fw"></i></span>
						
						 <input class="form-control" type="text" placeholder="Email address" name="username" />
				</div>
				<br>
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-key fa-fw"></i></span>
 
					<input class="form-control" type="password" placeholder="Password"
						name="password" />
				</div>
				<br>

				<div>
					<button type="submit" class="btn btn-warning">   
						<i class="fa fa-user-circle"
							style="font-size: 17px; color: rgb(47, 79, 79)"></i> SUBMIT
					</button>
				</div>
			</form>
		</div>
	</div>
	</div>
	<div class="col-xs-12 col-sm-6">
	
 <img src="<c:url value="/lib/image/Books-2-icon.png"/>">
 </div>  </div>
	</div>
	
	
	</body>
</html>