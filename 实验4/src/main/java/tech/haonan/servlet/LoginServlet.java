package tech.haonan.servlet;


//import tech.haonan.Service.LoginService;
//import tech.haonan.Service.LoginServiceImpl;
import tech.haonan.Service.LoginService;
import tech.haonan.Service.LoginServiceImpl;
import tech.haonan.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: yhn
 * @Date: 2020/9/24 19:52
 * @Description:
 **/
@WebServlet("/login")
public class LoginServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username =  req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username + " " + password);
        // new一个Secvice层的对象 用于调用它的findByUserName方法 查询用户是否存在
        LoginService loginService = new LoginServiceImpl();
        //去查询用户输入的登录名和密码是否正确  层层调用 查询
        User user = loginService.findByUserName(username,password);
        if(user !=null){   // 调用函数返回了对象不为空 那么说明数据库存在信息
            req.setAttribute("username",username);
            req.getRequestDispatcher("main.jsp").forward(req,resp);
        }else{  //如果返回值为null 说明用户名密码错误
            resp.getWriter().println("<h1>用户名或者密码输入错误</h1>");
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
