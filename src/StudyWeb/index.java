package StudyWeb;

import controller.jdbcutil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.awt.*;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class index extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        jdbcutil jdbc=new jdbcutil();
        String user_id,user_pass;
        user_id=req.getParameter("user_id");
        user_pass=req.getParameter("user_pass");
        String sql="select user_id from user_information where user_id=? and user_password=?";
        PreparedStatement ps=jdbc.Ps(sql);

        try {
            ps.setString(1,user_id);
            ps.setString(2,user_pass);
            ResultSet rs=jdbc.rs(ps);
            if (rs.next()){
                HttpSession session=req.getSession();
                session.setAttribute("key","ok");
                //req.setAttribute("key",1);
                req.getRequestDispatcher("/index2.html").forward(req,resp);
                return;
            }else{
                req.setAttribute("key",0);
            }
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //System.out.println("成功");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
