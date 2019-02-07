package com.zhzye.novs.dao;

import com.zhzye.novs.entity.Department;

import java.util.List;

public interface DepartmentDao {
    void insert(Department department);
    void delete(Long id);
    void update(Department department);
    Department selectById(Long id);
    List<Department> selectAll();
}
