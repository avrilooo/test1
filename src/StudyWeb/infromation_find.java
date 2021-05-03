package StudyWeb;

import controller.jdbcutil;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class infromation_find extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*String user_id,user_pass;
        user_id=(String) req.getAttribute("user_id");
        user_pass=(String) req.getAttribute("user_pass");*/
        jdbcutil jdbcutil=new jdbcutil();
        String sql="select * from user_information";
        PreparedStatement ps=jdbcutil.Ps(sql);
        ResultSet rs= jdbcutil.rs(ps);
        req.setAttribute("information",rs);
        ServletContext application=req.getServletContext();
        application.setAttribute("exam",rs);
        req.getRequestDispatcher("/index2.jsp").forward(req,resp);
        jdbcutil.Close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
