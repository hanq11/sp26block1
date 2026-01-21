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
