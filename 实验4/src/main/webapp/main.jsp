<%--
  Created by IntelliJ IDEA.
  User: 尹浩男
  Date: 2020/9/24
  Time: 19:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String username =  (String) request.getAttribute("username");

%>
<html>
<head>
    <title>登录成功</title>
</head>
<body>
    <h1>登录成功，欢迎您  <%=username%></h1>
    <h2>
        <a href="/login.jsp">点击重新跳转到登录界面</a>
    </h2>
</body>
</html>
