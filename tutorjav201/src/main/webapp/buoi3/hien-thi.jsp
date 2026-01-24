<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lovep
  Date: 1/22/2026
  Time: 10:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    Tim kiem theo ten khach hang:
    <form action="/don-hang/tim-kiem" method="get">
        Ten khach hang: <input type="text" name="tenKhachHang"> <br>
        <button>Search</button>
    </form>
    <br>
    Them don hang:
    <form action="/don-hang/them" method="post">
        tenKhachHang <input type="text" name="tenKhachHang"> <br>
        ngayMua <input type="text" name="ngayMua"> <br>
        tongTien <input type="text" name="tongTien"> <br>
        daThanhToan:
        Da thanh toan <input type="radio" name="daThanhToan" value="true">
        Chua thanh toan <input type="radio" name="daThanhToan" value="false">
        <br>
        San pham:
            <select name="idSanPham">
                <c:forEach items="${listSanPham}" var="sp">
                    <option value="${sp.id}" label="${sp.tenSanPham}"></option>
                </c:forEach>
            </select>
        <br>
        <button>Save</button>
    </form>

    Bang don hang:
    <table>
        <thead>
            <tr>
                <th>id</th>
                <th>tenKhachHang</th>
                <th>ngayMua</th>
                <th>tongTien</th>
                <th>daThanhToan</th>
                <th>tenSanPham</th>
                <th>giaBan</th>
                <th>Hanh dong</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${listDonHang}" var="dh">
                <tr>
                    <td>${dh.id}</td>
                    <td>${dh.tenKhachHang}</td>
                    <td>${dh.ngayMua}</td>
                    <td>${dh.tongTien}</td>
                    <td>${dh.daThanhToan == true ? "Da thanh toan" : "Chua thanh toan"}</td>
                    <td>${dh.sanPham.tenSanPham}</td>
                    <td>${dh.sanPham.giaBan}</td>
                    <td>
                        <a href="/don-hang/view-update?id=${dh.id}">View update</a>
                        <a href="/don-hang/xoa?id=${dh.id}">Xoa</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
