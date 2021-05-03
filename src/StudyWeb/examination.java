package StudyWeb;

import controller.jdbcutil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.ClientInfoStatus;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class examination extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        jdbcutil jdbcutil=new jdbcutil();
        String sql="select * from que order by rand() limit 4";
        PreparedStatement ps=jdbcutil.Ps(sql);
        ResultSet rs= jdbcutil.rs(ps);
        HttpSession session=req.getSession();
        session.setAttribute("exam",rs);
        req.getRequestDispatcher("/examination.jsp").forward(req,resp);
        jdbcutil.Close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
