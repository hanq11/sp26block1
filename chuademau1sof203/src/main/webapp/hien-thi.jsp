<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lovep
  Date: 2/2/2026
  Time: 5:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    Them bai hat:
    <form action="/bai-hat/add" method="post">
        Ten bai hat: <input type="text" name="tenBaiHat"> <br>
        Gia: <input type="text" name="gia"> <br>
        Phat hanh dia:
            Roi: <input type="radio" name="phatHanhDia" value="true">
            Chua: <input type="radio" name="phatHanhDia" value="false">
        <br>
        Ngay ra mat: <input type="text" name="ngayRaMat">
        <br>
        <button>Save</button>
    </form>
    <br>
    Bang bai hat:
    <table>
        <thead>
            <tr>
                <th>id</th>
                <th>tenBaiHat</th>
                <th>gia</th>
                <th>phatHanhDia</th>
                <th>ngayRaMat</th>
                <th>hanh dong</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${listBaiHat}" var="bh">
                <tr>
                    <td>${bh.id}</td>
                    <td>${bh.tenBaiHat}</td>
                    <td>${bh.gia}</td>
                    <td>${bh.phatHanhDia == true ? "Roi" : "Chua"}</td>
                    <td>${bh.ngayRaMat}</td>
                    <td>
                        <a href="/bai-hat/view-update?id=${bh.id}">View update</a>
                        <a href="/bai-hat/delete?id=${bh.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
