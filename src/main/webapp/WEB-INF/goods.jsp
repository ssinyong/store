<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>

<body>

<%@ include file="includes/header.jsp"%>
  <h1>
      goods.jsp
  </h1>
<style>
    .goods img{
        width: 300px;
    }
</style>

  <c:forEach items="${goodslist}" var="goods">
      <div class="goods">
              ${goods}
          <a href="/view?mno=${goods.mno}">
              <img src="/img/${goods.img1}">
          </a>
      </div>
  </c:forEach>

  <h1>Goods List</h1>
  <p>${goodslist}</p>

</body>
</html>

<%@ include file="includes/footer.jsp"%>