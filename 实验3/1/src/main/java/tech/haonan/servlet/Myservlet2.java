package tech.haonan.servlet;

import javax.servlet.RequestDispatcher;
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
        //拿到name的值
        String name = req.getParameter("name");
        // 如果name值大于40 那么就跳转到old.jsp 文件中去
        if(Integer.parseInt((String) req.getParameter("age")) > 40 )
            resp.sendRedirect("old.jsp?name=" +name );
        // 如果name值小于40 那么就直接写到网页中 欢迎年轻人
        else if(Integer.parseInt(  (String) req.getParameter("age")) < 20 )
            resp.getWriter().println("<h1>欢迎你 年轻人</h1> ");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
