package listener;

import controller.jdbcutil;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class onelistener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        jdbcutil jdbc=new jdbcutil();
        //创建一个集合储存接口
        Map map=new HashMap();
        //打开服务器时候创建20个Connection
        for (int i = 0; i < 21; i++) {
            Connection conn = jdbc.Conn();
            map.put(conn, true);//true为空闲
        }
        //将装载集合的map放入全局作用对象
        ServletContext application=sce.getServletContext();
        application.setAttribute("xz",map);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //关闭时销毁
        ServletContext application=sce.getServletContext();
        Map map=(Map)application.getAttribute("xz");
        Set key=map.keySet();
        Iterator it=key.iterator();
        while (it.hasNext()){
            try {
                ((Connection)it.next()).close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }
}
