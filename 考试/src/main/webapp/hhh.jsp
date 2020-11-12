<%--
  Created by IntelliJ IDEA.
  User: 尹浩男
  Date: 10/10/2020
  Time: 6:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%  String str = request.getContextPath();
        response.sendRedirect(str +"/index"); %>
</body>
</html>
