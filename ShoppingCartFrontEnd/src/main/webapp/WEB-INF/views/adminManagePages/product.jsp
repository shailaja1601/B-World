<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
    <title>Product</title>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
  <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

         <!-- Latest compiled and minified CSS -->
 <link href="<c:url value="/lib/css/bootstrap.css" />" rel="stylesheet">
    <script src="<c:url value="/lib/js/jquery.js" />"></script>
           <!-- Latest compiled and minified JavaScript -->
    <script src="<c:url value="/lib/js/bootstrap.js" />"></script>
          <!-- Font-awesome -->
<link href="<c:url value="/lib/font-awesome/css/font-awesome.min.css"/>" rel="stylesheet">
 <!-- My CSS file-->
 <link href="<c:url value="/lib/styleCSS/header.css" />" rel="stylesheet">
	
<style type="text/css">
.container {
	padding: 15px;
}
.size {
	width: 450px;
	height:650px;
	margin-left:100px;
	margin-top:15px;
	background-color:rgba(0,0,0,0.4);
	border-radius:5px;
	}
input{
border-radius:5px;
width:300px;
}
textarea{
border-radius:5px;
width:300px;
}
 .give{
 margin-top:10px;
 margin-left:100px;
 }
 .header{
 color:white;
padding:10px;
padding-left:15px;
 }
  .body label{
 color:white;
padding:10px;
padding-left:15px;
 }
</style>
</head>
<body>
<div class="size">
<div  class="content">
	<div class="header">
<h1>Add a Product</h1></div>
<c:choose>
<c:when test="${productAdd}">
<c:url var="addAction" value="/manage_product_add"/>
</c:when>
<c:otherwise>
<c:url var="addAction" value="/manage_product_update"/>
</c:otherwise>
</c:choose>
<form:form action="${addAction}" modelAttribute="product" enctype="multipart/form-data" method="post">
<div class=body>
<table>
  <tr>
      <td><form:label path="productId"><spring:message text="ID"/></form:label></td>
      <c:choose>
         <c:when test="${productAdd=='false'}">
          <td><form:input path="productId"  readonly="true"/></td>
         </c:when>
         <c:otherwise> 
     <td><form:input path="productId" disable=".{5,20}" required="true" title="id should contain 5 to characters"/></td>
          </c:otherwise>
      </c:choose>
        </tr> 
        <tr>
        <td><form:label path="productName"><spring:message text="NAME"/></form:label></td>
        <td><form:input path="productName" required="true"/></td>
        </tr>
        <tr>
        <td><form:label path="price"><spring:message text="PRICE"/></form:label></td>
        <td><form:input path="price" required="true"/></td>
        </tr>
        
         <tr>
    
        
        <td><form:label path="authors"><spring:message text="AUTHORS"/></form:label></td>
        <td><form:select path="authors.author" items="${authorsList}" itemValue="author" itemLabel="author"/></td>
          </tr>
        
        <tr>
     
        <td><form:label path="languages"><spring:message text="LANGUAGE"/></form:label></td>
        <td><form:select path="languages.language" items="${languagesList}" itemValue="language" itemLabel="language"/></td>
          </tr>
        
         <tr>
      
        <td><form:label path="category"><spring:message text="CATEGORY"/></form:label></td>
        <td><form:select path="category.categoryName" items="${categoryList}" itemValue="categoryName" itemLabel="categoryName"/></td>
          </tr>
           
           <tr>
       
        <td><form:label path="supplier"><spring:message text="SUPPLIER"/></form:label></td>
        <td><form:select path="supplier.supplierName" items="${supplierList}" itemValue="supplierName" itemLabel="supplierName"/></td>
          </tr> 
        <tr>
        <td><form:label path="stock"><spring:message text="STOCK"/></form:label></td>
        <td><form:input path="stock" required="true"/></td>
        </tr>
         
        <tr>
   <td><form:label path="description"><spring:message text="Description"></spring:message></form:label></td>
   <td><form:textarea path="description" required="true" rows="30" cols="50" style="max-height:100px;min-height:100px; resize: none;overflow-y: scroll"/></td>
</tr>
        
          <tr>
          <tr>
          <td align="left"><form:label path="image"><spring:message text="IMAGE"/></form:label></td>
          <td align="left"><form:input type="file" name="image" path="image"/></td>
        </tr>
       </table></div> 
       <table>
       <tr>
<td colspan="2"><c:if test="${!empty product.productName}">
<input type="submit" class="give" value="<spring:message text="Update Product"/>"/>
</c:if>
<c:if test="${empty product.productName}">
<input type="submit" class="give" value="<spring:message text="Add Product"/>"/>
</c:if>
</tr>
</table>
</form:form></div></div>
   <div class="container">
<button type="button"  class="btn btn-info" data-toggle="collapse" data-target="#myTable">Click here to view the Product Table</button>
 <div id="myTable" class="collapse">
    
     <h4>Product List</h4>
     
     <c:if test="${!empty productList}">
     <table class="table">
     <thead>
     <tr>
     <th width="80">Product ID</th>
     <th width="120">Product Name</th>
     <th width="120">Product Price</th>
     <th width="120">Author ID</th>
     <th width="120">Language ID</th>
     <th width="80">Category ID</th>
     <th width="80">Supplier ID</th>
     <th width="80">Stock</th>
     <th width="60">Edit</th>
     <th width="60">Delete</th>
     </tr></thead>
     <tbody>
     <c:forEach items="${productList}" var="product">
     <tr>
      <td>${product.productId}</td>
      <td>${product.productName}</td>
      <td>${product.price}</td>
      <td>${product.authorID}</td>
      <td>${product.languageID}</td>
       <td>${product.categoryID}</td>
       <td>${product.supplierID}</td>
       <td>${product.stock}</td>
      <td><a href="<c:url value='/manage_product_edit?productName=${product.productName}'/>">Edit</a></td>
      <td><a href="<c:url value='/manage_product_remove?productId=${product.productId}'/>">Delete</a></td>
      </tr>
      </c:forEach>
      </tbody>
      </table>
       </c:if>
      </div>
     </div>
      
</body>
</html>