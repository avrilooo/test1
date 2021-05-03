package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class zhuce extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Date time=new Date();
        String user_id=req.getParameter("user_id");
        String user_pass=req.getParameter("user_pass");
        String user_mail=req.getParameter("user_mail");
        jdbcutil jdbc=new jdbcutil();
        String sql="insert into user_information(user_id,user_password,user_mailbox) values(?,?,?)";
        PreparedStatement ps=jdbc.Ps(sql,req);
        try {
            ps.setString(1,user_id);
            ps.setString(2,user_pass);
            ps.setString(3,user_mail);
            ps.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            jdbc.Close(req);
        }
        Date time2=new Date();
        //jdbc.Close();
        System.out.println("耗时："+(time2.getTime()-time.getTime())+"毫秒");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
