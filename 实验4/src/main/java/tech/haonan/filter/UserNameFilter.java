package tech.haonan.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @Author: yhn
 * @Date: 2020/9/24 22:33
 * @Description:
 **/
@WebFilter(filterName = "UserNameFilter" , urlPatterns = "/login")
public class UserNameFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 获取username和password
        String name =  servletRequest.getParameter("username");
        String password = servletRequest.getParameter("password");
        boolean flag = false;
        if(name == null || name.equals("") ){
            // 将信息存储到Request中 后期jsp中可以使用
            servletRequest.setAttribute("error1","用户名不能为空");
            flag = true;
        }
        if(password == null || password.equals("") ){
            // 将信息存储到Request中 后期jsp中可以使用
            servletRequest.setAttribute("error2","密码不能为空");
            flag = true;
        }
        if(flag)
            servletRequest.getRequestDispatcher("error.jsp").forward(servletRequest,servletResponse);
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
