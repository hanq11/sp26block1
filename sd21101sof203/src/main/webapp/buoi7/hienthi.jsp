<%--
  Created by IntelliJ IDEA.
  User: Huyen
  Date: 1/19/2026
  Time: 5:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <th>STT</th>
        <th>ID</th>
        <th>Mã</th>
        <th>Tên</th>
        <th>Tuổi</th>
        <th>Giới tính</th>
        <th>Quê quán</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${listGVs}" var="gv" varStatus="i">
        <tr>
            <td>${i.index+1}</td>
            <td>${gv.id}</td>
            <td>${gv.ma}</td>
            <td>${gv.ten}</td>
            <td>${gv.tuoi}</td>
            <td>${gv.gioiTinh}</td>
            <td>${gv.queQuan}</td>
        </tr>

    </c:forEach>
</table>

</body>
</html>
