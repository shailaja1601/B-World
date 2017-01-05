
<html>
<head>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<link href="<c:url value="/lib/css/bootstrap.css" />" rel="stylesheet">
    <script src="<c:url value="/lib/js/jquery.js" />"></script>
    <script src="<c:url value="/lib/js/bootstrap.js" />"></script>
    <style>
 
  .carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
      width: 70%;
      margin: auto;
  }
  </style>
</head>
<body>
 <div class="container">
   <c:set var="imageFolder"  value="/lib/image/categoryImage/"/>
     
  <br>
  <div id="myCarousel" class="carousel slide"  data-ride="carousel" >
    <!-- Indicators -->
    <ol class="carousel-indicators">
    <c:forEach begin="0" end="${categoryList.size()-1}" varStatus="loop">
    <c:choose>
    <c:when test="${loop=='0'}">
      <li data-target="#myCarousel" data-slide-to="loop" class="active"></li>
      </c:when>
      <c:otherwise>
      <li data-target="#myCarousel" data-slide-to="loop"></li>
      </c:otherwise>
      </c:choose>
      </c:forEach>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
    <c:set var="count" value="0"/>
    <c:forEach var="listValue" items="${categoryList}">
    <c:choose>
    <c:when test="${count=='0'}">
      <div class="item active">
       <a href="open_category?id=${listValue.categoryName}"> <img src="<c:url value="${imageFolder}${listValue.categoryId}.jpg " />" alt="${listValue.categoryName}" style="width:1200; height:500"></a>
        <div class="carousel-caption">
            <h3 align="center">${listValue.categoryName}</h3>
            </div>
      </div>
      <c:set var="count" value="1"></c:set>
      </c:when>
      <c:otherwise>
    <div class="item">
                <a href="open_category?id=${listValue.categoryName}"><img src="<c:url value="${imageFolder}${listValue.categoryId}.jpg " />" alt="${listValue.categoryName}" style="width:1200; height:500"></a>
                <div class="carousel-caption">
            <h3 align="center">${listValue.categoryName}</h3>
            </div>
        </div>
        </c:otherwise>
        </c:choose>
        </c:forEach>
        </div>
    
    <!-- Left and right controls -->
     <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>   
</body>
</html>