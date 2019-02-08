package com.zhzye.novs.dao;

import com.zhzye.novs.entity.Staff;

public interface SelfDao {
    Staff selectByAccount(String account);
}
