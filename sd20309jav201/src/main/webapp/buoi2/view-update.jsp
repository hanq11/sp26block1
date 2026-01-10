<%--
  Created by IntelliJ IDEA.
  User: lovep
  Date: 1/10/2026
  Time: 3:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    Sua truong hoc:
    <form action="/truong-hoc/sua" method="post">
        Id: <input type="text" name="id" value="${th.id}"> <br>
        Ten truong: <input type="text" name="tenTruong" value="${th.tenTruong}"> <br>
        Dia chi: <input type="text" name="diaChi" value="${th.diaChi}"> <br>
        <button>Save</button>
    </form>
</body>
</html>
