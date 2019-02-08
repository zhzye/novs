package com.zhzye.novs.dao;

import com.zhzye.novs.entity.Staff;

public interface ShelfDao {
    Staff selectByAccount(String account);
}
