<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lovep
  Date: 1/17/2026
  Time: 1:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    Sua giang vien:
    <form action="/giang-vien/sua" method="post">
        Id: <input type="text" name="id" value="${gv.id}"> <br>
        Ten giang vien: <input type="text" name="tenGiangVien" value="${gv.tenGiangVien}"> <br>
        Tuoi: <input type="text" name="tuoi" value="${gv.tuoi}"> <br>
        Gioi tinh:
        Nam: <input type="radio" value="false" name="gioiTinh" ${gv.gioiTinh == false ? "checked" : ""}>
        Nu: <input type="radio" value="true" name="gioiTinh" ${gv.gioiTinh == true ? "checked" : ""}>
        <br>
        Truong hoc:
        <select name="idTruongHoc">
            <c:forEach items="${listTruongHoc}" var="th">
                <option value="${th.id}" label="${th.tenTruong}" ${gv.truongHoc.id == th.id ? "selected" : ""}></option>
            </c:forEach>
        </select>
        <br>
        <button>Save</button>
    </form>
</body>
</html>
