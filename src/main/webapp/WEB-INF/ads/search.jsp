<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Search Results</h1>
<c:choose>
    <c:when test="${not empty ad}">
        <div class="ad">
            <h2><a href="/ads/${ad.id}">${ad.title}</a></h2>
            <p>${ad.description}</p>
        </div>
    </c:when>
    <c:when test="${not empty errorMessage}">
        <div class="alert alert-danger">${errorMessage}</div>
    </c:when>
    <c:otherwise>
        <div class="alert alert-info">No search result.</div>
    </c:otherwise>
</c:choose>



</body>
</html>
