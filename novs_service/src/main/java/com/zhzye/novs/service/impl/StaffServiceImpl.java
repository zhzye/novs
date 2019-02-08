package com.zhzye.novs.service.impl;

import com.zhzye.novs.dao.StaffDao;
import com.zhzye.novs.entity.Staff;
import com.zhzye.novs.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("staffService")
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffDao staffDao;

    public void add(Staff staff) {
        staffDao.insert(staff);
    }

    public void remove(Long id) {
        staffDao.delete(id);
    }

    public void edit(Staff staff) {
        staffDao.update(staff);
    }

    public Staff get(Long id) {
        return staffDao.selectById(id);
    }

    public List<Staff> getAll() {
        return staffDao.selectAll();
    }
}
