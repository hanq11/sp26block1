<%--
  Created by IntelliJ IDEA.
  User: lovep
  Date: 1/29/2026
  Time: 9:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    ${message}
    <form action="/login" method="post">
        username: <input type="text" name="username"> <br>
        password: <input type="text" name="password"> <br>
        <button>Login</button>
    </form>
</body>
</html>
