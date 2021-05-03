package lianxi;

import com.fasterxml.jackson.databind.ObjectMapper;
import controller.jdbcutil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.swing.plaf.IconUIResource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class 省份查询 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        shengfensql sf=new shengfensql();
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out=resp.getWriter();
        String sheng_id,sm_name,shenghui;
        sheng_id=req.getParameter("sheng_id");
//        sm_name=req.getParameter("sm_name");
//        shenghui=req.getParameter("shenghui");
        jdbcutil jdbcutil=new jdbcutil();
        String sql="select jiancheng ,shenghui from province where id=?";
        PreparedStatement ps=jdbcutil.Ps(sql);
            try {
                ps.setString(1,sheng_id);
                ResultSet rs=jdbcutil.rs(ps);
                    while (rs.next()) {
                        sf.setJiancheng(rs.getString("jiancheng"));
                        sf.setShenghui(rs.getString("shenghui"));
                    }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally {
                jdbcutil.Close();
            }
            ObjectMapper om=new ObjectMapper();
            String json=om.writeValueAsString(sf);
            out.print(json);
    }
}
