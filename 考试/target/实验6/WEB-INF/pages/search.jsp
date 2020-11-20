<%--
  Created by IntelliJ IDEA.
  User: 尹浩男
  Date: 11/12/2020
  Time: 3:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>search</title>
</head>
<body>
    <form action="<%=request.getContextPath()%>/searchUser" method="post">
        搜索界面 <br>
        id : <input type="text" name="id" value="${user.id}"><br>
        用户名 : <input type="text" name="username" value="${user.username}"><br>
        密码  : <input type="text" name="password" value="${user.password}">  <br>
        email: <input type="text" name="email" value="${user.email}">  <br>
        age: <input type="text" name="age" value="${user.age}">  <br>
        sex: <input type="text" name="sex" value="${user.sex}">  <br>
        tel: <input type="text" name="tel" value="${user.tel}">  <br>
        addr : <input type="text" name="addr" value="${user.addr}">  <br>
        idNumber : <input type="text" name="idNumber" value="${user.idNumber}">  <br>
        salary : <input type="text" name="salary" value="${user.salary}">  <br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
