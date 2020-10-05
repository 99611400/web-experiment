<%--
  Created by IntelliJ IDEA.
  User: 尹浩男
  Date: 10/4/2020
  Time: 7:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>

</head>

<body>
    <form action="/login" method="post">
        用户名： <input type="text" name="username"><br>
        密码： <input type="text" name="password"><br>
        <input type="submit" value="登录" id="loginSubmit">
    </form>
</body>

</html>
