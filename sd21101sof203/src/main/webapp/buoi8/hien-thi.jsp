<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lovep
  Date: 1/21/2026
  Time: 6:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    Them nguoi dung:
    <form action="/nguoi-dung/them" method="post">
        Ten: <input type="text" name="ten"> <br>
        Email: <input type="text" name="email"> <br>
        Tuoi: <input type="text" name="tuoi"> <br>
        Dang hoat dong:
            Dang hoat dong: <input type="radio" name="dangHoatDong" value="true">
            Khong hoat dong: <input type="radio" name="dangHoatDong" value="false">
        <br>
        <button>Save</button>
    </form>
    <br>
    Bang nguoi dung:
    <table>
        <thead>
            <tr>
                <th>Id</th>
                <th>Ten</th>
                <th>Email</th>
                <th>Tuoi</th>
                <th>Dang hoat dong</th>
                <th>Hanh dong</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${listNguoiDung}" var="nd">
                <tr>
                    <td>${nd.id}</td>
                    <td>${nd.ten}</td>
                    <td>${nd.email}</td>
                    <td>${nd.tuoi}</td>
                    <td>${nd.dangHoatDong == false ? "Khong hoat dong" : "Hoat dong"}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
