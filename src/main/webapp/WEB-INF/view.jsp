<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<style>
    .goods img{
        width: 300px;
    }
</style>
<div class="goods">
    <h1>goods</h1>
    <p>${goods} </p>
    <img src="/img/${goods.img1}">
    <img src="/img/${goods.img2}">
</div>
<a href="/goods">
    <button>돌아가기</button>
</a>
<form action="/cart" method="post">
    <input type="hidden" name="mno" value="${goods.mno}">
    <button>담기</button>
</form>
</body>
</html>