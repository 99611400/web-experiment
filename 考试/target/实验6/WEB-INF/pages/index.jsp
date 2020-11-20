<%--
  Created by IntelliJ IDEA.
  User: 尹浩男
  Date: 10/10/2020
  Time: 10:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
</head>
<body>
    请选择您要办理的业务 <br>
    <a href="<%=request.getContextPath()%>/loginJsp">登录</a> <br>
    <a href="<%=request.getContextPath()%>/registerJsp">注册</a> <br>
    <a href="<%=request.getContextPath()%>/findAll">查看所有用户信息</a> <br>
    <a href="<%=request.getContextPath()%>/search">搜索</a>
</body>
</html>
