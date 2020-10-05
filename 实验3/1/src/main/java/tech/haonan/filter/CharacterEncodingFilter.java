package tech.haonan.filter;

import com.sun.net.httpserver.HttpExchange;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Author: yhn
 * @Date: 2020/9/17 21:54
 * @Description:
 **/
public class CharacterEncodingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 设置信息编码格式为utf-8
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html;charset=UTF-8");
        // 将所有的请求放行
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
