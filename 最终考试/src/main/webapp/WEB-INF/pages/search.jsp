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



    <form action="<%=request.getContextPath()%>/searchWorker" method="post">
        搜索界面 <br>
        workerno : <input type="text" name="workerno" ><br>
        workname : <input type="text" name="workname" ><br>
        workerage  : <input type="text" name="workerage" >  <br>
        workerdesc: <input type="text" name="workerdesc" >  <br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
