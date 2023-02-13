
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Edit Profile</title>
</head>
<body>

<h2>Edit Profile</h2>

<form action="updateProfile" method="post">

  <div>
    <label for="username">Username:</label>
    <input type="text" id="username" name="username" value="<%= request.getAttribute("username") %>" required>
  </div>

  <div>
    <label for="email">Email:</label>
    <input type="email" id="email" name="email" value="<%= request.getAttribute("email") %>" required>
  </div>

  <div>
    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required>
  </div>

  <div>
    <input type="submit" value="Update">
  </div>

</form>

</body>
</html>
