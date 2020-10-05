<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>yhn</title>
    <script type="text/javascript">
        window.onload = function (){  //javascript 代码用来提示在前端提升用户 姓名不能为空
            let oButton1 = document.getElementById("submit1");
            let oButton2 = document.getElementById("submit2");
            let oName1 = document.getElementById("name1");
            let oName2 = document.getElementById("name2");
            let name1 = oName1.value;
            let name2 = oName2.value;
            oButton1.onclick = function (){
                name1 = oName1.value;
                if(name1 === "")
                    alert("get提交中姓名不能为空");
            }
            oButton2.onclick = function (){
                name2 = oName2.value;
                if(name2 === "")
                    alert("post提交中姓名不能为空");
            }
        }
    </script>
</head>
<body>
    <form action="/hello" method="get">  <!--此表单提交方式为    get    -->
        姓名: <input type="text" id="name1" name="name"> <br>
        年龄: <input type="text" name="age"> <br>
        所在学校: <input type="text" name="school"> <br>
        <input type="submit" value="提交" id="submit1" >
    </form>
<hr>
    <form action="/hello" method="post">  <!--此表单提交方式为    post    -->
        姓名: <input name="name" id="name2"> <br>
        年龄: <input name="age"> <br>
        所在学校: <input name="school"> <br>
        <input type="submit" value="提交" id="submit2">
    </form>
</body>
</html>