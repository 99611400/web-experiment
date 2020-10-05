<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
    <script>
        window.onload = function (){
            let oButton = document.getElementById("submit");
            let oUsernameText = document.getElementById("username");
            let oPasswordText = document.getElementById("password");
            oButton.onclick = function (){
                if(oUsernameText.value ===null ||oUsernameText.value ==="" ){
                    alert("用户名不能为空");
                }
                if(oPasswordText.value === null ||oPasswordText.value === "" ){
                    alert("密码不能为空");
                }
            }
        }
    </script>
<body>
    <form action="/login" method="post">
        用户名 <input type="text"  id="username" name="username"> <br>
        密码 <input type="password" id="password" name="password" >  <br>
        <input type="submit" id="submit" value="提交" >
    </form>
</body>
</html>