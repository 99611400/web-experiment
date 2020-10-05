<%--
  Created by IntelliJ IDEA.
  User: 尹浩男
  Date: 2020/9/20
  Time: 23:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>old</title>
</head>
<body>
<% String name = request.getParameter("name"); %>  <!--获取从后端得到的name值-->
    <h1>欢迎你 老先生 <%=name%></h1>
</body>
</html>
