<%--
  Created by IntelliJ IDEA.
  User: stevedeciga
  Date: 2/12/23
  Time: 11:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Delete Ad</title>
</head>
<body>
<h2>Are you sure you want to delete this ad?</h2>
<form action="/ads/delete" method="get">
  <input type="hidden" name="id" value="${ad.id}"/>
  <input type="submit" value="Delete"/>
</form>
</body>
</html>

