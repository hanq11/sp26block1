<%--
  Created by IntelliJ IDEA.
  User: lovep
  Date: 1/25/2026
  Time: 8:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    Sua nguoi dung:
    <form action="/nguoi-dung/sua" method="post">
        Id: <input type="text" name="id" value="${nd.id}" readonly> <br>
        Ten: <input type="text" name="ten" value="${nd.ten}"> <br>
        Email: <input type="text" name="email" value="${nd.email}"> <br>
        Tuoi: <input type="text" name="tuoi" value="${nd.tuoi}"> <br>
        Dang hoat dong:
        Dang hoat dong: <input type="radio" name="dangHoatDong" value="true" ${nd.dangHoatDong == true ? "checked" : ""}>
        Khong hoat dong: <input type="radio" name="dangHoatDong" value="false" ${nd.dangHoatDong == false ? "checked" : ""}>
        <br>
        <button>Save</button>
    </form>
</body>
</html>
