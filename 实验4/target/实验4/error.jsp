<%--
  Created by IntelliJ IDEA.
  User: 尹浩男
  Date: 2020/9/24
  Time: 19:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String errorMessage1 = (String) request.getAttribute("error1");
    String errorMessage2 = (String) request.getAttribute("error2");
    String str = "";
    if(errorMessage1!=null && errorMessage1.length() > 0)
         str += errorMessage1 + "  ";
    if(errorMessage2!=null && errorMessage2.length() > 0)
        str += errorMessage2 + "  ";
%>
<html>
<head>
    <title>error</title>
</head>
<body>
    <h1>
      <%=str%>
    </h1>
    <h2>
        <a href="/login.jsp">点击重新跳转到登录界面</a>
    </h2>
</body>
</html>
