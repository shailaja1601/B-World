<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<%@taglib prefix="B" uri="http://java.sun.com/jsp/jstl/core" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <link href="<B:url value="/lib/css/main.css" />" rel="stylesheet">
    <script src="<B:url value="/lib/js/jquery.1.10.2.min.js" />"></script>
    <script src="<B:url value="/lib/js/main.js" />"></script>

<link href="<B:url value="/lib/font-awesome/css/font-awesome.min.css"/>" rel="stylesheet">
 </head>
<body>
<form action="validate" method="post">
<div class="input-group margin-bottom-sm">
  <span class="input-group-addon"><i class="fa fa-envelope-o fa-fw"></i></span>
  <input class="form-control" type="text" placeholder="Email address">
</div>
<div class="input-group">
  <span class="input-group-addon"><i class="fa fa-key fa-fw"></i></span>
  <input class="form-control" type="password" placeholder="Password">
  </div>


</form>
<button type="submit" class="btn btn-warning">SUBMIT</button>

</body>
</html>