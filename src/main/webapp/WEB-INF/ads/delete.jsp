<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>
<head>
  <title>Delete</title>
  <jsp:include page="/WEB-INF/partials/head.jsp">
    <jsp:param name="title" value="Create a new Ad"/>
  </jsp:include>
</head>
<body>
<h2>Are you sure you want to delete this ad?</h2>
<form action="/ads/delete" method="POST">
  <input type="hidden" name="id" value="${ad.id}"/>
  <input type="submit" value="Delete"/>
</form>
</body>
</html>

