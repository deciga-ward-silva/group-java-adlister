<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<<<<<<< HEAD
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
=======

>>>>>>> b446132f5392a265bf79f78d0744ca0799297fbf
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Please Log In" />
    </jsp:include>
<<<<<<< HEAD

    <h3>Profile</h3>
</head>
<div class="container">
    <h1>Welcome, ${sessionScope.user.username}!</h1>
</div>
=======
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
</head>

<br>
<br>
<br>
<br>
<br>
    <div class="container">
        <h3>Profile</h3>
        <h1>Welcome, ${sessionScope.user.username}!</h1>
        <button type="button" class="btn btn-danger">Edit Profile</button>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script>

>>>>>>> b446132f5392a265bf79f78d0744ca0799297fbf
</head>
<body>
<br>
<br>
<br>
<<<<<<< HEAD
<button type="button" class="btn btn-danger">Edit Profile</button>
<a href="/ads/create" class="btn btn-primary">Create New Ad</a>
<a href="/ads/delete" class="btn btn-primary">Delete Ad</a>
<br>
=======

<a href="/ads/create" class="btn btn-primary">Create New Ad</a>
<a href="/ads/delete" class="btn btn-primary">Delete Ad</a>



<br>

>>>>>>> b446132f5392a265bf79f78d0744ca0799297fbf
<div class="container">
    <h1>Ads-List</h1>
    <c:forEach var="ad" items="${ads}">
        <div>
            <h2>${ad.title}</h2>
            <p>${ad.description}</p>
        </div>
    </c:forEach>
</div>





<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script>
</body>
</html>