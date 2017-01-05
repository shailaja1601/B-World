
<head>
<%@taglib prefix="B" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Header</title>
<link href="<B:url value="/lib/css/bootstrap.css" />" rel="stylesheet">
<script src="<B:url value="/lib/js/jquery.js" />"></script>
<script src="<B:url value="/lib/js/bootstrap.js" />"></script>

<link href="<B:url value="/lib/font-awesome/css/font-awesome.min.css"/>" rel="stylesheet">
	 <!-- My CSS file-->
 <link href="<B:url value="/lib/styleCSS/header.css" />" rel="stylesheet">
	
<script>
	$(document).ready(function() {
		$('.dropdown-toggle').dropdown();
	});
</script>
</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<ul class="nav navbar-nav navbar-left">
				<li><a href="aboutUs">About us</a></li>
				<li><a href="contactUs"><i class="fa fa-phone-square" aria-hidden="true">  Contact us</i></a></li>
			</ul>
			<div class="nav navbar-nav form-inline navbar-right"
				style="padding: 10px;">
				<div class="input-group">
					<input type="text" class="form-control"
						placeholder="Type here to search" />
					<div class="input-group-btn">
						<button class="btn btn-warning" style="font-size: 20px;">
							<i class="glyphicon glyphicon-search"></i>
						</button>
					</div>
				</div>
			</div>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="home"><i class="fa fa-home" aria-hidden="true"></i></a></li>
				
				<B:if test="${empty loggedInUser}">
				
					<li><a href="register"><i class="fa fa-user-plus" aria-hidden="true">  Sign Up</i></a></li>

					<li><a href="Login"><i class="fa fa-sign-in" aria-hidden="true">  Login</i></a></li>
							
				</B:if>	
 				<B:if test="${not empty loggedInUser}">
 				<B:if test="${isAdmin=='false'}">
						<li><a href="cart"><i class="fa fa-opencart" aria-hidden="true"></i> My Cart ${cartSize} </a></li>
					</B:if>
					
					<li><a href="Logout"><span
							class="glyphicon glyphicon-log-out"></span>Logout</a></li>
              	</B:if>
              	<B:if test="${not empty loggedInUser}">
				<B:if test="${isAdmin=='true'}">
				<li class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown">Manage<span class="caret"></span></a>
            <ul class="dropdown-menu">
            <li><a href="manageCategories"><i class="fa fa-tags" aria-hidden="true">  Category</i></a></li>
            <li><a href="manageSupplier"><i class="fa fa-users" aria-hidden="true">  Supplier</i></a></li>
			<li><a href="manageAuthors"><i class="fa fa-book" aria-hidden="true">  Authors</i></a></li>
			<li><a href="manageLanguages"><i class="fa fa-language" aria-hidden="true">  Languages</i></a></li>
			<li><a href="manageProducts"><i class="fa fa-paypal" aria-hidden="true">  Product</i></a></li>
			 </ul></li></B:if>
			 </B:if>				
			</ul>
		</div>
	</nav>
	
	<nav class="navbar navbar-light bg-faded" >
	
	 <h1 style="font-size:50px;" class="text-center"><b><span style="color:#DAA520;text-shadow:6px 6px 6px #808080;">B-W<img src="<B:url value="/lib/image/o_logo.png"/>">RLD</span></b></h1>
			 <div class="text-center" class="lead" style="color:#191970;text-shadow:4px 4px 4px #DAA520;"><b>ONLINE BOOK STORE</b></div> 
	 
	</nav>
	
</body>
</html>

 	











