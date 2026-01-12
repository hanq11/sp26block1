<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lovep
  Date: 1/12/2026
  Time: 5:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    Ho ten: ${hoTen} <br>
    Ngay sinh: ${ngaySinh} <br>
    Mon hoc:
    <c:forEach items="${arrMonHoc}" var="monHoc">
        ${monHoc}
    </c:forEach>
</body>
</html>
