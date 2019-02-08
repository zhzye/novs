package com.zhzye.novs.service.impl;

import com.zhzye.novs.dao.ShelfDao;
import com.zhzye.novs.dao.StaffDao;
import com.zhzye.novs.entity.Staff;
import com.zhzye.novs.service.ShelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("shelfService")
public class ShelfServiceImpl implements ShelfService {
    @Autowired
    private ShelfDao shelfDao;

    @Autowired
    private StaffDao staffDao;

    public Staff login(String acount, String password) {
        Staff staff = shelfDao.selectByAccount(acount);
        if (staff == null) return null;
        if (staff.getPassword().equals(password)) {
            return staff;
        }
        return null;
    }

    public void changePassword(Long id, String password) {
        Staff staff = staffDao.selectById(id);
        staff.setPassword(password);
        staffDao.update(staff);
    }
}
