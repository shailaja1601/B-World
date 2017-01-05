<html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>


<head><%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%></head>
<body>
<jsp:include page="header.jsp"></jsp:include>
${successMessage} 
<c:if test="${not empty errorMessage}">
     <jsp:include page="login.jsp"></jsp:include>
</c:if>
${errorMessage} 
<c:if test="${UserClickedLogin}">
   <jsp:include page="login.jsp"></jsp:include>
</c:if>

<c:if test="${UserClickedRegister}">
<jsp:include page="register.jsp"></jsp:include>
</c:if>

</body>
</html>
