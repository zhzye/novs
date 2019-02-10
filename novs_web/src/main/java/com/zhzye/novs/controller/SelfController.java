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

    public void logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        HttpSession httpSession = httpServletRequest.getSession();
        httpSession.setAttribute("USER", null);
        httpServletResponse.sendRedirect("toLogin.do");
    }

    public void main(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.getRequestDispatcher("index.jsp").forward(httpServletRequest, httpServletResponse);
    }

    public void info(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.getRequestDispatcher("../info.jsp").forward(httpServletRequest, httpServletResponse);
    }

    //      /self/toChangePassword.do
    public void toChangePassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("../change_password.jsp").forward(request,response);
    }
    //      /self/changePassword.do
    public void changePassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String password = request.getParameter("password");
        String password1 = request.getParameter("password1");
        HttpSession session = request.getSession();
        Staff staff = (Staff)session.getAttribute("USER");
        if(!staff.getPassword().equals(password)){
            response.sendRedirect("toChangePassword.do");
        }else{
            shelfService.changePassword(staff.getId(),password1);
            //response.sendRedirect("../logout.do");
            response.getWriter().print("<script type=\"text/javascript\">parent.location.href=\"../logout.do\"</script>");
        }
    }
}
