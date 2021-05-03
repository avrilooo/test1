package lianxi;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class 体重测试 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name,width,height;
        name=req.getParameter("name");
        height=req.getParameter("h");
        width=req.getParameter("w");
        float msg=Float.valueOf(width)/(Float.valueOf(height) *Float.valueOf(height));
        String s="您的系数是:"+msg;
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out=resp.getWriter();
        out.print(s);
    }
}
