<%--
  Created by IntelliJ IDEA.
  User: 尹浩男
  Date: 10/9/2020
  Time: 6:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>success</title>
</head>
<body>
<!--Integer id, String username, String password, String email,
Integer age, String tel, String addr, String idNumber, Integer married,
 Double salary-->
    注册成功 你的注册信息是: <br>
    用户名:  ${user.username} <br>
    密码:  ${user.password} <br>
    邮箱:  ${user.email} <br>
    年龄:  ${user.age} <br>
    电话:  ${user.tel} <br>
    住址:  ${user.addr} <br>
    身份证号:  ${user.idNumber} <br>
    是否结婚:  ${user.married} <br>
    薪酬:  ${user.salary} <br>
</body>
</html>
