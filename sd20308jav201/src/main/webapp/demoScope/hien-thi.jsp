<%--
  Created by IntelliJ IDEA.
  User: lovep
  Date: 1/24/2026
  Time: 12:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%
    pageContext.setAttribute("pageMessage", "From page scope");
%>
<body>
<%--    request scope--%>
    Message lay tu request scope: ${demoRequestScope} <br>
<%--session scope--%>
    Message lay tu session scope: ${sessionScope.demoSessionScope} <br>
<%--application scope--%>
    Message lay tu application scope: ${applicationScope.demoApplicationScope} <br>
<%--page scope--%>
    Message lay tu page: ${pageMessage}
</body>
</html>
