<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lovep
  Date: 1/24/2026
  Time: 9:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    Sua don hang:
    <form action="/don-hang/sua" method="post">
        id <input type="text" name="id" value="${donHang.id}"> <br>
        tenKhachHang <input type="text" name="tenKhachHang" value="${donHang.tenKhachHang}"> <br>
        ngayMua <input type="text" name="ngayMua" value="${donHang.ngayMua}"> <br>
        tongTien <input type="text" name="tongTien" value="${donHang.tongTien}"> <br>
        daThanhToan:
        Da thanh toan <input type="radio" name="daThanhToan" value="true" ${donHang.daThanhToan == true ? "checked" : ""}>
        Chua thanh toan <input type="radio" name="daThanhToan" value="false" ${donHang.daThanhToan == false ? "checked" : ""}>
        <br>
        San pham:
        <select name="idSanPham">
            <c:forEach items="${listSanPham}" var="sp">
                <option value="${sp.id}" label="${sp.tenSanPham}" ${donHang.sanPham.id == sp.id ? "selected" : ""}></option>
            </c:forEach>
        </select>
        <br>
        <button>Save</button>
    </form>
</body>
</html>
