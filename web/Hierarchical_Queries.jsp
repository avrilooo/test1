<%--
  Created by IntelliJ IDEA.
  User: avrilooo
  Date: 2021/4/20
  Time: 20:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script type="text/javascript" src="jquery/jquery.js"></script>
    <script>
        $(function (){
            $("#city").mouseout(function () {
                $("#shi").empty();
                $.get("HQS",
                    data = {"city_id": $("#city>option:selected").val()},
                    function (data) {
                        //更新第二个下拉列表
                        $.each(
                            data, function (index, shi_name) {
                                $("#shi").append(" <option>" + shi_name + "</option>")
                            }
                        )
                    },
                    dataType = "json",
                );
            });
        })
    </script>
</head>
<body>
<select id="city">
    <option value="1" selected>河北</option>
    <option value="2">山西</option>
    <option value="3">内蒙古</option>
    <option value="8">福建</option>
    <option value="9">江西</option>
</select>
<br>
<select id="shi">
    <option >石家庄市</option>
</select>
</body>
</html>