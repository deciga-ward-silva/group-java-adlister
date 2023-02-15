<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<<<<<<< HEAD
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  HEAD
=======
<%@taglib prefix=""%>
<html>
<head>
 HEAD
>>>>>>> b446132f5392a265bf79f78d0744ca0799297fbf
  <title>Delete Ad</title>
</head>
<body>
<h2>Are you sure you want to delete this ad?</h2>
<form action="/ads/delete" method="get">
  <input type="hidden" name="id" value="${ad.id}"/>
  <input type="submit" value="Delete"/>
</form>
</body>
<<<<<<< HEAD
</html>
=======

</html>
>>>>>>> b446132f5392a265bf79f78d0744ca0799297fbf
