package tech.haonan;

import com.sun.net.httpserver.HttpServer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: yhn
 * @Date: 2020/9/14 14:46
 * @Description:
 **/
public class FirstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //下面三行代码是设置传输的格式 否则中文会出现乱码
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().println("<h1>hello world</h1>");
        resp.getWriter().println("servlet 演示");
        resp.getWriter().flush();
        resp.getWriter().close();
    }
}
