package com.dog.controller.system.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by Administrator on 2017/2/14.
 * 自定义实现登录，权限，日志，性能等功能
 */
public class loginFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println(loginFilter.class.getName()+"开始过滤和验证，记录各种东西~~~~");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest, servletResponse);//看到这没，这只要是传递下一个Filter
    }

    public void destroy() {

    }
}
