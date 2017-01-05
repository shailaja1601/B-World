<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Registration</title>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
  <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib prefix="B" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="<B:url value="/lib/css/bootstrap.css" />" rel="stylesheet">
    <script src="<B:url value="/lib/js/jquery.js" />"></script>
    <script src="<B:url value="/lib/js/bootstrap.js" />"></script>
    <link href="<B:url value="/lib/font-awesome/css/font-awesome.min.css"/>" rel="stylesheet">
 
   <!-- My CSS file-->
  <link href="<B:url value="/lib/styleCSS/header.css" />" rel="stylesheet">
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<div class="container">
<div class="row">
 <div class="col-lg-6 col-md-offset-3">
   <div class="panel panel-primary">

        <div class="panel-heading"><p align="center">Create Account</p></div>
       
       <B:url var="action" value="/register_form" />
    <form action="${action}"  method="post">
      <div class="panel-body">
     <div class="form-group" action="Post">
     Your Name:
     <input type="text" class="form-control"  name="name" placeholder="Shailaja Singh" required autofocus/>
     Contact Number:
     <input type="text" class="form-control"  name="contact" placeholder="xxxxxxxxxx" required/>
     E-Mail ID:
     <input type="email" class="form-control" name="mail" placeholder="shailaja@abc.com" required/>
     Password:
     <input type="password" class="form-control" name="password" pattern="[A-Za-z0-9]{5,10}" title="Password should be of 5-10 character only">
     </div>
         <center> <button class="btn btn-primary"><i class="fa fa-user-circle" style="font-size:17px;"></i> Create an account</button></a>
   </center>
      </div>
      </form>
     
     </div>
   </div>
   </div>
   </div>
</html>