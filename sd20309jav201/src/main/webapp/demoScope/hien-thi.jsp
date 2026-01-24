<%--
  Created by IntelliJ IDEA.
  User: lovep
  Date: 1/24/2026
  Time: 2:47 PM
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
    Message tu request scope: ${requestMessage} <br>
<%--session scope--%>
    Message tu session scope: ${sessionScope.sessionMessage} <br>
<%--application scope--%>
    Message tu application scope: ${applicationScope.applicationMessage} <br>
<%--page scope--%>
    Message tu page scope: ${pageMessage}
</body>
</html>
