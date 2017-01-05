<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
<title>Insert title here</title>
<script>
$(document).ready(function(){
    $('[data-toggle="tooltip"]').tooltip();   
});
</script>
<style>
 .container:hover{
 font-size: 700%;
}
 img + .tooltip > .tooltip-inner {
      background-color: #73AD21; 
      color: #FFFFFF; 
      border: 1px solid green; 
      padding: 15px;
      font-size: 20px;
  }
</style>
</head>
<body>    
<c:set var="imageFolder"  value="/lib/image/productImage/"/>
<div class="container">
      <c:forEach var="listcategory" items="${categoryList}">
     
      <c:if test="${listcategory.getCategoryName()== categoryName}">
      <c:set var="category" value="${listcategory}"/>
      </c:if>
      </c:forEach>   
      
     
      <c:forEach var="listValue" items="${category.getProducts()}">
           <a href="show_product?id=${listValue.productName}">  <img alt="${listValue.productName}" src="<c:url value="${imageFolder}${listValue.productId}.jpg " />"  data-toggle="tooltip" data-placement="bottom" title="PRICE :- ${listValue.price}" style="height:200px; width:150px;"></a>
          
       </c:forEach>
       
 </div>      
  </body>
</html>