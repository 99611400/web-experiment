<%--
  Created by IntelliJ IDEA.
  User: 尹浩男
  Date: 11/12/2020
  Time: 3:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>search</title>
</head>
<body>
<body>
<h1>符合条件的工人信息有</h1>
<table border="1" cellspacing="0" cellpadding="0">
    <tr>
        <td>workerno</td>
        <td>workname</td>
        <td>workerage</td>
        <td>workerdesc</td>

    </tr>
    <c:forEach items="${list}" var="worker">
        <tr>
            <td>${worker.workerno}</td>
            <td>${worker.workname}</td>
            <td>${worker.workerage}</td>
            <td>${worker.workerdesc}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
