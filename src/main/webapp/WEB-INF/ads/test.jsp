<%@ page import="com.codeup.adlister.models.Ad" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<<<<<<< HEAD
  <title>Ad Details</title>
=======
    <title>Ad Details</title>
>>>>>>> b446132f5392a265bf79f78d0744ca0799297fbf
</head>
<body>
<h1>Ad Details</h1>
<%
<<<<<<< HEAD
  Ad ad = (Ad) request.getAttribute("ad");
  if (ad != null) {
=======
    Ad ad = (Ad) request.getAttribute("ad");
    if (ad != null) {
>>>>>>> b446132f5392a265bf79f78d0744ca0799297fbf
%>
<p>Name: <%= ad.getTitle() %></p>
<p>Description: <%= ad.getDescription() %></p>
<%
} else {
%>
<p>Ad not found</p>
<%
<<<<<<< HEAD
  }
=======
    }
>>>>>>> b446132f5392a265bf79f78d0744ca0799297fbf
%>
</body>
</html>
