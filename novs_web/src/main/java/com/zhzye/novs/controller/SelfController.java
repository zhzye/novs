package com.zhzye.novs.controller;

import com.zhzye.novs.entity.Staff;
import com.zhzye.novs.service.SelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller("selfController")
public class SelfController {
    @Autowired
    private SelfService shelfService;

    public void toLogin(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.getRequestDispatcher("login.jsp").forward(httpServletRequest, httpServletResponse);
    }

    public void login(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String account = httpServletRequest.getParameter("account");
        String password = httpServletRequest.getParameter("password");
        Staff staff = shelfService.login(account, password);
        if (staff == null) {
            httpServletResponse.sendRedirect("toLogin.do");
        } else {
            HttpSession httpSession = httpServletRequest.getSession();
            httpSession.setAttribute("USER", staff);
            httpServletResponse.sendRedirect("main.do");
        }
    }

    public void main(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.getRequestDispatcher("../index.jsp").forward(httpServletRequest, httpServletResponse);
    }
}
