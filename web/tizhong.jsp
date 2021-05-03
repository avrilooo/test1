<%--
  Created by IntelliJ IDEA.
  User: avrilooo
  Date: 2021/4/18
  Time: 14:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script>
      function doit(){
            var xmlHttp=new XMLHttpRequest();
            xmlHttp.onreadystatechange=function(){
                 // alert("参数是："+xmlHttp.readyState+"和"+xmlHttp.status);
                if (xmlHttp.readyState==4&&xmlHttp.status==200){
                     var data=xmlHttp.responseText;
                     document.getElementById("dengdai").innerText=data;

                }
            }
            //获取参数
          var name=document.getElementById("name").value;
          var height=document.getElementById("h").value;
          var width=document.getElementById("w").value;
          var mas="name="+name+"&h="+height+"&w="+width;
          // alert(mas);
            xmlHttp.open("get","TC?"+mas,true);
            xmlHttp.send();
        }
    </script>
</head>
<body>
<table>
    <tr>
        <td>姓名:</td><td><input type="text"  id="name"></td>
    </tr>
    <tr>
        <td>身高:</td><td><input type="text"  id="h"></td>
    </tr>
    <tr>
        <td>体重:</td><td><input type="text"  id="w"></td>
    </tr>
    <tr>
        <td><input type="button" id="tijiao" value="提交按钮" onclick="doit()"></td><td><input type="button" value="凑数按钮"></td>
    </tr>
</table>
<font id="dengdai">信息等待更新.....</font>
</body>
</html>
