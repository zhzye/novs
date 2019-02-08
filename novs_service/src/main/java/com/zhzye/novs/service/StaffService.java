package com.zhzye.novs.service;

import com.zhzye.novs.entity.Staff;

import java.util.List;

public interface StaffService {
    void add(Staff staff);
    void remove(Long id);
    void edit(Staff staff);
    Staff get(Long id);
    List<Staff> getAll();
}
