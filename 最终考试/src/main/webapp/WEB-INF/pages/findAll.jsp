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
