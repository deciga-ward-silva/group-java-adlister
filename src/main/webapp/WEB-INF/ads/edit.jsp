<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>
    <title>Edit Ad</title>
</head>
<body>

<h1>Edit Ad</h1>



<form action="/ads/edit" method="post">
    <input type="hidden" name="id" value="${ad.id}">

    <div>
        <label>Title:</label>
        <input type="text" name="title" value="${ad.title}">
    </div>

    <div>
        <label>Description</label>
        <textarea name="description">${ad.description}</textarea>
    </div>

    <input type="submit" value="Save Changes">
</form>

</body>
</html>
