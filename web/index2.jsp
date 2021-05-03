<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: avrilooo
  Date: 2021/4/5
  Time: 17:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ResultSet Information=(ResultSet) request.getAttribute("information");
%>
<center>
<table border="1px">
    <tr>
        <td>用户id</td><td>用户密码</td><td>用户邮箱</td><td>删除</td>
    </tr>
    <%while (Information.next()){%>
    <tr>
        <td><%=Information.getString("user_id")%></td><td><%=Information.getString("user_password")%></td><td><%=Information.getString("user_mailbox")%>
        </td><td><a href="/myweb/del?id=<%=Information.getString("id")%>" target="_self">删除</a></td>
    </tr>
    <%}%>
</table>
</center>
