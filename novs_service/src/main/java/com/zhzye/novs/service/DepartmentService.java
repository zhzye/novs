package com.zhzye.novs.service;

import com.zhzye.novs.entity.Department;

import java.util.List;

public interface DepartmentService {
    void add(Department department);
    void remove(Long id);
    void edit(Department department);
    Department get(Long id);
    List<Department> getAll();
}
