package HQ;

import com.fasterxml.jackson.databind.ObjectMapper;
import controller.jdbcutil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.module.FindException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HQS extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType( "application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        jdbcutil jdbcutil=new jdbcutil();
        provi provi=new provi();
        String city_id;
        city_id=req.getParameter("city_id");
        String sql="select name from city where provinceid=?";
        PreparedStatement ps=jdbcutil.Ps(sql);
        List city=new ArrayList();
        try {
            ps.setString(1,city_id);
            ResultSet rs=jdbcutil.rs(ps);
            while (rs.next()){
//                provi.setName((rs.getString("name")));
                city.add(rs.getString("name"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            jdbcutil.Close();
        }
        ObjectMapper objectMapper=new ObjectMapper();
        String json=objectMapper.writeValueAsString(city);
        //System.out.println(json);
        out.print(json);

    }
}
