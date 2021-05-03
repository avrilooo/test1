package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class zhanshi extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session =req.getSession();
        //System.out.println(session.getAttribute("神州"));
        /*resp.setContentType("text/html; charset=utf-8");
        PrintWriter out= resp.getWriter();*/
        Enumeration names=session.getAttributeNames();
        while (names.hasMoreElements()){
            String name=(String) names.nextElement();
            int shuliang=(int)session.getAttribute(name);
            System.out.println(name+shuliang);
            //System.out.println(session.getAttribute((String)names.nextElement()));
            //System.out.println((String)names.nextElement()+session.getAttribute((String)names.nextElement()));

        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
