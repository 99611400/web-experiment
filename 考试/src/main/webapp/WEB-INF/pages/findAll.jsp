<%--
  Created by IntelliJ IDEA.
  User: 尹浩男
  Date: 10/8/2020
  Time: 10:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>所有用户查看</title>
</head>
<body>
    <table border="1" cellspacing="0" cellpadding="0">
        <tr>
            <td>id</td>
            <td>用户名</td>
            <td>密码</td>
            <td>邮箱</td>
            <td>年龄</td>
            <td>性别</td>
            <td>电话</td>
            <td>住址</td>
            <td>身份证号</td>
            <td>是否结婚</td>
            <td>薪酬</td>
            <td>编辑</td>
            <td>删除</td>
        </tr>
        <c:forEach items="${list}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>${user.password}</td>
                <td>${user.email}</td>
                <td>${user.age}</td>
                <td>${user.sex}</td>
                <td>${user.tel}</td>
                <td>${user.addr}</td>
                <td>${user.idNumber}</td>
                <td>${user.married}</td>
                <td>${user.salary}</td>
                <td><a href="/queryUpdate?id=${user.id}">编辑</a></td>
                <td><a href="/delete?id=${user.id}">删除</a></td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
