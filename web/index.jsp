<%--
  Created by IntelliJ IDEA.
  User: avrilooo
  Date: 2021/4/5
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
int login=(int) request.getAttribute("key");
%>
<%if(login==0){  %>
<center><font size="40px" color="red">登录失败</font></center>
<%}%>