<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	
<script>
	$(document).ready(function() {
		$('.dropdown-toggle').dropdown();
	});
</script>
<style>
a{
 color:white;
 font-size: 18px;
}
hr{
border: none;
    height:1px;
}
</style>
</head>
<body>

<nav class="navbar navbar-light">
       <div class="container">
        <ul class="nav nav-pills " role="tablist">
         <!-- Filter By Authors  -->
         <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Authors<span class="caret"></span></a>       
           <ul class="dropdown-menu" role="menu">
            <c:forEach items="${authorsList}" var="authors">
        <li><a href="open_select_author?id=${authors.author}"> ${authors.author} </a></li>
        </c:forEach>
        </ul></li>
         <!-- Filter By Languages  -->
        <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Languages<span class="caret"></span></a>       
           <ul class="dropdown-menu" role="menu">
            <c:forEach items="${languagesList}" var="languages">
        <li><a href="open_select_language?id=${languages.language}"> ${languages.language} </a></li>
        </c:forEach>
        <li> <img src="<c:url value="/lib/image/indian-writing.jpg"/>"></li>
        
        </ul>
        
        </li>
         <!-- Filter By Category  -->
         <c:forEach items="${categoryList}" var="category">
        <li><a href="open_category?id=${category.categoryName}"> ${category.categoryName}</a>
        </li>
        </c:forEach>
        </ul>
       </div>
       
       </nav>
<hr color="red">
</body>
</html>