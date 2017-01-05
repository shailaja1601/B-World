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
</head>

<body>
<div class="container">
<div class="row">
 <div class="col-xs-6 col-md-6">
   <div class="panel panel-primary">
      <div class ="panel-heading">Shipping Address</div>
         <div class="panel-body">
            <form:form class="form-horizontal" action="${flowExecutionUrl}&_eventId=submitShippingAddress"  commandName="shippingAddress">
               <div class="form-group">
                 <label for =""> Line 1 </label>
                    <div class ="col-sm 10">
                    <form:errors path="line1" class="error" />
                    <form:input path="line1" type="text" autofocus="true" class="form-control" required="true"/>
                    </div>
               </div>
               <div class="form-group">
                 <label for ="" class="control-label"> Line 2 </label>
                    <div class ="col-sm 10">
                    <form:errors path="line2" class="error" />
                    <form:input path="line2" type="text"  class="form-control" />
                    </div>
               </div>
               <div class="form-group">
                 <label for ="" class="control-label"> City </label>
                    <div class ="col-sm 10">
                    <form:errors path="city" class="error" />
                    <form:input path="city" type="text"  class="form-control" required="true"/>
                    </div>
               </div>
               <div class="form-group">
                 <label for ="" class="control-label">State </label>
                    <div class ="col-sm 10">
                    <form:errors path="state" class="error" />
                    <form:input path="state" type="text"  class="form-control" required="true"/>
                    </div>
               </div>
               <div class="form-group">
                 <label for ="" class="control-label"> Country </label>
                    <div class ="col-sm 10">
                    <form:errors path="country" class="error" />
                    <form:input path="country" type="text"  class="form-control" required="true"/>
                    </div>
               </div>
               <div class="form-group">
                 <label for ="" class="control-label"> Zip code </label>
                    <div class ="col-sm 10">
                    <form:errors path="Zipcode" class="error" />
                    <form:input path="city" type="text" pattern="^[1-9][0-9]{5}$" title="Enter zipcode" class="form-control" required="true"/>
                    </div>
               </div>
               
               <div class="col-md-offset-3">
                 <input type="submit"  class="btn btn-md btn-success" value="Save"/>
                <a href="${flowExecutionUrl}&_eventId=cancel" type="button" class="btn btn-md btn-danger">Cancel</a>
                </div>
   
         </form:form>
         </div>
         </div>
       </div>
       <div class="col-xs-12 col-sm-6">
	
 <img src="<c:url value="/lib/image/Delivery.jpg"/>" style="width:600px;height:600px">
 </div> 
    </div>
   </div>
   
</body>
</html>