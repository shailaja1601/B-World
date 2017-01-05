
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<title>Insert title here</title>
</head>
<body>
<div class="container">

<div class="col-xs-8 col-md-7">
 <div class="panel panel-primary">
      <div class ="panel-heading">Cart Details</div>
         <div class="panel-body">
<table>
  <tr>
  <th align = "left" width ="80">Cart ID</th>
  <th align ="left" width ="120">Product Name</th>
  <th align ="left" width="120">Quantity</th>
  <th align ="left" width ="80">Price</th>
  <th colspan="2" align="center" width ="60">Action</th>
  </tr>
  <c:forEach items="${cartList }"  var="cart">
  <tr>
   <td align ="left">${cart.id}</td>
   <td align="left">${cart.productName}</td>
   <td align="left"><center>${cart.quantity}</center></td>
   <td align ="left">${cart.price}</td>
   <td align ="left"><a href="<c:url value='/cart_delete?id=${cart.id}'/>">Delete</a></td>
   </tr>
   </c:forEach>
</table>
<h2> Total Cost: ${totalAmount}</h2>
</div>
</div>
</div>
</div>
<div class="container">
<div class="col-xs-12 col-md-offset-6">
<a href="cart_checkout"  class="btn btn-md btn-success" >Checkout</a>
</div>
</div>

</body>
</html>