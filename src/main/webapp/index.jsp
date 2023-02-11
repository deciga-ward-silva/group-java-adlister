<%--JSP Directive--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--JSTL TAG--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>

<%--JSP Adding Header Content--%>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Welcome to my site!" />
    </jsp:include>
</head>
<body>
<%--JSP Adding navbar--%>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />


<%--Main title for webage--%>
    <div class="Main Title">
        <h1>Welcome to the Adlister!</h1>
    </div>

<%--Ads table to display single ad--%>
<div class="ads container">
    <h1>Ad Details</h1>

    <table class="ads table">

        <tr>
            <th>Ads Title name</th>
            <td><c:out value="${ads.title}"></c:out></td>
        </tr>

        <tr>Ads Description</tr>
        <td><c:out value="${ads.description}"></c:out></td>

        <tr>Ads Price</tr>
        <td><c:out value="${ads.price}"></c:out></td>


    </table>


<%--For each was created to display every add within the database.--%>
    <tbody>
    <c:forEach items="${ads}" var="ad">

        <tr>
<%--For each iteration of the loop, the href will create a different link to access the details of each add. --%>
            <td><a href="ad?id=${ad.id}"></a></td>
        </tr>

    </c:forEach>
    </tbody>
</div>






</body>
</html>
