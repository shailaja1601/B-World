<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="<c:url value="/lib/css/bootstrap.css" />" rel="stylesheet">
<script src="<c:url value="/lib/js/jquery.js" />"></script>
<script src="<c:url value="/lib/js/bootstrap.js" />"></script>

<link href="<c:url value="/lib/font-awesome/css/font-awesome.min.css"/>" rel="stylesheet">
 <link href="<c:url value="/lib/styleCSS/header.css" />" rel="stylesheet">
<style>

 .foot:hover{
 font-size: 150%;
}
  .wrapper {
    height:100px;
    width: 100%;
	padding-top:60px;
	position:relative;
} 
footer {
    position: absolute;
    height: 100px;
    bottom: 0;
    width: 100%;
    padding-top:60px;
}

hr{
border: none;
    height:1px;
    widht:1000px;
}

</style>

</head>
<body>
<div class="container">
      <div class="wrapper"> <hr color="red">
    
      <footer class="navbar">
   <header>
		<div class="text-center">
			<h4>&copy 2016-2017 B-World</h4>
			<h6>Follow Us</h6>
			<a href="#" class="foot"><i class="fa fa-facebook-square fa-2x" aria-hidden="true" style="color:blue"></i></a>
			<a href="#" class="foot"><i class="fa fa-twitter-square fa-2x" aria-hidden="true" style="color:DeepSkyBlue"></i></a>
			<a href="#" class="foot"><i class="fa fa-instagram fa-2x" aria-hidden="true" style="color:Indigo"></i></a>
			<a href="#" class="foot"><i class="fa fa-google-plus-official fa-2x" aria-hidden="true" style="color:red"></i></a>
		</div>
	</header>
	</footer>
	 </div>
	 </div> 
</body>
</html>