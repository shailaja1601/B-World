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
	height:380px;
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
 margin-top:25px;
 margin-left:150px;
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
<body><br><br><br>
	${msg}
	<div class="size">
	<div  class="content">
	<div class="header">
<h1>Add a Supplier</h1></div>

<c:choose>
<c:when test="${supplierAdd}">
<c:url var="Action" value="/manage_supplier_add"/>
</c:when>
<c:otherwise>
<c:url var="Action" value="/manage_supplier_update"/>
</c:otherwise>
</c:choose>

<form:form action="${Action}" modelAttribute="supplier" method="post">
<div class="body">
<table>
<tr>
  <td><form:label path="supplierId"><spring:message text="ID"/></form:label></td>
  <c:choose>
   <c:when test="${!empty supplier.supplierId}">
     <td><form:input path="supplierId" disable="true" readonly="true"/></td>
   </c:when>
   <c:otherwise>
     <td><form:input path="supplierId" disable=".{5,20}" required="true" title="id should contain 5 to characters"/></td>
   </c:otherwise>
  </c:choose>
</tr>
<tr>
   <td><form:label path="supplierName"><spring:message text="Name"></spring:message></form:label></td>
   <td><form:input path="supplierName" required="true" value='${supplier.getSupplierName()}'/></td>
</tr>
<tr>
   <td><form:label path="address"><spring:message text="Address"></spring:message></form:label></td>
   <td><form:textarea path="address" required="true" value='${supplier.getAddress()}' rows="4"/></td>
</tr>
</table></div>
<div class="footer">
<table>

<tr>
<td colspan="2"><c:if test="${!empty supplier.supplierName}">
<input type="submit" class="give" value="<spring:message text="Update Supplier"/>"/>
</c:if>
<c:if test="${empty supplier.supplierName}">
<input type="submit" class="give" value="<spring:message text="Add Supplier"/>"/>
</c:if>
</tr>
</table></div>
</form:form></div></div>
  
    	<div class="container">
		<button type="button" class="btn btn-success" data-toggle="modal"
			data-target="#myTable">Click here to view the Supplier Table</button>
		<div class="modal fade" id="myTable" role="dialog">
			<div class="modal-dialog">

				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Category List</h4>
					</div>
					<div class="modal-body">
						<c:if test="${!empty supplierList}">
							<table class="table">
								<thead>
									<tr>
										<th width="80">Supplier ID</th>
										<th width="120">Supplier Name</th>
										<th width="120">Supplier Address</th>
										<th width="60">Edit</th>
										<th width="60">Delete</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${supplierList}" var="supplier">
										<tr>
											<td>${supplier.supplierId}</td>
											<td>${supplier.supplierName}</td>
											<td>${supplier.address}</td>
											<td><a
												href="<c:url value='/manage_supplier_edit?id=${supplier.supplierId}'/>">Edit</a></td>
											<td><a
												href="<c:url value='/manage_supplier_remove?id=${supplier.supplierId}'/>">Delete</a></td>
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