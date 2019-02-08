package com.zhzye.novs.global;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        String path = httpServletRequest.getServletPath();
        if (path.toLowerCase().indexOf("login") != -1) {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        } else {
            HttpSession httpSession = httpServletRequest.getSession();
            Object object = httpSession.getAttribute("USER");
            if (object != null) {
                filterChain.doFilter(httpServletRequest, httpServletResponse);
            } else {
                httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/toLogin.do");
            }
        }

    }

    @Override
    public void destroy() {

    }
}
