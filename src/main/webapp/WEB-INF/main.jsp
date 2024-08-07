<%--
  Created by IntelliJ IDEA.
  User: a
  Date: 2024-08-05
  Time: 오후 3:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <h1>
      main.jsp
  </h1>
  <p>${aniList}</p>
     <c:forEach items="${aniList}" var="goods">
        <div class="goods">
               ${goods}
            <a href="/goods=${goods.ano}">
                <img src="/img/${goods.img1}">
            </a>
       </div>
     </c:forEach>
</body>
</html>
