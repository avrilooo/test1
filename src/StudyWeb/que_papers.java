package StudyWeb;

import controller.jdbcutil;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;

public class que_papers extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        jdbcutil jdbcutil = new jdbcutil();
        int fenshu = 0;
        Enumeration<String> name=req.getParameterNames();
        while (name.hasMoreElements()){
            String que_idid=name.nextElement();
            String que_id=que_idid.substring(6);
            String que_xuaxnaing=req.getParameter(que_idid);
           /* System.out.println(req.getParameter(que_idid));
            System.out.println(que_idid);
            System.out.println(que_id);*/
            String sql="select `true` from que where id=?";
            PreparedStatement ps=jdbcutil.Ps(sql);
            try {
                ps.setString(1,que_id);
                ResultSet rs=jdbcutil.rs(ps);
                while (rs.next()){
                    String que_true=rs.getString(1);
                    //System.out.println(que_true);
                    if (que_true.equals(que_xuaxnaing)){
                        fenshu+=25;
                    }
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        System.out.println("分数是："+fenshu);
    }
}