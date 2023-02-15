<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Please Log In" />
    </jsp:include>
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

</head>
<body>
<br>
<br>
<br>



<a href="/ads/create" class="btn btn-primary">Create New Ad</a>
<a href="/ads/delete" class="btn btn-primary">Delete Ad</a>



<br>
<div class="container">
    <h1>Update Ad</h1>
    <form action="/ads/edit" method="post">
        <div class="form-group">
            <label for="adId">Select Ad to Edit</label>
            <select class="form-control" name="adId" id="adId">
                <option value="">Select an ad</option>
                <c:forEach var="ad" items="${ads}">
                    <option value="${ad.id}">${ad.title}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label for="title">Title</label>
            <input type="text" class="form-control" name="title" id="title">
        </div>
        <div class="form-group">
            <label for="description">Description</label>
            <textarea class="form-control" name="description" id="description"></textarea>
        </div>
        <input type="submit" value="Update Ad" class="btn btn-primary">
    </form>
</div>



<br>

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