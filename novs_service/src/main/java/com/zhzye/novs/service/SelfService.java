package com.zhzye.novs.service;

import com.zhzye.novs.entity.Staff;

import java.util.List;

public interface SelfService {
    Staff login(String acount, String password);
    void changePassword(Long id, String password);
}