<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lovep
  Date: 1/8/2026
  Time: 3:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    Them truong hoc:
    <form action="/truong-hoc/them" method="post">
        Ten truong: <input type="text" name="tenTruong"> <br>
        Dia chi: <input type="text" name="diaChi"> <br>
        <button>Save</button>
    </form>
    <br>
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
                    <td>
                        <a href="/truong-hoc/view-update?id=${th.id}">View update</a>
                        <a href="/truong-hoc/xoa?id=${th.id}">Xoa</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
