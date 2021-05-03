package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

//刷卡消费

public class twoservelt extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out= resp.getWriter();
        resp.setContentType("text/html; charset=utf-8");
        //获取oneServelt的cookie
        Cookie[] cookies=req.getCookies();
        String name=null;
        int yuer=0;
        //获取点餐数据
        int canfei=Integer.parseInt(req.getParameter("food"));
        //建一张新卡储存数据，覆盖原数据
        Cookie newcook=null;
        for (Cookie cook:cookies
             ) {
            if ("user_id".equals(cook.getName())){
                name=cook.getValue();
            }else if ("user_money".equals(cook.getName())){
                if (Integer.parseInt(cook.getValue())>canfei) {
                    yuer=Integer.parseInt(cook.getValue())-canfei;
                    newcook=new Cookie("user_money",String.valueOf(yuer));
                    cook.setValue("Integer.parseInt(cook.getValue())-canfei");
                }else{
                    out.print("余额不足...");
                }
            }
        }
        //将cookie返回给user(必须，不然数据不会更新)
       resp.addCookie(newcook);
        out.print("用户"+name+"消费"+canfei+"元"+"剩余"+yuer+"元");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
