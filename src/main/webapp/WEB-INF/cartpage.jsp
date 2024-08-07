<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .cart-item {
            display: flex;
            align-items: center;
            border-bottom: 1px solid #ddd;
            padding: 10px;
        }
        .cart-item img {
            width: 50px; /* 이미지 크기를 작게 설정 */
            height: auto;
            margin-right: 20px; /* 이미지와 텍스트 사이의 여백 설정 */
        }
        .cart-item-details {
            display: flex;
            flex-direction: column;
        }
        .cart-item-detail {
            margin-right: 20px;
        }
        .cart-item span {
            margin-right: 20px; /* 각 항목 사이의 여백 설정 */
        }
    </style>
</head>
<body>
<h1>cartpage</h1>

<form action="/order" method="post">
   <div>
     <c:forEach var="goods" items="${wantedGoods}">
        <div class="cart-goods">
            <img src="/img/${goods.img1}" alt="${goods.mname}">
            <div class="cart-item-details">
                <span class="cart-item-detail">상품명: ${goods.mname}</span>
                <span class="cart-item-detail">가격: ${goods.mprice} 원</span>

                <input type="hidden" name="mnos" value="${goods.mno}"/>

            </div>
        </div>
     </c:forEach>
   </div>

    <button>order</button>
</form>



<a href="/main">
    <button>목록</button>
</a>
</body>
</html>