package StudyWeb;

import controller.jdbcutil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class information_modify extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        jdbcutil jdbcutil=new jdbcutil();
        String id=req.getParameter("id");
        String sql="delete from user_information where id=?";
        PreparedStatement ps=jdbcutil.Ps(sql);
        try {
            ps.setString(1,id);
            ps.execute();
            req.getRequestDispatcher("/find").forward(req,resp);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        jdbcutil.Close();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
