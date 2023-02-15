<%@ page import="com.codeup.adlister.models.Ad" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Ad Details</title>
</head>
<body>
<h1>Ad Details</h1>
<%
  Ad ad = (Ad) request.getAttribute("ad");
  if (ad != null) {
%>
<p>Name: <%= ad.getTitle() %></p>
<p>Description: <%= ad.getDescription() %></p>
<%
} else {
%>
<p>Ad not found</p>
<%
  }
%>
</body>
</html>
