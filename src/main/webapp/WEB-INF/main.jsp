<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
    <title>Bootstrap Example</title>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body class="p-3 m-0 border-0 bd-example m-0 border-0">

  <style>
      .d-block {
          width: 100%; /* 이미지가 부모 컨테이너의 너비를 채우도록 설정 */
          height: 900px; /* 이미지의 높이를 자동으로 설정하여 비율 유지 */
          max-width: 1000px; /* 최대 너비를 1000px로 설정 */
          margin: 0 auto; /* 이미지를 가운데 정렬 */
      }
      .carousel-control-prev-icon,
      .carousel-control-next-icon {
          background-color: black; /* 버튼 아이콘을 검정색으로 설정 */
          background-size: 100%, 100%; /* 아이콘 크기를 조정 */
      }
  </style>
  <div id="carouselExampleIndicators" class="carousel slide">
      <div class="carousel-indicators">
          <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
          <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
          <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
          <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="3" aria-label="Slide 4"></button>
      </div>
      <div class="carousel-inner">
          <c:forEach items="${aniList}" var="ani">
              <div class="carousel-item ${ani.ano == 1?'active':''}">
                  <a href="/goods?ano=${ani.ano}">
                    <img src="/img/a${ani.ano}.jpg" class="d-block w-100 h-100" alt="...">
                  </a>
              </div>
          </c:forEach>
      </div>
      <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Previous</span>
      </button>
      <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Next</span>
      </button>
  </div>

</body>
</html>