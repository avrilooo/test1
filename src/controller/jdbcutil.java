package controller;

import com.sun.source.tree.WhileLoopTree;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

import java.net.http.WebSocket;
import java.sql.*;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class jdbcutil {
    Connection conn=null;
    PreparedStatement ps=null;
    ResultSet rs=null;
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //重载

    public Connection Conn(HttpServletRequest req){
            /*Connection conn= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/user","root","123456");
            System.out.println(conn);
            return conn;*/
        ServletContext application=req.getServletContext();

           Map map=(Map) application.getAttribute("xz");

            Iterator it=map.keySet().iterator();
            while (it.hasNext()){
                conn=(Connection) it.next();
                boolean bl=(boolean)map.get(conn);
                if (bl==true){
                    //System.out.println(it.next());
                    conn=(Connection)it.next();
                    map.put(conn,false);
                    break;
                }
            }
        return conn;
    }

    public PreparedStatement Ps(String sql,HttpServletRequest req){
        try {
            ps=Conn(req).prepareStatement(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ps;
    }


    public void Close(HttpServletRequest req){
        /*if (conn!=null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }*/
        ServletContext application=req.getServletContext();
        Map map=(Map)application.getAttribute("xz");
        map.put(conn,true);
        if (ps!=null){
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }



    //旧方法
    public Connection Conn(){
        try {
            conn= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/user","root","123456");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
       return conn;
    }

    public PreparedStatement Ps(String sql){
        Connection conn=Conn();
        try {
            ps=conn.prepareStatement(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ps;
    }

    public ResultSet rs(PreparedStatement ps){
        try {
             rs=ps.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return  rs;
    }
    public void Close(){
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (ps!=null){
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }

}
