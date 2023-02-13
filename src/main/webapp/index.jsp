<%--JSP Directive--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--JSTL TAG--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
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
            <th>Title</th>
            <td><c:out value="${ads.title}"></c:out></td>
        </tr>

        <tr>
            <th>Description</th>
            <td><c:out value="${ads.description}"></c:out></td>
        </tr>


        <tr>
            <th>Price</th>
            <td><c:out value="${ads.price}"></c:out></td>
        </tr>


    </table>

    <%--POTENTIAL EDIT, UPDATE, DELETE FORM FOR FUNCTIONALITY--%>

    <%--Update--%>
    <form action="updateAd" method="post">
        <input type="hidden" name="id" value="${ads.id}" />
        <input type="submit" value="Update Ad"/>
    </form>
    <%--Delete--%>
    <form action="deletedAd" method="post">
        <input type="hidden" name="id" value="${ad.id}"/>
        <input type="submit" value="Delete Ad"/>
    </form>


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
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script>
</body>
</html>








