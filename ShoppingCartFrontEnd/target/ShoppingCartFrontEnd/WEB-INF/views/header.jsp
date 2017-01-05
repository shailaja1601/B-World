<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@taglib prefix="B" uri="http://java.sun.com/jsp/jstl/core" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Header</title>
<link href="<B:url value="/lib/css/main.css" />" rel="stylesheet">
    <script src="<B:url value="/lib/js/jquery.1.10.2.min.js" />"></script>
    <script src="<B:url value="/lib/js/main.js" />"></script>

<link href="<B:url value="/lib/font-awesome/css/font-awesome.min.css"/>" rel="stylesheet">

<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
</head>
<body>
 <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">WebSiteName</a>
      
    </div>
   
    <ul class="nav navbar-nav">
      <li><a href="#">Home</a></li>
       <li><a href="#">Product</a></li>
       <li><a href="#">Accessories</a></li>
       </ul>   
     
      <ul class="nav navbar-nav navbar-right">
      
                 <c:if test="${not empty successMessage}">
            <li><a href="#"><span class="glyphicon glyphicon-shopping-cart"></span>My Cart</a></li>
            <li><a href="#"><span class="glyphicon glyphicon-log-out"></span>Logout</a></li>
                 </c:if>
                 <c:if test="${empty successMessage}">
             <li><a href="register"><span class="glyphicon glyphicon-user"></span>Sign Up</a></li>
            <li><a href="login"><span class="glyphicon glyphicon-log-in"></span>Login</a></li>
            <li><a href="#"><span class="glyphicon glyphicon-log-in"></span>Admin Login</a></li>
                  </c:if>
      </ul> 
    
       </div>
       </nav>
       </body>
       </html>
       