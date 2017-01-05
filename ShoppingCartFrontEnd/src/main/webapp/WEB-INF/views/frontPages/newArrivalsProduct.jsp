
<html>
<head>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='B'%>
<link href="<B:url value="/lib/css/bootstrap.css" />" rel="stylesheet">
    <script src="<B:url value="/lib/js/jquery.js" />"></script>
    <script src="<B:url value="/lib/js/bootstrap.js" />"></script>
   <style>
 .icon img{
  
    position: absolute;
    top: 42%;
    width: 100px;
    height: 100px;
    left: 18%;
}
  .thumbnail {
      padding: 0 0 15px 0;
      border: none;
      border-radius: 0;
  }
  .btn {
      padding: 10px 20px;
      background-color: #5cb85c;
      color: #f1f1f1;
      border-radius: 0;
      transition: .2s;
  }
  .btn:hover, .btn:focus {
      border: 1px solid #333;
      background-color: #fff;
      color: #000;
  }
   </style> 
</head>
<body>
 <div class="container">
   <B:set var="imageFolder"  value="/lib/image/productImage/"/>
     <br><br><br><br>
      <div class="container">
     <center>
     <img src="<B:url value="/lib/image/newL2.png"/>" style="width:900px;height:150px">
     </center>
      </div>
      <br>
     
        <div class="row text-center">
    <B:forEach var="listValue" items="${newArrivalsList}">
    
     <div class = "col-sm-6 col-md-3">
       
          
          <img src="<B:url value="${imageFolder}${listValue.productId}.jpg " />"  class="img-thumbnail" alt="${listValue.productName}" style="width:200; height:255">
     <div class="icon"><img src="<B:url value="/lib/image/newL.png"/>"></div>
     <br> <a href="show_product?id=${listValue.productName}"><button class="btn">Buy Now</button></a>
      </div>
     </B:forEach>
    </div>
     
    </div>
</body>
</html>