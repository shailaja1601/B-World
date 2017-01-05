<html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<head>

   <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
    <script src="<c:url value="/lib/js/jquery.js" />"></script>
    <script src="<c:url value="/lib/js/bootstrap.js" />"></script>
    
     <!-- My CSS file-->
 <link href="<c:url value="/lib/styleCSS/header.css" />" rel="stylesheet">
 <style type="text/css">

 a{
 color:white;
 font-size: 18px;
}
 </style>
 </head>
<body>

<jsp:include page="frontPages/header.jsp"></jsp:include>
<jsp:include page="ProductPages/product_menu.jsp"></jsp:include>

<c:if test="${loadHome=='true'}">  
     <jsp:include page="frontPages/home.jsp"></jsp:include>
     
</c:if>
${successMessage} 
${AdminsuccessMessage} 
${errorMessage} 

<c:if test="${UserClickedRegister}">
 ${successMessageforUser}
${errorMessageforUser} 
<jsp:include page="frontPages/register.jsp"></jsp:include>
</c:if>

<c:if test = "${UserClickedLogin=='true' || invalidCredentials=='true'}">
<div> ${errorMessage} </div>
   <%@ include file="frontPages/login.jsp"%>
</c:if>

<c:if test="${isAdminClickedCategories}">
   <jsp:include page="adminManagePages/category.jsp"></jsp:include>
</c:if>

<c:if test="${UserClickedAboutUs}">
   <jsp:include page="frontPages/aboutUs.jsp"></jsp:include>
</c:if>

<c:if test="${UserClickedContactUs}">
   <jsp:include page="frontPages/contactUs.jsp"></jsp:include>
</c:if>

<c:if test="${isAdminClickedProduct}">
    <jsp:include page="adminManagePages/product.jsp"></jsp:include>
</c:if>

  <c:if test="${isAdminClickedSupplier}">
     <jsp:include page="adminManagePages/supplier.jsp"></jsp:include>
</c:if>

<c:if test="${isAdminClickedAuthors}">
   <jsp:include page="adminManagePages/authors.jsp"></jsp:include>
</c:if>

<c:if test="${isAdminClickedLanguages}">
   <jsp:include page="adminManagePages/languages.jsp"></jsp:include>
</c:if>

<c:if test="${!empty selectedProduct.productName}">
   <jsp:include page="ProductPages/selectedProduct.jsp"></jsp:include>
</c:if>

<c:if test="${!empty categoryName}">
   <jsp:include page="ProductPages/productViewPage.jsp"></jsp:include>
</c:if> 

<c:if test="${!empty author}">
   <jsp:include page="ProductPages/authorViewPage.jsp"></jsp:include>
</c:if> 

<c:if test="${!empty language}">
   <jsp:include page="ProductPages/languageViewPage.jsp"></jsp:include>
</c:if> 

<c:if test="${displayCart=='true'}">
   <jsp:include page="ProductPages/cart.jsp"></jsp:include>
</c:if>


<jsp:include page="frontPages/footer.jsp"></jsp:include>

</body>
</html>
