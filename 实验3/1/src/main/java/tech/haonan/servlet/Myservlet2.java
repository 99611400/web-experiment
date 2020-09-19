package tech.haonan.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: yhn
 * @Date: 2020/9/17 20:24
 * @Description:
 **/
@WebServlet("/insideInterface")
public class Myservlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(Integer.parseInt((String) req.getParameter("age")) > 40 )
            resp.getWriter().println("<h1>欢迎您 老先生</h1> ");
        else if(Integer.parseInt(  (String) req.getParameter("age")) < 20 )
            resp.getWriter().println("<h1>欢迎你 少年</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
