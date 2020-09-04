$(function () {
    $("#submitInput").click(function (){
        let name = $("#name").val();
        let number = $("#number").val();
        let numberPatten = /^\d{4}-\d{4}-\d{4}-\d{4}$/;
        let namePatten = /^[a-zA-Z0-9\u4e00-\u9fa5]+$/;
        let str ="";
        if (numberPatten.test(number) && namePatten.test(name)){
            alert("正确");
        }else{
            if(numberPatten.test(number) == false) //如果卡号错误
                str += "卡号错误！！！\n";
            else if(numberPatten.test(number) == true)
                str += "卡号正确\n"
            if(namePatten.test(name) == false) //如果名字错误
                str += "名字输入错误！！！\n";
            else if(namePatten.test(name) == true)
                str += "名字输入正确\n";
            alert("输入存在错误 \n" + str)
        }
    })
});