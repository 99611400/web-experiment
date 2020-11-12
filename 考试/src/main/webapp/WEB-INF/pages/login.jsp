<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户登录</title>
</head>
<body>
    <form action="<%=request.getContextPath()%>/login" method="post">
        <h4 style="color: red;">${error}</h4>
        登录界面 <br>
        用户名 : <input type="text" name="username"><br>
        密码  : <input type="text" name="password"> <br>
        <input type="submit" value="提交">
    </form>
</body>
</html>