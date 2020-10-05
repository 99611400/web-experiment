package tech.haonan.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: yhn
 * @Date: 2020/9/17 22:35
 * @Description:
 **/
public class MyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //验证姓名是否为空
        if(servletRequest.getParameter("name").length() == 0)
            //如果为空 转发到error.jsp 拒绝连接
            servletRequest.getRequestDispatcher("error.jsp").forward(servletRequest,servletResponse);
        else
            //如果不为空 放行
            filterChain.doFilter(servletRequest,servletResponse);
    }
}
