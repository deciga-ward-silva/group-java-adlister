<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
  <title>Profile</title>
</head>
<body>

<h1>My Profile</h1>

<h2>My Ads</h2>
<table>
  <thead>
  <tr>
    <th>ID</th>
    <th>Title</th>
    <th>Description</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="ad" items="${userAds}">
    <tr>
      <td>${ad.id}</td>
      <td>${ad.title}</td>
      <td>${ad.description}</td>
    </tr>
  </c:forEach>
  </tbody>
</table>

</body>
</html>