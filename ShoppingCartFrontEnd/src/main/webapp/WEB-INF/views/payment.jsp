<!DOCTYPE html>
<html>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!-- Latest compiled and minified CSS -->
<link href="<c:url value="/lib/css/bootstrap.css" />" rel="stylesheet">
<script src="<c:url value="/lib/js/jquery.js" />"></script>
<!-- Latest compiled and minified JavaScript -->
<script src="<c:url value="/lib/js/bootstrap.js" />"></script>
<!-- Font-awesome -->
<link href="<c:url value="/lib/font-awesome/css/font-awesome.min.css"/>"
	rel="stylesheet">	

<head>
<style type="text/css">
.container{
margin-top:60px;
}
</style>
</head>
<body >
<div class="container">
<div class="row">
<div class="col-xs-6 col-md-5">
   <div class="panel panel-primary">
      <div class ="panel-heading">Payment Method</div>
         <div class="panel-body">
<form:form class="form-horizontal"  action="${flowExecutionUrl}&_eventId=submitPaymentMethod" commandName="paymentMethod">
<table>
<tr><td>Credit Card:<td><input type ="radio" name="paymentMethod" value="Credit Card"></td></td></tr>
<tr><td>Debit Card:<td><input type ="radio" name="paymentMethod" value="Debit Card"></td></td></tr>
<tr><td>Net Banking:<td> <input type ="radio" name="paymentMethod" value="Net Banking"></td></td></tr>
<tr><td>COD:<td><input type ="radio" name="paymentMethod" value="Cash On Delivery"></td></td></tr>

</table>

 <div class="col-md-offset-3">
                 <input type="submit" name="_eventID_submitPaymentMethod"
                 class="btn btn-md btn-success" value="Save">
<a href="${flowExecutionUrl}&_eventId=cancel" type="button" class="btn btn-md btn-danger">Cancel</a>
</div>

</form:form>
</div>
</div>
</div>
<div class="col-xs-12 col-sm-6">
	
<img src="<c:url value="/lib/image/sp34.jpg"/>"></div>
</div>
</div>
</body>
</html>