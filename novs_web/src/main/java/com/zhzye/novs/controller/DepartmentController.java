package com.zhzye.novs.controller;

import com.zhzye.novs.entity.Department;
import com.zhzye.novs.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller("departmentController")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    public void list(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        List<Department> departments = departmentService.getAll();
        httpServletRequest.setAttribute("LIST", departments);
        httpServletRequest.getRequestDispatcher("../department_list.jsp").forward(httpServletRequest, httpServletResponse);
    }
    
    public void toAdd(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.getRequestDispatcher("../department_add.jsp").forward(httpServletRequest, httpServletResponse);
    }

    public void add(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String name = httpServletRequest.getParameter("name");
        String address = httpServletRequest.getParameter("address");
        Department department = new Department();
        department.setName(name);
        department.setAddress(address);
        departmentService.add(department);
        httpServletResponse.sendRedirect("list.do");
    }

    public void toEdit(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        Long id = Long.parseLong(httpServletRequest.getParameter("id"));
        Department department = departmentService.get(id);
        httpServletRequest.setAttribute("OBJ", department);
        httpServletRequest.getRequestDispatcher("../department_edit.jsp").forward(httpServletRequest, httpServletResponse);
    }

    public void edit(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String name = httpServletRequest.getParameter("name");
        String address = httpServletRequest.getParameter("address");
        Long id = Long.parseLong(httpServletRequest.getParameter("id"));

        Department department = new Department();
        department.setId(id);
        department.setName(name);
        department.setAddress(address);

        departmentService.edit(department);

        httpServletResponse.sendRedirect("list.do");
    }

    public void remove(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        Long id = Long.parseLong(httpServletRequest.getParameter("id"));
        departmentService.remove(id);
        httpServletResponse.sendRedirect("list.do");
    }
}
