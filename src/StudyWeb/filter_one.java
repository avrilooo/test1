package StudyWeb;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class filter_one implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession(false);
        String uri = req.getRequestURI();
        if (uri.contains("index") || session != null) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            req.getRequestDispatcher("/index.html").forward(req, resp);
        }
    }
}