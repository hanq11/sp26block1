<%--
  Created by IntelliJ IDEA.
  User: lovep
  Date: 2/2/2026
  Time: 5:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    Sua bai hat:
    <form action="/bai-hat/update" method="post">
        Id: <input type="text" name="id" value="${baiHat.id}"> <br>
        Ten bai hat: <input type="text" name="tenBaiHat" value="${baiHat.tenBaiHat}"> <br>
        Gia: <input type="text" name="gia" value="${baiHat.gia}"> <br>
        Phat hanh dia:
        Roi: <input type="radio" name="phatHanhDia" value="true" ${baiHat.phatHanhDia == true ? "checked" : ""}>
        Chua: <input type="radio" name="phatHanhDia" value="false" ${!baiHat.phatHanhDia == true ? "checked" : ""}>
        <br>
        Ngay ra mat: <input type="text" name="ngayRaMat" value="${baiHat.ngayRaMat}">
        <br>
        <button>Save</button>
    </form>
</body>
</html>
