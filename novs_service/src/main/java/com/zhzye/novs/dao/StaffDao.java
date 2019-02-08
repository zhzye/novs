package com.zhzye.novs.dao;


import com.zhzye.novs.entity.Staff;

import java.util.List;

public interface StaffDao {
    void insert(Staff staff);
    void delete(Long id);
    void update(Staff staff);
    Staff selectById(Long id);
    List<Staff> selectAll();
}
