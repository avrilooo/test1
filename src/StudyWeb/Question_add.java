package StudyWeb;

import controller.jdbcutil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Question_add extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        jdbcutil jdbcutil=new jdbcutil();
        String que,a,b,c,d,true_que;
        que=req.getParameter("que");
        a=req.getParameter("A");
        b=req.getParameter("B");
        c=req.getParameter("C");
        d=req.getParameter("D");
        true_que=req.getParameter("true_que");
        String sql="INSERT INTO `user`.`que` (`ques`, `A`, `B`, `C`, `D`, `true`) VALUES (?,?,?,?,?,?)";
        PreparedStatement ps=jdbcutil.Ps(sql);
        try {
            ps.setString(1,que);
            ps.setString(2,a);
            ps.setString(3,b);
            ps.setString(4,c);
            ps.setString(5,d);
            ps.setString(6,true_que);
            ps.execute();
            req.getRequestDispatcher("/index2.html").forward(req,resp);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        jdbcutil.Close();


    }
}
