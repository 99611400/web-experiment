<%--
  Created by IntelliJ IDEA.
  User: 尹浩男
  Date: 10/9/2020
  Time: 10:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>regiter</title>
</head>
<body>
    <form action="<%=request.getContextPath()%>/register" method="post">
        <h4 style="color: red;">${error}</h4>
        注册界面 <br>
        用户名 : <input type="text" name="username"><br>
        密码  : <input type="text" name="password"> <br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
