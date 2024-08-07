<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>

<body>

<%@ include file="includes/header.jsp"%>

<div class="ani">
    <a href="/goods?ano=${param.ano}&cno=1" class="btn btn-outline-primary">피규어</a>
    <a href="/goods?ano=${param.ano}&cno=2" class="btn btn-outline-secondary">라이프</a>
    <a href="/goods?ano=${param.ano}&cno=3" class="btn btn-outline-success">악세사리</a>
    <a href="/goods?ano=${param.ano}&cno=4" class="btn btn-outline-danger">간식</a>
    <a href="/goods?ano=${param.ano}&cno=5" class="btn btn-outline-warning">문구류</a>
</div>

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