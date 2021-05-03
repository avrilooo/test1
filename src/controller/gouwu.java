package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
//存入功能
public class gouwu extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取私人储物柜
        HttpSession session=req.getSession();
        //获取商品名称
        String goodname=req.getParameter("name");
        //数量
        Integer shuliang=(Integer) session.getAttribute(goodname);
        //获得并添加数据
        if (shuliang==null){
            session.setAttribute(goodname,1);
            //resp.sendRedirect("/myweb/index.html");
        }else{
            session.setAttribute(goodname,shuliang+1);
            //resp.sendRedirect("/myweb/index.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
