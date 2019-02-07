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
}
