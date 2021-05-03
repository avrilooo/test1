<%@ page import="java.sql.ResultSet" %>
<%@ page import="jakarta.servlet.http.HttpSession" %><%--
  Created by IntelliJ IDEA.
  User: avrilooo
  Date: 2021/4/7
  Time: 12:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form action="/myweb/quepar">
<%
   HttpSession session1=request.getSession();
    ResultSet exam=(ResultSet)session1.getAttribute("exam");
    while (exam.next()){
%>
    <table>
        <tr><td>题目:</td><td><%=exam.getString("ques")%></td></tr>
        <tr><td>A:</td><td><%=exam.getString("A")%></td></tr>
        <tr><td>B:</td><td><%=exam.getString("B")%></td></tr>
        <tr><td>C:</td><td><%=exam.getString("C")%></td></tr>
        <tr><td>D:</td><td><%=exam.getString("D")%></td></tr>
        <tr><td>选项：</td><td>
            <input type="radio" name="option<%=exam.getString("id")%>" value="A">A
            <input type="radio" name="option<%=exam.getString("id")%>" value="B">B
            <input type="radio" name="option<%=exam.getString("id")%>" value="C">C
            <input type="radio" name="option<%=exam.getString("id")%>" value="D">D</td>
        </tr>
        <tr></tr>
    </table>
<br>
<%}%>
    <input type="submit" value="提交">
    &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
    <input type="reset" value="重写">
</form>
