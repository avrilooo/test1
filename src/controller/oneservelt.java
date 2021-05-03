package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class oneservelt extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取提交内容
        String user_id,user_money;
        user_id=req.getParameter("user_id");
        user_money=req.getParameter("user_money");
        //存入cookie
        Cookie card=new Cookie("user_id",user_id);
        card.setMaxAge(60*5);
        Cookie card2=new Cookie("user_money",user_money);
        card2.setMaxAge(60*5);
        //交还给浏览器
        resp.addCookie(card);
        resp.addCookie(card2);
        resp.sendRedirect("/myweb/User2.html");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
