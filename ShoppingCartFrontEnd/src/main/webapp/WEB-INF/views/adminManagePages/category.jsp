<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Category</title>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Latest compiled and minified CSS -->
<link href="<c:url value="/lib/css/bootstrap.css" />" rel="stylesheet">
<script src="<c:url value="/lib/js/jquery.js" />"></script>
<!-- Latest compiled and minified JavaScript -->
<script src="<c:url value="/lib/js/bootstrap.js" />"></script>
<!-- Font-awesome -->
<link href="<c:url value="/lib/font-awesome/css/font-awesome.min.css"/>"
	rel="stylesheet">
	
 <!-- My CSS file-->
 <link href="<c:url value="/lib/styleCSS/header.css" />" rel="stylesheet">
		
<style type="text/css">


.container {
	padding: 15px;
}

.size {
	width: 400px;
	height:420px;
	margin-left:100px;
	margin-top:15px;
	background-color:rgba(0,0,0,0.4);
	border-radius:5px;
	}
input{
border-radius:5px;
}
textarea{
border-radius:5px;
width:178px;
}
 .give{
 margin-top:20px;
 margin-left:150px;
 border-radius:5px;

 }
 .header{
 color:white;
padding:10px;
padding-left:15px;
 }
  .body label{
 color:white;
 margin-top:5px;
padding:10px;
padding-left:15px;
 }
</style>
</head>
<body><br><br><br>
	${msg}
	<div class="size">
	<div  class="content">
	<div class="header">
<h1>Add a Category</h1></div>

<c:choose>
<c:when test="${categoryAdd}">
<c:url var="Action" value="/manage_category_add"/>
</c:when>
<c:otherwise>
<c:url var="Action" value="/manage_category_update"/>
</c:otherwise>
</c:choose>

<form:form action="${Action}" modelAttribute="category" enctype="multipart/form-data" method="post">

<div class="body">
<table>
<tr>
  <td><form:label path="categoryId"><spring:message text="ID"/></form:label></td>
  <c:choose>
   <c:when test="${!empty category.categoryId}">
     <td><form:input path="categoryId" disable="true" readonly="true"/></td>
   </c:when>
   <c:otherwise>
     <td><form:input path="categoryId" disable=".{5,20}" required="true" title="id should contain 5 to characters"/></td>
   </c:otherwise>
  </c:choose>
</tr>
<tr>
   <td><form:label path="categoryName"><spring:message text="Name"></spring:message></form:label></td>
   <td><form:input path="categoryName" required="true" value='${category.getCategoryName()}'/></td>
</tr>
<tr>
   <td><form:label path="description"><spring:message text="Description"></spring:message></form:label></td>
   <td><form:textarea path="description" required="true" rows="4"/></td>
</tr>
<tr>
          <td align="left"><form:label path="image"><spring:message text="IMAGE"/></form:label></td>
          <td align="left"><form:input type="file" name="image" path="image"/></td>
        </tr>
</table></div>
<div class="footer">
<table>

<tr>
<td colspan="2"><c:if test="${!empty category.categoryName}">
<input type="submit" class="give" value="<spring:message text="Update Category"/>"/>
</c:if>
<c:if test="${empty category.categoryName}">
<input type="submit" class="give" value="<spring:message text="Add Category"/>"/>
</c:if>
</tr>

</table></div>
</form:form>
  
 </div></div>
  
 
  	<div class="container">
		<button type="button" class="btn btn-success" data-toggle="modal"
			data-target="#myTable">Click here to view the Category Table</button>
		
		
		<div class="modal fade" id="myTable" role="dialog">
			<div class="modal-dialog">

				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Category List</h4>
					</div>
					<div class="modal-body">
						<c:if test="${!empty categoryList}">
							<table class="table">
								<thead>
									<tr>
										<th width="80">Category ID</th>
										<th width="120">Category Name</th>
										<th width="120">Category Description</th>
										<th width="60">Edit</th>
										<th width="60">Delete</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${categoryList}" var="category">
										<tr>
											<td>${category.categoryId}</td>
											<td>${category.categoryName}</td>
											<td>${category.description}</td>
											<td><a
												href="<c:url value='/manage_category_edit?id=${category.categoryId}'/>">Edit</a></td>
											<td><a
												href="<c:url value='/manage_category_remove?categoryName=${category.categoryName}'/>">Delete</a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</c:if>
					</div>
				</div>
			</div>
		</div>
	</div>
 
</body>
</html>