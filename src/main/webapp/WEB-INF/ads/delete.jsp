<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix=""%>
<html>
<head>
 HEAD
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