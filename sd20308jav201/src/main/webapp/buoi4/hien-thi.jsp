<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lovep
  Date: 1/13/2026
  Time: 1:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    Them giang vien:
    <form action="/giang-vien/them" method="post">
        Ten giang vien: <input type="text" name="tenGiangVien"> <br>
        Tuoi: <input type="text" name="tuoi"> <br>
        Gioi tinh:
            Nam: <input type="radio" value="false" name="gioiTinh">
            Nu: <input type="radio" value="true" name="gioiTinh">
        <br>
        Truong hoc:
            <select name="idTruongHoc">
                <c:forEach items="${listTruongHoc}" var="th">
                    <option value="${th.id}" label="${th.tenTruong}"></option>
                </c:forEach>
            </select>
        <br>
        <button>Save</button>
    </form>
    <br>
    Bang thong tin:
    <table>
        <thead>
        <tr>
            <th>Id</th>
            <th>Ten giang vien</th>
            <th>Tuoi</th>
            <th>Gioi tinh</th>
            <th>Ten truong</th>
            <th>Dia chi truong</th>
            <th>Hanh dong</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listGiangVien}" var="gv">
            <tr>
                <td>${gv.id}</td>
                <td>${gv.tenGiangVien}</td>
                <td>${gv.tuoi}</td>
                <td>${gv.gioiTinh == false ? "Nam" : "Nu"}</td>
                <td>${gv.truongHoc.tenTruong}</td>
                <td>${gv.truongHoc.diaChi}</td>
                <td>
                    <a href="/giang-vien/view-update?id=${gv.id}">View update</a>
                    <a href="/giang-vien/xoa?id=${gv.id}">Xoa</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>
