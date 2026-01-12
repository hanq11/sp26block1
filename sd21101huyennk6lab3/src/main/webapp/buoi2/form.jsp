<%--
  Created by IntelliJ IDEA.
  User: lovep
  Date: 1/12/2026
  Time: 5:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/buoi2/signin" method="post">
        Ho va ten: <input type="text" name="hoTen"> <br>
        Ngay sinh: <input type="date" name="ngaySinh"> <br>
        So dien thoai: <input type="text" name="soDienThoai"> <br>
        Gioi tinh:
            Nam: <input type="radio" name="gioiTinh" value="nam">
            Nu: <input type="radio" name="gioiTinh" value="nu">
        <br>
        Dia chi: <textarea name="diaChi" rows="4" cols="4"></textarea>
        <br>
        Quoc gia:
        <select name="quocGia">
            <option value="vn">Viet nam</option>
            <option value="lao">Lao</option>
        </select>
        <br>
        Mon hoc:
        <select name="monHoc" multiple>
            <option value="toan">Toan</option>
            <option value="van">Van</option>
        </select>
        <br>
        So thich:
            An: <input type="checkbox" name="soThich" value="an">
            Ngu: <input type="checkbox" name="soThich" value="ngu">
        <button type="submit">Save</button>
    </form>
</body>
</html>
