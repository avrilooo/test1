<%--
  Created by IntelliJ IDEA.
  User: avrilooo
  Date: 2021/4/18
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="jquery/jquery.js"></script>
    <script>
        //     function dochaxun(){
        //         var xmlHttp=new XMLHttpRequest();
        //         xmlHttp.onreadystatechange=function () {
        //             if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
        //                 //打印查询结果
        //                 var data =xmlHttp.responseText;
        //                 var jsonsql=eval("("+data+")");
        //                 document.getElementById("jiancheng").value=jsonsql.jiancheng;
        //                 document.getElementById("shenghui").value=jsonsql.shenghui;
        //                 }
        //             }
        //         var sheng_id=document.getElementById("shengfen_name").value;
        //         var smail_name=document.getElementById("jiancheng").value;
        //         var shenghui=document.getElementById("shenghui").value;
        //         var mas="sheng_id="+sheng_id+"&sm_name="+smail_name+"&shenghui="+shenghui;
        //         xmlHttp.open("get","sfcx?"+mas,true);
        //         xmlHttp.send();
        // }
        $(function () {
                $("#chaxun").click(function () {
                    $.ajax({
                        url: "sfcx",
                        data: {"sheng_id": $("#shengfen_name").val()},
                        success: function (data) {
                            $("#jiancheng").val(data.jiancheng);
                            $("#shenghui").val(data.shenghui)
                        },
                        error: function () {
                            alert("error");
                        },
                        dataType:"json",
                    })
                })
            })
    </script>
</head>
<body>
<table>
    <tr>
        <td>省份代号:</td><td><input type="text" id="shengfen_name"></td>
        <td><input type="button" id="chaxun" value="查询" ></td>
    </tr>
    <tr>
        <td>简称：</td><td><input type="text" id="jiancheng"></td>
    </tr>
    <tr>
        <td>省会：</td><td><input type="text" id="shenghui"></td>
    </tr>
</table>
</body>
</html>
