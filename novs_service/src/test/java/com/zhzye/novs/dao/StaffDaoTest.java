package com.zhzye.novs.dao;

import com.zhzye.novs.entity.Staff;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class StaffDaoTest {
    @Autowired
    private StaffDao staffDao;

    @Test
    public void insert() {
        Staff staff = new Staff();
        staff.setName("staff_test");
        staff.setAccount("account1");
        staff.setPassword("password1");
        staff.setStatus("正常");
        staff.setDepartmentId(3L);
        staffDao.insert(staff);
    }

    @Test
    public void selectAll() {
        List<Staff> staffList = staffDao.selectAll();
        for (Staff staff : staffList) {
            System.out.println(staff);
        }
    }
}
