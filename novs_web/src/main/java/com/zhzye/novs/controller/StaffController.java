package com.zhzye.novs.controller;

import com.zhzye.novs.entity.Department;
import com.zhzye.novs.entity.Staff;
import com.zhzye.novs.service.DepartmentService;
import com.zhzye.novs.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller("staffController")
public class StaffController {
    @Autowired
    private StaffService staffService;

    @Autowired
    private DepartmentService departmentService;

    public void list(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        List<Staff> staffs = staffService.getAll();
        httpServletRequest.setAttribute("LIST", staffs);
        httpServletRequest.getRequestDispatcher("../staff_list.jsp").forward(httpServletRequest, httpServletResponse);
    }
    
    public void toAdd(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        List<Department> departments = departmentService.getAll();
        httpServletRequest.setAttribute("DLIST", departments);
        httpServletRequest.getRequestDispatcher("../staff_add.jsp").forward(httpServletRequest, httpServletResponse);
    }

    public void add(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String account = httpServletRequest.getParameter("account");
        String password = httpServletRequest.getParameter("password");
        String name = httpServletRequest.getParameter("name");
        Date bornDate = null;
        try {
            bornDate = new SimpleDateFormat("yyyy-MM-dd").parse(httpServletRequest.getParameter("bornDate"));
        } catch (ParseException e) {
            try {
                bornDate = new SimpleDateFormat("yyyy-MM-dd").parse("1970-01-01");
            } catch (ParseException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        Staff staff = new Staff();
        staff.setAccount(account);
        staff.setPassword(password);
        staff.setName(name);
        staff.setBornDate(bornDate);
        staff.setStatus("正常");
        staff.setDepartmentId(3L);
        staffService.add(staff);
        httpServletResponse.sendRedirect("list.do");
    }

    public void toEdit(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        Long id = Long.parseLong(httpServletRequest.getParameter("id"));
        Staff staff = staffService.get(id);
        List<Department> departments = departmentService.getAll();
        httpServletRequest.setAttribute("DLIST", departments);
        httpServletRequest.setAttribute("OBJ", staff);
        httpServletRequest.getRequestDispatcher("../staff_edit.jsp").forward(httpServletRequest, httpServletResponse);
    }

    public void edit(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String account = httpServletRequest.getParameter("account");
        String password = httpServletRequest.getParameter("password");
        String name = httpServletRequest.getParameter("name");
        Date bornDate = null;
        try {
            bornDate = new SimpleDateFormat("yyyy-MM-dd").parse(httpServletRequest.getParameter("bornDate"));
        } catch (ParseException e) {
            try {
                bornDate = new SimpleDateFormat("yyyy-MM-dd").parse("1970-01-01");
            } catch (ParseException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        Long id = Long.parseLong(httpServletRequest.getParameter("id"));

        Staff staff = staffService.get(id);
        staff.setAccount(account);
        staff.setPassword(password);
        staff.setName(name);
        staff.setBornDate(bornDate);

        staffService.edit(staff);

        httpServletResponse.sendRedirect("list.do");
    }

    public void remove(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        Long id = Long.parseLong(httpServletRequest.getParameter("id"));
        staffService.remove(id);
        httpServletResponse.sendRedirect("list.do");
    }
}
