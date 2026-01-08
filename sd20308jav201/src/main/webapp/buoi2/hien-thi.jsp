<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lovep
  Date: 1/8/2026
  Time: 1:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    Bang thong tin:
    <table>
        <thead>
            <tr>
                <th>Id</th>
                <th>Ten truong</th>
                <th>Dia chi</th>
                <th>Hanh dong</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${listTruongHoc}" var="th">
                <tr>
                    <td>${th.id}</td>
                    <td>${th.tenTruong}</td>
                    <td>${th.diaChi}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
