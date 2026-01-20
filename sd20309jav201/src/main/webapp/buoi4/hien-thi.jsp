<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lovep
  Date: 1/13/2026
  Time: 3:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    Tim kiem giang vien:
    <form action="/giang-vien/tim-kiem" method="get">
        Ten: <input type="text" name="tenGiangVien"> <br>
        <button>Search</button>
    </form>
    <br>
    Them giang vien:
    <form action="/giang-vien/them" method="post">
        Ten giang vien: <input type="text" name="tenGiangVien"> <br>
        Tuoi: <input type="text" name="tuoi"> <br>
        Gioi tinh:
            Nam: <input type="radio" name="gioiTinh" value="false">
            Nu: <input type="radio" name="gioiTinh" value="true">
        <br>
        Truong hoc:
            <select name="idTruongHoc">
                <c:forEach items="${listTruongHoc}" var="th">
                    <option value="${th.id}" label="${th.tenTruong}"></option>
                </c:forEach>
            </select>
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
    <a href="/giang-vien/phan-trang?page=0">First</a>
    <a href="/giang-vien/phan-trang?page=${page == 0 ? 0 : page - 1}">Prev</a>
    <a href="/giang-vien/phan-trang?page=${page == totalPages - 1 ? page : page + 1}">Next</a>
    <a href="/giang-vien/phan-trang?page=${totalPages - 1}">Last</a>
    <br>
    <c:forEach begin="0" end="${totalPages - 1}" varStatus="i">
        <a
                href="/giang-vien/phan-trang?page=${i.index}"
                style="${page == i.index ? 'color: red' : ''}"
        >${i.index + 1}</a>
    </c:forEach>
</body>
</html>
